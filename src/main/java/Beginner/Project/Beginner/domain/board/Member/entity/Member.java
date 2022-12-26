package Beginner.Project.Beginner.domain.board.Member.entity;

import Beginner.Project.Beginner.domain.board.Member.dto.request.MemberParam;
import Beginner.Project.Beginner.domain.comment.admin.entity.AdminComment;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board")
    Long seq;

    String content;
    String username;
    String title;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "member", fetch = FetchType.LAZY)
    private List<AdminComment> adminComment = new ArrayList<>();

    public void update(MemberParam param){
        this.content = param.getContent();
        this.username = param.getUsername();
        this.title = param.getTitle();
    }

}
