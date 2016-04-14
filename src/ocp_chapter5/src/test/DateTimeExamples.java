import org.junit.Assert;
import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class DateTimeExamples {
    @Test
    public void localDateTime(){
        LocalDateTime localDateTime=LocalDateTime.of(2016,4,14,0,0);
        Assert.assertEquals(localDateTime.getDayOfWeek(), DayOfWeek.THURSDAY);
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
}
