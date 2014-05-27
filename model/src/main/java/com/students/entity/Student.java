package com.students.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

/**
 * Created by Elena on 5/27/2014.
 */
@Entity
public class Student {
    private int idStudent;
    private String firstName;
    private String lastName;
    private String group;
    private Date date;
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
    @Column(name = "group")
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (idStudent != student.idStudent) return false;
        if (date != null ? !date.equals(student.date) : student.date != null) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        if (group != null ? !group.equals(student.group) : student.group != null) return false;
        if (lastName != null ? !lastName.equals(student.lastName) : student.lastName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idStudent;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "studentByIdStudent")
    public Collection<Teaching> getTeachingsByIdStudent() {
        return teachingsByIdStudent;
    }

    public void setTeachingsByIdStudent(Collection<Teaching> teachingsByIdStudent) {
        this.teachingsByIdStudent = teachingsByIdStudent;
    }
}
