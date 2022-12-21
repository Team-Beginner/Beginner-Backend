package com.example.workout.domain.member.presentation.controller;

import com.example.workout.domain.member.presentation.dto.request.LoginRequest;
import com.example.workout.domain.member.presentation.dto.request.SignUpRequest;
import com.example.workout.domain.member.presentation.dto.response.MemberLoginResponse;
import com.example.workout.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> signUp(@RequestBody @Validated SignUpRequest signUpRequest){
        memberService.signUp(signUpRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/login")
    public ResponseEntity<MemberLoginResponse> login(@RequestBody LoginRequest loginRequest){
        MemberLoginResponse data = memberService.login(loginRequest);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
