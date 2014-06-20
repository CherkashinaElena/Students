package com.students.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Elena on 6/12/2014.
 */
@Controller
public class HomeController extends AbstractController{

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView mainPage() {
        return new ModelAndView("home");
    }

}
