package com.students.repository;

import com.students.entity.Teaching;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elena on 6/17/2014.
 */
@Repository("teachingRepository")
public class TeachingRepository extends IRepository {

    public List<Teaching> findTeachingByIdStudent(int idStudent) {
        return sessionFactory.getCurrentSession().createQuery("from Teaching where idStudent = " + idStudent + "").list();
    }

    public List<Teaching> findTeachingByIdSubject(int idSubject) {
        return sessionFactory.getCurrentSession().createQuery("from Teaching where idSubject = " + idSubject + "").list();
    }

    public List<Teaching> findTeachingByIdSemester(int idSemester) {
        return sessionFactory.getCurrentSession().createQuery("from Teaching where idSemester = " + idSemester + "").list();
    }

    public void deleteTeachingofStudent(int idStudent) {

        List<Teaching> teachings = findTeachingByIdStudent(idStudent);

        for (Teaching teaching : teachings){
            sessionFactory.getCurrentSession().delete(teaching);
        }
    }

    public void deleteTeachingofSubject(int idSubject) {

        List<Teaching> teachings = findTeachingByIdStudent(idSubject);

        for (Teaching teaching : teachings){
            sessionFactory.getCurrentSession().delete(teaching);
        }
    }

    public void deleteTeachingofSemester(int idSemester){
        List<Teaching> teachings = findTeachingByIdSemester(idSemester);

        for (Teaching teaching : teachings){
            sessionFactory.getCurrentSession().delete(teaching);
        }
    }

    public List<Integer> getSemestersofStudent(int idStudent){
        return sessionFactory.getCurrentSession().createQuery("select distinct idSemester from Teaching where idStudent = " + idStudent + " " +
                "order by idSemester").list();
    }

    public List<Teaching> getTeachingofSemestr(int idStudent, int idSemester){
        return sessionFactory.getCurrentSession().createQuery("from Teaching " +
                "where idStudent = " + idStudent + " and idSemester = " + idSemester + "").list();
    }

    public Double averagePerSemester(int idStudent, int idSemester){
        Double sum = 0.0;

        List<Teaching> teachings = getTeachingofSemestr(idStudent, idSemester);
        if(teachings == null){
            return null;
        }else{
            for(Teaching t : teachings){
                sum += t.getStudentMark();
            }
        }
        return sum / teachings.size();
    }
}
