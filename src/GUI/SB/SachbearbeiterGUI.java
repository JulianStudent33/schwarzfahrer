package src.GUI.SB;

import src.Foo;
import src.GUI.*;
import src.GUI.EinstellungenGUI;
import src.GUI.ProfilGUI;
import src.GUI.StatistikenGUI;
import static src.Foo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SachbearbeiterGUI extends Parent_GUI {
    String[] texts = {"<html><body><center><p>Transaktion<br>bearbeiten</p></center></body></html>",
            "<html><body><center><p>Schwarzfahrten<br>suchen</p></center></body></html>",
            "<html><body><center><p>Statistiken</p></center></body></html>",
            "<html><body><center><p>Profil</p></center></body></html>",
            "<html><body><center><p>Einstellungen</p></center></body></html>",
            "<html><body><center><p>Abmelden</p></center></body></html>"
    };

    public SachbearbeiterGUI(Parent_GUI parent){

        //Setup
        setupGUI(parent, "SachbearbeiterGUI");

        //Styling
        styleMenu(texts);
        if (SchwarzfahrtenListe.isEmpty()){
            Kachel1.setEnabled(false);
            Kachel2.setEnabled(false);
        }
        //ActionListener
        Kachel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TransaktionbearbeitenGUI.openTransaktionbearbeiten(getFrame());
                Kachel1.setEnabled(false);

            }
        });
        Kachel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SchwarzfahrtensuchenGUI.openSchwarzfahrtensuchenGUI(getFrame());
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
    public static void openSBGUI(Parent_GUI parent){
        SachbearbeiterGUI gui = new SachbearbeiterGUI(parent);
    }
}
