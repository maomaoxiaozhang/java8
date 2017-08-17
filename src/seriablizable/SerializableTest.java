package seriablizable;

import java.io.*;

/**
 * Created by zhanggq on 2017/8/16.
 */
public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Worm worm = new Worm(6, 'a');
        System.out.println("before~~~");
        System.out.println("worm = " + worm);

        //序列化操作1--FileOutputStream
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("worm.out"));
        oos1.writeObject("Worm storage by FileOutputStream ");
        oos1.writeObject(worm);
        oos1.close();

        //反序列化操作1--FileOutputStream
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("worm.out"));
        String s1 = (String)ois1.readObject();
        Worm worm1 = (Worm)ois1.readObject();
        ois1.close();
        System.out.println("反序列化操作1之后~~~");
        System.out.println(s1);
        System.out.println(worm1);

        //序列化操作2--ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos2 = new ObjectOutputStream(baos);
        oos2.writeObject("Worm storage by ByteArrayOutputStream ");
        oos2.writeObject(worm);
        oos2.flush();

        //反序列化操作2--ByteArrayInputStream
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois2 = new ObjectInputStream(bais);
        String s2 = (String)ois2.readObject();
        Worm worm2 = (Worm)ois2.readObject();
        ois2.close();
        System.out.println("反序列化操作2之后~~~");
        System.out.println(s2);
        System.out.println(worm2);
    }
}
