package miu.edu.cs.cs425.eregistrar2.repository;


import miu.edu.cs.cs425.eregistrar2.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {

}
