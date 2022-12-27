package com.example.workout.domain.comment.entity;

import com.example.workout.domain.board.entity.Auth;
import com.example.workout.domain.comment.presentation.dto.request.CommentParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name="Comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long Id;

    private String userName;
    private String content;

    @ManyToOne
    @JoinColumn(name = "auth")
    private Auth auth;

    public void update(String content, String userName){
        this.content=content;
        this.userName=userName;
    }


}
