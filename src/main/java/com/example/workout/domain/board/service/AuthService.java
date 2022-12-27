package com.example.workout.domain.board.service;

import com.example.workout.domain.board.entity.Auth;
import com.example.workout.domain.board.presentation.dto.request.AuthParam;

import java.util.List;
import java.util.Optional;

public interface AuthService {
    List<Auth> viewAll();
    Optional<Auth> viewOne(Long seq);
    Object write(Long seq);
    void edit(Long seq, AuthParam param);
    void add(AuthParam param);
    void delete(Long seq);
}
