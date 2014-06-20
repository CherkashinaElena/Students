package com.students.controller;

import com.students.entity.Semester;
import com.students.entity.Subject;
import com.students.model.SemesterSaveModel;
import com.students.model.SubjectsModel;
import com.students.service.SemesterService;
import com.students.service.TeachingService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elena on 6/18/2014.
 */
@Controller
public class SemesterController extends AbstractController{

    @RequestMapping(value = "/semesters", method = RequestMethod.GET)
    public ModelAndView semestersPage() {

        ModelAndView modelAndView = new ModelAndView("semesterPage", "semesterList", ((SemesterService)semesterService).getSemesters());
        modelAndView.addObject("duration", ((SemesterService)semesterService).getDurationofSemester(1));
        modelAndView.addObject("subjects", ((SemesterService)semesterService).getSubjectsofSemester(1));

        return modelAndView;
    }

    @RequestMapping(value = "/getSubjects", method = RequestMethod.GET)
    @ResponseBody
    public String ajaxTeaching(WebRequest request) throws Exception {

        int idSemester = Integer.parseInt(request.getParameter("semester"));

        List<Semester> semesters = ((SemesterService)semesterService).getSubjectsofSemester(idSemester);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = "";
        try {
            json = objectMapper.writeValueAsString(semesters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return json;
    }

    @RequestMapping(value = "/semesterSavePage", method = RequestMethod.GET)
    public ModelAndView semesterSavePage(@ModelAttribute SemesterSaveModel semester) {

        return new ModelAndView("saveSemester", "subjectList", subjectService.getAll());
    }

    @RequestMapping(value = "/saveSemester", method = RequestMethod.POST)
    @ResponseBody
    public String saveSemester(@RequestBody SemesterSaveModel semester) {

        int idSemester = Integer.parseInt(semester.getSemester());
        int duration = Integer.parseInt(semester.getDuration());
        List<Subject> subjects = new ArrayList<Subject>();

        for(SubjectsModel s : semester.getSubjectList()){
            Subject subject = new Subject();

            subject.setIdSubject(Integer.parseInt(s.getIdSubject()));
            subject.setName(s.getName());

            subjects.add(subject);
        }

        List<Semester> semestersfromDB = ((SemesterService)semesterService).getSubjectsofSemester(idSemester);

        if(semestersfromDB.size() == 0){
            for(Subject s : subjects){
                Semester newSemester = new Semester();

                newSemester.setIdSemester(idSemester);
                newSemester.setDuration(duration);
                newSemester.setIdSubject(s.getIdSubject());
                newSemester.setSubjectByIdSubject(s);

                semesterService.save(newSemester);
            }
        }else{
            ((SemesterService)semesterService).deleteByIdSemester(idSemester);

            for(Subject s : subjects){
                Semester newSemester = new Semester();

                newSemester.setIdSemester(idSemester);
                newSemester.setDuration(duration);
                newSemester.setIdSubject(s.getIdSubject());
                newSemester.setSubjectByIdSubject(s);

                semesterService.save(newSemester);
            }
        }
        return "good";
    }

    @RequestMapping(value = "/deleteSemester/{idSemester}")
    public ModelAndView deleteSemester(@PathVariable("idSemester") int idSemester) {

        ((TeachingService)teachingService).deleteTeachingofSemester(idSemester);
        ((SemesterService)semesterService).deleteByIdSemester(idSemester);

        return new ModelAndView("redirect:/semesters");
    }

    @RequestMapping(value = "/editSemester/{idSemester}")
    public ModelAndView editSemesterPage(@PathVariable("idSemester") int idSemester) {

        List<Semester> subjectsofSemester = ((SemesterService)semesterService).getSubjectsofSemester(idSemester);

        SemesterSaveModel semesterSaveModel = new SemesterSaveModel();

        semesterSaveModel.setSemester(String.valueOf(subjectsofSemester.get(0).getIdSemester()));
        semesterSaveModel.setDuration(String.valueOf(subjectsofSemester.get(0).getDuration()));

        ModelAndView modelAndView = new ModelAndView("saveSemester", "semesterModel", semesterSaveModel);
        modelAndView.addObject("subjectList", subjectService.getAll());

        return modelAndView;
    }


}
