package src;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.io.IOException;

import static src.Foo.*;

public class Main {
    public static void main(String[] args) {
        //Start
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            UIManager.put("ComboBox.buttonArrowColor", dark);
            UIManager.put("ComboBox.buttonBackground", white);
            UIManager.put("Component.arrowType", "triangle");
            UIManager.put("ComboBox.popupBackground", white);
            UIManager.put("ComboBox.selectionForeground", white);
            UIManager.put("ComboBox.selectionBackground", dunkelb);
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

