package com.example.springbootall.mapper.cluster;

import com.example.springbootall.model.Student;

public interface StudentMapper {

    Student selectById(Integer id);

    int updateById(Student student);
}
