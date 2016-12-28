package ocp_chapter6;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.NotSerializableException;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.DateTimeException;
import java.util.MissingResourceException;

public class ExceptionClasses {
    @Test
    public void checkedExceptionsToMemorize() {
        ParseException parseException = new ParseException("", 0);
        Assert.assertTrue(isCheckedException(parseException));

        IOException ioException = new IOException();
        Assert.assertTrue(isCheckedException(ioException));

        FileNotFoundException fileNotFoundException = new FileNotFoundException();
        Assert.assertTrue(isCheckedException(fileNotFoundException));

        NotSerializableException notSerializableException = new NotSerializableException();
        Assert.assertTrue(isCheckedException(notSerializableException));

        SQLException sqlException = new SQLException();
        Assert.assertTrue(isCheckedException(sqlException));
    }

    @Test
    public void runtimeExceptionsToMemorize() {
        ArithmeticException arithmeticException = new ArithmeticException();
        Assert.assertTrue(isRuntimeException(arithmeticException));

        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        Assert.assertTrue(isRuntimeException(arrayIndexOutOfBoundsException));

        ClassCastException classCastException = new ClassCastException();
        Assert.assertTrue(isRuntimeException(classCastException));

        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        Assert.assertTrue(isRuntimeException(illegalArgumentException));

        NullPointerException nullPointerException = new NullPointerException();
        Assert.assertTrue(isRuntimeException(nullPointerException));

        NumberFormatException numberFormatException = new NumberFormatException();
        Assert.assertTrue(isRuntimeException(numberFormatException));

        ArrayStoreException arrayStoreException = new ArrayStoreException();
        Assert.assertTrue(isRuntimeException(arrayStoreException));

        DateTimeException dateTimeException = new DateTimeException("");
        Assert.assertTrue(isRuntimeException(dateTimeException));

        MissingResourceException missingResourceException = new MissingResourceException("", "", "");
        Assert.assertTrue(isRuntimeException(missingResourceException));

        IllegalStateException illegalStateException = new IllegalStateException();
        Assert.assertTrue(isRuntimeException(illegalStateException));

        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        Assert.assertTrue(isRuntimeException(unsupportedOperationException));
    }

    private boolean isRuntimeException(Exception exception) {
        return exception instanceof RuntimeException;
    }

    private boolean isCheckedException(Exception exception) {
        return exception instanceof Exception && !(exception instanceof RuntimeException);
    }
}
