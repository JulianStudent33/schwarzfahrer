package src.GUI.Admin;

import src.Foo;
import src.GUI.GUI_Mama;
import src.GUI.firstRegistrationGUI;

import javax.swing.*;
import java.awt.*;

public class AdminAnlegenGUI extends JFrame {

    public AdminAnlegenGUI(GUI_Mama parent){

    }

    public static void openAdminAnlegenGUI(GUI_Mama parent){
        Foo.getDirectoryData();
        AdminAnlegenGUI gui = new AdminAnlegenGUI(parent);
        //Abbild von firstRegistrationGUI?
    }
}
