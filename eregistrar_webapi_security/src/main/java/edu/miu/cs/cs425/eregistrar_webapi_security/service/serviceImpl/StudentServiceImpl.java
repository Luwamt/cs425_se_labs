package edu.miu.cs.cs425.eregistrar_webapi_security.service.serviceImpl;

import edu.miu.cs.cs425.eregistrar_webapi_security.dto.StudentDto;
import edu.miu.cs.cs425.eregistrar_webapi_security.exception.MyException;
import edu.miu.cs.cs425.eregistrar_webapi_security.model.Student;
import edu.miu.cs.cs425.eregistrar_webapi_security.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar_webapi_security.service.StudentService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepo.findAll(Sort.by(Sort.Direction.ASC, "lastName"));
    }

    @Override
    public List<Student> searchStudents(String name) {
        return studentRepo.searchStudentByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                name,name);
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentRepo.save(student);
    }

//    @Override
//    public Student updateStudent(Long studentId, Student updStudent) {
//        var std = Student.build(studentId,
//                updStudent.getStudentNumber(), updStudent.getFirstName(), updStudent.getMiddleName(),
//                updStudent.getLastName(), updStudent.getCgpa(), updStudent.getDateOfEnrollment(),
//                updStudent.getIsInternational());
//
//        return studentRepo.save(std);
//    }

@Override
    public Student updateStudent(Long studentId, StudentDto updStudent) {
        //Student student = new Student();
        var std = Student.build(studentId,
                updStudent.getStudentNumber(),updStudent.getFirstName(), updStudent.getMiddleName(),
                updStudent.getLastName(), updStudent.getCgpa(), updStudent.getDateOfEnrollment(),
                updStudent.getIsInternational());

            return studentRepo.save(std);
    }

    @Override
    public Student getStudentById(Long studentId) throws MyException {
        return studentRepo.findById(studentId).orElseThrow(() ->
                new MyException(String.format("Student with Id: %d, is not found ", studentId)));

    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
    }
}
