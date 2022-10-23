package edu.miu.cs.cs425.eregistrarwebapi.controller;

import edu.miu.cs.cs425.eregistrarwebapi.exception.MyException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = {"eregistrar/api/student"})
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = {"/list"}) //eregistrar/api/student/list
    public ResponseEntity<List<Student>> getAllStudentsList() {
        return ResponseEntity.ok(studentService.getStudents());
    }

    @GetMapping(value = {"/get/{stdId}"})  ///eregistrar/api/student/get/1
    public ResponseEntity<Student> getStudentById(@PathVariable Long stdId) throws MyException {
        var student = studentService.getStudentById(stdId);
        return ResponseEntity.ok(student);
    }

    @PostMapping(value = {"/register"})//eregistrar/api/student/register
    public ResponseEntity<Student> registerNewStudent(@Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.addNewStudent(student), HttpStatus.CREATED);
    }

    @PutMapping(value = {"/update/{id}"})
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id, @Valid @RequestBody Student student) {
        return new ResponseEntity<>(studentService.updateStudent(id, student), HttpStatus.OK);
    }


    @DeleteMapping(value = {"/delete/{id}"})
         public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) throws MyException{
        studentService.deleteStudent(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);

}



}
