package org.mert.repository;

import org.mert.repository.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<Auth,Long> {

    Optional<Auth> findOptionalByUsernameAndPassword(String username, String password);
    Optional<Auth> findOptionalByUsername(String username);
}
