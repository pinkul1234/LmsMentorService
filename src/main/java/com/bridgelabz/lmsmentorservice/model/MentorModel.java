package com.bridgelabz.lmsmentorservice.model;

import com.bridgelabz.lmsmentorservice.dto.MentorDto;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "Mentor")
@Data
public class MentorModel{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String mentorType;
    private String mentorRole;
    private  long mobileNumber;
    private String email;
    private String experienceYears;
    private String preferredTime;
    private LocalDate startDate;
    private String status;
    private String mentorDescription;
    private String profileImageUrl;
    private int creatorUser;
    private long supervisorId;
    private LocalDateTime createdTimeStamp;
    private LocalDateTime updatedTimeStamp;

    public MentorModel(MentorDto mentorDto){
        this.employeeId = mentorDto.getEmployeeId();
        this.firstName = mentorDto.getFirstName();
        this.lastName = mentorDto.getLastName();
        this.mentorType = mentorDto.getMentorType();
        this.mentorRole = mentorDto.getMentorRole();
        this.mobileNumber = mentorDto.getMobileNumber();
        this.email = mentorDto.getEmail();
        this.experienceYears = mentorDto.getExperienceYears();
        this.preferredTime = mentorDto.getPreferredTime();
        this.startDate = mentorDto.getStartDate();
        this.status = mentorDto.getStatus();
        this.mentorDescription = mentorDto.getMentorDescription();
        this.profileImageUrl = mentorDto.getProfileImageUrl();
        this.creatorUser = mentorDto.getCreatorUser();
        this.supervisorId = mentorDto.getSupervisorId();
        this.createdTimeStamp = mentorDto.getCreatedTimeStamp();
        this.updatedTimeStamp = mentorDto.getUpdatedTimeStamp();
    }

    public MentorModel() {

    }
}