package ocp_chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class PeriodExamples {
    @Test
    public void periodExample() {
        //Period is more than day! so more than Duration
        Period period = Period.ofMonths(1);
        LocalDate localDate = LocalDate.now();
        int currentMonth = localDate.getMonthValue();
        Assert.assertTrue(localDate.plus(period).getMonthValue() > currentMonth);

    }
}
