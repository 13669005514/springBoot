package com.example.pojo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * @author: fxzhang
 * @Date: 2018/12/6 20:41
 */
@Entity
@Table(name = "new")
public class New {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "n_id")
    private Integer nid;

    @Column(name = "context")
    private String  context;

    @ManyToMany(mappedBy = "news")
    private Set<User> users = new HashSet<>();

    public Integer getNid() {
        return nid;
    }

    public New setNid(Integer nid) {
        this.nid = nid;
        return this;
    }

    public String getContext() {
        return context;
    }

    public New setContext(String context) {
        this.context = context;
        return this;
    }

    public Set<User> getUsers() {
        return users;
    }

    public New setUsers(Set<User> users) {
        this.users = users;
        return this;
    }

    @Override
    public String toString() {
        return "New{" +
                "nid=" + nid +
                ", context='" + context + '\'' +
                ", users=" + users +
                '}';
    }
}
