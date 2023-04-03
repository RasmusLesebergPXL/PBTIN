package be.pxl.ja;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class ParsingDateExampleTest {

    @Test
    void itShouldFormatStringToZonedDateTime() throws ParseException {
        String dateString = "Wed May 21 00:00:00 EDT 2008";
        String pattern = "EEE MMM d HH:mm:ss z yyyy";
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH));
        ZonedDateTime expectedzonedDateTime = LocalDateTime
                .of(2008, 5, 21, 0, 0, 0)
                .atZone(ZoneId.of("America/New_York"));
        assertEquals(expectedzonedDateTime, zonedDateTime);
    }

    @Test
    void itShouldFormatStringToLocalDateTime() throws ParseException {
        String dateString = "Wed May 21 00:00:00 EDT 2008";
        String pattern = "EEE MMM d HH:mm:ss z yyyy";

        LocalDateTime localDateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(pattern, Locale.ENGLISH));
        LocalDateTime expectedLocalDateTime = LocalDateTime.of(2008, 5, 21, 0, 0, 0);
        assertEquals(expectedLocalDateTime, localDateTime);
    }
}
