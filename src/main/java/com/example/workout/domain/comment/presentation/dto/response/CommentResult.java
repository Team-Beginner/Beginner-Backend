package com.example.workout.domain.comment.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.PrimitiveIterator;

@Getter
@Setter
@ToString
public class CommentResult {
    private Long Id;
    private String userName;
    private String content;
}
