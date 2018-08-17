package com.fatal.service;

import com.fatal.entity.User;

import java.util.List;

/**
 * User 服务
 * @author: Fatal
 * @date: 2018/8/17 0017 16:42
 */
public interface UserService {

    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> list(Integer pageNum, Integer pageSize);

}
