package edu.miu.cs.cs425.studentmgmt.model;

import edu.miu.cs.cs425.studentmgmt.model.model.ClassRoom;
import edu.miu.cs.cs425.studentmgmt.model.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.model.service.ClassRoomService;
import edu.miu.cs.cs425.studentmgmt.model.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.model.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {
    @Autowired
    private StudentService studentService;
    @Autowired
    private TranscriptService transcriptService;
    @Autowired
    private ClassRoomService classRoomService;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
        System.out.println("Hello Spring boot");

    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting the CLI application student");
        /**
         * Transcript Field
         */
        Transcript transcript = new Transcript( "BS Computer Science");
        Transcript transcript2 = new Transcript( "MS Computer Science");
        Transcript transcript3 = new Transcript( "PHD Computer Science");
        Transcript transcript4 = new Transcript( "BS Computer Science");

        List<Transcript> transcriptList = Arrays.asList(transcript,transcript2,transcript3,transcript4);
//        for (Transcript trans : transcriptList){
//            Transcript result = transcriptService.addNewTranscript(trans);
//            System.out.println("The new addedTranscript:" +result);
//       }

/**
 * Student Field
 */
        var std1 = new Student( "000-65-0082", "Lily",
                "Haile", "Fish", 4.0, LocalDate.of(2020, 8, 20)
                , transcript);
        var std2 = new Student( "000-61-0001", "Anna",
                "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24)
                , transcript2);

        var std3 = new Student( "000-65-0052", "Arkan",
                "Filli", "Fish", 3.0, LocalDate.of(2021, 3, 10)
                , transcript3);
        var std4 = new Student( "000-61-0041", "Mercy",
                "Abraha", "Senay", 3.69, LocalDate.of(2022, 5, 2)
               , transcript4);

        transcript.setStudent(std1);
        transcript2.setStudent(std2);
        transcript3.setStudent(std3);
        transcript4.setStudent(std4);

        List<Student> studentslist = Arrays.asList(std1,std2,std3,std4);

//        for (Student stds :studentslist ){
//            Student newAdded =studentService.addNewStudent(stds);
//            System.out.println("The new Students joined to Miu: "+newAdded);
//        }
        //Displays in the system
        studentService.getStudents().forEach(
                student -> System.out.println(student)
        );

        /**
         *   Update student
         */

        var updName = new Student(2L, "000-61-0001", "Hanna",
                "Lynn", "Smith", 3.45, LocalDate.of(2019, 5, 24)
                , transcript2);
        var updatedStd = studentService.updateStudent(2L, updName);
        System.out.println("UpdatedName " + updatedStd);
        /**
         *   Delete student
         */
        // studentService.deleteStudent(3L);


        transcriptService.getTranscript().forEach(
                trans-> System.out.println(trans)
        );
/**
 * Class Room Field
 */
        ClassRoom classRoom1 = new ClassRoom( "McLaughlin building", "M105",studentslist);
        ClassRoom classRoom2 = new ClassRoom( "Drier building", "M256",studentslist);
        ClassRoom classRoom3 = new ClassRoom( "Verill building", "M47A",studentslist);
        ClassRoom classRoom4 = new ClassRoom( "McLaughlin building", "M115",studentslist);

        std1.setClassRoom(classRoom1);
        std2.setClassRoom(classRoom2);
        std3.setClassRoom(classRoom3);
        std4.setClassRoom(classRoom4);
        List<ClassRoom> classRoomList = Arrays.asList(classRoom1,classRoom2,classRoom3,classRoom4);

//        for (ClassRoom rooms: classRoomList){
//            ClassRoom reslut =classRoomService.addNewClassRoom(rooms) ;
//        }

        classRoomService.getAllClassRoom().forEach(
                room->System.out.println(room)
        );

        var student1 = studentService.getStudentById(1L);
        var student2 = studentService.getStudentById(2L);
        var classroom2 = classRoomService.getClassRoomById(2L);
        assignStudentsToClassroom(student1, classroom2);
        assignStudentsToClassroom(student2, classroom2);
    }

    private void assignStudentsToClassroom(Student student, ClassRoom classRoom) {
        student.setClassRoom(classRoom);
        studentService.updateStudent(student);
    }
}
