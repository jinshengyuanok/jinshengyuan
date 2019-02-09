package com.yuan;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yuan.model.User;
import com.yuan.service.accountManager.ConsumeRecordService;
import com.yuan.service.accountManager.ConsumeTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailParseException;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JinshengyuanApplicationTests {

    @Autowired
    public ConsumeRecordService consumeRecordService;

    @Test
    public void contextLoads() {
        List<Map<String, Object>> mapList = consumeRecordService.countByConsumeType();
        System.out.println("map.size():" + mapList.size());
        mapList.forEach(obj ->
                obj.entrySet().forEach(map -> System.out.println("key:" + map.getKey() + "------value:" + map.getValue().toString()))

        );
    }

    //@Test
    public void redisClient(){
        Jedis jedis = new Jedis("192.168.1.154",6379);
        /*String[] keys = {"set1","set2","set3","set4"};
        jedis.sadd(keys.toString(),)*/
        User user = new User();
        user.setId("1");
        user.setEmail("123@qq.com");
        user.setPassword("123");
        user.setMobilePhone(110);
        user.setNickName("tom");
        user.setUserName("张三");
        user.setGender("1");
        user.setRegisterTime(new Date());
        System.out.println(user.toString());

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(user);
        System.out.println(jsonArray.toJSONString());
        jedis.rpush("user",jsonArray.toJSONString());
        //System.out.println(jedis.ping());

        List<String> lsit = jedis.lrange("user",new Long(0),new Long(-1));
    }




}

