package com.example.test;

import com.example.Application;
import com.example.dao.*;
import com.example.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: zhangfx
 * @Date: 2018/12/5/ 16:01
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {Application.class})
public class UserTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserJpaRepository userJpaRepository;
    @Autowired
    private UserQueryRepository userQueryRepository;
    @Autowired
    private UserCrudRepository userCrudRepository;
//    @Autowired
//    private UserPageRepository userPageRepository;
    @Autowired
    private UserJpaSpeciRepository userJpaSpeciRepository;

    @Test
    public void saveUser() {
        User user = new User();
        user.setLoginName("root");
        user.setPassword("123456");
        this.userJpaRepository.save(user);
    }

    @Test
    public void findByUser() {

        for (User root : this.userRepository.findByLoginName("root")) {
            System.out.println(root);
        }
    }

    @Test
    public void findByUser2() {
        for (User root : this.userRepository.findByLoginNameAndPassword("root","123456")) {
            System.out.println(root);
        }
    }
    @Test
    public void findByUser3() {
        for (User root : this.userRepository.findByLoginNameLike("roo%")) {
            System.out.println(root);
        }
    }

    @Test
    public void findByUser4() {
        for (User root : this.userQueryRepository.queryUserName("root")) {
            System.out.println(root);
        }
    }


    @Test
    @Transactional
    @Rollback(false)//取消自动回滚
    public void findByUser5() {
       this.userQueryRepository.updateUserPassword("qwer");
    }

    @Test
    public void findByUser6() {
        List<User> all = (List<User>) this.userCrudRepository.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void findByUser7() {

        User user = new User();
        user.setLoginName("asd");
        user.setPassword("我是密码");
        User save = this.userCrudRepository.save(user);
        System.out.println(save);

    }

    @Test
    public void findByUser8() {
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Predicate equal = criteriaBuilder.equal(root.get("loginName"), "root");
                return equal;
            }
        };
        List<User> all = this.userJpaSpeciRepository.findAll(spec);
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 多条件查询
     */
    @Test
    public void findByUser9() {
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();
                predicates.add(criteriaBuilder.equal(root.get("loginName"),"root"));
                predicates.add(criteriaBuilder.equal(root.get("password"),"qwer"));

                Predicate[] predicates1 = new Predicate[predicates.size()];
                return criteriaBuilder.and(predicates.toArray(predicates1));
            }
        };
        List<User> all = this.userJpaSpeciRepository.findAll(spec);
        for (User user : all) {
            System.out.println(user);
        }
    }

    /**
     * 多条件查询
     */
    @Test
    public void findByUser10() {
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                return criteriaBuilder.and(criteriaBuilder.equal(root.get("loginName"),"root"),criteriaBuilder.equal(root.get("password"),"qwer"));
            }
        };
        List<User> all = this.userJpaSpeciRepository.findAll(spec);
        for (User user : all) {
            System.out.println(user);
        }
    }


}
