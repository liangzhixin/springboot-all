package com.example.springbootall.mapper.master;

import com.example.springbootall.model.Teacher;

public interface TeacherMapper {

    Teacher selectById(Integer id);

    int updateById(Teacher teacher);
}
