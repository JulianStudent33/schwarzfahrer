package src.GUI.Sachbearbeiter;

import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.EinstellungenGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.ProfilGUI;
import src.GUI.StartfensterGUI;
import src.GUI.StatistikenGUI;
import src.roles.Sachbearbeiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static src.Foo.*;

public class SachbearbeiterGUI extends JFrame implements ActionListener {

    public static Sachbearbeiter currentUser;
    public static JButton Kachel1 = new JButton();
    public static JButton Kachel2 = new JButton();
    public static JButton Statistiken  = new JButton();
    public static JButton Profil = new JButton();
    public static JButton Einstellungen = new JButton();
    public static JButton Abmelden = new JButton();




    public SachbearbeiterGUI(){

        currentUser = currentSachbearbeiter;
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
        label.setText("<html><body><center><p><u>Hallo Sachbearbeiter<u></p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 28));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(200,50, 500,50);

       //JButton "Schwarzfahrt erfassen"
        //Styling
        Kachel1.addActionListener(this);
        Kachel1.setText("<html><body><center><p>Kachel 1</p></center></body></html>");
        Kachel1.setBackground(hellb);
        Kachel1.setForeground(white);
        Kachel1.setHorizontalTextPosition(JLabel.CENTER);
        Kachel1.setVerticalTextPosition(JLabel.CENTER);
        Kachel1.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Kachel1.setHorizontalAlignment(JLabel.CENTER);
        Kachel1.setVerticalAlignment(JLabel.CENTER);
        Kachel1.setFocusable(false);
        Kachel1.setBorderPainted(false);
        Kachel1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Kachel1.setBounds(140,100,100,100);

        //ActionListener

        Kachel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               // Kachel1GUI.openKachel1GUI();

            }
        });

        // JButton "Schwarzfahrer suchen"
        //Styling
        Kachel2.addActionListener(this);
        Kachel2.setText("<html><body><center><p>Kachel 2</p></center></body></html>");
        Kachel2.setBackground(dunkelb);
        Kachel2.setForeground(white);
        Kachel2.setHorizontalTextPosition(JLabel.CENTER);
        Kachel2.setVerticalTextPosition(JLabel.CENTER);
        Kachel2.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Kachel2.setHorizontalAlignment(JLabel.CENTER);
        Kachel2.setVerticalAlignment(JLabel.CENTER);
        Kachel2.setFocusable(false);
        Kachel2.setBorderPainted(false);
        Kachel2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Kachel2.setBounds(140,100,100,100);

        //ActionListener

        Kachel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Kachel2GUI.openKachel2GUI();

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

                StatistikenGUI.openStatistikenGUI();

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

                ProfilGUI.openProfilGUI(getRootPane().getParent());

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

                EinstellungenGUI.openEinstellungenGUI(getRootPane().getParent());

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

                dispose();
                currentUser.abmelden();
                StartfensterGUI.startFenster(getRootPane().getParent());


            }
        });

        // Gesamt Window
        this.setSize(900,550);
        this.setTitle("Sachbearbeiter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(dark);

        // Add Befehle

        // Daten aktualisieren
        Foo.getDirectoryData();

        // Add für einzelnen Elemente innerhalb der Panels
        Text.add(label, BorderLayout.SOUTH);

        //Text.add(Trennlinie,BorderLayout.SOUTH);
        gridpanel.add(Kachel1);
        gridpanel.add(Kachel2);
        gridpanel.add(Statistiken);
        gridpanel.add(Profil);
        gridpanel.add(Einstellungen);
        gridpanel.add(Abmelden);

        // Add für gesamte Panels
        this.add(gridpanel, BorderLayout.CENTER);
        this.add(Text, BorderLayout.NORTH);

    }

    public  void enableButtons(){
        Kachel1.setEnabled(true);
        Kachel2.setEnabled(true);
        Statistiken.setEnabled(true);
        Profil.setEnabled(true);
        Einstellungen.setEnabled(true);
        Abmelden.setEnabled(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void openSBGUI(){
        Foo.getDirectoryData();
        SachbearbeiterGUI gui = new SachbearbeiterGUI();
    }
    public static void main(String[] args) {
        openSBGUI();
    }
}
