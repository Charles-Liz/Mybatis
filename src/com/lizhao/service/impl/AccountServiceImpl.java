package com.lizhao.service.impl;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lizhao.pojo.Account;
import com.lizhao.pojo.Log;
import com.lizhao.service.AccountService;

/** 
* @author by lizhao
* @version 2019年6月12日 下午5:32:01 
* 类说明  

*/
public class AccountServiceImpl implements AccountService{//一个表对应一个service
    @Override
    public int transfer(Account accIn, Account accOut) throws IOException {
        // TODO Auto-generated method stub
       InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
       SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
       SqlSession session = factory.openSession();
       Account accOutSelect = session.selectOne("selByAccnoPwd",accOut);
       if(accOutSelect!=null) {
           //账号密码匹配,准备转账
           Account accInSelect = session.selectOne("selByAccnoName",accIn);
           if(accInSelect!=null) {//说明转账账户正确
               if(accOutSelect.getBalance()>=accOut.getBalance()) {//余额充足,可以进行转账
                   accIn.setBalance(accIn.getBalance());
                   accOut.setBalance(-accOut.getBalance());
                   int index = session.update("upBalanceByAccno",accOut);//转账方
                   index+= session.update("upBalanceByAccno", accIn);//收款方
                   if(index==2) {//转账成功
                       //插到日志表
                       Log log = new Log();
                       log.setAccIn(accInSelect.getAccno());
                       log.setAccOut(accOutSelect.getAccno());
                       log.setMoney(accIn.getBalance());
                       session.insert("insToLog", log);
                       session.commit();
                       session.close();
                       return SUCCESS;
                   }else {//转账失败
                       session.rollback();
                       session.close();
                       return ERROR;
                   }
               }else {//返回余额不足
                   return ACCOUNT_BALANCE_NOT_ENOUGH;
               }
               
           }else { //收款人账号姓名不匹配
              return ACCOUT_NAME_NOT_MATCH;
           }
       }else {
           //不匹配则返回
           return ACCOUNT_PASSWORD_NOT_MACTH;
       }
    }

}
