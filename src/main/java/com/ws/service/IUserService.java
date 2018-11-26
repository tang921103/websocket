package com.ws.service;

import com.ws.entities.User;

import java.util.List;

public interface IUserService {
    List<User> getUsers(String username);
}
