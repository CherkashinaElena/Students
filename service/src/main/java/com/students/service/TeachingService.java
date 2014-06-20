package com.students.service;

import com.students.entity.Teaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Elena on 6/17/2014.
 */
@Transactional
@Service("teachingService")
public class TeachingService extends IService<Teaching>{

    @Override
    public Teaching save(Teaching object) {
        return teachingDao.save(object);
    }

    @Override
    public void update(Teaching object) {
        teachingDao.update(object);
    }

    @Override
    public void delete(Teaching object) {
        teachingDao.delete(object);
    }

    @Override
    public Teaching get(Integer id) {
        return teachingDao.get(id);
    }

    @Override
    public List<Teaching> getAll() {
        return teachingDao.getAll();
    }

    @Transactional
    public List<Teaching> findTeachingByIdStudent(int idStudent){
        return teachingRepository.findTeachingByIdStudent(idStudent);
    }

    @Transactional
    public void deleteTeachingofStudent(int idStudent) {
        teachingRepository.deleteTeachingofStudent(idStudent);
    }

    @Transactional
    public void deleteTeachingofSubject(int idSubject){
        teachingRepository.deleteTeachingofSubject(idSubject);
    }

    @Transactional
    public List<Integer> getSemesterofStudent(int idStudent){
        return teachingRepository.getSemestersofStudent(idStudent);
    }

    @Transactional
    public List<Teaching> getTeachingofSemestr(int idStudent, int idSemester){
        return teachingRepository.getTeachingofSemestr(idStudent, idSemester);
    }

    @Transactional
    public Double averagePerSemester(int idStudent, int idSemester){
        return teachingRepository.averagePerSemester(idStudent, idSemester);
    }

    @Transactional
    public void deleteTeachingofSemester(int idSemester){
        teachingRepository.deleteTeachingofSemester(idSemester);
    }
}
