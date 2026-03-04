package com.hzy.std_server.entity;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 11:26
 * Description: 教师课程成绩类
 */
public class CourseTeacherInfo {
    private Integer cid;
    private Integer tid;
    private String cname;
    private String tname;
    private Integer ccredit;
    private Float grade;

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

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getCcredit() {
        return ccredit;
    }

    public void setCcredit(Integer ccredit) {
        this.ccredit = ccredit;
    }

    public Float getGrade() {
        return grade;
    }

    public void setGrade(Float grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "CourseTeacherInfo{" +
                "cid=" + cid +
                ", tid=" + tid +
                ", cname='" + cname + '\'' +
                ", tname='" + tname + '\'' +
                ", ccredit=" + ccredit +
                ", grade=" + grade +
                '}';
    }
}
