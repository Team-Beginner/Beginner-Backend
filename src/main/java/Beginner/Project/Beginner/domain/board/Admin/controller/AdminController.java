package Beginner.Project.Beginner.domain.board.Admin.controller;

import Beginner.Project.Beginner.domain.board.Admin.dto.request.AdminParam;
import Beginner.Project.Beginner.domain.board.Admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    //test

    private final AdminService adminService;

    @GetMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity all(){
        adminService.all();
        return ResponseEntity.ok(HttpStatus.OK);
    }



    @GetMapping(value = "/{seq}")
    public ResponseEntity write(@PathVariable("seq") Long seq){
        adminService.write(seq);
        return ResponseEntity.ok(adminService.write(seq));
    }




    @PostMapping("/add")
    public ResponseEntity<Void> add(@RequestBody @Valid AdminParam param){
        adminService.add(param);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @PutMapping(value = "/{seq}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> edit(@RequestBody @Valid AdminParam param,@PathVariable("seq") Long seq){
        adminService.edit(param);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @DeleteMapping(value = "/{seq}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable("seq") Long seq){
        adminService.delete(seq);
        return ResponseEntity.ok(null);
    }
}
