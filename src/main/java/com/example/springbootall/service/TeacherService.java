package com.example.springbootall.service;

import com.alibaba.fastjson.JSON;
import com.example.springbootall.mapper.master.TeacherMapper;
import com.example.springbootall.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TeacherService {

    @Autowired
    private TeacherMapper teacherMapper;

    @Transactional(value = "masterTransactionManager")
    public void test(){
        Teacher teacher = teacherMapper.selectById(1);
        teacher.setAge(teacher.getAge() + 1);
        teacherMapper.updateById(teacher);
        log.info(JSON.toJSONString(teacher));

        int i = 1/0;

        Teacher teacher2 = teacherMapper.selectById(2);
        teacher2.setAge(teacher2.getAge() - 1);
        teacherMapper.updateById(teacher2);
        log.info(JSON.toJSONString(teacher2));
    }
}
