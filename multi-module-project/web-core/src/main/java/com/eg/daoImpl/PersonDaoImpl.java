package com.eg.daoImpl;

import com.eg.dao.IPersonDao;
import com.eg.entity.Person;
import com.eg.util.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by zhujn on 2019/9/10.
 */
public class PersonDaoImpl
        implements IPersonDao {

    public String sayHello() {
        Person p = new Person();
        p.setAge(23);
        p.setName("zs");
        return p.getName()+p.getAge();
    }

    public Person findById(Integer id) {
        Connection con = null;
        ResultSet rest = null;
        Person p = null;
        try {
            con = (Connection) ConnectionUtils.openConnection();
            String sql ="select * from person where id=?";
            PreparedStatement preparedStatement
                    =con.prepareStatement(sql);
            preparedStatement.setObject(1,id);
            rest = preparedStatement.executeQuery();
            while (rest.next()){
                p = new Person();
                p.setId(rest.getInt("id"));
                p.setName(rest.getString("name"));
                p.setAge(rest.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return p;
    }

    public ArrayList<Person> findAll() {
        Connection con = null;
        ResultSet rest = null;
        ArrayList<Person> list= new ArrayList<Person>();
        Person p = null;
        try {
            con = (Connection) ConnectionUtils.openConnection();
            String sql ="select * from person";
            PreparedStatement preparedStatement
                    =con.prepareStatement(sql);
            rest = preparedStatement.executeQuery();
            while (rest.next()){
                p = new Person();
                p.setId(rest.getInt("id"));
                p.setName(rest.getString("name"));
                p.setAge(rest.getInt("age"));
                list.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean deletPerson(int id) {
            Connection con = null;
            boolean b= false;
            try {
                con = (Connection) ConnectionUtils.openConnection();
                String sql ="delete from person where id=?";
                PreparedStatement preparedStatement
                        =con.prepareStatement(sql);
                preparedStatement.setObject(1,id);
                int n = preparedStatement.executeUpdate();
                b = n >=1 ? true : false;
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return b;
    }

    public boolean doUpdate(Person p) {
            Connection con = null;
            boolean b = false;
            try {
                con = (Connection) ConnectionUtils.openConnection();
                String sql = " update person set name = ?,age = ? where id = ?";

                PreparedStatement preparedStatement
                        = con.prepareStatement(sql);
                preparedStatement.setObject(1, p.getName());
                preparedStatement.setObject(2, p.getAge());
                preparedStatement.setObject(3, p.getId());
                int n = preparedStatement.executeUpdate();
                b = n >= 1 ? true : false;
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return b;
    }

    public void executeSql() {
        String sql="insert into person(id) values(?)";
        try {
            Connection con = ConnectionUtils.openConnection();
            PreparedStatement stmt = null;
            con.setAutoCommit(false);
            stmt = con.prepareStatement(sql);
            for(int i=1;i<=25;i++){
                stmt.setInt(1,i);
                stmt.addBatch();
                //把sql语句加入批处理
                if(i%10==0){
                    stmt.executeBatch();//执行
                    stmt.clearBatch();//清除
                }
            }
            stmt.executeBatch();//执行最后剩下的
            con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    };

}
