package com.lizhao.service;

import java.io.IOException;

import com.lizhao.pojo.PageInfo;

/** 
* @author by lizhao
* @version 2019年6月11日 下午12:07:05 
* 类说明 

*/
public interface PeopleService {
    PageInfo showpage(int pageSize,int pageNumber)throws IOException;
}
