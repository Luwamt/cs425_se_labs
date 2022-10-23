package miu.edu.cs.cs425.eregistrar2.repository;


import miu.edu.cs.cs425.eregistrar2.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
}
