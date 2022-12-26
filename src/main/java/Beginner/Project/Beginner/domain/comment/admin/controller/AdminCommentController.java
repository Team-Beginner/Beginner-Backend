package Beginner.Project.Beginner.domain.comment.admin.controller;


import Beginner.Project.Beginner.domain.comment.admin.dto.request.AdminCommentParam;
import Beginner.Project.Beginner.domain.comment.admin.service.AdminCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class AdminCommentController {

    private final AdminCommentService adminConmmentService;

    @GetMapping()
    public ResponseEntity all(){
        adminConmmentService.all();
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/{seq}")
    public ResponseEntity write(@PathVariable("seq") Long seq){
        adminConmmentService.write(seq);
        return ResponseEntity.ok(adminConmmentService.write(seq));
    }

    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody @Valid AdminCommentParam commentParam){
        adminConmmentService.add(commentParam);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @PutMapping("/{seq}")
    public ResponseEntity<Void> edit(@RequestBody @Valid AdminCommentParam commentParam, @PathVariable("seq")Long seq){
        adminConmmentService.edit(commentParam);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{seq}")
    public ResponseEntity<Void> delete(@PathVariable ("seq")Long seq){
        adminConmmentService.delete(seq);
        return ResponseEntity.ok(null);
    }



}
