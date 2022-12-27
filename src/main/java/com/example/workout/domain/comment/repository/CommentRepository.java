package com.example.workout.domain.comment.repository;

import com.example.workout.domain.comment.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Comment> findByUsername(String userName);
    Optional<Comment> findById(Long Id);

}
