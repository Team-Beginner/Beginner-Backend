package Beginner.Project.Beginner.domain.board.Admin.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AdminResult {
    private Long seq;
    private String content;
    private String username;
    private String title;
}
