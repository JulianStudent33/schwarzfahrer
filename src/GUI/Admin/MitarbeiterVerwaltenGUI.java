package src.GUI.Admin;
import src.Foo;

import static src.Foo.*;
import javax.swing.*;

public class MitarbeiterVerwaltenGUI extends JFrame {

    public static void openMitarbeiterVerwaltenGUI(){
        Foo.getDirectoryData();
        MitarbeiterVerwaltenGUI gui = new MitarbeiterVerwaltenGUI();
    }
}
