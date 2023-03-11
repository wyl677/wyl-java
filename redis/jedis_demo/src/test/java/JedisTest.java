import com.wyl.jedis.util.JedisConnectionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import redis.clients.jedis.Jedis;

import java.io.PipedReader;
import java.util.Map;

/**
 * @auther yanl.wang
 * @date 2023/3/11
 **/
public class JedisTest {
    private Jedis jedis;

    @BeforeEach
    void setUp(){
        //1.建立连接
        jedis = new Jedis("192.168.83.2",6379);
        //2.设置密码
        jedis.auth("123456");
        //3.选择库
        jedis.select(0);
    }

    /**
     * 测试String类型
     */
    @Test
    void testString(){
        //存入数据
//        String result = jedis.set("name", "jack");
//        System.out.println("result = " + result);
        //获取数据
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }

    /**
     * 测试Hash类型
     */
    @Test
    void testHash(){
        //插入hash数据
        jedis.hset("user:1","name","lisi");
        jedis.hset("user:1","age","21");

        //获取
        Map<String, String> hgetAll = jedis.hgetAll("user:1");
        System.out.println(hgetAll);
    }

    /**
     * 测试jedis连接池
     */
    @Test
    void testJedisConnPool(){
        jedis = JedisConnectionFactory.getJedis();
        String name = jedis.get("name");
        System.out.println("name = " + name);
    }
    @AfterEach
    void closeConn(){
        if (jedis != null){
            jedis.close();
        }
    }

}
