package com.students.model;

import java.util.List;

/**
 * Created by Elena on 6/18/2014.
 */
public class SemesterSaveModel {

    String semester;
    String duration;
    List<SubjectsModel> subjectList;

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<SubjectsModel> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<SubjectsModel> subjectList) {
        this.subjectList = subjectList;
    }
}
