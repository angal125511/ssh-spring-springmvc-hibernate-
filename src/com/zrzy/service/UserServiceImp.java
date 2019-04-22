package com.zrzy.service;

import com.zrzy.dao.UserDao;
import com.zrzy.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/22
 * Time: 17:17
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public void add(User user) {

        userDao.add(user);
    }

    @Transactional
    @Override
    public void update(User user) {
        userDao.update(user);
    }
    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findOne(Integer id) {
        return (User)userDao.findById(id);
    }

    @Override
    public User findById(Integer id) {
        User user =(User) userDao.findById(id);
        return user;
    }
}
