package com.example.dao;

import com.example.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/4/ 10:12
 */
/**
 * 参数一 T :当前需要映射的实体
 * 参数二 ID :当前映射的实体中的OID的类型
 *
 */
public interface UsersRepository extends JpaRepository<User,Integer>{

}

