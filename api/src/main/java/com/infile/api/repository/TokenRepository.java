package com.infile.api.repository;

import com.infile.api.model.SessionToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenRepository extends JpaRepository<SessionToken, Long> {

    SessionToken findByToken(String token);
}
