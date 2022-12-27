package com.example.workout.domain.comment.service.Impl;

import com.example.workout.domain.comment.entity.Comment;
import com.example.workout.domain.comment.presentation.dto.request.CommentParam;
import com.example.workout.domain.comment.repository.CommentRepository;
import com.example.workout.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    @Transactional
    public List<Comment> viewAll(){
        List<Comment> comment =commentRepository.findAll();
        return comment;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(CommentParam param){
        Comment comment = Comment.builder()
                .content(param.getContent())
                .userName(param.getUserName())
                .build();

        commentRepository.save(comment);
    }


    @Override
    @Transactional
    public void edit(Long id, CommentParam param) {
        Comment getEntity =commentRepository.findById(id)
                .orElseThrow( ()->new RuntimeException());
        getEntity.update(param.getContent(), param.getUserName());
        commentRepository.save(getEntity);

    }

    @Override
    @Transactional
    public void delete(Long Id){ commentRepository.deleteById(Id);}
}
