package src.GUI;
import src.Foo;

import static src.Foo.*;
public class EinstellungenGUI {

    public static void openEinstellungenGUI(){
        Foo.getDirectoryData();
        EinstellungenGUI gui = new EinstellungenGUI();
    }
}
