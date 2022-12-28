package com.example.workout.domain.board.entity;

import com.example.workout.domain.comment.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Builder
@Table(name = "board")
@NoArgsConstructor
@AllArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seq;

    private String content;
    private String userName;
    private String title;
    private String category;
    private String kind;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "board", fetch = FetchType.LAZY)
    private List<Comment> comment;

    public void update(String content,String title,String userName,String category,String kind){
        this.content=content;
        this.title=title;
        this.userName=userName;
        this.category=category;
        this.kind=kind;
    }

}
