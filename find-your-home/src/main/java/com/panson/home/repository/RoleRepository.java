package com.panson.home.repository;

import com.panson.home.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Package: com.panson.home.repository
 * Description：
 * Author: Panson
 * Date: Created in 2018/7/11 15:07
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findRolesByUserId(Long userId);
}
