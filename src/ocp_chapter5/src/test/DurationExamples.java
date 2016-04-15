import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;
import java.time.LocalDateTime;

public class DurationExamples {
    @Test
    public void durationExample() {
        Duration duration = Duration.ofHours(5);
        LocalDateTime localDateTime = LocalDateTime.now();
        Assert.assertTrue(localDateTime.getHour() < localDateTime.plus(duration).getHour());
    }
}
