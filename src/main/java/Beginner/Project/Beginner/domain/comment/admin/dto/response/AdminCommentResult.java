package Beginner.Project.Beginner.domain.comment.admin.dto.response;

import lombok.*;

@Getter
@Builder
@ToString
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminCommentResult {
    private String username;
    private String content;
    private Long seq;
}
