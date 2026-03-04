package com.hzy.std_server.mapper;

import com.hzy.std_server.entity.CourseTeacherInfo;
import com.hzy.std_server.entity.SctInfo;
import com.hzy.std_server.entity.StudentCourseTeacher;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 15:38
 * Description: None
 */
@Mapper
@Repository
public interface StudentCourseTeacherMapper {

    public List<CourseTeacherInfo> findByStudentId(@Param("sid") Integer sid,
                                                   @Param("term") String term);

    public List<SctInfo> findBySearch(@Param("sid") Integer sid,
                                      @Param("sname") String sname,
                                      @Param("sFuzzy") Integer sFuzzy,
                                      @Param("cid") Integer cid,
                                      @Param("cname") String cname,
                                      @Param("cFuzzy") Integer cFuzzy,
                                      @Param("tid") Integer tid,
                                      @Param("tname") String tname,
                                      @Param("tFuzzy") Integer tFuzzy,
                                      @Param("lowBound") Integer lowBound,
                                      @Param("highBound") Integer highBound,
                                      @Param("term") String term);

    @Select("SELECT DISTINCT sct.term FROM student_course_teacher sct")
    public List<String> findAllTerm();

    @Select("SELECT * FROM student_course_teacher WHERE sid = #{sct.sid} AND cid = #{sct.cid} AND tid = #{sct.tid} AND term = #{sct.term}")
    public List<StudentCourseTeacher> findBySct(@Param("sct") StudentCourseTeacher studentCourseTeacher);

    @Insert("INSERT INTO student_course_teacher (sid, cid, tid, term) VALUES (#{s.sid}, #{s.cid}, #{s.tid}, #{s.term})")
    public boolean insert(@Param("s")StudentCourseTeacher studentCourseTeacher);

    @Update("UPDATE student_course_teacher SET sct.grade = #{grade} WHERE sct.sid = #{sid} AND sct.tid = #{tid} AND sct.cid = #{cid} AND sct.term = #{term}")
    public boolean updateById(@Param("sid") Integer sid,
                              @Param("cid") Integer cid,
                              @Param("tid") Integer tid,
                              @Param("term") String term,
                              @Param("grade") Integer grade);

    @Delete("DELETE FROM student_course_teacher WHERE sid = #{sct.sid} AND tid = #{sct.tid} AND cid = #{sct.cid}")
    public boolean deleteBySct(@Param("sct") StudentCourseTeacher sct);
}

