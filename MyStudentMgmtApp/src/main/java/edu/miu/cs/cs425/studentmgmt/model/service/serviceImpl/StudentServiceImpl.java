package edu.miu.cs.cs425.studentmgmt.model.service.serviceImpl;

import edu.miu.cs.cs425.studentmgmt.model.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.model.service.StudentService;
import org.springframework.stereotype.Service;



@Service
public class StudentServiceImpl implements StudentService {

   private StudentRepository studentRepo;

    public StudentServiceImpl(StudentRepository studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Iterable<Student> getStudents() {
        return studentRepo.findAll();
    }

    @Override
    public Student addNewStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student updateStudent(Long studentId,Student updStudent) {
       var  std = studentRepo.findById(studentId).orElse(null);
        if(std!= null){
            std.setFirstName(updStudent.getFirstName());
            studentRepo.save(std);
        }
        return std;
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
