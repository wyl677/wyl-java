package com.wyl.beanpost;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @auther yanl.wang
 * @date 2023/2/8
 * 后置处理bean
 *   BeanPostProcessor作用：对Spring工厂所创建的对象进行在加工
 *   细节：BeanPostProcessor会对Spring工厂中所有创建的对象进行在加工
 *
 **/
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Categroy) {
            Categroy categroy = (Categroy) bean;
            categroy.setName("xiaowb");
        }
        return bean;
    }
}
