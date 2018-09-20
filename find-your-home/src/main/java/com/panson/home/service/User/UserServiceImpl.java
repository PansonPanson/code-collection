package com.panson.home.service.User;

import com.panson.home.entity.Role;
import com.panson.home.entity.User;
import com.panson.home.repository.RoleRepository;
import com.panson.home.repository.UserRepository;
import com.panson.home.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Package: com.panson.home.service.User
 * Description：
 * Author: Panson
 * Date: Created in 2018/7/11 14:22
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User findUserByName(String userName) {
        User user =  userRepository.findByName(userName);

        if (user == null) {
            return null;
        }

        List<Role> roles = roleRepository.findRolesByUserId(user.getId());
        if (roles == null || roles.isEmpty()) {
            throw new DisabledException("权限非法");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("Role_" + role.getName())));
        user.setAuthorityList(authorities);
        return user;
    }
}
