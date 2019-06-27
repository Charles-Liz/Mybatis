package com.lizhao.mapper;

import java.util.List;

import com.lizhao.pojo.Teacher;

/** 
* @author by lizhao
* @version 2019年6月20日 下午6:14:22 
* 类说明 

*/
public interface TeacherMapper {
    Teacher selById(int id);
    List<Teacher> selectById(int id);
    List<Teacher> selectById2(int id);
}
