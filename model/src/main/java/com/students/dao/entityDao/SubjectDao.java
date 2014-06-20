package com.students.dao.entityDao;

import com.students.dao.generalDao.SessionDao;
import com.students.entity.Subject;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 6/18/2014.
 */
@Component("subjectDao")
public class SubjectDao extends SessionDao<Subject> {

    @Override
    public Subject save(Subject object) {

        Integer idSubject = (Integer) sessionFactory.getCurrentSession().save(object);

        Subject subject = get(idSubject);

        return subject;
    }

    @Override
    public void update(Subject object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Subject object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Subject get(Integer id) {
        return (Subject) sessionFactory.getCurrentSession().load(Subject.class, id);
    }

    @Override
    public List<Subject> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Subject").list();
    }
}
