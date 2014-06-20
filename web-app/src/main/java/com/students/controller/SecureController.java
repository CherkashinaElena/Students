package com.students.controller;

import com.students.entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by Elena on 5/28/2014.
 */
@Controller
public class SecureController {
    @ModelAttribute
    public User populateCurrentUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
