package com.bridgelabz.lmsmentorservice.service;


import com.bridgelabz.lmsmentorservice.dto.MentorDto;
import com.bridgelabz.lmsmentorservice.exception.MentorNotFoundException;
import com.bridgelabz.lmsmentorservice.model.MentorModel;
import com.bridgelabz.lmsmentorservice.repository.MentorRepository;
import com.bridgelabz.lmsmentorservice.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public MentorModel addMentor(String token, MentorDto mentorDto) {
        long userId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isMentorPresent = mentorRepository.findById(userId);
        if (isMentorPresent.isPresent()) {
            MentorModel mentorModel = new MentorModel(mentorDto);
            mentorRepository.save(mentorModel);
            return mentorModel;
        }
        throw new MentorNotFoundException(400, "Mentor Added Unsuccessfull");
    }

    @Override
    public MentorModel updateMentor(long id, String token, MentorDto mentorDto) {
        long userId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isAdminPresent = mentorRepository.findById(userId);
        if (isAdminPresent.isPresent()) {
            Optional<MentorModel> isMentorPresent = mentorRepository.findById(id);
            if (isMentorPresent.isPresent()) {
                isMentorPresent.get().setEmployeeId(mentorDto.getEmployeeId());
                isMentorPresent.get().setFirstName(mentorDto.getFirstName());
                isMentorPresent.get().setLastName(mentorDto.getLastName());
                isMentorPresent.get().setMentorType(mentorDto.getMentorType());
                isMentorPresent.get().setMentorRole(mentorDto.getMentorRole());
                isMentorPresent.get().setMobileNumber(mentorDto.getMobileNumber());
                isMentorPresent.get().setEmail(mentorDto.getEmail());
                isMentorPresent.get().setExperienceYears(mentorDto.getExperienceYears());
                isMentorPresent.get().setPreferredTime(mentorDto.getPreferredTime());
                isMentorPresent.get().setStartDate(mentorDto.getStartDate());
                isMentorPresent.get().setStatus(mentorDto.getStatus());
                isMentorPresent.get().setMentorDescription(mentorDto.getMentorDescription());
                isMentorPresent.get().setProfileImageUrl(mentorDto.getProfileImageUrl());
                isMentorPresent.get().setCreatorUser(mentorDto.getCreatorUser());
                isMentorPresent.get().setSupervisorId(mentorDto.getSupervisorId());
                isMentorPresent.get().setCreatedTimeStamp(mentorDto.getCreatedTimeStamp());
                isMentorPresent.get().setUpdatedTimeStamp(mentorDto.getUpdatedTimeStamp());
                mentorRepository.save(isMentorPresent.get());
                return isMentorPresent.get();
            }
            throw new MentorNotFoundException(400, "Mentor Not Found");
        }
        throw new MentorNotFoundException(400, "Failed");
    }


    @Override
    public List<MentorModel> getMentorData(String token) {
        long userId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isCandidatePresent = mentorRepository.findById(userId);
        if (isCandidatePresent.isPresent()) {
            List<MentorModel> getAllMentors = mentorRepository.findAll();
            return getAllMentors;
        } else {
            throw new MentorNotFoundException(400, "Mentor Not Available");
        }
    }

    @Override
    public MentorModel getDeleteMentor(long id, String token) {
        long userId = tokenUtil.decodeToken(token);
        Optional<MentorModel> isAdmin = mentorRepository.findById(userId);
        if (isAdmin.isPresent()) {
            Optional<MentorModel> isMentorPresent = mentorRepository.findById(id);
            if (isMentorPresent.isPresent()) {
                mentorRepository.delete(isMentorPresent.get());
                return isMentorPresent.get();
            }
            throw new MentorNotFoundException(400, "Mentor does not found");
        }
        throw new MentorNotFoundException(400, "Failed");
    }


    @Override
    public List<MentorModel> fetchDetail(String token) {
        long userId = tokenUtil.decodeToken(token);
        List<MentorModel> isMentorId = mentorRepository.findByAllId(userId);
        if (isMentorId.isEmpty()) {
            throw new MentorNotFoundException(400, "Mentor not found");
        } else {
            return isMentorId;
        }
    }

}
