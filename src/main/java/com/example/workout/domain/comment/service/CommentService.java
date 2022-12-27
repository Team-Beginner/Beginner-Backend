package com.example.workout.domain.comment.service;

import com.example.workout.domain.comment.entity.Comment;
import com.example.workout.domain.comment.presentation.dto.request.CommentParam;

import java.util.List;

public interface CommentService {
    public List<Comment> viewAll();
    public void add(CommentParam param);
    public void edit(Long id, CommentParam param);
    public void delete(Long Id);
}
