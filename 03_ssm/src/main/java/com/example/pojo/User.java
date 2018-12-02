package com.example.pojo;

/**
 * @Description:
 * 实体类User
 * @author: fxzhang
 * @Date: 2018/12/1 20:54
 */
public class User {

    /**
     * id 唯一标识号
     */
    private Integer id;
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 登录密码
     */
    private String password;
    /**
     * 名字
     */
    private String name;
    /**
     * 头像地址
     */
    private String head;

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getLoginName() {
        return loginName;
    }

    public User setLoginName(String loginName) {
        this.loginName = loginName;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getHead() {
        return head;
    }

    public User setHead(String head) {
        this.head = head;
        return this;
    }
}
