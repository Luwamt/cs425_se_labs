package edu.miu.cs.cs425.eregistrar.service.serviceImpl;

import edu.miu.cs.cs425.eregistrar.model.Transcript;
import edu.miu.cs.cs425.eregistrar.repository.TranscriptRepository;
import edu.miu.cs.cs425.eregistrar.service.TranscriptService;
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
