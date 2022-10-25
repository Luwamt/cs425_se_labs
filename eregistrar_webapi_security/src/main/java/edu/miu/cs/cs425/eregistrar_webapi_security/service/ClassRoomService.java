package edu.miu.cs.cs425.eregistrar_webapi_security.service;


import edu.miu.cs.cs425.eregistrar_webapi_security.model.ClassRoom;



public interface ClassRoomService {

    Iterable<ClassRoom> getAllClassRoom();
    ClassRoom getClassRoomById(Long classId);
    ClassRoom addNewClassRoom(ClassRoom classRoom);
    void deleteById(Long classId);
}
