package com.example.workout.domain.comment.presentation;

import com.example.workout.domain.comment.presentation.dto.request.CommentParam;
import com.example.workout.domain.comment.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/comment/require")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequiredArgsConstructor
public class RequireCommentController {
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity viewAll() {
        commentService.viewAll();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity add(@RequestBody @Valid CommentParam param) {
        commentService.add(param);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Void> edit(@PathVariable("Id") Long id, @RequestBody @Valid CommentParam param) {
        commentService.edit(id, param);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{Id}")
    public ResponseEntity delete(@PathVariable("Id") Long id) {
        commentService.delete(id);
        return ResponseEntity.ok(null);
    }
}
