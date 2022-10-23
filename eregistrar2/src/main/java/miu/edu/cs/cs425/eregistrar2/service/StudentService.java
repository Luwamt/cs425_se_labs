package miu.edu.cs.cs425.eregistrar2.service;

import miu.edu.cs.cs425.eregistrar2.model.Student;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    Page<Student> getStudents(int pageNo);
 List<Student> searchStudents(String search1);
//    List<Student> searchStudents(String search);
    Student addNewStudent(Student student);
    void updateStudent(Long studentId,Student updStudent);
    Student getStudentById(Long studentId);
    void deleteStudent(Long studentId);
}
