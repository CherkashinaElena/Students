package com.students.dao;

import com.students.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 5/27/2014.
 */
@Component("studentDao")
public class StudentDao extends SessionDao<Student> {
    @Override
    public void save(Student object) {
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void update(Student object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Student object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Student get(Integer id) {
        return (Student) sessionFactory.getCurrentSession().load(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Student").list();
    }
}