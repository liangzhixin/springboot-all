package com.example.springbootall.retry;

import com.example.springbootall.SpringbootAllApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {SpringbootAllApplication.class})
public class RetryJobSubTest {

    @Autowired
    private RetryJobSub retryJobSub;

    @Test
    public void test() {
        boolean res = retryJobSub.execute("lzx", 18);
        System.out.println("返回:" + res);
    }
}