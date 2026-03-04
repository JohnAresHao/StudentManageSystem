package com.hzy.std_server.controller;

import com.hzy.std_server.entity.Teacher;
import com.hzy.std_server.service.TeacherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 12:34
 * Description: 教师管理控制类
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/teacher")
public class TeacherController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private TeacherService teacherService;

    @PostMapping("/addTeacher")
    public boolean addTeacher(@RequestBody Teacher teacher) {
        return teacherService.save(teacher);
    }

    @PostMapping("/login")
    public boolean login(@RequestBody Teacher teacher) {
        logger.info("正在验证教师登陆 " + teacher);
        Teacher t = teacherService.findById(teacher.getTid());
        logger.info("数据库教师信息" + t);
        if (t == null || !t.getPassword().equals(teacher.getPassword())) {
            return false;
        }
        else {
            return true;
        }
    }

    @GetMapping("/findById/{tid}")
    public Teacher findById(@PathVariable("tid") Integer tid) {
        logger.info("正在查询学生信息 By id " + tid);
        return teacherService.findById(tid);
    }

    @PostMapping("/findBySearch")
    public List<Teacher> findBySearch(@RequestBody Map<String, String> map) {
        return teacherService.findBySearch(map);
    }

    @GetMapping("/deleteById/{tid}")
    public boolean deleteById(@PathVariable("tid") int tid) {
        logger.info("正在删除学生 tid：" + tid);
        return teacherService.deleteById(tid);
    }

    @PostMapping("/updateTeacher")
    public boolean updateTeacher(@RequestBody Teacher teacher) {
        logger.info("更新 " + teacher);
        return teacherService.updateById(teacher);
    }
}

