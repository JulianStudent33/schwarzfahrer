package src.GUI;

import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.InactivityListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public abstract class GUI_Mama extends JFrame {

    public String name;
    String[] optionenLogout = {"Aus", "10", "15", "30"};

    public GUI_Mama parentGUI;
    Action logout = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();

            if (parentGUI!=null){
                parentGUI.dispose();
            }
            StartfensterGUI.startFenster(null);


        }
    };
    public InactivityListener listener = new InactivityListener(this, logout, 0);



    public GUI_Mama(){

    }


    public void StartAutoLogout(){

        int time = 1;


        if (!Foo.getCurrentLogoutTime().equals(optionenLogout[0])){
            if (Foo.getCurrentLogoutTime().equals(optionenLogout[1])){
                //time = 10;
            }
            if (Foo.getCurrentLogoutTime().equals(optionenLogout[2])){
                //time = 20;
            }
            if (Foo.getCurrentLogoutTime().equals(optionenLogout[3])){
                //time = 30;
            }
            listener.setInterval(time);
            listener.start();
            System.out.println("Logout nach " + time + " Minuten");
        }

    }

    public void StopAutoLogout(){
        listener.stop();
    }



    public GUI_Mama getFrame(){

        return this;
    }


}
