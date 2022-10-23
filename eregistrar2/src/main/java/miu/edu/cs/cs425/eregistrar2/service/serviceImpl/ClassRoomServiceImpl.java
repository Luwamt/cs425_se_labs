package miu.edu.cs.cs425.eregistrar2.service.serviceImpl;


import lombok.AllArgsConstructor;
import miu.edu.cs.cs425.eregistrar2.model.ClassRoom;
import miu.edu.cs.cs425.eregistrar2.repository.ClassRoomRepository;
import miu.edu.cs.cs425.eregistrar2.service.ClassRoomService;
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
