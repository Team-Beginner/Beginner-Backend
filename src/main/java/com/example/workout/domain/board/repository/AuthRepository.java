package com.example.workout.domain.board.repository;

import com.example.workout.domain.board.entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AuthRepository extends JpaRepository<Auth, Long> {
    Optional<Auth> findByUsername(String userName);
    Optional<Auth> findBySeq(Long seq);
}
