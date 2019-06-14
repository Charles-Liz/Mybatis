package com.lizhao.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.lizhao.mapper.ProductMapper;
import com.lizhao.pojo.Category;
import com.lizhao.pojo.Product;


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


    private static void listAll() throws IOException {
        session = TestMybatis.getSqlSession();
        List<Category> cg = session.selectList("selectAll");
        for(Category c:cg) {
            System.out.println(c);
        }
    }
    
    private static void insert(String name) throws IOException {
        session = getSqlSession();
        Category c = new Category();
        c.setName(name);
        session.insert("addCategory", c);
    }
    
    private static void update() throws IOException {
        session = getSqlSession();
        Category c = session.selectOne("getCategory", 15);
        c.setName("修改了15的名字");
        session.update("updateCategory", c);
    }
    private static void one2many() throws IOException {
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

    public static void main(String[] args) throws IOException {
      session = getSqlSession();
      ProductMapper product = session.getMapper(ProductMapper.class);//反射
      Product byId = product.getById(1);
      System.out.println(byId);
    }

}
