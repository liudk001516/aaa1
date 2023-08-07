package com.yunhe.dao;

import com.yunhe.enity.User;

public interface UserDao {
    User findUserByUserNameAndPassword(String username, String password);
}
