package com.eng.domain.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.InputStream;

/**
 * Created by zhujn on 2019/9/26.
 */
public class SqlSessionUtil {
    private static SqlSessionFactory
        sqlSessionFactory = null;
    static {
        try{
            InputStream inputStream
                    = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory=
                    new SqlSessionFactoryBuilder().build(inputStream);
         }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }
    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
}
