package com.min.service.UserServiceImpl;

import com.min.dao.PermissionMapper;
import com.min.dao.RoleMapper;
import com.min.entity.User;
import com.min.repository.UserRepository;
import com.min.service.UserService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Set;

/**
 * @Auther: cpb
 * @Date: 2018/8/10 10:39
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private PermissionMapper permissionMapper;

    @Resource
    private RoleMapper roleMapper;


    @Override
    public User findByName(String userName) {
        return userRepository.findByName(userName);
    }

    @Override
//    @Cacheable(value = "perm" ,key="#p0")
    public Set<String> findPermissions(String userName) {
        return permissionMapper.findPermissions(userName);
    }

    @Override
//    @Cacheable(value = "role" ,key="#p0")
    public Set<String> findRoles(String userName) {
        return roleMapper.findRoles(userName);
    }
}
