package com.wyl.servlet;



import com.wyl.annotation.*;

import javax.lang.model.element.VariableElement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.time.temporal.ValueRange;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther yanl.wang
 * @date 2023/2/3
 **/
public class DispatcherServlet extends HttpServlet {

    List<String> classNames = new ArrayList<String>();
    Map<String,Object> beans = new HashMap<String, Object>();
    Map<String,Object> handlerMap = new HashMap<String, Object>();

    private static final long serialVersionUID = 1L;

    public void init(ServletConfig config){
        //把所有的bean扫描------扫描所有的class文件
        scanPackage("com.wyl");//写到properties配置文件

        //根据全类名创建bean
        doInstance();
        //根据bean进行依赖注入
        doIoc();

        buildUrlMapping();//方法和地址关联 wyl/query------->method建立映射关系
    }

    //com.wyl
    private void scanPackage(String basePackage){
        URL url = this.getClass().getClassLoader().getResource("/"+basePackage.replaceAll("\\.","/"));
        String fileStr = url.getFile();

        File file = new File(fileStr);
        String[] filesStr = file.list();

        for (String path : filesStr) {
            File filePath = new File(fileStr + path);//com.wyl.servlet
            if (filePath.isDirectory()){
                scanPackage(basePackage+"." + path);
            }else {
                //加入List
                classNames.add(basePackage+"."+filePath.getName());//com.wyl.servlet.DispatcherServlet
            }
        }
    }

    //根据扫描的List全类名，进行实例化
    public void doInstance(){
        if (classNames.size()<= 0 ){
            System.out.println("包扫描失败............");
            return;
        }

        //list的所有class类
        for (String className : classNames) {
            String cn = className.replace(".class","");
            try {
                Class<?> clazz = Class.forName(cn);
                if (clazz.isAnnotationPresent(WylController.class)){
                    Object instance = clazz.newInstance(); //创建控制类
                    WylRequestMapping requestMapping = clazz.getAnnotation(WylRequestMapping.class);
                    String rmvalue = requestMapping.value();//  /wyl
                    beans.put(rmvalue,instance);
                }else if (clazz.isAnnotationPresent(WylService.class)){
                    WylService service = clazz.getAnnotation(WylService.class);
                    Object instance = clazz.newInstance();
                    beans.put(service.value(),instance);
                }else {
                    continue;
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //把service注入到controller
    public void doIoc(){
        if(beans.entrySet().size() <= 0 ){
            System.out.println("没有一个实例化的类");
        }

        //把map里所有的实例遍历出来
        for (Map.Entry<String,Object> entry: beans.entrySet()){
            Object instance = entry.getValue();
            Class clazz = instance.getClass();

            if (clazz.isAnnotationPresent(WylController.class)){
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    if (field.isAnnotationPresent(WylAutowired.class)){
                        WylAutowired auto = field.getAnnotation(WylAutowired.class);
                        String key = auto.value(); // WylServiceImpl
                        field.setAccessible(true);
                        try {
                            field.set(instance,beans.get(key));//?
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }else {
                        continue;
                    }
                }
            }else {
                continue;
            }

        }
    }


    private void buildUrlMapping(){
        if (beans.entrySet().size() <= 0 ){
            System.out.println("没有类的实例化...........");
        }

        for (Map.Entry<String, Object> entry : beans.entrySet()) {
            Object instance =  entry.getValue();

            Class<?> clazz = instance.getClass();
            if (clazz.isAnnotationPresent(WylController.class)){
                WylRequestMapping requestMapping = clazz.getAnnotation(WylRequestMapping.class);//@WylRequestMapping("/wyl")
                String classPath = requestMapping.value();// /wyl

                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(WylRequestMapping.class)){
                        WylRequestMapping methodMapping = method.getAnnotation(WylRequestMapping.class);
                        String methodPath = methodMapping.value();

                        handlerMap.put(classPath + methodPath, method);
                    }else {
                        continue;
                    }
                }

            }else {
                continue;
            }
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求路径 /wyl-mvc/wyl/query
        String uri = req.getRequestURI();
        String context = req.getContextPath(); // wyl-mvc
        String path = uri.replace(context, ""); // /wyl/query

        Method method = (Method) handlerMap.get(path);

        //根据key=/wyl 到map去拿
        com.wyl.controller.WylController instance = (com.wyl.controller.WylController) beans.get("/"+path.split("/")[1]); //  /wyl

        Object arg[] = hand(req,resp,method);
        try {
            method.invoke(instance,arg);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    private static Object[] hand(HttpServletRequest request,HttpServletResponse response,Method method){
        // 拿到当前待执行方法有哪些参数
        Class<?>[] paramClazzs = method.getParameterTypes();
        //根据参数的个数，new一个参数的数组，将方法里的所有参数赋值到args来
        Object[] args = new Object[paramClazzs.length];

        int args_i = 0;
        int index = 0;
        for (Class<?> paramClazz : paramClazzs) {
            if (ServletRequest.class.isAssignableFrom(paramClazz)){
                args[args_i++] = request;
            }
            if (ServletResponse.class.isAssignableFrom(paramClazz)){
                args[args_i++] = response;
            }

            //从0-3判断有没有RequestParam注解，很明显paramClazz为0和1时，不是，
            //当为2和3时为@RequestParam,需要解析
            //[@com.wyl.annotation.WylRequestParam(value=name)]
            Annotation[] paramAns = method.getParameterAnnotations()[index];
            if (paramAns.length>0){
                for (Annotation paramAn : paramAns) {
                    if (WylRequestParam.class.isAssignableFrom(paramAn.getClass())){
                        WylRequestParam rp = (WylRequestParam) paramAn;
                        //找到注解里的name和age
                        args[args_i++] = request.getParameter(rp.value());
                    }
                }
            }
            index++;
        }
        return args;
    }
}
