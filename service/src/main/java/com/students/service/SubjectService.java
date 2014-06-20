package com.students.service;

import com.students.entity.Subject;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Elena on 6/18/2014.
 */
@Service("subjectService")
public class SubjectService extends IService<Subject> {

    @Override
    public Subject save(Subject object) {
        return subjectDao.save(object);
    }

    @Override
    public void update(Subject object) {
        subjectDao.update(object);
    }

    @Override
    public void delete(Subject object) {
        subjectDao.delete(object);
    }

    @Override
    public Subject get(Integer id) {
        return subjectDao.get(id);
    }

    @Override
    public List<Subject> getAll() {
        return subjectDao.getAll();
    }
}
