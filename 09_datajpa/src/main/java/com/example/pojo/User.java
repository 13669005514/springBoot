package com.example.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 15:50
 */
@Entity
@Table(name = "t_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login_name")
    private String loginName;

    @Column(name = "password")
    private String password;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")//外键
    private Role role;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_new",joinColumns = @JoinColumn(name = "user_id"),inverseJoinColumns = @JoinColumn(name = "new_id"))
    private Set<New> news = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public User setRole(Role role) {
        this.role = role;
        return this;
    }

    public Set<New> getNews() {
        return news;
    }

    public User setNews(Set<New> news) {
        this.news = news;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", loginName='" + loginName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
