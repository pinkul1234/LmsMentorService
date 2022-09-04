package com.bridgelabz.lmsmentorservice.controller;

import com.bridgelabz.lmsmentorservice.dto.MentorDto;
import com.bridgelabz.lmsmentorservice.model.MentorModel;
import com.bridgelabz.lmsmentorservice.service.IMentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mentor")
public class MentorController {

    @Autowired
    IMentorService mentorService;

    @PostMapping("/addmentor")
    public MentorModel addMentor(@RequestHeader String token, @RequestBody MentorDto mentorDto){
        return mentorService.addMentor(token, mentorDto);
    }

    @PutMapping("/updatementor{id}")
    public MentorModel updateMentor(@RequestHeader String token, @RequestBody MentorDto mentorDto, @PathVariable long id){
        return mentorService.updateMentor(id, token, mentorDto);
    }

    @GetMapping("/getmentordata")
    public List<MentorModel> getAllMentor(@RequestHeader String token){
        return mentorService.getMentorData(token);
    }

    @DeleteMapping("/deletementor")
    public MentorModel deleteMentor(@PathVariable long id, @RequestHeader String token){
        return mentorService.getDeleteMentor(id, token);
    }


    @GetMapping("/fetchdetail")
    public List<MentorModel> fetchDetail(@RequestHeader String token){
        return mentorService.fetchDetail(token);
    }


}