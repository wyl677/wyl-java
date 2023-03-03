package com.wyl.com.wyl.collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther yanl.wang
 * @date 2022/5/11
 **/
public class TestMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("aaaa","1111");
        map.put("bbbb","2222");
        map.put("cccc","3333");
        System.out.println(map);

        Map<String, String> map1 = new HashMap<>();
        map1.put("aaaa","4444");
        map1.put("bbbb","5555");
        map1.put("cccc","6666");
        System.out.println(map1);

        List list = new ArrayList<>();
        list.add(map);
        list.add(map1);
        System.out.println(list);

        Student zhang = new Student("zhang", "123");
        new Student("li","456");
        System.out.println(zhang);

    }
}
