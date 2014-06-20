package com.students.entity;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by Elena on 6/18/2014.
 */
@Entity
public class Subject {
    private int idSubject;
    private String name;
    private Collection<Semester> semestersByIdSubject;

    @Id
    @Column(name = "idSubject")
    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (idSubject != subject.idSubject) return false;
        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idSubject;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "subjectByIdSubject")
    public Collection<Semester> getSemestersByIdSubject() {
        return semestersByIdSubject;
    }

    public void setSemestersByIdSubject(Collection<Semester> semestersByIdSubject) {
        this.semestersByIdSubject = semestersByIdSubject;
    }
}
