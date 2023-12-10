package com.simplejdbc.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.Reader;

public class Mybatis {

    private static SqlSessionFactory factory;

    static {
        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
            factory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession openSession(boolean autoCommit) {
        return factory.openSession(autoCommit);
    }

    public static SqlSession openSession() {
        return factory.openSession();
    }

}
