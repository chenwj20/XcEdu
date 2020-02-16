package com.xuecheng.auth;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestClient {
    @Test
    public void test01(){
        String password = "123456";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i < 6; i++) {
            String encode = bCryptPasswordEncoder.encode(password);
            System.out.println(encode);
        }
    }
}
