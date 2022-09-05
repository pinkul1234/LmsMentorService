package com.bridgelabz.lmsmentorservice.service;

import com.bridgelabz.lmsmentorservice.dto.MentorDto;
import com.bridgelabz.lmsmentorservice.model.MentorModel;
import com.bridgelabz.lmsmentorservice.util.Response;

import java.util.List;

public interface IMentorService {

    Response updateMentor(long id, String token, MentorDto mentorDto);

    List<MentorModel> getMentorData(String token);

    Response getDeleteMentor(long id, String token);

    Response addMentor(String token, MentorDto mentorDto);


    Response getMentorsDetailsById(String token, long id);
}