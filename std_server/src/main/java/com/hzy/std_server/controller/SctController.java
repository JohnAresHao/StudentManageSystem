package com.hzy.std_server.controller;

import com.hzy.std_server.entity.CourseTeacherInfo;
import com.hzy.std_server.entity.SctInfo;
import com.hzy.std_server.entity.StudentCourseTeacher;
import com.hzy.std_server.service.SctService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 15:08
 * Description: 学生选课成绩控制类
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/sct")
public class SctController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SctService sctService;

    @PostMapping("/save")
    public String save(@RequestBody StudentCourseTeacher studentCourseTeacher) {
        if (sctService.isSctExist(studentCourseTeacher)) {
            return "禁止重复选课";
        }
        logger.info("正在保存 sct 记录：" + studentCourseTeacher);
        return sctService.save(studentCourseTeacher) ? "选课成功" : "选课失败，联系管理员";
    }

    @GetMapping("/findBySid/{sid}/{term}")
    public List<CourseTeacherInfo> findBySid(@PathVariable Integer sid, @PathVariable String term) {
        return sctService.findBySid(sid, term);
    }

    @GetMapping("/findAllTerm")
    public List<String> findAllTerm() {
        return sctService.findAllTerm();
    }

    @PostMapping("/deleteBySct")
    public boolean deleteBySct(@RequestBody StudentCourseTeacher studentCourseTeacher) {
        logger.info("正在删除 sct 记录：" + studentCourseTeacher);
        return sctService.deleteBySct(studentCourseTeacher);
    }

    @PostMapping("/findBySearch")
    public List<SctInfo> findBySearch(@RequestBody Map<String, String> map) {
        return sctService.findBySearch(map);
    }

    @GetMapping("/findById/{sid}/{cid}/{tid}/{term}")
    public SctInfo findById(@PathVariable Integer sid,
                            @PathVariable Integer cid,
                            @PathVariable Integer tid,
                            @PathVariable String term) {
        return sctService.findByIdWithTerm(sid, cid, tid, term);
    }

    @GetMapping("/updateById/{sid}/{cid}/{tid}/{term}/{grade}")
    public boolean updateById(@PathVariable Integer sid,
                              @PathVariable Integer cid,
                              @PathVariable Integer tid,
                              @PathVariable String term,
                              @PathVariable Integer grade) {
        return sctService.updateById(sid, cid, tid, term, grade);
    }

    @GetMapping("/deleteById/{sid}/{cid}/{tid}/{term}")
    public boolean deleteById(@PathVariable Integer sid,
                              @PathVariable Integer cid,
                              @PathVariable Integer tid,
                              @PathVariable String term) {
        return sctService.deleteById(sid, cid, tid, term);
    }

}

