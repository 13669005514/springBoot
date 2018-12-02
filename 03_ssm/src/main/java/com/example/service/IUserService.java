package com.example.service;

import com.example.pojo.User;

import java.util.List;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/1 21:03
 */
public interface IUserService {
    /**
     * 查询全部用户信息
     * @return 全部用户信息
     */
    List<User> selectUsers();

    /**
     * 新增单个用户信息
     * @param user
     * @return 插入结果
     */
    int insertUser(User user);

    /**
     * 修改指定用户信息
     * @param user
     * @return 修改结果
     */
    int updateUser(User user);

    /**
     * 删除指定用户信息
     * @param id
     * @return 删除结果
     */
    int deleteUser(Integer id);
}
