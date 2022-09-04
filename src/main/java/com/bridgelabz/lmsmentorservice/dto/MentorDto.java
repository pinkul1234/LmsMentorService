package com.bridgelabz.lmsmentorservice.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MentorDto {
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
}