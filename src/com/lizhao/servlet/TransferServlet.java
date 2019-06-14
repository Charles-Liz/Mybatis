package com.lizhao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizhao.pojo.Account;
import com.lizhao.service.AccountService;
import com.lizhao.service.impl.AccountServiceImpl;

/** 
* @author by lizhao
* @version 2019年6月12日 下午8:05:15 
* 类说明 

*/
@WebServlet("/transfer")
public class TransferServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Account accOut = new Account();
        accOut.setAccno(req.getParameter("accOutNo"));
        accOut.setPassword(Integer.parseInt(req.getParameter("accOutPwd")));
        accOut.setBalance(Double.parseDouble(req.getParameter("balance")));
        Account accIn = new Account();
        accIn.setAccno(req.getParameter("accInNo"));
        accIn.setName(req.getParameter("accInName"));
        accIn.setBalance(Double.parseDouble(req.getParameter("balance")));
        AccountService accService = new AccountServiceImpl();
        int result = accService.transfer(accIn,accOut);
        if(result==AccountService.SUCCESS) {
            //resp.sendRedirect("/Mybatis/show");//跳转到分页显示log信息的servlet
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
        
    }
}
