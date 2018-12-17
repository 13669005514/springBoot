package com.example;

import com.example.service.Provider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class ApplicationTests {

    @Autowired
    private Provider provider;

    @Test
    public void contextLoads() throws InterruptedException {
        while (true) {

            this.provider.send("hhhh");
            this.provider.send2("rrrrr");
            Thread.sleep(1000);
        }
    }


    @Test
    public void contextLoads2() throws InterruptedException {
        while (true) {
            this.provider.send3("hhhh");
            Thread.sleep(5000);
        }
    }

    @Test
    public void contextLoads3() throws InterruptedException {
        while (true) {
            this.provider.send4("hhhh");
            Thread.sleep(1000);
        }
    }

}

