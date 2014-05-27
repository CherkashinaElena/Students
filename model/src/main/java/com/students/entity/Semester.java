package com.students.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Elena on 5/27/2014.
 */
@Entity
@IdClass(SemesterPK.class)
public class Semester {
    private int idSemester;
    private Integer duration;
    private int idSubject;
    private Subject subjectByIdSubject;
    private Collection<Teaching> teachings;

    @Id
    @Column(name = "idSemester")
    public int getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(int idSemester) {
        this.idSemester = idSemester;
    }

    @Basic
    @Column(name = "duration")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    @Id
    @Column(name = "idSubject")
    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Semester semester = (Semester) o;

        if (idSemester != semester.idSemester) return false;
        if (idSubject != semester.idSubject) return false;
        if (duration != null ? !duration.equals(semester.duration) : semester.duration != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSemester;
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + idSubject;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "idSubject", referencedColumnName = "idSubject", nullable = false, insertable = false, updatable = false)
    public Subject getSubjectByIdSubject() {
        return subjectByIdSubject;
    }

    public void setSubjectByIdSubject(Subject subjectByIdSubject) {
        this.subjectByIdSubject = subjectByIdSubject;
    }

    @OneToMany(mappedBy = "semester")
    public Collection<Teaching> getTeachings() {
        return teachings;
    }

    public void setTeachings(Collection<Teaching> teachings) {
        this.teachings = teachings;
    }
}
