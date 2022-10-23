package edu.miu.cs.cs425.eregistrar.controller;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

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
    @GetMapping(value={"/new"})
    public String registerNewStudentForm(Model model){
        var newStudent =new Student();
        model.addAttribute("student",newStudent);
        return "student/new";
    }
    @PostMapping(value = {"/new"})
    public String saveNewStudent(@Valid @ModelAttribute("student") Student student,
                                 BindingResult bindingResult,Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("student", student);
            model.addAttribute("errors",bindingResult.getAllErrors());
            return "student/new";
        }
        studentService.addNewStudent(student);
        return "redirect:/eregistrar/student/list";
    }
    @GetMapping(path={"/edit/{id}"})
    public String editStudent(@PathVariable(value = "id") Long id , Model model){
        var editStudent= studentService.getStudentById(id);
        model.addAttribute("students",editStudent);
        //model.setViewName("student/edit");
        return  "student/edit";
    }
    //Delete controller
//    public ModelAndView deleteStudent(Long stdId){
//        var modelView = new ModelAndView();
//       // String dlete= studentService.deleteStudent(stdId);
//        modelView.addObject()
//    }

    @GetMapping(value = {"/admin"}) // /eregistrar/student/list
    public ModelAndView admin(){
        var modelView = new ModelAndView();
        var students =  studentService.getStudents();
        modelView.addObject("students",students);
        modelView.setViewName("student/admin");
        return modelView;
    }
//    @GetMapping(value={"/students/new"})
//    public String addNewStudent(Model model){
//        Student student =new Student();
//        model.addAttribute("student",student);
//        return "student/create_student";
//    }

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
        modelAndView.setViewName("student/search");
        return modelAndView;
    }
}
