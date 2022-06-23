package src;
import src.users.*;

import javax.swing.*;
import java.io.IOException;

import static src.Foo.*;

public class Main {
    public static void main(String[] args) {
        //Start
        SwingUtilities.invokeLater(new Runnable() {


            public void run() {

                try {
                    System.out.println(adminPath);
                    deleteDirs();
                    startRun();
                    currentAdmin.setBenutzername("Admin2");
                    deleteDirs();
                }catch (Exception e){
                    System.err.println(e.getMessage());
                    System.out.println("Exception in Main");
                }finally {

                    System.exit(420);
                }












            }
        });
        }


}

