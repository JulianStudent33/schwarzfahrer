package src.GUI.Kon;

import src.GUI.*;
import src.GUI.Kacheln.EinstellungenGUI;
import src.GUI.Kacheln.ProfilGUI;
import src.GUI.Kacheln.StatistikenGUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KontrolleurGUI extends GUI_Mama {
    String[] texts = {"<html><body><center><p>Schwarzfahrt<br>erfassen</p></center></body></html>",
            "<html><body><center><p>Schwarzfahrer<br>suchen</p></center></body></html>",
            "<html><body><center><p>Statistiken</p></center></body></html>",
            "<html><body><center><p>Profil</p></center></body></html>",
            "<html><body><center><p>Einstellungen</p></center></body></html>",
            "<html><body><center><p>Abmelden</p></center></body></html>"
    };
    public KontrolleurGUI(GUI_Mama parent) {

        setupGUI(parent, "KontrolleurGUI");
        this.currentUser.display();

        //Styling
        styleMenu(texts);

        //ActionListener:
        Kachel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SchwarzfahrtErfassenGUI.open(getFrame());
                Kachel1.setEnabled(false);
            }
        });
        Kachel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //zu implementieren
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
    public static void openKonGUI(GUI_Mama parent){
        KontrolleurGUI gui = new KontrolleurGUI(parent);
    }
}



