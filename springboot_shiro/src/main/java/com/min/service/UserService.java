package com.min.service;

import com.min.entity.User;

import java.util.Set;

/**
 * @Auther: cpb
 * @Date: 2018/8/10 10:39
 * @Description:
 */
public interface UserService {
    User findByName(String userName);

    Set<String> findPermissions(String userName);

    Set<String> findRoles(String userName);

}
