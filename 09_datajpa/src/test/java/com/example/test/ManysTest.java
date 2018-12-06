package com.example.test;

import com.example.Application;
import com.example.dao.UserJpaRepository;
import com.example.pojo.New;
import com.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/6 21:02
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ManysTest {

    @Autowired
    private UserJpaRepository userJpaRepository;


    @Test
    public void save() {
        User user = new User();
        user.setLoginName("李四");
        user.setPassword("123456");

        New aNew = new New();
        aNew.setContext("第一条新闻");
        New aNew2 = new New();
        aNew2.setContext("第二条新闻");

        user.getNews().add(aNew);
        user.getNews().add(aNew2);

        aNew.getUsers().add(user);
        aNew2.getUsers().add(user);

        this.userJpaRepository.save(user);



    }




}
