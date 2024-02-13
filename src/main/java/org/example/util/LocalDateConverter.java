package org.example.util;

import com.opencsv.bean.AbstractBeanField;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class LocalDateConverter extends AbstractBeanField<LocalDate, String> {
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected LocalDate convert(String value) {
        if (value == null || value.trim().isEmpty() || "null".equalsIgnoreCase(value.trim())) {
            return null; // Return null for empty or 'null' strings
        }
        try {
            return LocalDate.parse(value, formatter);
        } catch (DateTimeParseException e) {
            throw new RuntimeException("Error parsing LocalDate: " + value, e);
        }
    }
}
