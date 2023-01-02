package com.example.workout.domain.board.presentation;

import com.example.workout.domain.board.presentation.dto.request.AuthParam;
import com.example.workout.domain.board.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping("/require")
public class RequireController {
    private final AuthService authService;

    @GetMapping
    public ResponseEntity viewAll(){
        authService.viewAll();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/view/{seq}")
    public ResponseEntity viewOne(@PathVariable Long seq){
        authService.viewOne(seq);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/write/{seq}")
    public ResponseEntity write(@PathVariable Long seq){
        authService.write(seq);
        return ResponseEntity.ok(authService.write(seq));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody @Valid AuthParam param){
        authService.add(param);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/{seq}")
    public ResponseEntity<Void> edit(@PathVariable Long seq, @RequestBody @Valid AuthParam param){
        authService.edit(seq,param);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<Void> delete(@PathVariable Long seq){
        authService.delete(seq);
        return ResponseEntity.ok(null);
    }
}