package com.eng.domain.test;

import com.eng.domain.Clazz;
import com.eng.domain.Student;
import com.eng.domain.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by zhujn on 2019/9/26.
 */
public class TestClazz {
    public static void main(String[] args){
        SqlSession session = SqlSessionUtil.getSqlSession();
        //1.先查询
        List<Clazz> studentList
                = session.selectList("com.eng.mapper.selectClazz");
       for(Clazz clazz : studentList){
           System.out.println(clazz);
       }
        session.commit();
        session.close();
        //2.再执行修改
    }
}
