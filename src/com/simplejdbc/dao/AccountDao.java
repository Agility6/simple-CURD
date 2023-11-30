package com.simplejdbc.dao;

import com.simplejdbc.pojo.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 增加一个账户
     * @param account
     * @return 整数表示成功
     */
    int addAccount(Account account);

    /**
     * 根据id删除账户信息
     * @param Aid
     * @return 整数代表成功
     */
    int deleteAccount(int Aid);

    /**
     * 根据id修改账户的用户名和密码
     * @param Aid
     * @param newUsername
     * @param newPassword
     * @return 整数代表成功
     */
    int updateAccount(int Aid, String newUsername, String newPassword);

    List<Account> finaAllAccount();
}
