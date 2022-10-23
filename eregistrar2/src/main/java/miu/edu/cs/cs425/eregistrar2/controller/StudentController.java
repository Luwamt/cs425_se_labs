package miu.edu.cs.cs425.eregistrar2.controller;


import miu.edu.cs.cs425.eregistrar2.model.Student;
import miu.edu.cs.cs425.eregistrar2.service.StudentService;
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

    @GetMapping(value = {"/list"})   // /eregistrar/student/list
    public ModelAndView getListOfStudents(@RequestParam(defaultValue = "0") int pageNo){
        var modelview = new ModelAndView();
        var students =studentService.getStudents(pageNo);
        modelview.addObject("students",students);
        modelview.addObject("currentPageNo",pageNo);
        modelview.setViewName("student/list");
        return  modelview;
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
        if(editStudent!=null){
            model.addAttribute("student",editStudent);
            return  "student/edit";
        }
        return "redirect:/eregistrar/student/list";
    }
    @GetMapping(value = {"/search"})///eregistrar/student/search?searchString=lily
    public ModelAndView searchStudentsByName(@RequestParam String searchString) {
        var modelAndView = new ModelAndView();
        var student = studentService.searchStudents(searchString );
        modelAndView.addObject("student", student);
        modelAndView.addObject("searchString", searchString);
        modelAndView.setViewName("student/Result");
        return modelAndView;
    }
    @GetMapping(value = {"/delete/{id}"})
    public String deleteStudent(@PathVariable(value = "id") Long stdId){
       studentService.deleteStudent(stdId);
       return  "redirect:/eregistrar/student/list";
    }

//
//    @GetMapping(value = {"/admin"}) // /eregistrar/student/list
//    public ModelAndView admin(){
//        var modelView = new ModelAndView();
//        var students =  studentService.getStudents();
//        modelView.addObject("students",students);
//        modelView.setViewName("student/admin");
//        return modelView;
//    }



    @PostMapping(value={"/studentpost"})
    public String saveStudent(@ModelAttribute("student") Student student){
  studentService.addNewStudent(student);
  return "redirect:/student/list";
    }


}
