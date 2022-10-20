package edu.miu.cs.cs425.studentmgmt.model.service.serviceImpl;

import edu.miu.cs.cs425.studentmgmt.model.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.model.repository.TranscriptRepository;
import edu.miu.cs.cs425.studentmgmt.model.service.TranscriptService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
    public Iterable<Transcript> getTranscript() {
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
