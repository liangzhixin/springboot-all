package com.example.springbootall.datasource.transaction;

import com.example.springbootall.mapper.master.TeacherMapper;
import com.example.springbootall.model.Teacher;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Administrator    测试事务的有效性
 */
@Service
public class TestTransactionService {

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 本类调用事务方法,必须通过((xxxService)AopContext.currentProxy()).方法名()来调用事务方法
     */
    public void test() throws Exception {
//        test1();  //事务不生效
//        ((TestTransactionService)AopContext.currentProxy()).test1();    //事务生效
        ((TestTransactionService)AopContext.currentProxy()).test2();    //默认只对RuntimeException和Error生效
    }

    /**
     * rollbackFor指定需要回滚的异常
     */
    @Transactional(value = "masterTransactionManager",rollbackFor = Exception.class)
    public void test1(){
        Teacher teacher1 = teacherMapper.selectById(1);
        Teacher teacher2 = teacherMapper.selectById(2);

        teacher1.setAge(teacher1.getAge() + 1);
        teacherMapper.updateById(teacher1);
        int i = 1/0;
        teacher2.setAge(teacher2.getAge() - 1);
        teacherMapper.updateById(teacher2);
    }

    /**
     * 不指定rollbackFor,则默认只针对RuntimeException和Error进行回滚
     *
     * 当然我们可以通过TransactionAspectSupport.currentTransactionStatus().setRollbackOnly()进行手动回滚
     */
    @Transactional(value = "masterTransactionManager")
    public void test2() throws Exception {
        try {
            Teacher teacher1 = teacherMapper.selectById(1);
            Teacher teacher2 = teacherMapper.selectById(2);

            teacher1.setAge(teacher1.getAge() + 1);
            teacherMapper.updateById(teacher1);

            //抛出异常
            try {
                File f = new File("a/a/a/a/aa");
                FileInputStream in = new FileInputStream(f);
                in.close();
            } catch (Exception e) {
                throw new IOException();                //非RuntimeException和Error
                //            throw new NullPointerException();     //RuntimeException
            }

            teacher2.setAge(teacher2.getAge() - 1);
            teacherMapper.updateById(teacher2);
        }catch (Exception e){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            throw new Exception(e);
        }
    }
}
