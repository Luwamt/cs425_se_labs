package edu.miu.cs.cs425.studentmgmt.model.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(name="student_number", nullable = false, unique = true)
    private String StudentNumber;
    @Column(nullable = false)
    private String firstName;
    private String middleName;
    @Column(nullable = false)
    private String lastName;
    private Double cgpa;
    private LocalDate dateOfEnrollment;
@JoinColumn(name = "transcript_id", nullable = false,unique = true)
@OneToOne
    private Transcript transcript;
    @ManyToOne
    @JoinColumn(name = "class_id")
private ClassRoom classRoom;

    public Student(Long studentId, String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment,
                   Transcript transcript) {
        this.studentId = studentId;
        StudentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcript = transcript;

    }
    public Student( String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment,
                   Transcript transcript) {
        StudentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.transcript = transcript;

    }


}
