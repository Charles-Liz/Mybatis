package com.lizhao.pojo;
/** 
* @author by lizhao
* @version 2019年6月12日 下午3:45:06 
* 类说明 

*/
public class Account {
    private int id;
    private String accno;
    private int password;
    private String name;
    private double balance;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccno() {
        return accno;
    }
    public void setAccno(String accno) {
        this.accno = accno;
    }
    public int getPassword() {
        return password;
    }
    public void setPassword(int password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "Account [id=" + id + ", accno=" + accno + ", password=" + password + ", name=" + name + ", balance="
                + balance + "]";
    }
    

}
