package src.GUI.Kontrolleur;

import javax.swing.*;
import src.Foo;
import src.GUI.start;
import src.users.Kontrolleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class KontrolleurGUI extends JFrame {
    public static Kontrolleur currentUser;
    private JToolBar konToolBar;
    private JPanel mainPanel;
    private JToggleButton schwarzfahrerSuchenToggleButton;
    private JToggleButton einstellungenToggleButton;
    private JToggleButton profilToggleButton;
    private JToggleButton abmeldenToggleButton;
    private JToggleButton schwarzfahrtErfassenToggleButton;
    private JToggleButton statistikenToggleButton;

    public KontrolleurGUI()  {
        currentUser = Foo.currentKontrolleur;
        setContentPane(mainPanel);
        setTitle("Kontrolleur Menü");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 600;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



       //Button Styles


        setVisible(true);

        //Button Funktionen Zuweisungen:


        schwarzfahrtErfassenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    erfassen.open();

            }
        });

        schwarzfahrerSuchenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        statistikenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        profilToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        einstellungenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        abmeldenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentUser.abmelden();
                start.startFenster();
            }
        });
    }

    public static void openKonGUI() {
        KontrolleurGUI gui = new KontrolleurGUI();
    }

    public static void main(String[] args) {
        openKonGUI();
    }



}
