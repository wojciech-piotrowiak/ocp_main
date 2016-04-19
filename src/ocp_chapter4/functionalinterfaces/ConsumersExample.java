package ocp_chapter4.functionalinterfaces;

import org.junit.Test;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumersExample {

    @Test
    public void test() {
        //Consumers do not return any data, just accept input
        Consumer<String> consumer = System.out::println;
        Consumer<String> anotherSingleConsumer = (a) -> System.out.println("prefix" + a);
        BiConsumer<String, String> biConsumer = (a, b) -> System.out.println(a + b);

        consumer.accept("test");
        anotherSingleConsumer.accept(" value");
        biConsumer.accept("firstPart+", "secondPart");
    }
}
