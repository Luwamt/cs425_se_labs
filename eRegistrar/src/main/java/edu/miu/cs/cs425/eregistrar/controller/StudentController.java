package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"/eregistrar/student"})
public class StudentController {
    @Autowired
private StudentService studentService;

    @GetMapping(value = {"/list"}) // /eregistrar/student/list
    public ModelAndView listStudents(){
        var modelView = new ModelAndView();
        var students =  studentService.getStudents();
        modelView.addObject("students",students);
        modelView.setViewName("student/list");
        return modelView;
    }
    @GetMapping(value = {"/admin"}) // /eregistrar/student/list
    public ModelAndView admin(){
        var modelView = new ModelAndView();
        var students =  studentService.getStudents();
        modelView.addObject("students",students);
        modelView.setViewName("student/admin");
        return modelView;
    }
    @GetMapping(value={"/students/new"})
    public String addNewStudent(Model model){
        Student student =new Student();
        model.addAttribute("student",student);
        return "student/create_student";
    }
    @PostMapping(value={"/studentpost"})
    public String saveStudent(@ModelAttribute("student") Student student){
  studentService.addNewStudent(student);
  return "redirect:/student/list";
    }

    @GetMapping(value = {"/search-name"})
    public ModelAndView searchStudentsByName(@RequestParam String name) {
        var modelAndView = new ModelAndView();
        var student = studentService.searchStudents(name);
        modelAndView.addObject("students", student);
        modelAndView.addObject("searchString", name);
        modelAndView.setViewName("student/admin");
        return modelAndView;
    }
}
