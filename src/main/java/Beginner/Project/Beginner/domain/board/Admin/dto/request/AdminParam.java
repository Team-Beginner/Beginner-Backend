package Beginner.Project.Beginner.domain.board.Admin.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminParam {


    @NotBlank
    private String content;

    @NotBlank
    private String username;

    @NotBlank
    private String title;


}
