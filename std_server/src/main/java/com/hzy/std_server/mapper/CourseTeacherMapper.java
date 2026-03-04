package com.hzy.std_server.mapper;

import com.hzy.std_server.entity.Course;
import com.hzy.std_server.entity.CourseTeacher;
import com.hzy.std_server.entity.CourseTeacherInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 15:17
 * Description: None
 */
@Mapper
@Repository
public interface CourseTeacherMapper {

    @Insert("INSERT INTO course_teacher (cid, tid, term) VALUES (#{cid}, #{tid}, #{term})")
    public boolean insertCourseTeacher(@Param("cid") Integer cid,
                                       @Param("tid") Integer tid,
                                       @Param("term") String term);

    public List<CourseTeacher> findBySearch(@Param("cid") Integer cid,
                                            @Param("tid") Integer tid,
                                            @Param("term") String term);

    public List<Course> findMyCourse(@Param("tid") Integer tid,
                                     @Param("term") String term);

    public List<CourseTeacherInfo> findCourseTeacherInfo(@Param("tid") Integer tid,
                                                         @Param("tname") String tname,
                                                         @Param("tFuzzy") Integer tFuzzy,
                                                         @Param("cid") Integer cid,
                                                         @Param("cname") String cname,
                                                         @Param("cFuzzy") Integer cFuzzy);

    @Delete("DELETE FROM course_teacher WHERE cid = #{c.cid} AND tid = #{c.tid}")
    public boolean deleteById(@Param("c") CourseTeacher courseTeacher);
}

