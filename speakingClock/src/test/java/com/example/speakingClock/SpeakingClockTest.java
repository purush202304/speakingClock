package com.example.speakingClock;

import com.example.speakingClock.service.SpeakingClock;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpeakingClockTest {

    @Test
    public void testMidnight() {
        LocalTime time = LocalTime.parse("00:00");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's Midnight am";
        assertEquals(expected, actual);
    }

    @Test
    public void testMidday() {
        LocalTime time = LocalTime.parse("12:00");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's Midday pm";
        assertEquals(expected, actual);
    }

    @Test
    public void testOnTheHour() {
        LocalTime time = LocalTime.parse("14:00");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's two pm";
        assertEquals(expected, actual);
    }

    @Test
    public void testRoundMinute() {
        LocalTime time = LocalTime.parse("08:15");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's eight fifteen am";
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleDigitMinute() {
        LocalTime time = LocalTime.parse("17:05");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's five five pm";
        assertEquals(expected, actual);
    }

    @Test
    public void testDoubleDigitMinute() {
        LocalTime time = LocalTime.parse("10:34");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's ten threety four am";
        assertEquals(expected, actual);
    }

    @Test
    public void testQuarterTo() {
        LocalTime time = LocalTime.parse("22:45");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's ten forty five pm";
        assertEquals(expected, actual);
    }

    @Test
    public void testHalfPast() {
        LocalTime time = LocalTime.parse("16:30");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's four thirty pm";
        assertEquals(expected, actual);
    }

    @Test
    public void testSingleDigitHour() {
        LocalTime time = LocalTime.parse("05:48");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's five fourty eight am";
        assertEquals(expected, actual);
    }

    @Test
    public void testDoubleDigitHour() {
        LocalTime time = LocalTime.parse("17:15");
        String actual = SpeakingClock.convertToWords(time);
        String expected = "It's five fifteen pm";
        assertEquals(expected, actual);
    }


}

