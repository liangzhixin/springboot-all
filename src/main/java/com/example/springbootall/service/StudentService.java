package com.example.springbootall.service;

import com.alibaba.fastjson.JSON;
import com.example.springbootall.mapper.cluster.StudentMapper;
import com.example.springbootall.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Transactional(value = "clusterTransactionManager")
    public void test(){
        Student student = studentMapper.selectById(1);
        student.setAge(student.getAge() + 1);
        studentMapper.updateById(student);
        log.info(JSON.toJSONString(student));

        int i = 1/0;

        Student student2 = studentMapper.selectById(2);
        student2.setAge(student2.getAge() - 1);
        studentMapper.updateById(student2);
        log.info(JSON.toJSONString(student));
    }
}
