package com.ws;

import com.ws.dao.UserMapper;
import com.ws.entities.User;
import com.ws.entities.UserExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WsApplicationTests {
    @Resource
    private UserMapper userMapper;
    @Test
    public void contextLoads() {
    }
    @Test
    public void getAllUsers(){
        UserExample userExample = new UserExample();
        List<User> list =  userMapper.selectByExample(userExample);
        System.out.println(list);
        System.out.println("test");
    }
}
