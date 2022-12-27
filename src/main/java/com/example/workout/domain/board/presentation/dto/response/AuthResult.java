package com.example.workout.domain.board.presentation.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.parameters.P;

@Getter
@Setter
@ToString
public class AuthResult {
    private Long seq;
    private String content;
    private String username;
    private String title;
    private String category;
    private String kind;
}
