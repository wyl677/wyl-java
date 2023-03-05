import com.wyl.proxy.User;
import com.wyl.proxy.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/3/5
 **/
public class MyTest {

    /**
     * 测试实现MethodBeforeAdvice接口实现动态代理
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = context.getBean("userService", UserService.class);
        userService.register(new User());
        userService.login("wyl","123456");
    }
}
