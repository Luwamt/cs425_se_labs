package edu.miu.cs.cs425.eregistrarwebapi.repository;


import edu.miu.cs.cs425.eregistrarwebapi.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long> {
}
