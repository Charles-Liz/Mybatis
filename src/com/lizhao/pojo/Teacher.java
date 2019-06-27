package com.lizhao.pojo;

import java.util.List;

/** 
* @author by lizhao
* @version 2019年6月20日 下午6:05:20 
* 类说明 

*/
public class Teacher {
    private int id;
    private String name;
    private List<Student> stuList;
    public List<Student> getStuList() {
        return stuList;
    }
    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Teacher [id=" + id + ", name=" + name + ", stuList=" + stuList + "]";
    }
  
    

}
