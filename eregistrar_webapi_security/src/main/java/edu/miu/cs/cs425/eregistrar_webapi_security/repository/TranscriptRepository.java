package edu.miu.cs.cs425.eregistrar_webapi_security.repository;

import edu.miu.cs.cs425.eregistrar_webapi_security.model.Transcript;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscriptRepository extends JpaRepository<Transcript, Long> {

}
