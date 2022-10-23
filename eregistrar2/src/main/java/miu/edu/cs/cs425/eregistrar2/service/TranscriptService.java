package miu.edu.cs.cs425.eregistrar2.service;


import miu.edu.cs.cs425.eregistrar2.model.Transcript;

public interface TranscriptService {

    Transcript getTranscriptById(Long transcriptId);
    Iterable<Transcript> getTranscript();
    Transcript addNewTranscript(Transcript transcript);
    void deleteTranscriptById(Long transcriptId);

}
