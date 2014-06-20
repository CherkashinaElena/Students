package com.students.service;

import com.students.dao.generalDao.Dao;
import com.students.entity.Semester;
import com.students.entity.Student;
import com.students.entity.Subject;
import com.students.entity.Teaching;
import com.students.repository.SemesterRepository;
import com.students.repository.TeachingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

/**
 * Created by Elena on 5/27/2014.
 */
public abstract class IService<T> {

    @Autowired
    @Qualifier("studentDao")
    Dao<Student> studentDao;

    @Autowired
    @Qualifier("subjectDao")
    Dao<Subject> subjectDao;

    @Autowired
    @Qualifier("semesterDao")
    Dao<Semester> semesterDao;

    @Autowired
    @Qualifier("teachingDao")
    Dao<Teaching> teachingDao;

    @Autowired
    @Qualifier("teachingRepository")
    TeachingRepository teachingRepository;

    @Autowired
    @Qualifier("semesterRepository")
    SemesterRepository semesterRepository;

    public abstract T save(T object);

    public abstract void update(T object);

    public abstract void delete(T object);

    public abstract T get(Integer id);

    public abstract List<T> getAll();

}
