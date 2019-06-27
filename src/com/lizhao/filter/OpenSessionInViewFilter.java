package com.lizhao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.ibatis.session.SqlSession;

import com.lizhao.util.MyBatisUtil;

/** 
* @author by lizhao
* @version 2019年6月17日 下午6:40:10 
* 类说明 

*/
@WebFilter("/*")
public class OpenSessionInViewFilter implements Filter{

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void doFilter(ServletRequest servletreq, ServletResponse servletresp, FilterChain filterchain)
            throws IOException, ServletException {
        SqlSession session  = MyBatisUtil.getSession();
        try {
            filterchain.doFilter(servletreq, servletresp);
            session.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            session.rollback();
            e.printStackTrace();
        }finally {
            MyBatisUtil.closeSession();
        }
        
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        
    }

}
