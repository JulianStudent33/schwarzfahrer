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


                    while(!startFenster()){
                        System.out.println("Anmeldung nicht erfolgreich. Wieder im Startfenster");
                    }
                    System.out.println("Wenn ein  zurückkommt, also nach Erfolgreicher Registrierung oder Anmeldung," +
                            " dann geht's weiter mit Menü. Wenn Ein Falsch zurückkommt");




                    //currentAdmin.setPasswort("IGEL");
                    //deleteDirs();
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

