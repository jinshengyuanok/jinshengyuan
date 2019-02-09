package com.yuan.utils;


import com.yuan.model.User;

public class SessionInfo implements java.io.Serializable {
    private String id;//用户ID
    private String userName;//用户名
    private String userIPAddress;//用户IP
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIPAddress() {
        return userIPAddress;
    }

    public void setUserIPAddress(String userIPAddress) {
        this.userIPAddress = userIPAddress;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
