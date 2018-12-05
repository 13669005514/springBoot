package com.example.dao;

import com.example.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 15:57
 */
@Repository
public interface UserJpaRepository extends JpaRepository<User,Integer> {

}
