package com.simplejdbc.dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDao {

    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static  String url = "jdbc:mysql://127.0.0.1:3308/mysql_jdbc_learn?useSSL=false&userUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String urlName = "root";
    private static String password = "root";


    public int baseUpdate(String sql, Object ...args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {

            Class.forName(driver);
            connection = DriverManager.getConnection(url, urlName, password);

            preparedStatement = connection.prepareStatement(sql);

            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }

            row = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }


        return row;
    }

    public List baseQuery(Class cls, String sql, Object ...args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List res = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, urlName, password);

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            res = new ArrayList<>();


            Field[] declaredFields = cls.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                declaredField.setAccessible(true);
            }

            while (resultSet.next()) {
                Object o = cls.newInstance();
                for (Field declaredField : declaredFields) {
                    String name = declaredField.getName();
                    Object data = resultSet.getObject(name);
                    declaredField.set(o, data);
                }
                res.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return res;

    }
}

