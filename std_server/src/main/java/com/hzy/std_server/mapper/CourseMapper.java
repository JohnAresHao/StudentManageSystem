package com.hzy.std_server.mapper;

import com.hzy.std_server.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 12:41
 * Description: None
 */
@Mapper
@Repository
public interface CourseMapper {
    //    select
    public List<Course> findBySearch(@Param("cid") Integer cid,
                                     @Param("cname") String cname, @Param("fuzzy") Integer fuzzy,
                                     @Param("lowBound") Integer lowBound, @Param("highBound") Integer highBound);

    //    insert
    public boolean insertCourse(@Param("course") Course course);

    //    update
    public boolean updateById(@Param("course") Course course);

    //    delete
    public boolean deleteById(@Param("cid") Integer cid);
}
