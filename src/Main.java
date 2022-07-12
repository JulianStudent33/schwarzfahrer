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
                //deleteDirs();
                try {

                    Foo foo = new Foo();

                    } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

               }
        });
        }


}

