package edu.miu.cs.cs425.eregistrar.service.serviceImpl;

import edu.miu.cs.cs425.eregistrar.model.Student;
import edu.miu.cs.cs425.eregistrar.repository.StudentRepository;
import edu.miu.cs.cs425.eregistrar.service.StudentService;
import net.bytebuddy.TypeCache;
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
        return studentRepo.findAll(Sort.by(Sort.Direction.ASC,"lastName"));
    }

    @Override
    public List<Student> searchStudents(String name) {
        return studentRepo.searchStudentByFirstName(name);
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
