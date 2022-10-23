package edu.miu.cs.cs425.eregistrarwebapi.service.serviceImpl;

import edu.miu.cs.cs425.eregistrarwebapi.exception.MyException;
import edu.miu.cs.cs425.eregistrarwebapi.model.Student;
import edu.miu.cs.cs425.eregistrarwebapi.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrarwebapi.service.StudentService;
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
        return studentRepo.searchStudentByFirstName(name);
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentRepo.save(student);
    }

    //    Student student = new Student();
//    var  std = studentRepo.findById(studentId).orElse(null);
//        if(std != null){
//        student.setStudentNumber(updStudent.getStudentNumber());
//        student.setFirstName(updStudent.getFirstName());
//        student.setMiddleName(updStudent.getMiddleName());
//        student.setLastName(updStudent.getLastName());
//        student.setCgpa(updStudent.getCgpa());
//        student.setDateOfEnrollment(updStudent.getDateOfEnrollment());
//        student.setIsInternational(updStudent.getIsInternational());
//        studentRepo.save(std);
//    }
//        else  throw new NullPointerException("No such Student");
//}
    @Override
    public void updateStudent(Long studentId, Student updStudent) {
        Student student = new Student();
        var std = studentRepo.findById(studentId).orElse(null);
        if (std != null) {
            student.setStudentNumber(updStudent.getStudentNumber());
            student.setFirstName(updStudent.getFirstName());
            student.setMiddleName(updStudent.getMiddleName());
            student.setLastName(updStudent.getLastName());
            student.setCgpa(updStudent.getCgpa());
            student.setDateOfEnrollment(updStudent.getDateOfEnrollment());
            student.setIsInternational(updStudent.getIsInternational());
            studentRepo.save(std);
        }
        else  throw new NullPointerException("No such Student");;
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
