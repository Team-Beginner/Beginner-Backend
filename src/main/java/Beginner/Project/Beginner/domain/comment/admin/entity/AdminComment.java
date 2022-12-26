package Beginner.Project.Beginner.domain.comment.admin.entity;

import Beginner.Project.Beginner.domain.board.Admin.entity.Admin;
import Beginner.Project.Beginner.domain.board.Member.entity.Member;
import Beginner.Project.Beginner.domain.comment.admin.dto.request.AdminCommentParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "admincomment")
@NoArgsConstructor
@AllArgsConstructor
public class AdminComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String username;

    private String content;

   @ManyToOne
   @JoinColumn(name = "admin")
   private Admin admin;

   @ManyToOne
   @JoinColumn(name = "member")
   private Member member;

    public void update(AdminCommentParam param){
        this.content=content;
        this.username=username;
    }


}
