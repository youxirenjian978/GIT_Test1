package com.wwk.git.service.impl;

import com.wwk.git.dao.UserMapper;
import com.wwk.git.entity.User;
import com.wwk.git.entity.Users;
import com.wwk.git.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper uMapper;

    @Override
    public List<User> queryUserPage(Map<String, Object> param) {
        return uMapper.getUserList(param);
    }

    @Override
    public int getCount(Map<String, Object> param) {
        return uMapper.getUserTotal(param);
    }

    @Override
    public int add(User user) {
        return uMapper.insert(user);
    }

    @Override
    public int delete(long userId) {
        return uMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int update(User user) {
        return uMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Users getById(long userId) {
        return uMapper.getUserByUserId(userId);
    }

    @Override
    public List<Map<String, Object>> getSexNum() {
        return uMapper.getSexNum();
    }

    @Override
    public List<Map<String, Object>> getNum() {
        return uMapper.getNum();
    }
}
