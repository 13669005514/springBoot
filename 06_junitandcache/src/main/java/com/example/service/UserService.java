package com.example.service;

import com.example.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/4/ 14:48
 */
public interface UserService {

    /**
     * 查找全部用户
     * @return
     */
    List<User> findAllUsers();

    /**
     * 查找指定用户
     * @param id
     * @return
     */
    Optional<User> findIdUser(Integer id);

    /**
     * 分页查询设置
     * @param pageable
     * @return
     */
    Page<User> findUserPageId(Pageable pageable);

    /**
     * 新增用户
     * @param user
     * @return
     */
    User insertUser(User user);


}
