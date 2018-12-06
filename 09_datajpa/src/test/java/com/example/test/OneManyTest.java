package com.example.test;

import com.example.Application;
import com.example.dao.UserJpaRepository;
import com.example.dao.UserRepository;
import com.example.pojo.Role;
import com.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/6 20:06
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class OneManyTest {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    public void saveUser() {
        //1.创建用户
        User user = new User();
        user.setLoginName("张三");
        user.setPassword("123456");
        //2.创建用户权限
        Role role = new Role();
        role.setName("管理员");
        //维护关联关系
        role.getUsers().add(user);
        user.setRole(role);

        this.userJpaRepository.save(user);
    }
    @Test
    public void findAll() {
        List<User> all = this.userJpaRepository.findAll();
        for (User user : all) {
            System.out.println(user);
            String name = user.getRole().getName();
            System.out.println(name);
        }



    }


}
