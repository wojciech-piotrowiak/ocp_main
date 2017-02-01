package ocp_chapter1;

/**
 * Created by wpiotrowiak on 31.01.17.
 */
public class PrivateVariableInside {
    PrivateVariableInside(int abc) {
    }

    private String secret = "TEST";

    public static void main(String... l) {
        PrivateVariableInside privateVariableInside = new PrivateVariableInside(23);
        System.out.print(privateVariableInside.secret);
        Outside outside = new Outside();
        //there is no outside variable!
    }
}

class Outside {
    private String outside = "outside";
}