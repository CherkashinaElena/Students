package com.students.controller;

import com.students.entity.Student;
import com.students.entity.Teaching;
import com.students.model.StudentSaveModel;
import com.students.model.StudentsModel;
import com.students.service.TeachingService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.TabableView;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Elena on 6/13/2014.
 */
@Controller
public class StudentController extends AbstractController {

    private Student selectedStudent = new Student();
    private StudentSaveModel studentSaveModel = new StudentSaveModel();

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public ModelAndView studentsMainPage() {

        ModelAndView modelAndView = new ModelAndView("studentsPage", "commandDeleteStudents", new StudentsModel());

        modelAndView.addObject("studentList", studentService.getAll());

        return modelAndView;
    }

    @RequestMapping(value = "/studentSavePage", method = RequestMethod.GET)
    public ModelAndView studentsSavePage(@ModelAttribute StudentSaveModel student) {

        return new ModelAndView("saveStudent", "commandSaveStudent", student);
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public ModelAndView saveStudent(@ModelAttribute StudentSaveModel student) {

        selectedStudent.setFirstName(student.getFirstName());
        selectedStudent.setLastName(student.getLastName());
        selectedStudent.setStudentGroup(student.getStudentGroup());
        selectedStudent.setDateEntering(student.getDateEntering());

        if (selectedStudent.getIdStudent() == 0) {
            studentService.save(selectedStudent);
        } else {
            studentService.update(selectedStudent);
        }

        selectedStudent = new Student();

        return new ModelAndView("redirect:/students");
    }


    @RequestMapping(value = "/editStudent/{idStudent}")
    public ModelAndView editStudentPage(@PathVariable("idStudent") int idStudent) {

        selectedStudent = studentService.get(idStudent);

        studentSaveModel.setLastName(selectedStudent.getLastName());
        studentSaveModel.setFirstName(selectedStudent.getFirstName());
        studentSaveModel.setStudentGroup(selectedStudent.getStudentGroup());
        studentSaveModel.setDateEntering(selectedStudent.getDateEntering());

        return new ModelAndView("saveStudent", "commandSaveStudent", studentSaveModel);
    }

    @RequestMapping(value = "/infoStudent/{idStudent}")
    public ModelAndView infoStudentPage(@PathVariable("idStudent") int idStudent) {

        Student studentinfo = studentService.get(idStudent);

        ModelAndView modelAndView = new ModelAndView("infoStudent");
        modelAndView.addObject("studentInfo", studentinfo);
        modelAndView.addObject("subjects", ((TeachingService) teachingService).getTeachingofSemestr(idStudent, 1));
        modelAndView.addObject("semesters", ((TeachingService) teachingService).getSemesterofStudent(idStudent));
        modelAndView.addObject("average", ((TeachingService)teachingService).averagePerSemester(idStudent, 1));

        return modelAndView;
    }

    @RequestMapping(value = "/deleteStudents", method = RequestMethod.POST)
    @ResponseBody
    public ModelAndView deleteStudents(@RequestBody List<StudentsModel> studentsModels) {

        for (StudentsModel sm : studentsModels) {
            int id = Integer.parseInt(sm.getIdStudent());
            ((TeachingService) teachingService).deleteTeachingofStudent(id);
            studentService.delete(studentService.get(id));
        }

        return new ModelAndView("redirect:/students");
    }

    @RequestMapping(value = "/getTeaching", method = RequestMethod.GET)
    @ResponseBody
    public String ajaxTeaching(WebRequest request) throws Exception {

        int idStudent = Integer.parseInt(request.getParameter("idStudent"));
        int idSemester = Integer.parseInt(request.getParameter("semester"));

        List<Teaching> teachings = ((TeachingService)teachingService).getTeachingofSemestr(idStudent, idSemester);

        ObjectMapper objectMapper = new ObjectMapper();

        String json = "";
        try {
            json = objectMapper.writeValueAsString(teachings);
        } catch (Exception e) {
           e.printStackTrace();
        }

        return json;
    }
}

