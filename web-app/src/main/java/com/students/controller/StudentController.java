package com.students.controller;

import com.students.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Elena on 5/27/2014.
 */
@Controller
public class StudentController extends AbstractController {

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView studentsMainPage() {
        ModelAndView modelAndView = new ModelAndView("studentsPage", "commandStudents", new Student());

        modelAndView.addObject("studentsList", studentService.getAll());

        return modelAndView;
    }

}
