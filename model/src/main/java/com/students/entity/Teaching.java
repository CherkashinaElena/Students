package com.students.entity;

import javax.persistence.*;

/**
 * Created by Elena on 5/27/2014.
 */
@Entity
public class Teaching {
    private int idTeaching;
    private int idSemester;
    private int idSubject;
    private int idStudent;
    private Semester semester;
    private Student studentByIdStudent;

    @Id
    @Column(name = "idTeaching")
    public int getIdTeaching() {
        return idTeaching;
    }

    public void setIdTeaching(int idTeaching) {
        this.idTeaching = idTeaching;
    }

    @Basic
    @Column(name = "idSemester")
    public int getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(int idІemester) {
        this.idSemester = idІemester;
    }

    @Basic
    @Column(name = "idSubject")
    public int getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(int idSubject) {
        this.idSubject = idSubject;
    }

    @Basic
    @Column(name = "idStudent")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teaching teaching = (Teaching) o;

        if (idStudent != teaching.idStudent) return false;
        if (idSubject != teaching.idSubject) return false;
        if (idTeaching != teaching.idTeaching) return false;
        if (idSemester != teaching.idSemester) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTeaching;
        result = 31 * result + idSemester;
        result = 31 * result + idSubject;
        result = 31 * result + idStudent;
        return result;
    }

    @ManyToOne
    @JoinColumns({@JoinColumn(name = "idSemester", referencedColumnName = "idSemester", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "idSubject", referencedColumnName = "idSubject", nullable = false, insertable = false, updatable = false)})
    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    @ManyToOne
    @JoinColumn(name = "idStudent", referencedColumnName = "idStudent", nullable = false, insertable = false, updatable = false)
    public Student getStudentByIdStudent() {
        return studentByIdStudent;
    }

    public void setStudentByIdStudent(Student studentByIdStudent) {
        this.studentByIdStudent = studentByIdStudent;
    }
}
