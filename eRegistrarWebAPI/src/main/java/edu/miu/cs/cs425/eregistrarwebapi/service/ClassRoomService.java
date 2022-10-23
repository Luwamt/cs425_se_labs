package edu.miu.cs.cs425.eregistrarwebapi.service;


import edu.miu.cs.cs425.eregistrarwebapi.model.ClassRoom;


public interface ClassRoomService {

    Iterable<ClassRoom> getAllClassRoom();
    ClassRoom getClassRoomById(Long classId);
    ClassRoom addNewClassRoom(ClassRoom classRoom);
    void deleteById(Long classId);
}
