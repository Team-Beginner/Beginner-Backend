package Beginner.Project.Beginner.domain.board.Member.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberResult {
    Long seq;
    String content;
    String username;
    String title;
}
