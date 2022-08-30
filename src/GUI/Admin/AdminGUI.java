package src.GUI.Admin;
import src.GUI.*;
import src.GUI.EinstellungenGUI;
import src.GUI.ProfilGUI;
import src.GUI.StatistikenGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class AdminGUI extends Parent_GUI {
    public static ArrayList<File> deletedFiles = new ArrayList<>();

    String[] texts = {"<html><body><center><p>Administrator<br>anlegen</p></center></body></html>",
            "<html><body><center><p>Mitarbeiter<br>verwalten</p></center></body></html>",
            "<html><body><center><p>Statistiken</p></center></body></html>",
            "<html><body><center><p>Profil</p></center></body></html>",
            "<html><body><center><p>Einstellungen</p></center></body></html>",
            "<html><body><center><p>Abmelden</p></center></body></html>"
    };
    public AdminGUI(Parent_GUI parent){

        setupGUI(parent, "AdminGUI");
        this.currentUser.display();

        //Styling
        styleMenu(texts);

        //ActionListener
        Kachel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegisterGUI.openAdminRegisterGUI(getFrame());
                setVisible(false);
            }
        });
        Kachel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MitarbeiterVerwaltenGUI.openMitarbeiterVerwaltenGUI(getFrame());
                Kachel2.setEnabled(false);
            }
        });
        Kachel3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                StatistikenGUI.openStatistikenGUI(getFrame());
                Kachel3.setEnabled(false);
            }
        });
        Kachel4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProfilGUI.openProfilGUI(getFrame());
                Kachel4.setEnabled(false);
            }
        });
        Kachel5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EinstellungenGUI.openEinstellungenGUI(getFrame());
                Kachel5.setEnabled(false);
            }
        });
        Kachel6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentUser.abmelden();
                Frame[] frames = getFrames();
                for (int i = 0; i < frames.length; i++){
                    frames[i].dispose();
                }
                StartfensterGUI.openStartFenster(getFrame());
                dispose();

            }
        });
    }

    public static void openAdminGUI(Parent_GUI parent){
        AdminGUI gui = new AdminGUI(parent);

    }
}


