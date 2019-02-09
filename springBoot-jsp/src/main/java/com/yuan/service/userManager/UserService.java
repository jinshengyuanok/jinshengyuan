package com.yuan.service.userManager;

import com.yuan.dao.userManageser.UserMapper;
import com.yuan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: jinshengyuan
 * Date: 2019-01-08
 * Time: 11:29
 * description:
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User getLoginUser(User user){
        return userMapper.getLoginUser(user);
    }

    public List<User> selectAll(){
        return userMapper.selectAll();
    }

    public int insertSelective(User user){
        return userMapper.insertSelective(user);
    }
}
