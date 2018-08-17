package com.fatal.service.impl;

import com.fatal.entity.User;
import com.fatal.mapper.UserMapper;
import com.fatal.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User 服务实现
 * @author: Fatal
 * @date: 2018/8/17 0017 16:43
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;  // 这里会报错，但并不会影响

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        // 校验参数...
        return userMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public int insert(User record) {
        // 校验参数...
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        // 校验参数...
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer userId) {
        // 校验参数...
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        // 校验参数...
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        // 校验参数...
        return userMapper.updateByPrimaryKey(record);
    }

    /*
     * 这个方法中用到了我们开头配置依赖的分页插件pagehelper
     * 很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * pageNum 开始页数
     * pageSize 每页显示的数据条数
     * */
    @Override
    public List<User> list(Integer pageNum, Integer pageSize) {
        // 校验参数..
        // 将参数传进这个方法就可以实现物理分页了，非常简单
        PageHelper.startPage(pageNum,pageSize);
        // 查询出整个 List
        List<User> all = userMapper.list();
        // 把查询结果给 PageInfo，它会帮我们取出当前页的数据
        PageInfo pageInfo = new PageInfo(all);
        return pageInfo.getList();
    }

}
