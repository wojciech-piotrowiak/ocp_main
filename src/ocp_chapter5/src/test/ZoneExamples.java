import org.junit.Assert;
import org.junit.Test;

import java.time.ZoneId;
import java.time.ZonedDateTime;

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
}
