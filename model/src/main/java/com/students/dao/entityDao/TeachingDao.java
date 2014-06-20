package com.students.dao.entityDao;

import com.students.dao.generalDao.SessionDao;
import com.students.entity.Teaching;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Elena on 6/17/2014.
 */
@Component("teachingDao")
public class TeachingDao extends SessionDao<Teaching> implements ITeachingDao{

    @Override
    public Teaching save(Teaching object) {

        Integer idTeaching = (Integer) sessionFactory.getCurrentSession().save(object);

        Teaching teaching = get(idTeaching);

        return teaching;
    }

    @Override
    public void update(Teaching object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void delete(Teaching object) {
        sessionFactory.getCurrentSession().delete(object);
    }

    @Override
    public Teaching get(Integer id) {
        return (Teaching) sessionFactory.getCurrentSession().load(Teaching.class, id);
    }

    @Override
    public List<Teaching> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from Teaching").list();
    }
}
