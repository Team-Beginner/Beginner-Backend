package Beginner.Project.Beginner.domain.board.Admin.repository;

import Beginner.Project.Beginner.domain.board.Admin.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    Optional<Admin> findByUsername(String username);

}
