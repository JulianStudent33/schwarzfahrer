package src;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import src.GUI.RegisterWindow;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static src.Foo.*;
import static src.GUI.GUI_Mama.*;

public class Main {


    public static void main(String[] args) {

        // True = LightMode - False = DarkMode

        //colorChange = true;
        colorChange = false;
        colormode(colorChange);
        //Start
        try {

            if (colorChange) {
               UIManager.setLookAndFeel(new FlatLightLaf());
            } else {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            }

            UIManager.put("ComboBox.disabledForeground", white);
            UIManager.put("ComboBox.disabledBackground", dark);
            UIManager.put("ComboBox.buttonDisabledArrowColor", dark);
            UIManager.put("ComboBox.buttonArrowColor", notSoDark);
            UIManager.put("ComboBox.buttonBackground", whitebg);
            UIManager.put("ComboBox.buttonHoverArrowColor", notSoDark);
            UIManager.put("ComboBox.buttonPressedArrowColor", white);
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


                    } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
        }


}

