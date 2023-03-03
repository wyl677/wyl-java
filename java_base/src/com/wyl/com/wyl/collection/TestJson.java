package com.wyl.com.wyl.collection;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @auther yanl.wang
 * @date 2022/5/16
 **/
public class TestJson {
    public static void main(String[] args) {
        String str = "{\n" +
                "    \"TRANSID\": \"WMA2000\",\n" +
                "    \"TRADE_CODE\": \"121\",\n" +
                "    \"TRADECODE\": \"102003\",\n" +
                "    \"TASKID\": \"202107051439450049760008\",\n" +
                "    \"NODE_NAME\": \"BI\",\n" +
                "    \"USERID\": \"0601\",\n" +
                "    \"BRNO\": \"9350501001\",\n" +
                "    \"RUN_SCRIPT\": \"TRUE\",\n" +
                "    \"DOCID\": \"20210609C19338B3-7498-D3EE-A2CA-7585B1B9183D-1\",\n" +
                "    \"VCRGUP\": \"00010028\",\n" +
                "    \"BUSTYP\": \"0070003\",\n" +
                "    \"CNYTYP\": \"1\",\n" +
                "    \"GRECHN\": \"0\",\n" +
                "    \"BI_FLG\": \"01\",\n" +
                "    \"TRDDAT\": \"20210609\",\n" +
                "    \"WFS_VS_TYP\": \"0\",\n" +
                "    \"BI_USERID\": \"0601\",\n" +
                "    \"khh\": \"0000971000831009\",\n" +
                "    \"businfo\": {\n" +
                "        \"aaa\": \"1111\"\n" +
                "    },\n" +
                "    \"treess\": \"1111111111111\",\n" +
                "    \"arr\": [\n" +
                "        {\n" +
                "            \"a\": \"1\",\n" +
                "            \"b\": \"2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"a\": \"3\",\n" +
                "            \"b\": \"4\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        JSONObject jsonObject = JSON.parseObject(str);
        System.out.println(jsonObject);
        jsonObject.remove("arr");
        System.out.println(jsonObject);
        jsonObject.remove("businfo");
        jsonObject.remove("treess");
        System.out.println(jsonObject);

    }
}
