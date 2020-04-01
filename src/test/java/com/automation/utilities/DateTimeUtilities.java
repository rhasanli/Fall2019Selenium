package com.automation.utilities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DateTimeUtilities {

    /**
     * This method returns current date as a String
     * MMM -> Jan, Feb Mar
     * MM -> 01, 02, 03
     *
     * @param format for example MMM dd, yyyy
     * @return
     */

    public static String getCurrentDate(String format) {
        return LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }

    /**
     * This method returns difference between end and start time
     *
     * @param start time
     * @param end time
     * @param format -> HH:mm:ss
     * @return
     */
    public static long getTimeDifference(String start, String end, String format) {
        LocalTime startTime = LocalTime.parse(start, DateTimeFormatter.ofPattern(format));
        LocalTime endTime = LocalTime.parse(end, DateTimeFormatter.ofPattern(format));
        return ChronoUnit.HOURS.between(startTime, endTime);
    }

}
