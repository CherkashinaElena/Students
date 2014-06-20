package com.students.dao.entityDao;

import com.students.dao.generalDao.SessionDao;
import com.students.entity.Student;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 5/27/2014.
 */
@Component("studentDao")
public class StudentDao extends SessionDao<Student> implements IStudentDao {
    @Override
    public Student save(Student object) {
        Integer idStudent = (Integer) sessionFactory.getCurrentSession().save(object);

        Student student = get(idStudent);

        return student;
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
        return (Student) sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Student").list();
    }
}