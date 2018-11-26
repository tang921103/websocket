package com.ws.service;

import com.ws.dao.UserMapper;
import com.ws.entities.User;
import com.ws.entities.UserExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserService implements IUserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public List<User> getUsers(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        return userMapper.selectByExample(userExample);
    }
}
