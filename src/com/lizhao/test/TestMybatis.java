package com.lizhao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lizhao.pojo.Category;
import com.lizhao.pojo.Product;


public class TestMybatis {
    static SqlSession session = null;
    static String resource = "mybatis-config.xml";
    static InputStream inputStream = null;
    static SqlSessionFactory sqlSessionFactory = null;
    private static  SqlSession getSqlSession() {
        try {
            inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return session;
        
    }
    
    private static void listAll() {
        session = TestMybatis.getSqlSession();
        List<Category> cg = session.selectList("selectAll");
        for(Category c:cg) {
            System.out.println(c);
        }
    }
    
    private static void insert(String name) {
        session = getSqlSession();
        Category c = new Category();
        c.setName(name);
        session.insert("addCategory", c);
    }
    
    private static void update() {
        session = getSqlSession();
        Category c = session.selectOne("getCategory", 15);
        c.setName("修改了15的名字");
        session.update("updateCategory", c);
    }
    private static void one2many() {
        session=getSqlSession();
        List<Category> cg = session.selectList("listCategory");
        System.out.println(cg.size());
        for(Category c :cg) {
            System.out.println(c);
            List<Product> ps = c.getProducts();
            for(Product p:ps) {
                System.out.println("\t"+p);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       //insert("新的Category4");
        try {
            one2many();
        }finally {
            session.commit();
            session.close();
        }
      // listAll();
       
    }

}
