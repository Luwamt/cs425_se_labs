package edu.miu.cs.cs425.eregistrar_webapi_security.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;


/**
        * This class defines a DTO for Publisher data
        * as will be expected from the Web API Client
        */
@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class StudentDto {

  private String studentNumber;
    @NotBlank(message = "Student name can not be null, empty or blank")
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
