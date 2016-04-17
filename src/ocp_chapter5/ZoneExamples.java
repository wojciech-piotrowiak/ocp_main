package ocp_chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.zone.ZoneRulesException;

public class ZoneExamples {
    @Test
    public void zoneExample() {
        //all available zones
        ZoneId.getAvailableZoneIds().stream().forEach(System.out::println);

        ZoneId warsawZoneId = ZoneId.of("Etc/GMT-1");
        ZoneId londonZoneID = ZoneId.of("GMT");
        int warsawHour = ZonedDateTime.now(warsawZoneId).getHour();
        int londonHour = ZonedDateTime.now(londonZoneID).getHour();
        Assert.assertTrue(londonHour < warsawHour);
    }

    @Test(expected = ZoneRulesException.class)
    public void unknownZone() {
        ZoneId.of("strangeName");
    }
}
