package com.example.workout.domain.board.presentation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthParam {


    @NotBlank
    private String title;

    @NotBlank
    private String content;

    @NotBlank
    private String username;

    @NotBlank
    private String kind;

    @NotBlank
    private String category;

}
