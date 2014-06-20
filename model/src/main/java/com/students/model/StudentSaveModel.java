package com.students.model;

import java.util.Date;

/**
 * Created by Elena on 6/15/2014.
 */
public class StudentSaveModel {

    private String firstName;
    private String lastName;
    private String studentGroup;
    private Date dateEntering;

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

    public Date getDateEntering() {
        return dateEntering;
    }

    public void setDateEntering(Date dateEntering) {
        this.dateEntering = dateEntering;
    }
}
