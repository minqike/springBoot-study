package com.min.repository;

import com.min.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: cpb
 * @Date: 2018/8/7 20:07
 * @Description:
 */
public interface PermissionRepository extends JpaRepository<User,Long> {
}
