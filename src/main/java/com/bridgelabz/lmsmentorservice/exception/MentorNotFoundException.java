package com.bridgelabz.lmsmentorservice.exception;

import com.bridgelabz.lmsmentorservice.util.Response;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class MentorNotFoundException extends RuntimeException{
    public Response getErrorResponse;
    private int statusCode;
    private String statusMessage;
    public MentorNotFoundException(int id, String statusMessage) {
        super(statusMessage);
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
    }
}
