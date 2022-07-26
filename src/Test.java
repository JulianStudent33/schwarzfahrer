package src;

import src.Foo.*;
import src.users.Kontrolleur;

import java.io.IOException;

public class Test {

    public Test() throws IOException {
        createDirectories();
        Kontrolleur testKontrolleur = new Kontrolleur("testKon", "Igel123");
        testKontrolleur.schwarzfahrtErfassen();
    }
    void createDirectories(){


        if (Foo.konDir.mkdirs()){
            System.out.println("Created kontrolleurDir succesfully.");
        }else{
            System.out.println("Did not create kontrolleurDir");
        }
        if (Foo.sfDir.mkdirs()){
            System.out.println("Created schwarzfahrerDir succesfully.");
        }else{
            System.out.println("Did not create schwarzfahrerDir");
        }
        if (Foo.sftDir.mkdirs()){
            System.out.println("Created schwarzfahrtenDir succesfully.");
        }else{
            System.out.println("Did not create schwarzfahrtenDir");
        }
    }
    public static void main(String[] args) throws IOException {

        Test test = new Test();
    }
}