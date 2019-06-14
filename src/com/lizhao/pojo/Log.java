package com.lizhao.pojo;
/** 
* @author by lizhao
* @version 2019年6月13日 上午11:40:43 
* 类说明 

*/
public class Log {
    private int id;
    private String accIn;
    private String accOut;
    private Double money;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccIn() {
        return accIn;
    }
    public void setAccIn(String accIn) {
        this.accIn = accIn;
    }
    public String getAccOut() {
        return accOut;
    }
    public void setAccOut(String accOut) {
        this.accOut = accOut;
    }
    public Double getMoney() {
        return money;
    }
    public void setMoney(Double money) {
        this.money = money;
    }
    @Override
    public String toString() {
        return "Log [id=" + id + ", accIn=" + accIn + ", accOut=" + accOut + ", money=" + money + "]";
    }

}
