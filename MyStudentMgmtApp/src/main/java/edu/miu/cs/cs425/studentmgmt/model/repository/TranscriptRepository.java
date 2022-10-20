package edu.miu.cs.cs425.studentmgmt.model.repository;

import edu.miu.cs.cs425.studentmgmt.model.model.Transcript;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends CrudRepository<Transcript, Long> {

}
