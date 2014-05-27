package com.students.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Elena on 5/27/2014.
 */
public class SemesterPK implements Serializable {
    private int idSemester;
    private int idSubject;

    @Column(name = "idSemester")
    @Id
    public int getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(int idSemester) {
        this.idSemester = idSemester;
    }

    @Column(name = "idSubject")
    @Id
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

        SemesterPK that = (SemesterPK) o;

        if (idSemester != that.idSemester) return false;
        if (idSubject != that.idSubject) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSemester;
        result = 31 * result + idSubject;
        return result;
    }
}
