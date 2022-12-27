package com.example.workout.domain.board.service;

import com.example.workout.domain.board.entity.Auth;
import com.example.workout.domain.board.presentation.dto.request.AuthParam;

import java.util.List;

public interface AuthService {
    public List<Auth> viewAll();
    public List<Auth> viewOne(Long seq);
    public Object write(Long seq);
    public void edit(AuthParam param);
    public void add(AuthParam param);
    public void delete(Long seq);
}
