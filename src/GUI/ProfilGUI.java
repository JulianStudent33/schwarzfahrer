package src.GUI;
import src.Foo;

import static src.Foo.*;
public class ProfilGUI {



    public static void openProfilGUI(){
        Foo.getDirectoryData();
        ProfilGUI gui = new ProfilGUI();
    }
}
