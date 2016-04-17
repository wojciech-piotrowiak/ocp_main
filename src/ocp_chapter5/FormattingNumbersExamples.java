package ocp_chapter5;

import org.junit.Assert;
import org.junit.Test;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class FormattingNumbersExamples {

    @Test
    public void format() {
        int number = 3_200_000 / 12;
        Assert.assertEquals("266,666", getFormattedNumberForLocale(Locale.US, number));
        Assert.assertEquals("266.666", getFormattedNumberForLocale(Locale.GERMANY, number));
        Assert.assertEquals("266 666", getFormattedNumberForLocale(Locale.CANADA_FRENCH, number));
    }

    @Test
    public void parse() throws ParseException {
        String number = "21.21";
        Assert.assertEquals("21.21", getParsedStringForLocale(Locale.US, number));
        Assert.assertEquals("21", getParsedStringForLocale(Locale.FRANCE, number));
    }

    @Test(expected = ParseException.class)
    public void parseException() throws ParseException {
        getParsedStringForLocale(Locale.US, "not a number");
    }

    private String getParsedStringForLocale(Locale us, String number) throws ParseException {
        NumberFormat instance = NumberFormat.getInstance(us);
        return instance.parse(number).toString();
    }

    private String getFormattedNumberForLocale(Locale us, int inputNumber) {
        NumberFormat instance = NumberFormat.getInstance(us);
        return instance.format(inputNumber);
    }
}
