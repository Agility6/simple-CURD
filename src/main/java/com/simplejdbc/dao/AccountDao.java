package com.simplejdbc.dao;

import com.simplejdbc.pojo.Account;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {

    /**
     * 增加一个账户
     * @param account
     * @return 整数表示成功
     */
    @Insert("INSERT INTO Account VALUES (#{Aid}, #{AName}, #{APassword})")
    boolean addAccount(Account account);

    /**
     * 根据id删除账户信息
     * @param Aid
     * @return 整数代表成功
     */
    @Delete("DELETE FROM Account WHERE Aid = #{Aid}")
    boolean deleteAccount(int Aid);

    /**
     * 根据id修改账户的用户名和密码
     * @param Aid
     * @param newUsername
     * @param newPassword
     * @return 整数代表成功
     * @return 整数代表成功
     */
    @Update("UPDATE Account SET AName = #{AName}, APassword = #{APassword} WHERE Aid = #{Aid}")
    boolean updateAccount(@Param("Aid") int Aid,
                      @Param("AName") String newUsername,
                      @Param("APassword") String newPassword);


    List<Account> finaAllAccount();
}
