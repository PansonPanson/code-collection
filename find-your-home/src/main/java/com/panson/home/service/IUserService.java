package com.panson.home.service;

import com.panson.home.entity.User;

/**
 * Package: com.panson.home.service
 * Description：
 * Author: Panson
 * Date: Created in 2018/7/11 14:21
 */
public interface IUserService {
    User findUserByName(String userName);
}
