package com.students.dao.entityDao;

import com.students.dao.generalDao.SessionDao;
import com.students.entity.Semester;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 6/18/2014.
 */
@Component("semesterDao")
public class SemesterDao extends SessionDao<Semester> {

    @Override
    public Semester save(Semester object) {

        sessionFactory.getCurrentSession().save(object);

        return null;
    }

    @Override
    public void update(Semester object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Semester object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Semester get(Integer id) {
        return (Semester) sessionFactory.getCurrentSession().load(Semester.class, id);
    }

    @Override
    public List<Semester> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Semester").list();
    }
}
