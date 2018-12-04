package com.example.service;

import com.example.dao.UsersRepository;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/4/ 10:15
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;


    @Override
    @Cacheable(value = "users")
    public List<User> findAllUsers() {
        return this.usersRepository.findAll();
    }

    @Override
    @Cacheable(value = "users")
    public Optional<User> findIdUser(Integer id) {
        return this.usersRepository.findById(id);
    }

    /**
     * key 属性：给存储的值起个名称。
     * 在查询时如果有名称相同的， 那么则知己从缓存中将数据返回
     * @param pageable
     * @return
     */
    @Override
    @Cacheable(value = "users",key = "#pageable.pageNumber")
    public Page<User> findUserPageId(Pageable pageable) {
        return this.usersRepository.findAll(pageable);
    }

    /**
     * 新增用户
     * CacheEvict清空指定的使用缓存方式
     * @param user
     * @return
     */
    @Override
    @CacheEvict(value = "users",allEntries = true)
    public User insertUser(User user) {
        return this.usersRepository.save(user);
    }
}
