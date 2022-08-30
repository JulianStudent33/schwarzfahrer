package src;
import java.io.*;

public class PersFile {

    public static FileOutputStream fs;
    public static FileInputStream fi;
    public static ObjectOutputStream out;
    public static ObjectInputStream in;


    public static void speichern(Object objectToWrite, File fileToWrite) throws IOException {
        fs = new FileOutputStream(fileToWrite);
        out = new ObjectOutputStream(fs);
        out.writeObject(objectToWrite);
        System.out.println("File geschrieben");
    }

    public static Object laden(File file) throws IOException, ClassNotFoundException {
        fi = new FileInputStream(file);
        in = new ObjectInputStream(fi);
        Object profile = (Object) in.readObject();
        return profile;
    }

}
