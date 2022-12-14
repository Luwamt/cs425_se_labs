package edu.miu.cs.cs425.eregistrarwebapi.service.serviceImpl;

import edu.miu.cs.cs425.eregistrarwebapi.model.ClassRoom;
import edu.miu.cs.cs425.eregistrarwebapi.repository.ClassRoomRepository;
import edu.miu.cs.cs425.eregistrarwebapi.service.ClassRoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService {

    private ClassRoomRepository classRoomRepo;

    @Override
    public List<ClassRoom> getAllClassRoom() {
        return classRoomRepo.findAll();
    }

    @Override
    public ClassRoom getClassRoomById(Long classId) {
        return getClassRoomById(classId);
    }

    @Override
    public ClassRoom addNewClassRoom(ClassRoom classRoom) {
        return classRoomRepo.save(classRoom);
    }

    @Override
    public void deleteById(Long classId) {
      classRoomRepo.deleteById(classId);
    }
}
