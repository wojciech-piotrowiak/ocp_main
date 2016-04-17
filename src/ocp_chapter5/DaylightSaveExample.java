package ocp_chapter5;

import org.junit.Test;

import java.time.*;

public class DaylightSaveExample {

    @Test
    public void testOnWarsaw() {
        //warsaw do not change time on this date
        LocalDate localDate = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime localTime = LocalTime.of(1, 30);
        ZoneId zoneId = ZoneId.of("Europe/Warsaw");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, zoneId);
        System.out.println(zonedDateTime);
        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime);
    }

    @Test
    public void testOnEastern() {
        //in this zone change happen 1:30 is now 3:30
        LocalDate localDate = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime localTime = LocalTime.of(1, 30);
        ZoneId zoneId = ZoneId.of("US/Eastern");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate, localTime, zoneId);
        System.out.println(zonedDateTime);
        zonedDateTime = zonedDateTime.plusHours(1);
        System.out.println(zonedDateTime);
    }
}
