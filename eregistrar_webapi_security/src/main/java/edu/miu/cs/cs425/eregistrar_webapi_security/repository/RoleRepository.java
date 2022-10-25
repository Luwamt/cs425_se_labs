package edu.miu.cs.cs425.eregistrar_webapi_security.repository;

import edu.miu.cs.cs425.eregistrar_webapi_security.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {

Optional<Role> findByName(String name);
}
