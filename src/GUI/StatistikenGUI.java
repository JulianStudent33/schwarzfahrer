package src.GUI;
import src.Foo;

import static src.Foo.*;
public class StatistikenGUI {

    public static void openStatistikenGUI(){
        Foo.getDirectoryData();
        StatistikenGUI gui = new StatistikenGUI();
    }
}
