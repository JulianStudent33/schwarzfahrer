package src.GUI.Sachbearbeiter;

import src.Foo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SachbearbeiterGUI extends JFrame implements ActionListener {

    private JButton Schwarzfahrterfassen = new JButton();
    private JButton Schwarzfahrersuchen = new JButton();
    private JButton Statistiken  = new JButton();
    private JButton Profil = new JButton();
    private JButton Einstellungen = new JButton();
    private JButton Abmelden = new JButton();

    public static Color dark = new Color(44,44,44);
    public static Color white = new Color(255,255,255);
    public static Color hellb = new Color(133, 179, 255);
    public static Color dunkelb = new Color(74,142,255);


    public SachbearbeiterGUI(){


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
        label.setText("<html><body><center><p><u>Willkommen, Sachbearbeiter<u></p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 28));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(200,50, 500,50);

       //JButton "Schwarzfahrt erfassen"
        Schwarzfahrterfassen.addActionListener(this);
        Schwarzfahrterfassen.setText("<html><body><center><p>Schwarzfahrt<br>erfassen</p></center></body></html>");
        Schwarzfahrterfassen.setBackground(hellb);
        Schwarzfahrterfassen.setForeground(white);
        Schwarzfahrterfassen.setHorizontalTextPosition(JLabel.CENTER);
        Schwarzfahrterfassen.setVerticalTextPosition(JLabel.CENTER);
        Schwarzfahrterfassen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Schwarzfahrterfassen.setHorizontalAlignment(JLabel.CENTER);
        Schwarzfahrterfassen.setVerticalAlignment(JLabel.CENTER);
        Schwarzfahrterfassen.setFocusable(false);
        Schwarzfahrterfassen.setBorderPainted(false);
        Schwarzfahrterfassen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Schwarzfahrterfassen.setBounds(140,100,100,100);


        // JButton "Schwarzfahrer suchen"
        Schwarzfahrersuchen.addActionListener(this);
        Schwarzfahrersuchen.setText("<html><body><center><p>Schwarzfahrer<br>suchen</p></center></body></html>");
        Schwarzfahrersuchen.setBackground(dunkelb);
        Schwarzfahrersuchen.setForeground(white);
        Schwarzfahrersuchen.setHorizontalTextPosition(JLabel.CENTER);
        Schwarzfahrersuchen.setVerticalTextPosition(JLabel.CENTER);
        Schwarzfahrersuchen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Schwarzfahrersuchen.setHorizontalAlignment(JLabel.CENTER);
        Schwarzfahrersuchen.setVerticalAlignment(JLabel.CENTER);
        Schwarzfahrersuchen.setFocusable(false);
        Schwarzfahrersuchen.setBorderPainted(false);
        Schwarzfahrersuchen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Schwarzfahrersuchen.setBounds(140,100,100,100);


        //JButton "Statistiken"
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

        //JButton "ProfilGUI"
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

        //JButton "Einstellungen"
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

        //JButton "Abmelden"
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
        gridpanel.add(Schwarzfahrterfassen);
        gridpanel.add(Schwarzfahrersuchen);
        gridpanel.add(Statistiken);
        gridpanel.add(Profil);
        gridpanel.add(Einstellungen);
        gridpanel.add(Abmelden);

        // Add für gesamte Panels
        this.add(gridpanel, BorderLayout.CENTER);
        this.add(Text, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void openSBGUI(){
        SachbearbeiterGUI gui = new SachbearbeiterGUI();
    }
    public static void main(String[] args) {
        openSBGUI();
    }
}
