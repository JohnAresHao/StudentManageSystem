package com.hzy.std_server.controller;

import com.hzy.std_server.entity.Course;
import com.hzy.std_server.service.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 12:41
 * Description: 课程管理控制类
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/course")
public class CourseController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseService courseService;

    @PostMapping("/findBySearch")
    public List<Course> findBySearch(@RequestBody Map<String, String> map) {
        return courseService.findBySearch(map);
    }

    @GetMapping("/findById/{cid}")
    public List<Course> findById(@PathVariable Integer cid) {
        return courseService.findBySearch(cid);
    }

    @PostMapping("/save")
    public boolean save(@RequestBody Course course) {
        logger.info("add course="+course);
        return courseService.insertCourse(course);
    }

    @GetMapping("/deleteById/{cid}")
    public boolean deleteById(@PathVariable Integer cid) {
        logger.info("正在删除课程 cid: " + cid);
        return courseService.deleteById(cid);
    }

    @PostMapping("/updateCourse")
    public boolean updateCourse(@RequestBody Course course) {
        logger.info("正在修改课程: " + course);
        return courseService.updateById(course);
    }

}

