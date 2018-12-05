package com.example.dao;

import com.example.pojo.User;
import org.springframework.data.repository.Repository;

import javax.persistence.Entity;
import java.util.List;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 16:30
 */
@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User,Integer> {

    /**
     * 方法的名称必须遵循驼峰式命名 findBy+属性名称+查询条件(默认相等)
     * @param name
     * @return
     */
    List<User> findByLoginName(String name);

    List<User> findByLoginNameAndPassword(String name,String password);

    List<User> findByLoginNameLike(String name);

}
