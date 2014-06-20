package com.students.model;

import java.io.Serializable;

/**
 * Created by Elena on 6/15/2014.
 */
public class StudentsModel implements Serializable{

    private String idStudent;
    private String firstName;
    private String lastName;
    private String studentGroup;
    private String dateEntering;

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public String getDateEntering() {
        return dateEntering;
    }

    public void setDateEntering(String dateEntering) {
        this.dateEntering = dateEntering;
    }
}
