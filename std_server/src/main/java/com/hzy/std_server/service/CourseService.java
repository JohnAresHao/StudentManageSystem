package com.hzy.std_server.service;

import com.hzy.std_server.entity.Course;
import com.hzy.std_server.mapper.CourseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Created by IntelliJ IDEA
 * User: john
 * Time: 2026/3/4 12:41
 * Description: None
 */
@Service
public class CourseService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findBySearch(Map<String, String> map) {
        Integer cid = null;
        Integer lowBound = null;
        Integer highBound = null;
        Integer fuzzy = 0;
        String cname = null;

        if (map.containsKey("cid")) {
            try {
                cid = Integer.parseInt(map.get("cid"));
            }
            catch (Exception e) {
            }
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
        if (map.containsKey("cname")) {
            cname = map.get("cname");
        }
        if (map.containsKey("fuzzy")) {
            fuzzy = (map.get("fuzzy").equals("true")) ? 1 : 0;
        }
        logger.info("查询课程 map：" + map);
        logger.info(cid + " " + cname + " " + fuzzy + " " + lowBound + " " + highBound);
        return courseMapper.findBySearch(cid, cname, fuzzy, lowBound, highBound);
    }

    public List<Course> findBySearch(Integer cid) {
        return courseMapper.findBySearch(cid, null, 0, null, null);
    }

    public List<Course> findById(Integer cid) {
        HashMap<String, String> map = new HashMap<>();
        if (cid != null)
            map.put("cid", String.valueOf(cid));
        return findBySearch(map);
    }

    public boolean updateById(Course course) {
        return courseMapper.updateById(course);
    }

    public boolean insertCourse(Course course) {
        return courseMapper.insertCourse(course);
    }

    public boolean deleteById(Integer cid) {
        return courseMapper.deleteById(cid);
    }


}