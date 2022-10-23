package miu.edu.cs.cs425.eregistrar2.service.serviceImpl;


import miu.edu.cs.cs425.eregistrar2.model.Transcript;
import miu.edu.cs.cs425.eregistrar2.repository.TranscriptRepository;
import miu.edu.cs.cs425.eregistrar2.service.TranscriptService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TranscriptServiceImpl implements TranscriptService {

    private TranscriptRepository transcriptRepo;

    public TranscriptServiceImpl(TranscriptRepository transcriptRepo) {
        this.transcriptRepo = transcriptRepo;
    }

    @Override
    public Transcript getTranscriptById(Long transcriptId) {
        return transcriptRepo.findById(transcriptId).orElse(null);
    }

    @Override
    public List<Transcript> getTranscript() {
        return transcriptRepo.findAll();
    }

    @Override
    public Transcript addNewTranscript(Transcript transcript) {
        return transcriptRepo.save(transcript);
    }

    @Override
    public void deleteTranscriptById(Long transcriptId) {
          transcriptRepo.deleteById(transcriptId);
    }
}
