package com.students.service;

import com.students.dao.Dao;
import com.students.entity.Student;
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

    public abstract void save(T object);

    public abstract void update(T object);

    public abstract void delete(T object);

    public abstract T get(Integer id);

    public abstract List<T> getAll();

}
