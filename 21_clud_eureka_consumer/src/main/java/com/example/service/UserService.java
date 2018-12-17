package com.example.service;

import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/15 20:46
 */
@Service
public class UserService {

    @Autowired
    private LoadBalancerClient loadBalancerClient;


    public List<User> getUsers() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("eureka_provider");
        StringBuffer sb = new StringBuffer();
        System.out.println(serviceInstance.getUri());
        sb.append("http://").append(serviceInstance.getHost()).append(":").append(serviceInstance.getPort()).append("/user/get");

        //创建springMVCTemplate
        RestTemplate rs = new RestTemplate();
        ParameterizedTypeReference<List<User>> type = new ParameterizedTypeReference<List<User>>(){};

        //封装返回信息
        ResponseEntity<List<User>> respone = rs.exchange(sb.toString(), HttpMethod.GET, null, type);

        List<User> users = respone.getBody();

        return users;
    }



}
