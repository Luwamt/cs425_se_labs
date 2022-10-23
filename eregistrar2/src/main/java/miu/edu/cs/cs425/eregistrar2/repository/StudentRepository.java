package miu.edu.cs.cs425.eregistrar2.repository;

import miu.edu.cs.cs425.eregistrar2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> searchStudentByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String fname,String lname);
    // @Query(value = "select p from Publisher p where p.name = :name")
    List<Student> searchStudentsByDateOfEnrollmentContainingOrCgpaContainingOrStudentNumberContainingIgnoreCase(
            LocalDate date ,double gpa, String stdNum);
}
