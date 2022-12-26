package Beginner.Project.Beginner.domain.board.Member.service;


import Beginner.Project.Beginner.domain.board.Member.repository.MemberRepository;
import Beginner.Project.Beginner.domain.board.Member.dto.request.MemberParam;
import Beginner.Project.Beginner.domain.board.Member.entity.Member;
import Beginner.Project.Beginner.domain.board.Member.dto.response.MemberResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberRepository memberRepository;

    @Transactional
    public List<Member> allBoard(){
        List<Member> members = memberRepository.findAll();
        return members;
    }

    @Transactional
    public Object allBoard(Long seq){
        return memberRepository.findById(seq).map(Member->{
            MemberResult memberResult = new MemberResult();
            memberResult.setContent(Member.getContent());
            memberResult.setUsername(Member.getUsername());
            memberResult.setTitle(Member.getTitle());
            memberResult.setSeq(Member.getSeq());
            return memberResult;

        }).get();
    }

    @Transactional
    public void edit(MemberParam param){
        Member getEntity = memberRepository.findByUsername(param.getUsername())
                .orElseThrow( () -> new RuntimeException() );
        getEntity.update(param);
        memberRepository.save(getEntity);
    }
    @Transactional
    public void add(MemberParam param){
        Member member = Member.builder()
                .content(param.getContent())
                .title(param.getTitle())
                .username(param.getUsername())
                .build();
        memberRepository.save(member);
    }

    @Transactional
    public void delete(Long seq){
        memberRepository.deleteById(seq);
    }

}
