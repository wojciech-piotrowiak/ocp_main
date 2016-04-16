package ocp_chapter8.serialize;

import java.io.Serializable;

public class SerializeMe implements Serializable {

    SerializeMe()
    {
        System.out.println("SerializeMe Constructor called");
    }
    String field;
    transient String name;
    ICannotSerializeMyself myself;
}
