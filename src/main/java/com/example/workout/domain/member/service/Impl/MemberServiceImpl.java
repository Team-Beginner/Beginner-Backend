package com.example.workout.domain.member.service.Impl;

import com.example.workout.domain.email.entity.EmailAuth;
import com.example.workout.domain.email.exception.MisMatchAuthCodeException;
import com.example.workout.domain.email.exception.NotVerifyEmailException;
import com.example.workout.domain.email.repository.EmailAuthRepository;
import com.example.workout.domain.member.presentation.dto.request.ChangePasswordRequest;
import com.example.workout.domain.member.presentation.dto.request.LoginRequest;
import com.example.workout.domain.member.presentation.dto.request.SignUpRequest;
import com.example.workout.domain.member.presentation.dto.response.MemberLoginResponse;
import com.example.workout.domain.member.presentation.dto.response.NewTokenResponse;
import com.example.workout.domain.member.entity.Member;
import com.example.workout.domain.member.entity.RefreshToken;
import com.example.workout.domain.member.exception.ExistEmailException;
import com.example.workout.domain.member.exception.MemberNotFoundException;
import com.example.workout.domain.member.repository.MemberRepository;
import com.example.workout.domain.member.repository.RefreshTokenRepository;
import com.example.workout.domain.member.service.MemberService;
import com.example.workout.global.role.Role;
import com.example.workout.global.security.jwt.TokenProvider;
import com.example.workout.global.security.jwt.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenProvider tokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;
    private final JwtProperties jwtProperties;
    private final EmailAuthRepository emailAuthRepository;

    @Transactional
    public MemberLoginResponse login(LoginRequest loginRequest) {
        Member member = memberRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new MemberNotFoundException("존재하지 않는 회원입니다"));
        if(!passwordEncoder.matches(loginRequest.getPassword(), member.getPassword())){
            throw new MisMatchAuthCodeException("비밀번호가 일치하지 않습니다.");
        }

        String accessToken = tokenProvider.generatedAccessToken(loginRequest.getEmail());
        String refreshToken = tokenProvider.generatedRefreshToken(loginRequest.getEmail());
        RefreshToken entityToRedis = new RefreshToken(loginRequest.getEmail(), refreshToken, tokenProvider.getREFRESH_TOKEN_EXPIRE_TIME());
        refreshTokenRepository.save(entityToRedis);

        return MemberLoginResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .expiredAt(tokenProvider.getExpiredAtToken(accessToken, jwtProperties.getAccessSecret()))
                .build();
    }



    @Transactional(rollbackFor = Exception.class)
    public void signUp(SignUpRequest signUpRequest) {
        boolean isExist = memberRepository.existsByEmail(signUpRequest.getEmail());
        if(isExist){
            throw new ExistEmailException("이미 존재하는 이메일입니다.");
        }
        EmailAuth emailAuth = emailAuthRepository.findById(signUpRequest.getEmail())
                .orElseThrow(() -> new NotVerifyEmailException("이미 존재하는 이메일입니다."));

        if(!emailAuth.getAuthentication()){
            throw new NotVerifyEmailException("인증되지 않은 이메일입니다.");
        }

        Member member = Member.builder()
                .email(signUpRequest.getEmail())
                .password(signUpRequest.getPassword())
                .name(signUpRequest.getName())
                .number(signUpRequest.getNumber())
                .role(Role.from(signUpRequest.getRole()))
                .build();
        memberRepository.save(member);
    }

    @Override
    public void changePassword(ChangePasswordRequest changePasswordRequest) {

    }

    @Override
    public void validateAuth(String email) {

    }

    @Override
    public NewTokenResponse tokenReissue(String requestToken) {
        return null;
    }
}
