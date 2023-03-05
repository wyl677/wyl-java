import com.wyl.basic.BeanFactory;
import com.wyl.basic.Person;
import com.wyl.basic.User;
import com.wyl.life.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;

/**
 * @auther yanl.wang
 * @date 2023/3/5
 **/
public class MyTest {

    /**
     * 测试通过Bean工厂创建对象
     */
    @Test
    public void test01(){
        Person person = (Person) BeanFactory.getBean("person");
        System.out.println(person);
    }

    /**
     * 通过实现FactoryBean的方式获取复杂对象
     */
    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection conn = context.getBean("conn",Connection.class);
        System.out.println(conn);
    }

    /**
     * 测试实例工厂创建复杂对象
     */
    @Test
    public void test03(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = context.getBean("conn1",Connection.class);
        System.out.println(conn);
    }

    /**
     * 测试静态工厂创建复杂对象
     */
    @Test
    public void test04(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Connection conn = context.getBean("conn2",Connection.class);
        System.out.println(conn);
    }

    /**
     * 测试Spring工厂控制对象创建的次数
     */
    @Test
    public void test05(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        User user1 = context.getBean("user", User.class);
        User user2 = context.getBean("user", User.class);
        System.out.println(user1 == user2);
    }

    /**
     * 测试Bean对象的生命周期
     */
    @Test
    public void test06(){
        ApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = context.getBean("product", Product.class);
        System.out.println(product);
    }

    /**
     * 测试Bean对象的生命周期销毁方法
     */
    @Test
    public void test07(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");
        Product product = context.getBean("product", Product.class);
        System.out.println(product);
        context.close();
    }
}
