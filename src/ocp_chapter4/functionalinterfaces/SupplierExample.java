package ocp_chapter4.functionalinterfaces;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class SupplierExample {

    @Test
    public void supplierExample() {
        Supplier<String> textSupplier = () -> "test";

        //the same logic, but different approach: constructor VS static method reference
        Supplier<LocalDate> dateSupplier = () -> LocalDate.now();
        Supplier<LocalDateTime> dateTimeSupplier = LocalDateTime::now;

        //supplier provides data without any parameters on input
        //only get() method is available
        Assert.assertEquals("test", textSupplier.get());
        System.out.println(dateSupplier.get());
        System.out.println(dateTimeSupplier.get());

    }
}
