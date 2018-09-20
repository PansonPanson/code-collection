package com.panson.home.repository;

import com.panson.home.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Package: com.panson.home.repository
 * Description：
 * Author: Panson
 * Date: Created in 2018/7/9 16:03
 */

public interface UserRepository extends CrudRepository<User, Long>{
    User findByName( String userName);
}
