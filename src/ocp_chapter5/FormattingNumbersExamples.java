package ocp_chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumbersExamples {

    @Test
    public void format() {
        int number = 3_200_000 / 12;
        Assert.assertEquals("266,666", getFormattedNumberForLocale(Locale.US, number));
        Assert.assertEquals("266.666", getFormattedNumberForLocale(Locale.GERMANY, number));
        Assert.assertEquals("266 666", getFormattedNumberForLocale(Locale.CANADA_FRENCH, number));
    }

    private String getFormattedNumberForLocale(Locale us, int inputNumber) {
        NumberFormat instance = NumberFormat.getInstance(us);
        return instance.format(inputNumber);
    }
}
