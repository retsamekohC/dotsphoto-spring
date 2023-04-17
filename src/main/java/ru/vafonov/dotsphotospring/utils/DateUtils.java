package ru.vafonov.dotsphotospring.utils;

import java.sql.Date;
import java.time.LocalDate;

public class DateUtils {

    public static Date now() {
        return Date.valueOf(LocalDate.now());
    }
}
