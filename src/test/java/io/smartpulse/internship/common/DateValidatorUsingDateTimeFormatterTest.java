package io.smartpulse.internship.common;

import io.smartpulse.internship.common.DateValidator;
import io.smartpulse.internship.common.DateValidatorUsingDateTimeFormatter;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


public class DateValidatorUsingDateTimeFormatterTest {


    static DateValidator dateValidator;

    static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZZZ");

    @BeforeAll
    static void init() {
        dateValidator = new DateValidatorUsingDateTimeFormatter(dateFormatter);
    }
    @Test
    void isValidTest() {
        Assertions.assertTrue(dateValidator.isValid("2022-01-26T00:00:56.000+0300"));
    }

    @Test
    void isInValidTest() {
        Assertions.assertFalse(dateValidator.isValid("2022-01-26T00:00:35"));
    }
}
