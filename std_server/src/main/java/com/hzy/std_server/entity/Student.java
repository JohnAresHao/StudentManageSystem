package com.hzy.std_server.entity;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 11:21
 * Description: 学生类
 */
public class Student {
    private Integer sid;
    private String sname;
    private String password;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
