package com.bridgelabz.lmsmentorservice.service;

import com.bridgelabz.lmsmentorservice.dto.MentorDto;
import com.bridgelabz.lmsmentorservice.model.MentorModel;

import java.util.List;

public interface IMentorService {

    MentorModel updateMentor(long id, String token, MentorDto mentorDto);

    List<MentorModel> getMentorData(String token);

    MentorModel getDeleteMentor(long id, String token);

    MentorModel addMentor(String token, MentorDto mentorDto);

    List<MentorModel> fetchDetail(String token);

}