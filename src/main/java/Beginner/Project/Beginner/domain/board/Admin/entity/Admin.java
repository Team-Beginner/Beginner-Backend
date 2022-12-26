package Beginner.Project.Beginner.domain.board.Admin.entity;

import Beginner.Project.Beginner.domain.board.Admin.dto.request.AdminParam;
import Beginner.Project.Beginner.domain.comment.admin.entity.AdminComment;
import lombok.*;

import javax.persistence.*;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String content;
    private String username;
    private String title;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "admin", fetch = FetchType.LAZY)
    private List<AdminComment> adminComment = new ArrayList<>();

    public void update(AdminParam param) {
        this.content=content;
        this.username=username;
        this.title=title;
    }
}
