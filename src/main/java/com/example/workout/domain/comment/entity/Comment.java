package com.example.workout.domain.comment.entity;

import com.example.workout.domain.board.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name="Comments")
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
    @Id
    @GeneratedValue
    private Long commentId;

    private String userName;
    private String content;

    @ManyToOne
    @JoinColumn(name = "board")
    private Board board;

    public void update(String content, String userName){
        this.content=content;
        this.userName=userName;
    }
}
