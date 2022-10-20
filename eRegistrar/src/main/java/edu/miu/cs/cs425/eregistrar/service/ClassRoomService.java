package edu.miu.cs.cs425.eregistrar.service;

import edu.miu.cs.cs425.eregistrar.model.ClassRoom;


public interface ClassRoomService {

    Iterable<ClassRoom> getAllClassRoom();
    ClassRoom getClassRoomById(Long classId);
    ClassRoom addNewClassRoom(ClassRoom classRoom);
    void deleteById(Long classId);
}
