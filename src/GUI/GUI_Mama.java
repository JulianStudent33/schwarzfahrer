package src.GUI;

import src.Foo;
import src.GUI.elements.InactivityListener;
import src.PersFile;
import src.roles.Administrator;
import src.roles.Kontrolleur;
import src.roles.Mitarbeiter;
import src.roles.Sachbearbeiter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public abstract class GUI_Mama extends JFrame {

    public String name;
    String[] optionenLogout = {"Aus", "10", "15", "30"};
    public Mitarbeiter currentUser;
    public boolean konAngemeldet;
    public boolean sbAngemeldet;
    public  boolean adminAngemeldet;
    public boolean autoLogoutON;
    public GUI_Mama parentGUI;
    Action logout = new AbstractAction() {
        public void actionPerformed(ActionEvent e) {
            dispose();

            if (parentGUI!=null){
                parentGUI.dispose();
            }
            StartfensterGUI.openStartFenster(null);


        }
    };
    public InactivityListener listener = new InactivityListener(this, logout, 0);



    public GUI_Mama(){

    }


    public void StartAutoLogout(){

        int time = 1;
        refreshCurrentUser();
        if (!Foo.getCurrentLogoutTime().equals(optionenLogout[0])){
            if (Foo.getCurrentLogoutTime().equals(optionenLogout[1])){
                //time = 5;
            }
            if (Foo.getCurrentLogoutTime().equals(optionenLogout[2])){
                //time = 15;
            }
            if (Foo.getCurrentLogoutTime().equals(optionenLogout[3])){
                //time = 30;
            }
            listener.setInterval(time);
            listener.start();
            this.autoLogoutON = true;
            System.out.println("Logout nach " + time + " Minuten");
        }

    }

    public void StopAutoLogout(){
        listener.stop();
        autoLogoutON = false;
    }

    public Mitarbeiter getCurrentUser(){
        if (parentGUI!=null && parentGUI.currentUser!=null){
            if (parentGUI.currentUser.isKontrolleur()){
                this.konAngemeldet = true;
            } else if (parentGUI.currentUser.isAdmin()) {
                this.adminAngemeldet = true;
            } else if (parentGUI.currentUser.isSachbearbeiter()) {
                this.sbAngemeldet = true;
            }
            System.out.println("Current User aus ParentGUI geholt");
            return parentGUI.currentUser;

        }else{
            System.out.println("Current User aus Foo geholt");
            if (Foo.currentUser.isKontrolleur()){
                this.konAngemeldet = true;
            } else if (Foo.currentUser.isAdmin()) {
                this.adminAngemeldet = true;
            } else if (Foo.currentUser.isSachbearbeiter()) {
                this.sbAngemeldet = true;
            }
            return Foo.currentUser;

        }

    }
    public void setupGUI(GUI_Mama parent, String name){
        this.name = name;
        parentGUI = parent;
        Foo.getDirectoryData();
        this.currentUser = getCurrentUser();
        if (parentGUI!=null){
            if (parentGUI.autoLogoutON){
                parentGUI.StopAutoLogout();
            }
        }
        StartAutoLogout();


    }
    public void setCurrentUser(Mitarbeiter currentUser){
        this.currentUser = currentUser;
    }
    public void refreshCurrentUser(){

        if (this.currentUser.isAdmin()){
            try {
                this.currentUser = (Administrator) PersFile.laden(currentUser.getUserFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (this.currentUser.isKontrolleur()){
            try {
                this.currentUser = (Kontrolleur) PersFile.laden(currentUser.getUserFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (this.currentUser.isSachbearbeiter()){
            try {
                this.currentUser = (Sachbearbeiter) PersFile.laden(currentUser.getUserFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }






    }

    public GUI_Mama getFrame(){

        return this;
    }


}
