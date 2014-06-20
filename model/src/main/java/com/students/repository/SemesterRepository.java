package com.students.repository;

import com.students.entity.Semester;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Elena on 6/18/2014.
 */
@Repository("semesterRepository")
public class SemesterRepository extends IRepository{

    public List<Semester> findSemesterByIdSubject(int idSubject) {
        return sessionFactory.getCurrentSession().createQuery("from Semester where idSubject = " + idSubject + "").list();
    }

    public void deleteSemesterofSubject(int idSubject) {

        List<Semester> semesters = findSemesterByIdSubject(idSubject);

        for (Semester semester : semesters){
            sessionFactory.getCurrentSession().delete(semester);
        }
    }

    public List<Integer> getSemesters(){
        return sessionFactory.getCurrentSession().createQuery("select distinct idSemester from Semester order by idSemester").list();
    }

    public Integer getDurationofSemester(int idSemester){
        List<Integer> durations = sessionFactory.getCurrentSession().createQuery("select distinct duration " +
                "from Semester where idSemester = " + idSemester + "").list();

        Integer duration = null;

        for(Integer i : durations){
            duration = i;
        }

        return duration;
    }

    public List<Semester> getSubjectsofSemester(int idSemester){
        return sessionFactory.getCurrentSession().createQuery("from Semester where idSemester = " + idSemester + "").list();
    }


    public void deleteByIdSemester(int idSemester){

        List<Semester> semesters = getSubjectsofSemester(idSemester);

        for(Semester s : semesters){
            sessionFactory.getCurrentSession().delete(s);
        }
    }
}
