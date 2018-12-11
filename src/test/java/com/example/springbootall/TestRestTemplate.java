package com.example.springbootall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootAllApplication.class)
public class TestRestTemplate {

    //使用RestTemplate运行单元测试时一定要注意先启动项目，不知道为啥，很奇怪！！！！！！！！！！！！！！
    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void test() {

        //不带参数以get方式访问
        restTemplate.getForObject("http://localhost:1001/all/hello", String.class);

        //带参数以get方式访问
        restTemplate.getForObject("http://localhost:1001/all/hello?token={1}", String.class, "111111");

        //带参数以get方式访问
        Map<String, Object> map = new HashMap<>();
        map.put("token", "111111");
        String res = restTemplate.getForObject("http://localhost:1001/all/hello?token={token}", String.class, map);
        System.out.println(res);

        //不带参数以post方式访问
        restTemplate.postForObject("http://localhost:1001/all/hello2", null, String.class);

        //带参数以post方式访问
        MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("token", "111111");
        res = restTemplate.postForObject("http://localhost:1001/all/hello2", multiValueMap, String.class);
        System.out.println(res);
    }
}
