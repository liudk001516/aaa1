package com.yunhe.service;

import com.yunhe.enity.User;

public interface UserService {

    User login(String username, String password);
}
