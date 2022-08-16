package src;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import src.GUI.RegisterWindow;

import javax.swing.*;
import java.io.IOException;

import static src.Foo.*;

public class Main {
    public static void main(String[] args) {

        // True = LightMode - False = DarkMode
        boolean test = false;
        colormode(test);
        //Start
        try {

            if(test){
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



                //RegisterWindow.openRegisterGUI();



                try {

                    Foo foo = new Foo();
                    Foo.okWindow("Keine Treffer");
                    } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        }


}

