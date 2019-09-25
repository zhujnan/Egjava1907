package com.webservice.personserviceimpl;

import com.eg.dao.IPersonDao;
import com.eg.daoImpl.PersonDaoImpl;
import com.eg.entity.Person;
import com.webservice.personservice.IPersonService;

/**
 * Created by zhujn on 2019/9/11.
 */
public class PersonServiceImpl
    implements IPersonService{
    IPersonDao pd = new PersonDaoImpl();
    public Person findPerson(Integer id) {
        return pd.findById(id);
    }
}
