package com.hzy.std_server.mapper;

import com.hzy.std_server.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 12:25
 * Description: None
 */
@Mapper
@Repository
public interface StudentMapper {

    //    select
    public List<Student> findAll();

    public Student findById(@Param("sid") Integer sid);

    public List<Student> findBySearch(@Param("student") Student student, @Param("fuzzy") Integer fuzzy);

    //    update
    public boolean updateById(@Param("student") Student student);

    //    insert
    public boolean save(@Param("student") Student student);

    //    delete
    public boolean deleteById(@Param("sid") Integer sid);

}
