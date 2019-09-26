package com.eng.domain.test;

import com.eng.domain.Student;
import com.eng.domain.User;
import com.eng.domain.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by zhujn on 2019/9/26.
 */
public class TestStudent {
    public static void main(String[] args){
        SqlSession session = SqlSessionUtil.getSqlSession();
        //1.先查询
        List<Student> studentList
                = session.selectList("com.eng.mapper.selectStudent");
        for (Student stu : studentList){
            System.out.println(stu);
        }
        session.commit();
        session.close();
        //2.再执行修改
    }
}
