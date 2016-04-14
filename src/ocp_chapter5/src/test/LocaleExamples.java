import org.junit.Assert;
import org.junit.Test;

import java.util.Locale;

public class LocaleExamples {
    @Test
    public void languageIsNotCountry() {
        Assert.assertNotEquals(Locale.GERMAN, Locale.GERMANY);
    }

    @Test
    public void defaultLocale() {
        Locale custom = new Locale("en", "DE");
        Assert.assertNotEquals(custom, Locale.getDefault());
        Locale.setDefault(custom);
        Assert.assertEquals(custom, Locale.getDefault());
    }

}
