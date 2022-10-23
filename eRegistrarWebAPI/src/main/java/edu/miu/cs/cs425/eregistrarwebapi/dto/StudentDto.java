package edu.miu.cs.cs425.eregistrarwebapi.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class StudentDto {

    private Long studentId;
    private String studentNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private Double cgpa;
    private LocalDate dateOfEnrollment;
    private String isInternational;
//@JsonIgnore
    //@JsonManageReference
    //@JsonBackReference  to mapping class


}
