package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/1 21:03
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> selectUsers() {
        List<User> users = userMapper.selectUsers();
        return users;
    }

    @Override
    public int insertUser(User user) {

        return userMapper.insertUser(user);
    }

    @Override
    public int updateUser(User user) {


        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }
}
