package src.GUI.Admin;

import src.Foo;
import src.GUI.GUI_Mama;

import javax.swing.*;

public class AdminAnlegenGUI extends JFrame {

    public AdminAnlegenGUI(GUI_Mama parent){

    }

    public static void openAdminAnlegenGUI(GUI_Mama parent){
        Foo.getDirectoryData();
        AdminAnlegenGUI gui = new AdminAnlegenGUI(parent);
        //Abbild von firstRegistrationGUI?
    }
}
