package ocp_chapter8;

import org.junit.Test;
import tools.Helper;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by wpiotrowiak on 28.01.17.
 */
public class PrintWriterExample {

    @Test
    public void sysout() {
        try (PrintWriter printWriter = new PrintWriter(System.out)) {
            printWriter.write(4);
            printWriter.print(2);
            printWriter.println();
            printWriter.println("X");
            printWriter.write("3");
        }
    }

    @Test
    public void stream() throws FileNotFoundException {
        try (PrintWriter printWriter = new PrintWriter(getFile())) {
            printWriter.write(4);
            printWriter.print(2);
            printWriter.println();
            printWriter.println("X");
            printWriter.write("3");
        }
    }

    private String getFile() {
        return Helper.getResource("chapter8/out.txt");
    }

}
