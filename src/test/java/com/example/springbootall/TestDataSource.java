package com.example.springbootall;

import com.alibaba.fastjson.JSON;
import com.example.springbootall.mapper.cluster.StudentMapper;
import com.example.springbootall.mapper.master.TeacherMapper;
import com.example.springbootall.model.Student;
import com.example.springbootall.model.Teacher;
import com.example.springbootall.service.StudentService;
import com.example.springbootall.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootAllApplication.class})
@Slf4j
public class TestDataSource {

    @Autowired
    StudentService studentService;

    @Autowired
    TeacherService teacherService;

    @Test
    public void testTeacherMapper(){
        teacherService.test();
    }

    @Test
    public void testStudentMapper(){
        studentService.test();
    }
}
