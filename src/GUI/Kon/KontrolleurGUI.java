package src.GUI.Kon;

import javax.swing.*;
import src.Foo;
import src.GUI.*;
import src.roles.Kontrolleur;
import static src.Foo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KontrolleurGUI extends GUI_Mama implements ActionListener {
    public static Kontrolleur currentUser;
    public static JButton SchwarzfahrtErfassen = new JButton();
    public static JButton SchwarzfahrerSuchen = new JButton();
    public static JButton Statistiken  = new JButton();
    public static JButton Profil = new JButton();
    public static JButton Einstellungen = new JButton();
    public static JButton Abmelden = new JButton();


    public KontrolleurGUI(GUI_Mama parent) {

        enableButtons();
        parentGUI = parent;

        currentUser = Foo.currentKontrolleur;
        // Panelmanagement
        JPanel gridpanel = new JPanel();
        gridpanel.setBackground(dark);
        gridpanel.setLayout(new BorderLayout());
        gridpanel.setPreferredSize(new Dimension(100,100));
        gridpanel.setBounds(50,25,300,30);
        gridpanel.setLayout(new GridLayout(2,3,20,20));
        gridpanel.setBorder(BorderFactory.createEmptyBorder(0,70,70,70));

        //Willkommentextpanel
        JPanel Text = new JPanel();
        Text.setBackground(dark);
        Text.setPreferredSize(new Dimension(100,150));
        Text.setLayout(null);

        // "Willkommen auf der" Text
        JLabel label = new JLabel();
        label.setText("<html><body><center><p><u>Hallo Kontrolleur<u></p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(fontLarge);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(200,50, 500,50);

        //JButton "Schwarzfahrt erfassen"
            //Styling
                SchwarzfahrtErfassen.addActionListener(this);
                SchwarzfahrtErfassen.setText("<html><body><center><p>Schwarzfahrt<br>erfassen</p></center></body></html>");
                SchwarzfahrtErfassen.setBackground(hellb);
                SchwarzfahrtErfassen.setForeground(white);
                SchwarzfahrtErfassen.setHorizontalTextPosition(JLabel.CENTER);
                SchwarzfahrtErfassen.setVerticalTextPosition(JLabel.CENTER);
                SchwarzfahrtErfassen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
                SchwarzfahrtErfassen.setHorizontalAlignment(JLabel.CENTER);
                SchwarzfahrtErfassen.setVerticalAlignment(JLabel.CENTER);
                SchwarzfahrtErfassen.setFocusable(false);
                SchwarzfahrtErfassen.setBorderPainted(false);
                SchwarzfahrtErfassen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                SchwarzfahrtErfassen.setBounds(140,100,100,100);

        //ActionListener:
        SchwarzfahrtErfassen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SchwarzfahrtErfassenGUI.open(getFrame());
                SchwarzfahrtErfassen.setEnabled(false);
            }
        });


        // JButton "Schwarzfahrer suchen"
        // Styling
        SchwarzfahrerSuchen.addActionListener(this);
        SchwarzfahrerSuchen.setText("<html><body><center><p>Schwarzfahrer<br>suchen</p></center></body></html>");
        SchwarzfahrerSuchen.setBackground(dunkelb);
        SchwarzfahrerSuchen.setForeground(white);
        SchwarzfahrerSuchen.setHorizontalTextPosition(JLabel.CENTER);
        SchwarzfahrerSuchen.setVerticalTextPosition(JLabel.CENTER);
        SchwarzfahrerSuchen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        SchwarzfahrerSuchen.setHorizontalAlignment(JLabel.CENTER);
        SchwarzfahrerSuchen.setVerticalAlignment(JLabel.CENTER);
        SchwarzfahrerSuchen.setFocusable(false);
        SchwarzfahrerSuchen.setBorderPainted(false);
        SchwarzfahrerSuchen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SchwarzfahrerSuchen.setBounds(140,100,100,100);

        // ActionListener
        SchwarzfahrerSuchen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //zu implementieren

            }
        });

        //JButton "Statistiken"
            //Styling
                Statistiken.addActionListener(this);
                Statistiken.setText("Statistiken");
                Statistiken.setBackground(hellb);
                Statistiken.setForeground(white);
                Statistiken.setHorizontalTextPosition(JLabel.CENTER);
                Statistiken.setVerticalTextPosition(JLabel.CENTER);
                Statistiken.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
                Statistiken.setHorizontalAlignment(JLabel.CENTER);
                Statistiken.setVerticalAlignment(JLabel.CENTER);
                Statistiken.setFocusable(false);
                Statistiken.setBorderPainted(false);
                Statistiken.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Statistiken.setBounds(140,100,100,100);

            //ActionListener
                Statistiken.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        StatistikenGUI.openStatistikenGUI(getFrame());

                    }
                });

        //JButton "ProfilGUI"
            //Styling
                Profil.addActionListener(this);
                Profil.setText("ProfilGUI");
                Profil.setBackground(dunkelb);
                Profil.setForeground(white);
                Profil.setHorizontalTextPosition(JLabel.CENTER);
                Profil.setVerticalTextPosition(JLabel.CENTER);
                Profil.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
                Profil.setHorizontalAlignment(JLabel.CENTER);
                Profil.setVerticalAlignment(JLabel.CENTER);
                Profil.setFocusable(false);
                Profil.setBorderPainted(false);
                Profil.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Profil.setBounds(140,100,100,100);

            //ActionListener
                Profil.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        ProfilGUI.openProfilGUI(getFrame());


                    }
                });

        //JButton "Einstellungen"
            //Styling
                Einstellungen.addActionListener(this);
                Einstellungen.setText("Einstellungen");
                Einstellungen.setBackground(hellb);
                Einstellungen.setForeground(white);
                Einstellungen.setHorizontalTextPosition(JLabel.CENTER);
                Einstellungen.setVerticalTextPosition(JLabel.CENTER);
                Einstellungen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
                Einstellungen.setHorizontalAlignment(JLabel.CENTER);
                Einstellungen.setVerticalAlignment(JLabel.CENTER);
                Einstellungen.setFocusable(false);
                Einstellungen.setBorderPainted(false);
                Einstellungen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Einstellungen.setBounds(140,100,100,100);

            //ActionListener
                Einstellungen.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                         EinstellungenGUI.openEinstellungenGUI(getFrame());

                    }
                });



        //JButton "Abmelden"
            //Styling
                Abmelden.addActionListener(this);
                Abmelden.setText("Abmelden");
                Abmelden.setBackground(dunkelb);
                Abmelden.setForeground(white);
                Abmelden.setHorizontalTextPosition(JLabel.CENTER);
                Abmelden.setVerticalTextPosition(JLabel.CENTER);
                Abmelden.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
                Abmelden.setHorizontalAlignment(JLabel.CENTER);
                Abmelden.setVerticalAlignment(JLabel.CENTER);
                Abmelden.setFocusable(false);
                Abmelden.setBorderPainted(false);
                Abmelden.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                Abmelden.setBounds(140,100,100,100);

            //ActionListener
                Abmelden.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        currentUser.abmelden();
                        StartfensterGUI.startFenster(getFrame());
                        dispose();

                    }
                });

        // Gesamt Window
        this.setSize(900,550);
        this.setTitle("Kontrolleur");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        this.getContentPane().setBackground(dark);

        // Add Befehle

        // Daten aktualisieren
        Foo.getDirectoryData();

        // Add für einzelnen Elemente innerhalb der Panels
        Text.add(label, BorderLayout.SOUTH);

        //Text.add(Trennlinie,BorderLayout.SOUTH);
        gridpanel.add(SchwarzfahrtErfassen);
        gridpanel.add(SchwarzfahrerSuchen);
        gridpanel.add(Statistiken);
        gridpanel.add(Profil);
        gridpanel.add(Einstellungen);
        gridpanel.add(Abmelden);

        // Add für gesamte Panels
        this.add(gridpanel, BorderLayout.CENTER);
        this.add(Text, BorderLayout.NORTH);

    }

    public  void enableButtons(){
        SchwarzfahrtErfassen.setEnabled(true);
        SchwarzfahrerSuchen.setEnabled(true);
        Statistiken.setEnabled(true);
        Profil.setEnabled(true);
        Einstellungen.setEnabled(true);
        Abmelden.setEnabled(true);
    }

    public static void openKonGUI(GUI_Mama parent){
        Foo.getDirectoryData();
        KontrolleurGUI gui = new KontrolleurGUI(parent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}



