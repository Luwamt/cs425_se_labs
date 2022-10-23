package edu.miu.cs.cs425.studentmgmt.model.service.serviceImpl;

import edu.miu.cs.cs425.studentmgmt.model.model.ClassRoom;
import edu.miu.cs.cs425.studentmgmt.model.repository.ClassRoomRepository;
import edu.miu.cs.cs425.studentmgmt.model.service.ClassRoomService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClassRoomServiceImpl implements ClassRoomService {

    private ClassRoomRepository classRoomRepo;

    @Override
    public Iterable<ClassRoom> getAllClassRoom() {
        return classRoomRepo.findAll();
    }

    @Override
    public ClassRoom getClassRoomById(Long classId) {
        return classRoomRepo.findById(classId).orElse(null);
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
