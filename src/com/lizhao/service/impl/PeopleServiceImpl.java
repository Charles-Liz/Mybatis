package com.lizhao.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lizhao.pojo.PageInfo;
import com.lizhao.service.PeopleService;
import com.lizhao.test.TestMybatis;
/** 
* @author by lizhao
* @version 2019年6月11日 下午12:10:12 
* 类说明 

*/
public class PeopleServiceImpl implements PeopleService{
    /*
     * (non-Javadoc)
     * 分页查询
     * @see com.lizhao.service.PeopleService#showpage(int, int)
     */
    @Override
    public PageInfo showpage(int pageSize, int pageNumber)throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = factory.openSession();
        PageInfo pi = new PageInfo();
        pi.setPageSize(pageSize);
        pi.setPageNumber(pageNumber);
        Map<String,Object> map  = new HashMap<>();
        map.put("pageStart", pageSize*(pageNumber-1));
        map.put("pageSize", pageSize);
        pi.setList(session.selectList("page",map));
        long count = session.selectOne("selCount");//总条数
        pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
        return pi;
    }

}
