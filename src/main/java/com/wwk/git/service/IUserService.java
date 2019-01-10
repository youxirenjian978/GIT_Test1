package com.wwk.git.service;


import com.wwk.git.entity.User;
import com.wwk.git.entity.Users;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<User> queryUserPage(Map<String, Object> param);

    int getCount(Map<String, Object> param);

    int add(User user);

    int delete(long userId);

    int update(User user);

    Users getById(long userId);

    List<Map<String, Object>> getSexNum();

    List<Map<String, Object>> getNum();
}
