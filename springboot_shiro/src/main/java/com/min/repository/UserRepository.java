package com.min.repository;

import com.min.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @Auther: cpb
 * @Date: 2018/8/7 20:07
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,Long>{
    @Query("select t from User t where t.username = ?1")
    User findByName(String userName);
}
