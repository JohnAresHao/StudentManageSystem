package com.hzy.std_server.entity;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 11:26
 * Description: 学生选课信息类
 */
public class SctInfo {
    private Integer sid;
    private Integer tid;
    private Integer cid;
    private String sname;
    private String tname;
    private String cname;
    private Float grade;
    private String term;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "SctInfo{" +
                "sid=" + sid +
                ", tid=" + tid +
                ", cid=" + cid +
                ", sname='" + sname + '\'' +
                ", tname='" + tname + '\'' +
                ", cname='" + cname + '\'' +
                ", grade=" + grade +
                ", term='" + term + '\'' +
                '}';
    }
}
