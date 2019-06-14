package com.lizhao.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lizhao.pojo.PageInfo;
import com.lizhao.service.PeopleService;
import com.lizhao.service.impl.PeopleServiceImpl;

/** 
* @author by lizhao
* @version 2019年6月11日 下午2:55:32 
* 类说明 

*/
@WebServlet("/page")
public class PeopleServlet extends HttpServlet{
    
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PeopleService peopleservice = new PeopleServiceImpl();
        //如果是第一次访问，设置默认值
        String pageSizeStr = req.getParameter("pageSize");
        int pageSize = 2;
            if(pageSizeStr!=null&&!pageSizeStr.equals("")) {
                 pageSize = Integer.parseInt(pageSizeStr);//太蠢了这里竟然还加双引号
            }
       
        String pageNumberStr = req.getParameter("pageNumber");
        int pageNumber = 1;
        if(pageNumberStr!=null&&!pageNumberStr.equals("")) {
            pageNumber = Integer.parseInt(pageNumberStr);
       }
       PageInfo pi = peopleservice.showpage(pageSize, pageNumber);
       req.setAttribute("PageInfo", pi);//前台根据属性名取值Page.xxx
       req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
    
}
