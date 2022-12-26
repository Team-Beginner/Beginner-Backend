package Beginner.Project.Beginner.domain.board.Member.repository;

import Beginner.Project.Beginner.domain.board.Member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);
}
