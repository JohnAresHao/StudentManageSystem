package com.hzy.std_server.entity;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 11:26
 * Description: 课程类
 */
public class Course {
    private Integer cid;
    private String cname;
    private Integer ccredit;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getCcredit() {
        return ccredit;
    }

    public void setCcredit(Integer ccredit) {
        this.ccredit = ccredit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", ccredit=" + ccredit +
                '}';
    }
}
