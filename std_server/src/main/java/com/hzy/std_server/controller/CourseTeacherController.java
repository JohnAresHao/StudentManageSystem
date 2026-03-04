package com.hzy.std_server.controller;

import com.hzy.std_server.entity.Course;
import com.hzy.std_server.entity.CourseTeacher;
import com.hzy.std_server.entity.CourseTeacherInfo;
import com.hzy.std_server.service.CourseTeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 15:07
 * Description: 教师开设课程控制类
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/courseTeacher")
public class CourseTeacherController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseTeacherService courseTeacherService;

    @GetMapping("/insert/{cid}/{tid}/{term}")
    public boolean insert(@PathVariable Integer cid, @PathVariable Integer tid, @PathVariable String term) {
        if (courseTeacherService.findBySearch(cid, tid, term).size() != 0) {
            return false;
        }
        return courseTeacherService.insertCourseTeacher(cid, tid, term);
    }

    @GetMapping("/findMyCourse/{tid}/{term}")
    public List<Course> findMyCourse(@PathVariable Integer tid, @PathVariable String term) {
        logger.info("查询教师课程：" + tid + " " + term);
        return courseTeacherService.findMyCourse(tid, term);
    }

    @PostMapping("/findCourseTeacherInfo")
    public List<CourseTeacherInfo> findCourseTeacherInfo(@RequestBody Map<String, String> map) {
        return courseTeacherService.findCourseTeacherInfo(map);
    }

    @PostMapping("/deleteById")
    public boolean deleteById(@RequestBody CourseTeacher courseTeacher) {
        return courseTeacherService.deleteById(courseTeacher);
    }
}

