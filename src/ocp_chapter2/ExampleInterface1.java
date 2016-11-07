package ocp_chapter2;

/**
 * Created by wpiotrowiak on 07.11.16.
 */
public interface ExampleInterface1 extends ExampleInterface2 {
    default String getText() {
        return "I'm first";
    }
}
