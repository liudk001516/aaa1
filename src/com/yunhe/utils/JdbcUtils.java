package com.yunhe.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class JdbcUtils {

    private static DataSource dataSource;

    static {
        Properties properties = new Properties();
        InputStream fis = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(fis);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接池
    public static DataSource getDataSource() {
        return dataSource;
    }

}
