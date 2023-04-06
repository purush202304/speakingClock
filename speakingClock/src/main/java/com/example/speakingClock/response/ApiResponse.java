package com.example.speakingClock.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
public class ApiResponse {
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    private ZonedDateTime timestamp;
    private int status;
    private String message;


    public ApiResponse(HttpStatus status, String message) {
        this.timestamp = ZonedDateTime.now();
        this.status = status.value();
        this.message = message;

    }
}
