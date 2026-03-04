package com.hzy.std_server.mapper;

import com.hzy.std_server.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 12:34
 * Description: None
 */
@Mapper
@Repository
public interface TeacherMapper {
    //    select
    public List<Teacher> findAll();

    public Teacher findById(@Param("tid") Integer tid);

    public List<Teacher> findBySearch(@Param("tid") Integer tid, @Param("tname") String tname, @Param("fuzzy") Integer fuzzy);

    //    update
    public boolean updateById(@Param("teacher") Teacher teacher);

    //    insert
    public boolean save(@Param("teacher") Teacher teacher);

    //    delete
    public boolean deleteById(@Param("tid") Integer tid);

}
