package com.example.speakingClock.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.key.ZonedDateTimeKeySerializer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Getter
@NoArgsConstructor
public class ApiError {
    @JsonSerialize(using = ZonedDateTimeSerializer.class)
    private ZonedDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

    public ApiError(HttpStatus status, String message, String path) {
        this.timestamp = ZonedDateTime.now();
        this.status = status.value();
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
