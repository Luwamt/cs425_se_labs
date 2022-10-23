package miu.edu.cs.cs425.eregistrar2.service;


import miu.edu.cs.cs425.eregistrar2.model.ClassRoom;


public interface ClassRoomService {

    Iterable<ClassRoom> getAllClassRoom();
    ClassRoom getClassRoomById(Long classId);
    ClassRoom addNewClassRoom(ClassRoom classRoom);
    void deleteById(Long classId);
}
