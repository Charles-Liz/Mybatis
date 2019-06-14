package com.lizhao.service;

import java.io.IOException;

import com.lizhao.pojo.Account;

/** 
* @author by lizhao
* @version 2019年6月12日 下午5:27:26 
* 类说明 

*/
public interface AccountService {
    /**
     *  账号密码不匹配
     */
    public static final int ACCOUNT_PASSWORD_NOT_MACTH = 1;
    /**
     *  账号姓名不匹配
     */
    public static final int ACCOUT_NAME_NOT_MATCH = 2;
    /**
     * 余额不足
     */
    public static final int ACCOUNT_BALANCE_NOT_ENOUGH = 3;
    /**
     * 转账成功
     */
    public static final int SUCCESS = 4;
    /**
     * 转账失败
     */
    public static final int ERROR = 5;
    /**
     * 
     * @param accIn
     * @param accOut
     * @return
     * @throws IOException
     */
   public int transfer(Account accIn,Account accOut) throws IOException;
}
