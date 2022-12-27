package com.example.workout.domain.comment.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentParam {

    @NotBlank
    private String userName;

    @NotBlank
    private String content;
}
