package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.Student;

public interface StudentService {
    Iterable<Student> getStudents();
    Student addNewStudent(Student student);
    Student updateStudent(Long studentId,Student updStudent);
    Student getStudentById(Long studentId);
    void deleteStudent(Long studentId);
}
