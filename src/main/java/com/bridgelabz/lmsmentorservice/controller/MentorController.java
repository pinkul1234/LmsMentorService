package com.bridgelabz.lmsmentorservice.controller;

import com.bridgelabz.lmsmentorservice.dto.MentorDto;
import com.bridgelabz.lmsmentorservice.model.MentorModel;
import com.bridgelabz.lmsmentorservice.service.IMentorService;
import com.bridgelabz.lmsmentorservice.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    IMentorService mentorService;

    @PostMapping("/addmentor")
    public ResponseEntity<Response> addMentor(@RequestHeader String token, @RequestBody MentorDto mentorDto){
        Response response = mentorService.addMentor(token, mentorDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/updatementor{id}")
    public ResponseEntity<Response> updateMentor(@RequestHeader String token, @RequestBody MentorDto mentorDto, @PathVariable long id){
        Response response = mentorService.updateMentor(id, token, mentorDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/getmentordata")
    public ResponseEntity<List<?>> getAllMentor(@RequestHeader String token){
        List<MentorModel> response = mentorService.getMentorData(token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deletementor")
    public ResponseEntity<Response> deleteMentor(@PathVariable long id, @RequestHeader String token){
        Response response = mentorService.getDeleteMentor(id, token);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @GetMapping("/getMentorById/{id}")
    public ResponseEntity<Response> getByMentorId(@RequestHeader String token,
                                                  @PathVariable long id) {
        Response response = mentorService.getMentorsDetailsById(token, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}