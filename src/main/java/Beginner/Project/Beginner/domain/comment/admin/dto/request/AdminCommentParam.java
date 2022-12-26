package Beginner.Project.Beginner.domain.comment.admin.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AdminCommentParam {
    @NotBlank
    private String username;

    @NotBlank
    private String content;
}
