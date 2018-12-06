package com.example.dao;

import com.example.pojo.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/6/ 15:17
 */
public interface UserQueryRepository extends Repository<User,Integer> {

    @Query(value = "select * from t_user where login_name = ?",nativeQuery = true)
    List<User> queryUserName(String name);

    //更新操作
    @Query(value = "update t_user set password = ? where login_name = 'root'",nativeQuery = true)
    @Modifying
    void updateUserPassword(String password);

}
