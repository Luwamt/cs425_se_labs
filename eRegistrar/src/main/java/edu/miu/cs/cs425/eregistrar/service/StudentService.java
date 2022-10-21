package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    List<Student> searchStudents(String name);
    Student addNewStudent(Student student);
    Student updateStudent(Long studentId,Student updStudent);
    Student getStudentById(Long studentId);
    void deleteStudent(Long studentId);
}
