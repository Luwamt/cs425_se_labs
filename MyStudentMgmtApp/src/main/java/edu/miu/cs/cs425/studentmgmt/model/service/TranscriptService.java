package edu.miu.cs.cs425.studentmgmt.model.service;

import edu.miu.cs.cs425.studentmgmt.model.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.model.Transcript;
import org.springframework.data.repository.CrudRepository;

public interface TranscriptService {

    Transcript getTranscriptById(Long transcriptId);
    Iterable<Transcript> getTranscript();
    Transcript addNewTranscript(Transcript transcript);
    void deleteTranscriptById(Long transcriptId);

}
