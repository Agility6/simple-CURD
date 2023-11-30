package com.simplejdbc.dao.impl;

import com.simplejdbc.dao.AccountDao;
import com.simplejdbc.pojo.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {


    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static  String url = "jdbc:mysql://127.0.0.1:3308/mysql_jdbc_learn?useSSL=false&userUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String urlName = "root";
    private static String password = "root";

    @Override
    public int addAccount(Account account) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {

            Class.forName(driver);
            connection = DriverManager.getConnection(url, urlName, password);

            String sql = "insert into Account values(?, ?, ?)";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, account.getAid());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getPassword());

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

    @Override
    public int deleteAccount(int Aid) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {

            Class.forName(driver);
            connection = DriverManager.getConnection(url, urlName, password);

            String sql = "delete from Account where Aid = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, Aid);

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

    @Override
    public int updateAccount(int Aid, String newUsername, String newPassword) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int row = 0;

        try {

            Class.forName(driver);
            connection = DriverManager.getConnection(url, urlName, password);

            String sql = "update account set Aname = ?, APassword = ? where Aid = ?";

            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, newPassword);
            preparedStatement.setInt(3, Aid);

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

    @Override
    public List<Account> finaAllAccount() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Account> res = null;

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, urlName, password);

            String sql = "select * from Account";

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            res = new ArrayList<>();

            while (resultSet.next()) {
                int aid = resultSet.getInt("Aid");
                String sName = resultSet.getString("SName");
                String sPassword = resultSet.getString("SPassword");
                res.add(new Account(aid, sName, sPassword));
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
