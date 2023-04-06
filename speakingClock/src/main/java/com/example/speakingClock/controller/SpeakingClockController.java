package com.example.speakingClock.controller;

import com.example.speakingClock.response.ApiResponse;
import com.example.speakingClock.service.SpeakingClock;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

import static com.example.speakingClock.constants.ControllerConstants.SPEAKING_CLOCK;

@RestController
public class SpeakingClockController {

    @GetMapping(value = SPEAKING_CLOCK)
    public ApiResponse getSpeakingClock(@RequestParam("time") @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime time) {
        return new ApiResponse(HttpStatus.OK, SpeakingClock.convertToWords(time));
    }
}
