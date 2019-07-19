package com.sjzHistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjzHistory.entity.SysUser;
import com.sjzHistory.repository.SysUserRepository;

/**
 * 用户服务层实现类
 * Created by Yocomg on 2019/7/16
 */
@Service("SysUserService")
public class SysUserServiceImpl implements SysUserService{
    @Autowired
    SysUserRepository userRepository;

    @Override
    public SysUser saveUser(SysUser user) {
        return userRepository.save(user);
    }

    @Override
    public SysUser checkLogin(String name, String password) {
        return userRepository.findFirstByNameAndPassword(name, password);
    }
}
