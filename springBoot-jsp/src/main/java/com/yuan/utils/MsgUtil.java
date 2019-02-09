package com.yuan.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2018-07-06
 * Time: 9:51
 * description:Ajax请求通用返回数据类
 **/

public class MsgUtil {
    private int code;//状态码
    private String msg;//提示信息
    private Map<String,Object> rows = new HashMap<String, Object>();//结果对象

    /**
     * 请求成功时,返回的状态码与提示消息
     * @return
     */
    public static MsgUtil success(){
        MsgUtil result = new MsgUtil();
        result.setCode(1);//返回1表示成功
        result.setMsg("处理成功");
        return result;
    }
    /**
     * 请求失败时,返回的状态码与提示消息
     * @return
     */
    public static MsgUtil fail(){
        MsgUtil result = new MsgUtil();
        result.setCode(2);//返回2表示失败
        result.setMsg("处理失败");
        return result;
    }

    /**
     * 新增方法,使其可进行链式操作
     * @param key
     * @param value
     * @return
     */
    public MsgUtil add(String key,Object value){
        this.getRows().put(key,value);
        return this;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getRows() {
        return rows;
    }

    public void setRows(Map<String, Object> rows) {
        this.rows = rows;
    }
}
