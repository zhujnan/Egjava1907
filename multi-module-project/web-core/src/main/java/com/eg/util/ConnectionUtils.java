package com.eg.util;

/**
 * Created by zhujn on 2019/9/10.
 */

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtils {
    private static String url;
    private static String driver;
    private static String username;
    private static String password;
    static {
        Properties props
                = new Properties();
        try {
            props.load(ConnectionUtils.class
            .getClassLoader()
            .getResourceAsStream(
                    "propert.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(props!=null){
            url=props.getProperty("url");
            driver=props.getProperty("driver");
            username=props.getProperty("username");
            password=props.getProperty("password");
            try {
                Class.forName(driver);
                //通过反射加载驱动对象
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection openConnection()throws SQLException{
        DruidDataSource druidDataSource
                = new DruidDataSource();
        DruidPooledConnection connection
                = null;
        druidDataSource.setDriverClassName(driver);
        druidDataSource.setUrl(url);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        connection = druidDataSource.getConnection();
        return connection;
    }
    public static void main(String[] args)throws Exception{
        Connection con = openConnection();
        System.out.println(con);
    }

}
