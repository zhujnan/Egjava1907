package com.eng.domain.test;

import com.eng.domain.User;
import com.eng.domain.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.reflect.annotation.ExceptionProxy;

import java.io.InputStream;

/**
 * Created by zhujn on 2019/9/26.
 */
public class TestUser {
    public static void main(String[] args)throws Exception{
       /* InputStream inputStream
                = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory
                = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();
        User u = new User(12,"12","12");
        session.insert("com.eng.mapper.save",u);*/
        SqlSession session = SqlSessionUtil.getSqlSession();
      /*  ¸ù¾Ýid²éÑ¯
      User u =
          session.selectOne("com.eng.mapper.selectById",12);
           System.out.println(u);*/
      session.delete("com.eng.mapper.removeUser",5);
        session.commit();
        session.close();
    };


}
