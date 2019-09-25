package com.webservice.personservice;

import com.eg.dao.IPersonDao;
import com.eg.daoImpl.PersonDaoImpl;
import com.eg.entity.Person;

/**
 * Created by zhujn on 2019/9/10.
 */
public interface IPersonService {

     Person findPerson(Integer id);
}
