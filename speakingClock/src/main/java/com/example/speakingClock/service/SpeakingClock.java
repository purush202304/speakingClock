package com.example.speakingClock.service;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class SpeakingClock {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH:mm");

    public static String convertToWords(LocalTime time) {
        int hour = time.getHour();
        int minute = time.getMinute();
        String hourStr = hourToWords(hour);
        String minuteStr = minuteToWords(minute);
        String meridianStr = (hour < 12) ? "am" : "pm";
        String result = "It's " + hourStr;
        if (minute > 0) {
            result += " " + minuteStr;
        }
        result += " " + meridianStr;
        return result;
    }

    private static String hourToWords(int hour) {
        if (hour == 0) {
            return "Midnight";
        } else if (hour == 12) {
            return "Midday";
        } else if (hour <= 12) {
            return digitToWord(hour);
        } else {
            return digitToWord(hour - 12);
        }
    }

    private static String minuteToWords(int minute) {
        if (minute == 15) {
            return "fifteen";
        } else if (minute == 30) {
            return "thirty";
        } else if (minute == 45) {
            return "forty five";
        } else if (minute < 10) {
            return digitToWord(minute);
        } else {
            int tens = minute / 10;
            int ones = minute % 10;
            String minuteStr = "";
            if (tens > 1) {
                minuteStr += digitToWord(tens) + "ty";
            } else {
                minuteStr += digitToWord(minute);
            }
            if (ones > 0) {
                minuteStr += " " + digitToWord(ones);
            }
            return minuteStr;
        }
    }

    private static String digitToWord(int digit) {
        switch (digit) {
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            case 10: return "ten";
            case 11: return "eleven";
            case 12: return "twelve";
            case 13: return "thirteen";
            case 14: return "fourteen";
            case 16: return "sixteen";
            case 17: return "seventeen";
            case 18: return "eighteen";
            case 19: return "nineteen";
            default: return "";
        }
    }
}
