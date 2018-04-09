package com.conmigo.app.function;

import java.time.LocalDate;

public class CustomFunction {
    public static String getDateRange(final LocalDate birthdate) {
        LocalDate today = LocalDate.now();
        LocalDate birthdate25 = birthdate.plusYears(25);
        LocalDate birthdate35 = birthdate.plusYears(35);
        LocalDate birthdate45 = birthdate.plusYears(45);
        LocalDate birthdate60 = birthdate.plusYears(60);

        String range = "60 >";
        if (birthdate25.isAfter(today)) {
            range = "< 25";
        } else if (birthdate35.isAfter(today)) {
            range = "25 - 35";
        } else if (birthdate45.isAfter(today)) {
            range = "35 - 45";
        } else if (birthdate60.isAfter(today)) {
            range = "45 - 60";
        }

        return range;
    }
}
