package edu.miu.cs.cs425.studentmgmt.model.service;

import edu.miu.cs.cs425.studentmgmt.model.model.Student;

import java.util.List;

public interface StudentService {
    Iterable<Student> getStudents();
    Student addNewStudent(Student student);
    Student updateStudent(Long studentId,Student updStudent);
    Student getStudentById(Long studentId);
    void deleteStudent(Long studentId);
}
