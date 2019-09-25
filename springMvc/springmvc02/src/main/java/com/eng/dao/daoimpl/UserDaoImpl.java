package com.eng.dao.daoimpl;

import com.eng.dao.IUserDao;
import com.eng.entity.User;
import com.eng.entity.UserMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Created by zhujn on 2019/9/23.
 */
@Repository
public class UserDaoImpl
        extends JdbcDaoSupport implements IUserDao{

    @Override
    public ArrayList<User> findAll() {
        String sql = "select id,loginname,password from user";
        ArrayList<User> list =  (ArrayList)this.getJdbcTemplate()
                .query(sql,new UserMapper());
        return list;
    }
    @Override
    public User findById(Integer id) {
        String sql ="select * from user where id = ?";
        User u = (User)this.getJdbcTemplate()
                .queryForObject(sql,new Object[]{id},
                        new UserMapper());
        return u;
    }

    @Override
    public boolean deleteById(Integer id) {

        String sql ="delete from user where id = ?";
        int i = this.getJdbcTemplate().update(sql,id);
        return i>=1?true:false;
    }
    @Override
    public void save(User u){
        String sql ="insert into user"+
                "(id,loginname,password)"+
                "values(?,?,?)";
        this.getJdbcTemplate().update(sql,
                new Object[]{
                        u.getId(),
                        u.getLoginname(),
                        u.getPassword()
        });
    }

    @Override
    public void update(User u) {
        String sql ="update user set loginname = ?,password = ? where id = ?";
      this.getJdbcTemplate().update(sql,
              u.getLoginname(),u.getPassword(),u.getId());
    }
}
