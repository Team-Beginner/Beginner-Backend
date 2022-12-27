package com.example.workout.domain.board.entity;

import com.example.workout.domain.board.presentation.dto.request.AuthParam;
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
@Table(name = "auth")
@NoArgsConstructor
@AllArgsConstructor
public class Auth {
    @Id
    @GeneratedValue
    private Long seq;


    private String content;
    private String userName;
    private String title;
    private String category;
    private String kind;

    public void update(String content,String title,String userName,String category,String kind){
        this.content=content;
        this.title=title;
        this.userName=userName;
        this.category=category;
        this.kind=kind;

    }
}
