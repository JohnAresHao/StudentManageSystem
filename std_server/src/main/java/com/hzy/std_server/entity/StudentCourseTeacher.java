package com.hzy.std_server.entity;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 11:26
 * Description: 学生选课类
 */
public class StudentCourseTeacher {
    private Integer sctid;
    private Integer sid;
    private Integer cid;
    private Integer tid;
    private Float grade;
    private String term;

    public Integer getSctid() {
        return sctid;
    }

    public void setSctid(Integer sctid) {
        this.sctid = sctid;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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
        return "StudentCourseTeacher{" +
                "sctid=" + sctid +
                ", sid=" + sid +
                ", cid=" + cid +
                ", tid=" + tid +
                ", grade=" + grade +
                ", term='" + term + '\'' +
                '}';
    }
}
