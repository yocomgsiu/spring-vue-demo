package com.sjzHistory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sjzHistory.entity.User;
import com.sjzHistory.repository.UserRepository;

/**
 * 用户服务层实现类
 * Created by Yocomg on 2019/7/16
 */
@Service("UserService")
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;
    
    @Override
    public User findUserById(long id) {
    	return userRepository.findFirstById(id);
    }

    @Override
    public User saveUser(User User) {
        return userRepository.save(User);
    }

    @Override
    public User checkLogin(String name, String password) {
        return userRepository.findFirstByNameAndPassword(name, password);
    }
}
