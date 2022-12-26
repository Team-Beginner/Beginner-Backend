package Beginner.Project.Beginner.domain.board.Member.dto.request;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MemberParam {

    @NotBlank
    private String content;

    @NotBlank
    private String username;

    @NotBlank
    private String title;

}
