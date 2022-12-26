package Beginner.Project.Beginner.domain.board.Member.controller;

import Beginner.Project.Beginner.domain.board.Member.service.MemberService;
import Beginner.Project.Beginner.domain.board.Member.dto.request.MemberParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity all(){
        return ResponseEntity.ok(memberService.allBoard());
    }

    @GetMapping(value = "/{seq}")
    public ResponseEntity all(@PathVariable("seq")Long seq){

        return ResponseEntity.ok(memberService.allBoard(seq));
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid MemberParam param){
        memberService.add(param);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{seq}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity edit(@RequestBody @Valid MemberParam param,@PathVariable("seq") Long seq){
        memberService.edit(param);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "{seq}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("seq") Long seq){
        memberService.delete(seq);
        return ResponseEntity.ok(null);
    }


}
