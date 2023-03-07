import com.wyl.entity.User;
import com.wyl.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @auther yanl.wang
 * @date 2023/3/7
 **/

public class MyTest {
    /**
     * 测试Spring与Mybatis整合
     */
    @Test
    public void test01(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("userService");
        User user = new User();
        user.setId(3);
        user.setUsername("哈哈");
        userService.register(user);
    }
}
