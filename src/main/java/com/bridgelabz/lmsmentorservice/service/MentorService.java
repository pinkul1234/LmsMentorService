package com.bridgelabz.lmsmentorservice.service;


import com.bridgelabz.lmsmentorservice.dto.MentorDto;
import com.bridgelabz.lmsmentorservice.exception.MentorNotFoundException;
import com.bridgelabz.lmsmentorservice.model.MentorModel;
import com.bridgelabz.lmsmentorservice.repository.MentorRepository;
import com.bridgelabz.lmsmentorservice.util.Response;
import com.bridgelabz.lmsmentorservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class MentorService implements IMentorService {
    @Autowired
    MentorRepository mentorRepository;
    @Autowired
    TokenUtil tokenUtil;
    @Autowired
    MailService mailService;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public Response addMentor(String token, MentorDto mentorDto) {
        boolean isMentorPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isMentorPresent) {
            MentorModel mentorModel = new MentorModel(mentorDto);
            mentorRepository.save(mentorModel);
            String body = "Mentor added sucessfully " + mentorModel.getId();
            String subject = "Mentor registration completed";
            mailService.send(mentorModel.getEmail(), body, subject);
            return new Response("Success", 200, mentorModel);
        }
        throw new MentorNotFoundException(400, "Mentor Added Unsuccessfull");
    }

    @Override
    public Response updateMentor(long id, String token, MentorDto mentorDto) {
        boolean isMentorPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);

        if (isMentorPresent) {
            Optional<MentorModel> isMentor = mentorRepository.findById(id);
            if (isMentor.isPresent()) {
                isMentor.get().setEmployeeId(mentorDto.getEmployeeId());
                isMentor.get().setFirstName(mentorDto.getFirstName());
                isMentor.get().setLastName(mentorDto.getLastName());
                isMentor.get().setMentorType(mentorDto.getMentorType());
                isMentor.get().setMentorRole(mentorDto.getMentorRole());
                isMentor.get().setMobileNumber(mentorDto.getMobileNumber());
                isMentor.get().setEmail(mentorDto.getEmail());
                isMentor.get().setExperienceYears(mentorDto.getExperienceYears());
                isMentor.get().setPreferredTime(mentorDto.getPreferredTime());
                isMentor.get().setStartDate(mentorDto.getStartDate());
                isMentor.get().setStatus(mentorDto.getStatus());
                isMentor.get().setMentorDescription(mentorDto.getMentorDescription());
                isMentor.get().setProfileImageUrl(mentorDto.getProfileImageUrl());
                isMentor.get().setCreatorUser(mentorDto.getCreatorUser());
                isMentor.get().setSupervisorId(mentorDto.getSupervisorId());
                isMentor.get().setCreatedTimeStamp(mentorDto.getCreatedTimeStamp());
                isMentor.get().setUpdatedTimeStamp(mentorDto.getUpdatedTimeStamp());
                mentorRepository.save(isMentor.get());
                return new Response("Success", 200, isMentor.get());
            }
            throw new MentorNotFoundException(400, "Mentor Not Found");
        }
        throw new MentorNotFoundException(400, "Failed");
    }


    @Override
    public List<MentorModel> getMentorData(String token) {
        boolean isMentorPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isMentorPresent) {
            List<MentorModel> isMentor = mentorRepository.findAll();
            return isMentor;
        } else {
            throw new MentorNotFoundException(400, "Mentor Not Available");
        }
    }

    @Override
    public Response getDeleteMentor(long id, String token) {
        boolean isMentorPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isMentorPresent) {
            Optional<MentorModel> isMentor = mentorRepository.findById(id);
            if (isMentor.isPresent()) {
                mentorRepository.delete(isMentor.get());
                return new Response("success", 200, isMentor.get());
            }
            throw new MentorNotFoundException(400, "Mentor does not found");
        }
        throw new MentorNotFoundException(400, "Failed");
    }


    @Override
    public Response getMentorsDetailsById(String token, long id) {
        boolean isMentorPresent = restTemplate.getForObject("http://localhost:8082/admin/validate/" + token, Boolean.class);
        if (isMentorPresent) {
            Optional<MentorModel> isMentor = mentorRepository.findById(id);
            if (isMentor.isPresent()) {
                return new Response("success", 200, isMentor);
            } else {
                throw new MentorNotFoundException(400, "Mentor not found");
            }
        }
        throw new MentorNotFoundException(400, "not found");
    }
}
