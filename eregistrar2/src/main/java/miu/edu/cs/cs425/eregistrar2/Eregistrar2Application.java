package miu.edu.cs.cs425.eregistrar2;

import miu.edu.cs.cs425.eregistrar2.model.Student;
import miu.edu.cs.cs425.eregistrar2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Eregistrar2Application  implements CommandLineRunner {
    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(Eregistrar2Application.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting the CLI application student");

/**
 * Student Field
 */
        var std1 = new Student( "000-65-0562", "Sena",
                "John", "Tes", 3.6, LocalDate.of(2016, 8, 30)
                , "Yes");
        var std2 = new Student( "000-62-0801", "Selam",
                "Hanes", "Nate", 3.45, LocalDate.of(2019, 7, 14)
                , "Yes");

        var std3 = new Student( "000-82-0852", "Debora",
                "Neba", "Ama", 3.96, LocalDate.of(2021, 12, 19)
                , "Yes");
        var std4 = new Student( "000-69-0741", "Mercy",
                "Abraha", "Senay", 3.75, LocalDate.of(2022, 9, 3)
                , "No");



        List<Student> studentslist = Arrays.asList(std1,std2,std3,std4);

//        for (Student stds :studentslist ){
//            Student newAdded =studentService.addNewStudent(stds);
//            System.out.println("The new Students joined to Miu: "+newAdded);
//        }
        //Displays in the system
//        studentService.getStudents().forEach(
//                student -> System.out.println(student)
//        );

        /**
         *   Delete student
         */
        // studentService.deleteStudent(3L);

}


}
