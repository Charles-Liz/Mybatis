package com.lizhao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lizhao.mapper.StudentMapper;
import com.lizhao.mapper.TeacherMapper;
import com.lizhao.pojo.Student;
import com.lizhao.pojo.Teacher;



public class TestMybatis {
    static SqlSession session = null;
    static String resource = "mybatis-config.xml";
    static InputStream inputStream = null;
    static SqlSessionFactory sqlSessionFactory = null;
    public static  SqlSession getSqlSession() throws IOException {
            inputStream = Resources.getResourceAsStream(resource);//从src开始找
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);//构建者设计模式
            session = sqlSessionFactory.openSession();      
        return session;
        
    }
   
    
    
    public TestMybatis() {
        super();
        // TODO Auto-generated constructor stub
    }


    public static void main(String[] args) throws IOException {
      session = getSqlSession();
      StudentMapper stuMapper = session.getMapper(StudentMapper.class);
      TeacherMapper teaMapper = session.getMapper(TeacherMapper.class);
      //根据老师ID查询，且返回旗下的所有学生
//      List<Teacher> teacher = teaMapper.selectById(1);
//      System.out.println(teacher);
      //根据老师ID查询，且返回旗下的所有学生[多表单独查询]
        List<Teacher> selectById2 = teaMapper.selectById2(2);
        System.out.println(selectById2);
//      List<Student> list = stuMapper.selAll();
//      for(Student stu:list) {
//          System.out.println(stu);
//      }
    }

}
