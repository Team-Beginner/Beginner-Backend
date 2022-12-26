package Beginner.Project.Beginner.domain.comment.admin.service;

import Beginner.Project.Beginner.domain.comment.admin.dto.request.AdminCommentParam;
import Beginner.Project.Beginner.domain.comment.admin.dto.response.AdminCommentResult;
import Beginner.Project.Beginner.domain.comment.admin.entity.AdminComment;
import Beginner.Project.Beginner.domain.comment.admin.repository.AdminCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminCommentService {
    private final AdminCommentRepository adminCommentRepository;

    @Transactional
    public List<AdminComment> all(){
        List<AdminComment> adminComment = adminCommentRepository.findAll();
        return adminComment;
    }

    @Transactional
    public Object write (Long seq){
        return adminCommentRepository.findById(seq).map(adminComment->{
            AdminCommentResult adminCommentResult = new AdminCommentResult();
            adminCommentResult.setContent(adminComment.getContent());
            adminCommentResult.setUsername(adminComment.getUsername());
            adminCommentResult.setSeq(adminComment.getSeq());
            return adminCommentResult;

        }).get();
    }

    @Transactional(rollbackFor = Exception.class)
    public void add(AdminCommentParam param){
        AdminComment adminComment = AdminComment.builder()
                .content(param.getContent())
                .username(param.getUsername())
                .build();

        adminCommentRepository.save(adminComment);
    }

    @Transactional
    public void edit(AdminCommentParam param){
        AdminComment getEntity = adminCommentRepository.findByUsername(param.getUsername())
                .orElseThrow( ()->new RuntimeException());
        getEntity.update(param);
        adminCommentRepository.save(getEntity);
    }

    @Transactional
    public void delete(Long seq){
        adminCommentRepository.deleteById(seq);
    }

}
