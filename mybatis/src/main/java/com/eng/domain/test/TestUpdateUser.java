package com.eng.domain.test;

import com.eng.domain.User;
import com.eng.domain.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

/**
 * Created by zhujn on 2019/9/26.
 */
public class TestUpdateUser {
    public static void main(String[] args){
        SqlSession session = SqlSessionUtil.getSqlSession();
        //1.先查询
        User u = session.selectOne("com.eng.mapper.selectById",12);
        u.setLoginname("tom");
        u.setPassword("tom12");
        session.update("com.eng.mapper.updateUser",u);
        session.commit();
        session.close();
        //2.再执行修改
    }

}
