package com.example.dao;

import com.example.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/6/ 17:41
 */
public interface UserJpaSpeciRepository extends JpaRepository<User,Integer>,JpaSpecificationExecutor<User> {
}
