package edu.miu.cs.cs425.eregistrarwebapi.service;


import edu.miu.cs.cs425.eregistrarwebapi.model.Transcript;

public interface TranscriptService {

    Transcript getTranscriptById(Long transcriptId);
    Iterable<Transcript> getTranscript();
    Transcript addNewTranscript(Transcript transcript);
    void deleteTranscriptById(Long transcriptId);

}
