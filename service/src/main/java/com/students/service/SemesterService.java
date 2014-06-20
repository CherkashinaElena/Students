package com.students.service;

import com.students.entity.Semester;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Elena on 6/18/2014.
 */
@Transactional
@Service("semesterService")
public class SemesterService extends IService<Semester> {

    @Override
    public Semester save(Semester object) {
        return semesterDao.save(object);
    }

    @Override
    public void update(Semester object) {
        semesterDao.update(object);
    }

    @Override
    public void delete(Semester object) {
        semesterDao.delete(object);
    }

    @Override
    public Semester get(Integer id) {
        return semesterDao.get(id);
    }

    @Override
    public List<Semester> getAll() {
        return semesterDao.getAll();
    }

    @Transactional
    public void deleteSemesterofSubject(int idSubject){
        semesterRepository.deleteSemesterofSubject(idSubject);
    }

    @Transactional
    public List<Integer> getSemesters(){
        return semesterRepository.getSemesters();
    }

    @Transactional
    public Integer getDurationofSemester(int idSemester){
        return semesterRepository.getDurationofSemester(idSemester);
    }

    @Transactional
    public List<Semester> getSubjectsofSemester(int idSemester){
       return semesterRepository.getSubjectsofSemester(idSemester);
    }

    @Transactional
    public void deleteByIdSemester(int idSemester){
        semesterRepository.deleteByIdSemester(idSemester);
    }
}
