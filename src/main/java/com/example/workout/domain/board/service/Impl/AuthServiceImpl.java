package com.example.workout.domain.board.service.Impl;

import com.example.workout.domain.board.presentation.dto.request.AuthParam;
import com.example.workout.domain.board.presentation.dto.response.AuthResult;
import com.example.workout.domain.board.entity.Auth;
import com.example.workout.domain.board.repository.AuthRepository;
import com.example.workout.domain.board.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    @Override
    @Transactional
    public List<Auth> viewAll(){
        List<Auth> auth = authRepository.findAll();
        return auth;
    }
    @Override
    @Transactional
    public List<Auth> viewOne(Long seq){
        List<Auth> auth = authRepository.findBySeq(seq);
        return auth;
    }
    @Override
    @Transactional
    public Object write(Long seq){
        return authRepository.findById(seq).map(Auth->{
            AuthResult authResult = new AuthResult();
            authResult.setContent(Auth.getContent());
            authResult.setTitle(Auth.getTitle());
            authResult.setUsername(Auth.getUserName());
            authResult.setSeq(Auth.getSeq());
            authResult.setCategory(Auth.getCategory());
            authResult.setKind(Auth.getKind());
            return authResult;
        }).get();
    }
    @Override
    @Transactional
    public void edit(Long seq, AuthParam param){
        Auth getEntity = authRepository.findBySeq(seq)
                .orElseThrow( ()->new RuntimeException());
        getEntity.update(param.getContent(), param.getTitle(), param.getUsername(), param.getCategory(), param.getKind());
        authRepository.save(getEntity);

    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void add(AuthParam param){
        Auth auth = Auth.builder()
                .title(param.getTitle())
                .content(param.getContent())
                .userName(param.getUsername())
                .kind(param.getKind())
                .category(param.getCategory())
                .build();

        authRepository.save(auth);
    }
    @Override
    @Transactional
    public void delete(Long seq){authRepository.deleteById(seq);}
}
