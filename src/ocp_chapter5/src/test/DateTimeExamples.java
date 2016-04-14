import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DateTimeExamples {
    @Test
    public void localDateTime(){
        //numeric example
        LocalDateTime localDateTime=LocalDateTime.of(2016,4,14,0,0);
        Assert.assertEquals(localDateTime.getDayOfWeek(), DayOfWeek.THURSDAY);

        //enums also in use
        LocalDateTime enumDateTime = LocalDateTime.of(2016, Month.APRIL, 14, 0, 0);
        Assert.assertEquals(enumDateTime.getDayOfWeek(), DayOfWeek.THURSDAY);
    }

    @Test
    public void localDate()
    {
        //date nad time objects are immutable!
        LocalDate localDate=LocalDate.of(2016,4,14);
        localDate.plus(1, ChronoUnit.DAYS);
        Assert.assertEquals(14,localDate.getDayOfMonth());

        LocalDate plus = localDate.plus(1, ChronoUnit.DAYS);
        Assert.assertEquals(15,plus.getDayOfMonth());
    }

    @Test
    public void parseExample() {
        //default configurations
        LocalDate localDate = LocalDate.parse("2016-04-15");
        Assert.assertEquals(2016, localDate.getYear());

        //predefined pattern
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate anotherLocalDate = LocalDate.parse("20160415", formatter);
        Assert.assertEquals(2016, anotherLocalDate.getYear());

        //custom pattern
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy@MM@dd");
        LocalDate lastLocalDate = LocalDate.parse("2016@04@15", customFormatter);
        Assert.assertEquals(2016, lastLocalDate.getYear());
    }
}
