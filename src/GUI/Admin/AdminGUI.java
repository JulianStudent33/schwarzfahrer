package src.GUI.Admin;
import src.Foo;
import src.GUI.*;
import src.roles.Administrator;
import src.roles.Mitarbeiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static src.Foo.*;

public class AdminGUI extends GUI_Mama implements ActionListener {

    //public static Administrator currentUser;
    public static JButton AdminAnlegen = new JButton();
    public static JButton MitarbeiterVerwalten = new JButton();
    public static JButton Statistiken = new JButton();
    public static JButton Profil = new JButton();
    public static JButton Einstellungen = new JButton();
    public static JButton Abmelden = new JButton();



    public AdminGUI(GUI_Mama parent){

        setupGUI(parent, "AdminGUI");
        enableButtons();
        this.currentUser.display();




        //currentUser = Foo.currentAdmin;
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
        label.setText("<html><body><center><p><u>Hallo Admin<u></p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(fontLarge);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(200,50, 500,50);

        //JButton "Schwarzfahrt erfassen"
        //Styling
        AdminAnlegen.addActionListener(this);
        AdminAnlegen.setText("<html><body><center><p>Administrator<br>anlegen</p></center></body></html>");
        AdminAnlegen.setBackground(hellb);
        AdminAnlegen.setForeground(white);
        AdminAnlegen.setHorizontalTextPosition(JLabel.CENTER);
        AdminAnlegen.setVerticalTextPosition(JLabel.CENTER);
        AdminAnlegen.setFont(fontMedium);
        AdminAnlegen.setHorizontalAlignment(JLabel.CENTER);
        AdminAnlegen.setVerticalAlignment(JLabel.CENTER);
        AdminAnlegen.setFocusable(false);
        AdminAnlegen.setBorderPainted(false);
        AdminAnlegen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AdminAnlegen.setBounds(140,100,100,100);

        //ActionListener
        AdminAnlegen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                AdminAnlegenGUI.openAdminAnlegenGUI(getFrame());
                AdminAnlegen.setEnabled(false);
            }
        });

        // JButton "Schwarzfahrer verwalten"
        //Styling
        MitarbeiterVerwalten.addActionListener(this);
        MitarbeiterVerwalten.setText("<html><body><center><p>Mitarbeiter<br>verwalten</p></center></body></html>");
        MitarbeiterVerwalten.setBackground(dunkelb);
        MitarbeiterVerwalten.setForeground(white);
        MitarbeiterVerwalten.setHorizontalTextPosition(JLabel.CENTER);
        MitarbeiterVerwalten.setVerticalTextPosition(JLabel.CENTER);
        MitarbeiterVerwalten.setFont(fontMedium);
        MitarbeiterVerwalten.setHorizontalAlignment(JLabel.CENTER);
        MitarbeiterVerwalten.setVerticalAlignment(JLabel.CENTER);
        MitarbeiterVerwalten.setFocusable(false);
        MitarbeiterVerwalten.setBorderPainted(false);
        MitarbeiterVerwalten.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        MitarbeiterVerwalten.setBounds(140,100,100,100);

        //ActionListener
        MitarbeiterVerwalten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MitarbeiterVerwaltenGUI.openMitarbeiterVerwaltenGUI(getFrame());
                MitarbeiterVerwalten.setEnabled(false);
            }
        });



        //JButton "Neuer Mitarbeiter"
        //Styling
        Statistiken.addActionListener(this);
        Statistiken.setText("<html><body><center><p>Statistiken</p></center></body></html>");
        Statistiken.setBackground(hellb);
        Statistiken.setForeground(white);
        Statistiken.setHorizontalTextPosition(JLabel.CENTER);
        Statistiken.setVerticalTextPosition(JLabel.CENTER);
        Statistiken.setFont(fontMedium);
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
                Statistiken.setEnabled(false);
            }
        });

        //JButton "Mitarbeiter verwalten"
        //Styling
        Profil.addActionListener(this);
        Profil.setText("<html><body><center><p>Profil</p></center></body></html>");
        Profil.setBackground(dunkelb);
        Profil.setForeground(white);
        Profil.setHorizontalTextPosition(JLabel.CENTER);
        Profil.setVerticalTextPosition(JLabel.CENTER);
        Profil.setFont(fontMedium);
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
                Profil.setEnabled(false);
            }
        });


        //JButton "Einstellungen"
        //Styling
        Einstellungen.addActionListener(this);
        Einstellungen.setText("<html><body><center><p>Einstellungen</p></center></body></html>");
        Einstellungen.setBackground(hellb);
        Einstellungen.setForeground(white);
        Einstellungen.setHorizontalTextPosition(JLabel.CENTER);
        Einstellungen.setVerticalTextPosition(JLabel.CENTER);
        Einstellungen.setFont(fontMedium);
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
                Einstellungen.setEnabled(false);
            }
        });

        //JButton "Abmelden"
            //Styling
                Abmelden.addActionListener(this);
                Abmelden.setText("<html><body><center><p>Abmelden</p></center></body></html>");
                Abmelden.setBackground(dunkelb);
                Abmelden.setForeground(white);
                Abmelden.setHorizontalTextPosition(JLabel.CENTER);
                Abmelden.setVerticalTextPosition(JLabel.CENTER);
                Abmelden.setFont(fontMedium);
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
                StartfensterGUI.openStartFenster(getFrame());
                dispose();

            }
        });


        // Gesamt Window
        this.setSize(900,550);
        this.setTitle("Admin-Panel");
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
        gridpanel.add(AdminAnlegen);
        gridpanel.add(MitarbeiterVerwalten);
        gridpanel.add(Statistiken);
        gridpanel.add(Profil);
        gridpanel.add(Einstellungen);
        gridpanel.add(Abmelden);

        // Add für gesamte Panels
        this.add(gridpanel, BorderLayout.CENTER);
        this.add(Text, BorderLayout.NORTH);
    }

    //Methoden
    public  void enableButtons(){
        AdminAnlegen.setEnabled(true);
        MitarbeiterVerwalten.setEnabled(true);
        Statistiken.setEnabled(true);
        Profil.setEnabled(true);
        Einstellungen.setEnabled(true);
        Abmelden.setEnabled(true);
    }

    public static void openAdminGUI(GUI_Mama parent){
        Foo.getDirectoryData();
        AdminGUI gui = new AdminGUI(parent);

    }

    public static void main(String[] args) {
        //openAdminGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }}

