package src.GUI.Sachbearbeiter;
import src.Foo;
import src.GUI.GUI_Mama;

import java.awt.*;

import static src.Foo.*;
public class Kachel2GUI {

    public Kachel2GUI(GUI_Mama parent){

    }

    public static void openKachel2GUI(GUI_Mama parent){
        Foo.getDirectoryData();
        Kachel2GUI gui = new Kachel2GUI(parent);
    }
}
