package com.hzy.std_server.entity;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 11:26
 * Description: 教师开设课程类
 */
public class CourseTeacher {
    private Integer ctid;
    private Integer cid;
    private Integer tid;
    private String term;

    public Integer getCtid() {
        return ctid;
    }

    public void setCtid(Integer ctid) {
        this.ctid = ctid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "CourseTeacher{" +
                "ctid=" + ctid +
                ", cid=" + cid +
                ", tid=" + tid +
                ", term='" + term + '\'' +
                '}';
    }
}
