package com.eg.dao;

import com.eg.entity.Person;

import java.util.ArrayList;

/**
 * Created by zhujn on 2019/9/10.
 */
public interface IPersonDao {
    String sayHello();
    Person findById(Integer id);
    ArrayList<Person> findAll();
    boolean deletPerson(int id);
    boolean doUpdate(Person p);
    void executeSql();
}
