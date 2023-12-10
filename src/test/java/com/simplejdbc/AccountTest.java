package com.simplejdbc;

import com.simplejdbc.dao.AccountDao;
import com.simplejdbc.pojo.Account;
import com.simplejdbc.util.Mybatis;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class AccountTest {

    @Test
    public void AccountAddTest() {

        try (SqlSession session = Mybatis.openSession()) {
            AccountDao dao = session.getMapper(AccountDao.class);
            Account account = new Account(3, "Agility", "123");
            Assert.assertTrue(dao.addAccount(account));
            session.commit();
        }
    }

    @Test
    public void AccountUpdate() {
        try (SqlSession session = Mybatis.openSession()) {
            AccountDao dao = session.getMapper(AccountDao.class);
            Assert.assertTrue(dao.updateAccount(3, "agility6", "321"));
            session.commit();
        }
    }

    @Test
    public void AccountRemove() {
        try (SqlSession session = Mybatis.openSession()) {
            AccountDao dao = session.getMapper(AccountDao.class);
            Assert.assertTrue(dao.deleteAccount(3));
            session.commit();
        }
    }

    @Test
    public void findAllAccount() {
        try (SqlSession session = Mybatis.openSession()) {
            AccountDao dao = session.getMapper(AccountDao.class);
            List<Account> accounts = dao.finaAllAccount();
            System.out.println(accounts);
        }

    }
}
