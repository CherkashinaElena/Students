package com.students.service;

import com.students.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Elena on 5/27/2014.
 */
@Service("studentService")
@Transactional
public class StudentService extends IService<Student> {

    @Override
    public Student save(Student object) {
        return studentDao.save(object);
    }

    @Override
    public void update(Student object) {
        studentDao.update(object);
    }

    @Override
    public void delete(Student object) {
        studentDao.delete(object);
    }

    @Override
    public Student get(Integer id) {
        return studentDao.get(id);
    }

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }
}