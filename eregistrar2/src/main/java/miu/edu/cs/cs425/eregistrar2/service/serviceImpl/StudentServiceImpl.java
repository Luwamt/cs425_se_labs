package miu.edu.cs.cs425.eregistrar2.service.serviceImpl;

import lombok.AllArgsConstructor;
import miu.edu.cs.cs425.eregistrar2.model.Student;
import miu.edu.cs.cs425.eregistrar2.repository.StudentRepository;
import miu.edu.cs.cs425.eregistrar2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

public class StudentServiceImpl implements StudentService {

@Autowired
   private StudentRepository studentRepo;

    @Override
    public Page<Student> getStudents(int pageNo) {
        return studentRepo.findAll(PageRequest.
                of(pageNo,4, Sort.Direction.ASC,"firstName","lastName","cgpa"));
                //(Sort.by(Sort.Direction.ASC,"firstName","lastName","cgpa"));
    }

//    @Override
//    public List<Student> searchStudents(String search) {
//        return studentRepo.searchStudentsByDateOfEnrollmentContainingOrCgpaContainingOrStudentNumberContainingIgnoreCase(
//              search,search,search
//        );


    @Override
    public List<Student> searchStudents(String search) {
        return studentRepo.
                searchStudentByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(
                        search,search);
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentRepo.save(student);
    }


    @Override
    public void updateStudent(Long studentId,Student updStudent) {
            Student student = new Student();
       var  std = studentRepo.findById(studentId).orElse(null);
        if(std != null){
            student.setStudentNumber(updStudent.getStudentNumber());
            student.setFirstName(updStudent.getFirstName());
            student.setMiddleName(updStudent.getMiddleName());
            student.setLastName(updStudent.getLastName());
            student.setCgpa(updStudent.getCgpa());
            student.setDateOfEnrollment(updStudent.getDateOfEnrollment());
            student.setIsInternational(updStudent.getIsInternational());
            studentRepo.save(std);
        }
        else  throw new NullPointerException("No such Student");
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepo.findById(studentId).orElse(null);

    }

    @Override
    public void deleteStudent(Long studentId) {
        studentRepo.deleteById(studentId);
    }
}
