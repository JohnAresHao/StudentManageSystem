package com.hzy.std_server.service;

import com.hzy.std_server.entity.CourseTeacherInfo;
import com.hzy.std_server.entity.SctInfo;
import com.hzy.std_server.entity.StudentCourseTeacher;
import com.hzy.std_server.mapper.StudentCourseTeacherMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 15:33
 * Description: None
 */
@Service
public class SctService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentCourseTeacherMapper studentCourseTeacherMapper;

    public List<CourseTeacherInfo> findBySid(Integer sid, String term) {
        return studentCourseTeacherMapper.findByStudentId(sid, term);
    }

    public List<String> findAllTerm() {
        return studentCourseTeacherMapper.findAllTerm();
    }

    public boolean isSctExist(StudentCourseTeacher studentCourseTeacher) {
        return studentCourseTeacherMapper.findBySct(studentCourseTeacher).size() != 0;
    }

    public boolean save(StudentCourseTeacher studentCourseTeacher) {
        return studentCourseTeacherMapper.insert(studentCourseTeacher);
    }

    public boolean deleteBySct(StudentCourseTeacher studentCourseTeacher) {
        return studentCourseTeacherMapper.deleteBySct(studentCourseTeacher);
    }

    public boolean deleteById(Integer sid, Integer cid, Integer tid, String  term) {
        StudentCourseTeacher studentCourseTeacher = new StudentCourseTeacher();
        studentCourseTeacher.setSid(sid);
        studentCourseTeacher.setCid(cid);
        studentCourseTeacher.setTid(tid);
        studentCourseTeacher.setTerm(term);
        return studentCourseTeacherMapper.deleteBySct(studentCourseTeacher);
    }

    public SctInfo findByIdWithTerm(Integer sid, Integer cid, Integer tid, String term) {
        return studentCourseTeacherMapper.findBySearch(
                sid, null, 0,
                cid, null, 0,
                tid, null, 0,
                null, null, term).get(0);
    }

    public boolean updateById(Integer sid, Integer cid, Integer tid, String term, Integer grade) {
        return studentCourseTeacherMapper.updateById(sid, cid, tid, term, grade);
    }

    public List<SctInfo> findBySearch(Map<String, String> map) {
        Integer sid = null, cid = null, tid = null;
        String sname = null, cname = null, tname = null, term = null;
        Integer sFuzzy = null, cFuzzy = null, tFuzzy = null;
        Integer lowBound = null, highBound = null;

        if (map.containsKey("cid")) {
            try {
                cid = Integer.parseInt(map.get("cid"));
            }
            catch (Exception e) {
            }
        }
        if (map.containsKey("sid")) {
            try {
                sid = Integer.parseInt(map.get("sid"));
            }
            catch (Exception e) {
            }
        }
        if (map.containsKey("tid")) {
            try {
                tid = Integer.parseInt(map.get("tid"));
            }
            catch (Exception e) {
            }
        }
        if (map.containsKey("sname")) {
            sname = map.get("sname");
        }
        if (map.containsKey("tname")) {
            tname = map.get("tname");
        }
        if (map.containsKey("cname")) {
            cname = map.get("cname");
        }
        if (map.containsKey("term")) {
            term = map.get("term");
        }
        if (map.containsKey("sFuzzy")) {
            sFuzzy = map.get("sFuzzy").equals("true") ? 1 : 0;
        }
        if (map.containsKey("tFuzzy")) {
            tFuzzy = map.get("tFuzzy").equals("true") ? 1 : 0;
        }
        if (map.containsKey("cFuzzy")) {
            cFuzzy = map.get("cFuzzy").equals("true") ? 1 : 0;
        }
        if (map.containsKey("lowBound")) {
            try {
                lowBound = Integer.parseInt(map.get("lowBound"));
            }
            catch (Exception e) {
            }
        }
        if (map.containsKey("highBound")) {
            try {
                highBound = Integer.valueOf(map.get("highBound"));
            }
            catch (Exception e) {
            }
        }

        logger.info("Sct 查询：" + map);
        return studentCourseTeacherMapper.findBySearch(
                sid, sname, sFuzzy,
                cid, cname, cFuzzy,
                tid, tname, tFuzzy,
                lowBound, highBound, term);
    }
}

