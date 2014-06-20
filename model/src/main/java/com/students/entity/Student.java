package com.students.entity;

import org.codehaus.jackson.annotate.JsonBackReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

/**
 * Created by Elena on 6/18/2014.
 */
@Entity
public class Student {
    private int idStudent;
    private String firstName;
    private String lastName;
    private String studentGroup;
    private Date dateEntering;
    private Collection<Teaching> teachingsByIdStudent;

    @Id
    @Column(name = "idStudent")
    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "studentGroup")
    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    @Basic
    @Column(name = "dateEntering")
    public Date getDateEntering() {
        return dateEntering;
    }

    public void setDateEntering(Date dateEntering) {
        this.dateEntering = dateEntering;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (idStudent != student.idStudent) return false;
        if (dateEntering != null ? !dateEntering.equals(student.dateEntering) : student.dateEntering != null)
            return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;
        if (studentGroup != null ? !studentGroup.equals(student.studentGroup) : student.studentGroup != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudent;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (studentGroup != null ? studentGroup.hashCode() : 0);
        result = 31 * result + (dateEntering != null ? dateEntering.hashCode() : 0);
        return result;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "studentByIdStudent")
    public Collection<Teaching> getTeachingsByIdStudent() {
        return teachingsByIdStudent;
    }

    public void setTeachingsByIdStudent(Collection<Teaching> teachingsByIdStudent) {
        this.teachingsByIdStudent = teachingsByIdStudent;
    }
}
