package com.lizhao.mapper;

import java.util.List;

import com.lizhao.pojo.Student;

/** 
* @author by lizhao
* @version 2019年6月20日 下午6:34:05 
* 类说明 

*/
public interface StudentMapper {
    List<Student> selAll();
    List<Student> selectByTid(int id);
}
