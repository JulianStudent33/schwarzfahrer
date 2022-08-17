package src;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import src.GUI.RegisterWindow;

import javax.swing.*;
import java.io.IOException;

import static src.Foo.*;

public class Main {

    public static boolean colorchange;
    public static void main(String[] args) {

        // True = LightMode - False = DarkMode
        colorchange = true;
        colormode(colorchange);
        //Start
        try {

            if(colorchange){
                UIManager.setLookAndFeel(new FlatLightLaf());
            } else {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            }


            UIManager.put("ComboBox.buttonArrowColor", dark);
            UIManager.put("ComboBox.buttonBackground", white);
            UIManager.put("Component.arrowType", "triangle");
            UIManager.put("ComboBox.popupBackground", white);
            UIManager.put("ComboBox.selectionForeground", dark);
            UIManager.put("ComboBox.selectionBackground", dunkelb);
            UIManager.put("PasswordField.showRevealButton", true);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }



        SwingUtilities.invokeLater(new Runnable() {


            public void run() {
                //deleteDirs();




                try {

                    Foo foo = new Foo();
                    RegisterWindow tet = new RegisterWindow(null);
                    } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        }


}

