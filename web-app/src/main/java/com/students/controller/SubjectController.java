package com.students.controller;

import com.students.entity.Subject;
import com.students.model.SubjectSaveModel;
import com.students.model.SubjectsModel;
import com.students.service.SemesterService;
import com.students.service.TeachingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Elena on 6/18/2014.
 */
@Controller
public class SubjectController extends AbstractController{

    private Subject selectedSubject = new Subject();
    private SubjectSaveModel subjectSaveModel = new SubjectSaveModel();

    @RequestMapping(value = "/subjects", method = RequestMethod.GET)
    public ModelAndView subjectsMainPage() {
        ModelAndView modelAndView = new ModelAndView("subjectsPage", "commandDeleteSubjects", new SubjectsModel());

        modelAndView.addObject("subjectList", subjectService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/subjectSavePage", method = RequestMethod.GET)
    public ModelAndView studentsSavePage(@ModelAttribute SubjectSaveModel subject) {

        return new ModelAndView("saveSubject", "commandSaveSubject", subject);
    }

    @RequestMapping(value = "/saveSubject", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute SubjectSaveModel subject) {

        selectedSubject.setName(subject.getName());

        if (selectedSubject.getIdSubject() == 0) {
            subjectService.save(selectedSubject);
        } else {
            subjectService.update(selectedSubject);
        }

        selectedSubject = new Subject();

        return new ModelAndView("redirect:/subjects");
    }

    @RequestMapping(value = "/editSubject/{idSubject}")
    public ModelAndView editStudentPage(@PathVariable("idSubject") int idSubject) {

        selectedSubject = subjectService.get(idSubject);

        subjectSaveModel.setName(selectedSubject.getName());

        return new ModelAndView("saveSubject", "commandSaveSubject", subjectSaveModel);
    }

    @RequestMapping(value = "/deleteSubjects", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deleteStudents(@RequestBody List<SubjectsModel> subjectsModels) {

        for (SubjectsModel sm : subjectsModels) {
            int id = Integer.parseInt(sm.getIdSubject());
            ((TeachingService) teachingService).deleteTeachingofSubject(id);
            ((SemesterService)semesterService).deleteSemesterofSubject(id);
            subjectService.delete(subjectService.get(id));
        }

        return new ModelAndView("redirect:/subjects");
    }
}
