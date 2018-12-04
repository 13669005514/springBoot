package com.example.test;

import com.example.Application;
import com.example.pojo.User;
import com.example.service.UserService;
import com.example.service.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/4/ 10:18
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserTest {

    @Autowired
    private UserService userService;

    @Test
    public void UserTest() {

        List<User> allUsers = userService.findAllUsers();
        for (User allUser : allUsers) {
            System.out.println(allUser);
        }
        System.out.println("============================");
        List<User> allUser2 = userService.findAllUsers();
        for (User allUser : allUser2) {
            System.out.println(allUser);
        }

    }


    @Test
    public void getId() {
        Optional<User> idUser = userService.findIdUser(1);
        System.out.println(idUser.toString());
        Optional<User> idUser2 =userService.findIdUser(1);
        System.out.println(idUser2.toString());
    }

    @Test
    public void getPage() {

       Pageable pageable = new PageRequest(0,2);
       long totalElements = userService.findUserPageId(pageable).getSize();
       System.out.println(totalElements);
       long totalElements2 = userService.findUserPageId(pageable).getSize();
       System.out.println(totalElements2);
       pageable = new PageRequest(0,1);
       long totalElements3 = userService.findUserPageId(pageable).getSize();
       System.out.println(totalElements3);
    }

    @Test
    public void saveUser() {
        int size = userService.findAllUsers().size();
        System.out.println(size);
        User user = new User();
        user.setName("李四2");
        user.setAge("16");
        User user1 = userService.insertUser(user);
        System.out.println(user1);

        int size2 = userService.findAllUsers().size();
        System.out.println(size2);

    }



}
