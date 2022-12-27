package com.example.workout.domain.comment.entity;

import com.example.workout.domain.comment.presentation.dto.request.CommentParam;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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

    public void update(String content, String userName){
        this.content=content;
        this.userName=userName;
    }


}
