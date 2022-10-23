package miu.edu.cs.cs425.eregistrar2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class ClassRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;
    @Column(nullable = false)
    private String buildingName;
    private String roomNumber;
//    @OneToMany(mappedBy = "classRoom")
//    private List<Student> students;

//    public ClassRoom(String buildingName, String roomNumber, List<Student> students) {
//        this.buildingName = buildingName;
//        this.roomNumber = roomNumber;
//        this.students = students;
//    }
}
