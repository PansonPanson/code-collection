package com.panson.home.entity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.panson.home.ApplicationTests;
import com.panson.home.repository.UserRepository;
/**
 * Package: com.panson.home.entity
 * Description：
 * Author: Panson
 * Date: Created in 7/15 15:49
 */
public class UserRepositoryTest extends ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        User user = userRepository.findOne(1L);
        Assert.assertEquals("wali", user.getName());
    }
}
