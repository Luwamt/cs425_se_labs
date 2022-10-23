package edu.miu.cs.cs425.eregistrarwebapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@AllArgsConstructor(staticName = "build")
@Getter
@Setter
@NoArgsConstructor
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    //studentNumber is required
    @Column(name="student_number", nullable = false, unique = true)//store in database
    //This is stored in memory
//    @NotNull(message = "Student number is not null")
//    @NotEmpty(message = "Student number can not empty or null")//""
    @NotBlank(message ="Student number can not be blank  spaces or empty or null" )
    private String studentNumber;
    @Column(nullable = false)
    @NotBlank(message ="firstName can not be blank  spaces or empty or null" )
    private String firstName;
    @Column(nullable = true)
    private String middleName;

    @NotBlank(message ="lastName can not be blank  spaces or empty or null" )
    @Column(nullable = false)
    private String lastName;
    private Double cgpa;

    @NotNull(message = "Enroll Date can't be null")
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfEnrollment;

    @Column(nullable = false)
    @NotBlank(message ="isInternational can not be blank  spaces or empty or null" )
    private String isInternational;
//@JsonIgnore
    //@JsonManageReference
    //@JsonBackReference  to mapping class
    public Student( String studentNumber, String firstName, String middleName, String lastName, Double cgpa, LocalDate dateOfEnrollment,
                    String isInternational) {
        studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.isInternational=isInternational;
    }


}
