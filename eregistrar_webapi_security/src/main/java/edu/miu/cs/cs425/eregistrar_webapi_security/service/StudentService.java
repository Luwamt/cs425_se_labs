package edu.miu.cs.cs425.eregistrar_webapi_security.service;

import edu.miu.cs.cs425.eregistrar_webapi_security.dto.StudentDto;
import edu.miu.cs.cs425.eregistrar_webapi_security.exception.MyException;
import edu.miu.cs.cs425.eregistrar_webapi_security.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    List<Student> searchStudents(String name);
    Student addNewStudent(Student student);
    Student updateStudent(Long studentId, StudentDto updStudent);
    Student getStudentById(Long studentId) throws MyException;
    void deleteStudent(Long studentId);
}
