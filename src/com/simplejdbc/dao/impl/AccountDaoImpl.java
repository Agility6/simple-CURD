package com.simplejdbc.dao.impl;

import com.simplejdbc.dao.AccountDao;
import com.simplejdbc.dao.BaseDao;
import com.simplejdbc.pojo.Account;

import java.util.List;

public class AccountDaoImpl extends BaseDao implements AccountDao {


    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static  String url = "jdbc:mysql://127.0.0.1:3308/mysql_jdbc_learn?useSSL=false&userUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai";
    private static String urlName = "root";
    private static String password = "root";

    @Override
    public int addAccount(Account account) {

        String sql = "insert into Account values(?, ?, ?)";
        return baseUpdate(sql, account.getAid(), account.getUsername(), account.getPassword());
    }

    @Override
    public int deleteAccount(int Aid) {

        String sql = "delete from Account where Aid = ?";
        return baseUpdate(sql, Aid);
    }

    @Override
    public int updateAccount(int Aid, String newUsername, String newPassword) {

        String sql = "update account set Aname = ?, APassword = ? where Aid = ?";
        return baseUpdate(sql, newUsername, newPassword, Aid);
    }

    @Override
    public List<Account> finaAllAccount() {

        String sql = "select * from Account";
        return baseQuery(Account.class, sql);
    }
}
