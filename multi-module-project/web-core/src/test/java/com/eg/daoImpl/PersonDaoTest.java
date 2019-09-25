package com.eg.daoImpl;

import com.eg.entity.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by zhujn on 2019/9/11.
 */
public class PersonDaoTest {
    @Test
    public void testDeletePerson() {
        PersonDaoImpl personDao
                = new PersonDaoImpl();
        //Person p = new Person(1,2,"zs");
        boolean b = personDao.deletPerson(1);
        System.out.println(b);
    }

    @Test
    public void testFindPerson() {
        PersonDaoImpl personDao
                = new PersonDaoImpl();
        //Person p = new Person(1,2,"zs");
        ArrayList<Person> lists = personDao.findAll();
        System.out.println(lists.toString());

    }

    @Test
    public void testupdate() {
        PersonDaoImpl personDao
                = new PersonDaoImpl();
        Person p = new Person(1, 21, "1");
        boolean b = personDao.doUpdate(p);
        System.out.println(b);
    }

    @Test
    public void testpatch() {
        PersonDaoImpl personDao
                = new PersonDaoImpl();
        personDao.executeSql();
    }
}