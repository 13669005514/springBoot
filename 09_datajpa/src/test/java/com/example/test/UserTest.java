package com.example.test;

import com.example.Application;
import com.example.dao.UserJpaRepository;
import com.example.dao.UserRepository;
import com.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 16:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserJpaRepository userJpaRepository;

    @Test
    public void saveUser() {
        User user = new User();
        user.setLoginName("root");
        user.setPassword("123456");
        this.userJpaRepository.save(user);
    }

    @Test
    public void findByUser() {

        for (User root : this.userRepository.findByLoginName("root")) {
            System.out.println(root);
        }
    }

    @Test
    public void findByUser2() {
        for (User root : this.userRepository.findByLoginNameAndPassword("root","123456")) {
            System.out.println(root);
        }
    }
    @Test
    public void findByUser3() {
        for (User root : this.userRepository.findByLoginNameLike("roo%")) {
            System.out.println(root);
        }
    }

}
