package com.example.demo;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class app2Test{
    @Autowired
    private SqlSession session;

    @Test
    public void test() throws Exception{
        System.out.println(session);
    }
}