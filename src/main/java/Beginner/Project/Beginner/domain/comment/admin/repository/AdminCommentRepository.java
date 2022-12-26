package Beginner.Project.Beginner.domain.comment.admin.repository;

import Beginner.Project.Beginner.domain.comment.admin.entity.AdminComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminCommentRepository extends JpaRepository<AdminComment, Long>{
    Optional<AdminComment> findByUsername(String username);
}
