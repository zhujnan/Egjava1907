package com.eng.domain.test;

import com.eng.domain.User;
import com.eng.domain.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhujn on 2019/9/26.
 */
public class TestSelectAll {

    public static void main(String[] args){
        SqlSession session = SqlSessionUtil.getSqlSession();
        List<Object> list
        =session.selectList("com.eng.mapper.selectAll2");
        System.out.println(list.size());
    }

}
