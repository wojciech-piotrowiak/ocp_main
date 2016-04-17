package ocp_chapter5;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.UnsupportedTemporalTypeException;

public class FormattingDateAndTime {
    LocalDate localDate = LocalDate.now();
    LocalDateTime localDateTime = LocalDateTime.now();
    ZonedDateTime zonedDateTime = ZonedDateTime.now();
    LocalTime localTime = LocalTime.now();
    DateTimeFormatter formatterOfLocalizedDate = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
    DateTimeFormatter formatterOfLocalizedDateTime = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
    DateTimeFormatter formatterOfLocalizedTime = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);

    @Test
    public void formatONLocalDate_Date() {
        formatterOfLocalizedDate.format(localDate);
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void formatONLocalDate_DateTime() {
        formatterOfLocalizedDateTime.format(localDate);
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void formatONLocalDate_Time() {
        formatterOfLocalizedTime.format(localDate);
    }


    @Test
    public void formatONLocalDateTime_Date() {
        formatterOfLocalizedDate.format(localDateTime);
        formatterOfLocalizedDate.format(zonedDateTime);
    }

    @Test
    public void formatONLocalDateTime_DateTime() {
        formatterOfLocalizedDateTime.format(localDateTime);
        formatterOfLocalizedDateTime.format(zonedDateTime);
    }

    @Test
    public void formatONLocalDateTime_Time() {
        formatterOfLocalizedTime.format(localDateTime);
        formatterOfLocalizedTime.format(zonedDateTime);
    }


    @Test(expected = UnsupportedTemporalTypeException.class)
    public void formatONLocalTime_Date() {
        formatterOfLocalizedDate.format(localTime);
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void formatONLocalTime_DateTime() {
        formatterOfLocalizedDateTime.format(localTime);
    }

    @Test
    public void formatONLocalTime_Time() {
        formatterOfLocalizedTime.format(localTime);
    }


}
