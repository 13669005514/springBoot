package com.example.dao;

import com.example.pojo.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/6/ 16:03
 */
public interface UserCrudRepository extends CrudRepository<User,Integer> {
}
