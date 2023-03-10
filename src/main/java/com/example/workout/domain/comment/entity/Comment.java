package com.example.workout.domain.comment.entity;

import com.example.workout.domain.board.entity.Auth;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name="comment")
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "commentId")
    private Long commentId;
    @Column(name = "userName")
    private String userName;
    @Column(name = "content")
    private String content;

    @ManyToOne
    @JoinColumn(name = "auth")
    private Auth auth;

    public void update(String content, String userName){
        this.content=content;
        this.userName=userName;
    }
}
