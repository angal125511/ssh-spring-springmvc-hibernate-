package com.zrzy.service;

import com.zrzy.entity.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: 徐大伟
 * User: ${和敬清寂}
 * Date: 2019/4/22
 * Time: 17:17
 */
public interface UserService {

    public List<User> findAll();

    public void add(User user);

    public void update(User user);

    public void delete(User user);

    public User findOne(Integer id);

    public User findById(Integer id);

}
