package edu.miu.cs.cs425.eregistrar_webapi_security.service;


import edu.miu.cs.cs425.eregistrar_webapi_security.model.Transcript;

public interface TranscriptService {

    Transcript getTranscriptById(Long transcriptId);
    Iterable<Transcript> getTranscript();
    Transcript addNewTranscript(Transcript transcript);
    void deleteTranscriptById(Long transcriptId);

}
