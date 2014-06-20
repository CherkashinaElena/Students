package com.students.service;

import com.students.dao.securityEntity.UserManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by Elena on 5/28/2014.
 */
@Service("userService")
public class UserService implements UserDetailsService {

    @Autowired
    @Qualifier("userManager")
    UserManager userManager;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userManager.getUser(username);
    }
}
