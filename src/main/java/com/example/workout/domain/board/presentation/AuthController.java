package com.example.workout.domain.board.presentation;

import com.example.workout.domain.board.entity.Auth;
import com.example.workout.domain.board.presentation.dto.request.AuthParam;
import com.example.workout.domain.board.service.Impl.AuthServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class AuthController {

    private final AuthServiceImpl authService;

    @GetMapping
    public ResponseEntity viewAll(){
        authService.viewAll();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/one")
    public ResponseEntity viewOne(Long seq){
        authService.viewOne(seq);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{Seq}")
    public ResponseEntity write(@PathVariable("Seq") Long Seq){
        authService.write(Seq);
        return ResponseEntity.ok(authService.write(Seq));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody @Valid AuthParam param){
        authService.add(param);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/{Seq}")
    public ResponseEntity<Void> edit(@PathVariable("Seq") Long seq, @RequestBody @Valid AuthParam param){
        authService.edit(seq,param);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{Seq}")
    public ResponseEntity<Void> delete(@PathVariable("Seq") Long Seq){
        authService.delete(Seq);
        return ResponseEntity.ok(null);
    }
}
