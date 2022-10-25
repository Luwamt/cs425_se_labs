package edu.miu.cs.cs425.eregistrar_webapi_security.repository;

import edu.miu.cs.cs425.eregistrar_webapi_security.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> searchStudentByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String name, String search);
    // @Query(value = "select p from Publisher p where p.name = :name")
}
