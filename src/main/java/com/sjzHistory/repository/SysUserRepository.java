package com.sjzHistory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sjzHistory.entity.SysUser;

/**
 * 用户Dao层
 * 继承JapRepository，可以实现一些默认方法，如save/findAll/findOne/delete/count/exists 等
 * Created by Yocomg on 2019/7/16
 */
public interface SysUserRepository extends JpaRepository<SysUser,Integer> {
    /**
     * 按用户名——密码查找
     */
    SysUser findFirstByNameAndPassword(String name, String password);

}
