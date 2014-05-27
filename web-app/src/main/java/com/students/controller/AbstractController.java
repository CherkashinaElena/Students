package com.students.controller;

import com.students.entity.Student;
import com.students.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by Elena on 5/27/2014.
 */
public abstract class AbstractController {

    @Autowired
    @Qualifier("studentService")
    IService<Student> studentService;
}
