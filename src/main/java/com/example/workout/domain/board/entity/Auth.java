package com.example.workout.domain.board.entity;

import com.example.workout.domain.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "auth")
@NoArgsConstructor
@AllArgsConstructor
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long seq;
    @Column(name = "content")
    private String content;
    @Column(name = "username")
    private String userName;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
    @Column(name = "kind")
    private String kind;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "auth", fetch = FetchType.LAZY)
    private List<Comment> comment = new ArrayList<>();

    public void update(String content,String title,String userName,String category,String kind){
        this.content=content;
        this.title=title;
        this.userName=userName;
        this.category=category;
        this.kind=kind;
    }

}
