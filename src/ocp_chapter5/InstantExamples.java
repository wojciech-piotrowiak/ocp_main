package ocp_chapter5;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalField;
import java.time.temporal.UnsupportedTemporalTypeException;

public class InstantExamples {
    @Test
    public void instantExample() {
        //instant is just point in time, always in GMT

        Instant now = Instant.now();
        Instant later = Instant.now();

        Duration between = Duration.between(now, later);
        System.out.println(between.toNanos());

        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        //zone information is printed
        System.out.println(zonedDateTime);

        //only date & time is accessable
        System.out.println(zonedDateTime.toInstant());
    }

    @Test(expected = UnsupportedTemporalTypeException.class)
    public void instantOperations() {
        Instant now = Instant.now();
        now.plus(1, ChronoUnit.WEEKS);
    }
}
