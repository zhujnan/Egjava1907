package com.eng.entity;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * ����һ��ӳ���࣬��д����mapRow��ɴӽ�����н��������
 * ������
 * Created by zhujn on 2019/9/19.
 */
public class UserMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
       User u = new User();
       u.setId(resultSet.getInt("id"));
      u.setLoginname(resultSet.getString("loginname"));
      u.setPassword(resultSet.getString("password"));
        return u;
    }
}
