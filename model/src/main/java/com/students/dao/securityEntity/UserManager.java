package com.students.dao.securityEntity;

import com.students.entity.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by Elena on 5/28/2014.
 */
@Component("userManager")
public class UserManager {

    private HashMap<String, User> users;

    public UserManager() {
        users = new HashMap<String, User>();
        users.put("elena", new User("elena", "elena", "ROLE_USER"));
        users.put("admin", new User("admin", "admin", "ROLE_USER, ROLE_ADMIN"));
    }

    public User getUser(String username) throws UsernameNotFoundException {
        if( !users.containsKey( username ) ){
            throw new UsernameNotFoundException(username + " not found" );
        }

        return users.get( username );
    }
}
