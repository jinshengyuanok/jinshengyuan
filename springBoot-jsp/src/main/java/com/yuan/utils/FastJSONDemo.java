package com.yuan.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.yuan.model.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2019-01-16
 * Time: 8:39
 * description:
 * Fastjson中的经常调用的方法:
 *
 * 1 public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray
 * 2 public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject
 * 3 public static final T parseObject(String text, Class clazz); // 把JSON文本parse为JavaBean
 * 4 public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray
 * 5 public static final List parseArray(String text, Class clazz); //把JSON文本parse成JavaBean集合
 * 6 public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本
 * 7 public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本
 * 8 public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray。
 **/
public class FastJSONDemo {


    public void testOne(){
        List<User> userList = new ArrayList<>();
        User user = null;
        for(int i=1;i<=10;i++){
            user = new User();
            user.setId(""+i);
            user.setUserName("testName"+i);
            user.setPassword("password"+i);
            user.setNickName("nickName"+i);
            if(i%2==0){
                user.setGender("男");
            }else{
                user.setGender("女");
            }
            user.setEmail("yjs_"+i+"@qq.com");
            user.setMobilePhone(100+i);
            user.setRegisterTime(new Date());
            user.setPhotoUrl("url"+i);
            userList.add(user);
        }

       // Object jsonObject = JSON.toJSON(userList);//将JavaBean转换为JSONObject或者JSONArray。
        //System.out.println(jsonObject);

       // Object o = JSON.toJSONString(userList,true);// 将JavaBean序列化为带格式的JSON文本
       // System.out.println(o);
      //将javaBean序列化为JSON文本，并对日期按照指定的格式进行格式化
       Object o1 =  JSON.toJSONStringWithDateFormat(userList,"yyyy-MM-dd HH:mm:ss");
        System.out.println(o1.toString());

       String json = o1.toString();

        JSONArray jsonArray = JSON.parseArray(json); // 把JSON文本parse成JSONArray

        System.out.println(jsonArray);

        jsonArray.forEach(str -> {
            System.out.println(JSON.parseObject(str.toString(),User.class).getUserName());// 把JSON文本parse为JavaBean
        });
    }

}
