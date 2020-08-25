package com.min.dao;


import java.util.Set;

/**
 * @Auther: cpb
 * @Date: 2018/8/2 09:46
 * @Description:
 */
public interface PermissionMapper {
    Set<String> findPermissions(String userName);

}
