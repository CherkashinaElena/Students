package com.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Elena on 5/28/2014.
 */
@Controller
public class SigninController {

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        return new ModelAndView("home");
    }
}
