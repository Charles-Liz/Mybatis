package com.lizhao.pojo;
/** 
* @author by lizhao
* @version 2019年6月10日 下午3:32:21 
* 类说明 

*/
public class People {
    private int id;
    private String name;
    private int age;
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
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    @Override
    public String toString() {
        return "People [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
    public People(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
    public People() {
        // TODO Auto-generated constructor stub
    }
}
