package ocp_chapter8.serialize;

import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class SerializeExample
{

    @Test(expected = NotSerializableException.class)
	public void notSerializableTest() throws IOException {
		// system out from constructor expected
		SerializeMe serializeMe = new SerializeMe();
		serializeMe.field = "testField";
		serializeMe.name = "testName";


		// Class ICannotSerializeMyself is NOT serializable, that's why Java will throw NotSerializableException.
		// This field can be marked as transient
		 serializeMe.myself=new ICannotSerializeMyself();

		try (FileOutputStream fileOut = new FileOutputStream("target\\employee.ser");
			 ObjectOutputStream out = new ObjectOutputStream(fileOut);)
		{
			out.writeObject(serializeMe);
		}
    }

    @Test
    public void simpleTest() throws IOException {
        // system out from constructor expected
        SerializeMe serializeMe = new SerializeMe();
        serializeMe.field = "testField";
        serializeMe.name = "testName";
        serializeMe.myself=null;

        try (FileOutputStream fileOut = new FileOutputStream("target\\employee.ser");
			 ObjectOutputStream out = new ObjectOutputStream(fileOut))
        {
            out.writeObject(serializeMe);
        }
    }

    @Test
	public  void constructorTest() throws IOException, ClassNotFoundException
	{
        // system out from constructor expected
		SerializeMe serializeMe = new SerializeMe();
		serializeMe.field = "testField";
		serializeMe.name = "testName";


		try (FileOutputStream fileOut = new FileOutputStream("target\\employee.ser");
			 ObjectOutputStream out = new ObjectOutputStream(fileOut))
		{
			out.writeObject(serializeMe);
		}

		try (FileInputStream fileIn = new FileInputStream("target\\employee.ser");
			 ObjectInputStream in = new ObjectInputStream(fileIn))
		{
            //no output from constructor!
			SerializeMe sm = (SerializeMe) in.readObject();

            //it's true, serialization success :)
            Assert.assertEquals(serializeMe.field,sm.field);
            //it's false because name is transient so value is not serialized
            Assert.assertNotEquals(serializeMe.name,sm.name);
		}
	}
}
