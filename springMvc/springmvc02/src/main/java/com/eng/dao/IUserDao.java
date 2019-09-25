package com.eng.dao;

import com.eng.entity.User;

import java.util.ArrayList;

/**
 * Created by zhujn on 2019/9/23.
 */
public interface IUserDao {
    ArrayList<User> findAll();

    User findById(Integer id);

    boolean deleteById(Integer id);

    void save(User u);

    void update(User u);
}
