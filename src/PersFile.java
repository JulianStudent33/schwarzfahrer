package src;
import java.io.*;

public class PersFile {
    public  File selectedFile;

    public static FileOutputStream fs;
    public static FileInputStream fi;
    public static ObjectOutputStream out;
    public static ObjectInputStream in;

    /*
    static {
        try {


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

     */
    public PersFile(File selectedFile){
        this.selectedFile = selectedFile;
    }

    public void  writeInFile(Object profile) throws IOException {
        fs = new FileOutputStream(selectedFile);
        out = new ObjectOutputStream(fs);
        System.out.println("Test1");
        out.writeObject(profile);
        System.out.println("Test2");
        System.out.println("File beschrieben mit Object.");
    }
    public static void writeInFile(Object objectToWrite, File fileToWrite) throws IOException {
        fs = new FileOutputStream(fileToWrite);
        out = new ObjectOutputStream(fs);
        out.writeObject(objectToWrite);
        System.out.println("File geschrieben");
    }
    public Object readOuttaFile() throws IOException, ClassNotFoundException {
        fi = new FileInputStream(selectedFile);
        in = new ObjectInputStream(fi);
        Object profile = (Object) in.readObject();
        return profile;
    }
    public static Object readOuttaFile(File file) throws IOException, ClassNotFoundException {
        fi = new FileInputStream(file);
        in = new ObjectInputStream(fi);
        Object profile = (Object) in.readObject();
        return profile;
    }

}
