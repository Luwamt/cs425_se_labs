package edu.miu.cs.cs425.eregistrarwebapi.service;

import edu.miu.cs.cs425.eregistrarwebapi.dto.StudentDto;
import edu.miu.cs.cs425.eregistrarwebapi.exception.MyException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    List<Student> searchStudents(String name);
    Student addNewStudent(Student student);
    Student updateStudent(Long studentId, Student updStudent);
    Student getStudentById(Long studentId) throws MyException;
    void deleteStudent(Long studentId);
}
