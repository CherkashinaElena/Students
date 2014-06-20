package com.students.entity;

import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;

/**
 * Created by Elena on 6/18/2014.
 */
@Entity
public class Teaching {
    private int idTeaching;
    private int idStudent;
    private int idSemester;
    private int idSubject;
    private Integer studentMark;
    private Student studentByIdStudent;
    private Semester semester;

    @Id
    @Column(name = "idTeaching")
    public int getIdTeaching() {
        return idTeaching;
    }

    public void setIdTeaching(int idTeaching) {
        this.idTeaching = idTeaching;
    }

    @Basic
    @Column(name = "idStudent")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "idSemester")
    public int getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(int idSemester) {
        this.idSemester = idSemester;
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
    @Column(name = "studentMark")
    public Integer getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(Integer studentMark) {
        this.studentMark = studentMark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teaching teaching = (Teaching) o;

        if (idSemester != teaching.idSemester) return false;
        if (idStudent != teaching.idStudent) return false;
        if (idSubject != teaching.idSubject) return false;
        if (idTeaching != teaching.idTeaching) return false;
        if (studentMark != null ? !studentMark.equals(teaching.studentMark) : teaching.studentMark != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTeaching;
        result = 31 * result + idStudent;
        result = 31 * result + idSemester;
        result = 31 * result + idSubject;
        result = 31 * result + (studentMark != null ? studentMark.hashCode() : 0);
        return result;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "idStudent", referencedColumnName = "idStudent", nullable = false, insertable = false, updatable = false)
    public Student getStudentByIdStudent() {
        return studentByIdStudent;
    }

    public void setStudentByIdStudent(Student studentByIdStudent) {
        this.studentByIdStudent = studentByIdStudent;
    }

    @JsonManagedReference
    @ManyToOne
    @JoinColumns({@JoinColumn(name = "idSemester", referencedColumnName = "idSemester", nullable = false, insertable = false, updatable = false), @JoinColumn(name = "idSubject", referencedColumnName = "idSubject", nullable = false, insertable = false, updatable = false)})
    public Semester getSemester() {
        return semester;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }
}
