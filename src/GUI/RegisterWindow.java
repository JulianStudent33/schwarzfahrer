package src.GUI;

import com.formdev.flatlaf.FlatDarkLaf;
import src.GUI.elements.PlaceholderTextField;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import static src.Foo.*;

public class RegisterWindow extends JFrame implements ActionListener {

    // Top Textfelder
    PlaceholderTextField bname = new PlaceholderTextField();
    PlaceholderTextField name = new PlaceholderTextField();
    PlaceholderTextField vname = new PlaceholderTextField();

    PlaceholderTextField mail = new PlaceholderTextField();
    PlaceholderTextField nummer = new PlaceholderTextField();
    PlaceholderTextField pw = new PlaceholderTextField();
    PlaceholderTextField pwb = new PlaceholderTextField();

    // Mid Texfelder
    PlaceholderTextField rolle = new PlaceholderTextField();
    PlaceholderTextField gender = new PlaceholderTextField();

    // Registrieren Button deklaration
    private JButton reg = new JButton();

    //Konstruktor
    RegisterWindow() {

        // Erneuter Aufruf des L&F sodass bei Rückgang auf vorheriges Fenster, das L&F bestehen bleibt
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            UIManager.put("ComboBox.buttonArrowColor", dark);
            UIManager.put("ComboBox.buttonBackground", white);
            UIManager.put("Component.arrowType", "triangle");
            UIManager.put("ComboBox.popupBackground", white);
            UIManager.put("ComboBox.selectionForeground",white);
            UIManager.put("ComboBox.selectionBackground",dunkelb);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        };

        // Start des Fensters mit der void Methode frame()
        frame();
    }

    private void frame() {

        // Panelmanagement

        // Panel für Text "Registrieren"
        JPanel Text = new JPanel();
        Text.setBackground(dark);
        Text.setSize(new Dimension(600,100));
        Text.setLocation(0,0);
        Text.setLayout(null);

        // Panel für Oberen drei Textfelder
        JPanel Top = new JPanel();
        Top.setBackground(dark);
        Top.setSize(400,250);
        Top.setLocation(93,100);
        Top.setLayout(new GridLayout(5,1,0,20));

        // Panel für die Mittleren Felder (Rolle, Gender, Geburtsdatum)
        JPanel Mid = new JPanel();
        Mid.setBackground(dark);
        Mid.setSize(401,35);
        Mid.setLocation(92,370);
        Mid.setLayout(new GridLayout(1,3,10,0));

        JPanel dMid = new JPanel();
        dMid.setBackground(dark);
        dMid.setSize(401,205);
        dMid.setLocation(92,425);
        dMid.setLayout(new GridLayout(4,1,0,20));



        // Panel für die Unterden Felder
        JPanel Bot = new JPanel();
        Bot.setBackground(dark);
        Bot.setSize(300,50);
        Bot.setLocation(145,655);
        Bot.setLayout(new GridLayout());

        // Panel für den Fehlertext unterhalb der Textfelder

        // Panel für den Registrieren Button

        // Panel zum fixen
        JPanel fix = new JPanel();
        fix.setBackground(dark);
        fix.setSize(400,140);
        fix.setLocation(100,240);
        fix.setLayout(new GridLayout());

        // JLabel für Titel
        JLabel label = new JLabel();
        label.setText("Registrieren");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 35));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(-8,0,600,100);

        // Top Panel Textfelder
        // bname anpassungen
        bname.setBorder(null);
        bname.setForeground(dark);
        bname.setBackground(white);
        bname.setCaretColor(dark);
        bname.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        bname.setSelectedTextColor(dark);
        bname.setSelectionColor(Color.gray);
        bname.setPlaceholder("Benutzername");
        //bname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Benutzername");

        // name anpassungen
        name.setBorder(null);
        String focus = name.getText();
        name.setForeground(dark);
        name.setBackground(white);
        name.setCaretColor(dark);
        name.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        name.setSelectedTextColor(dark);
        name.setSelectionColor(Color.gray);
        name.setPlaceholder("Name");

        // vname anpassungen
        vname.setBorder(null);
        vname.setForeground(dark);
        vname.setBackground(white);
        vname.setCaretColor(dark);
        vname.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        vname.setSelectedTextColor(dark);
        vname.setSelectionColor(Color.gray);
        vname.setPlaceholder("Vorname");

        // Mid Panel Management
        // Rolle Auswahlmenü
        // Auswahlmöglichkeiten
        String[] choices = {"Rolle","Kontrolleur", "Sachbearbeiter"};

        final JComboBox<String> rollen = new JComboBox<>(choices);
        rollen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 26));
        rollen.setBackground(white);
        rollen.setForeground(Color.gray);
        rollen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rollen.setFocusable(false);
        rollen.setBorder(null);

        // Gender Auswahlmenü
        String[] geschlecht = {"Geschlecht","Männlich","Weiblich","Divers"};

        final JComboBox<String> gender = new JComboBox<>(geschlecht);
        //gender.setPrototypeDisplayValue("XXXXXXXXXXXX");
        gender.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 26));
        gender.setBackground(white);
        gender.setForeground(Color.gray);
        gender.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gender.setFocusable(false);
        gender.setBorder(null);

        // Geburtsdatum Eingabefeld
        // Tag
        String[] days = {"T","1", "2","3","4","5","6","7","8","9","10","11","12","13","14","15","16",
                "17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

        final JComboBox<String> tage = new JComboBox<>(days);
        tage.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 26));
        tage.setBackground(white);
        tage.setForeground(dark);
        tage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tage.setFocusable(false);
        tage.setBorder(null);

        // Monat
        String[] month = {"M","1", "2","3","4","5","6","7","8","9","10","11","12"};

        final JComboBox<String> monat = new JComboBox<>(month);
        monat.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 26));
        monat.setBackground(white);
        monat.setForeground(dark);
        monat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        monat.setFocusable(false);
        monat.setBorder(null);

        // Jahr
        // Jahresvariable erstellen
        List<String> year = new ArrayList<>();
        int n = Calendar.getInstance().get(Calendar.YEAR);
        year.add("Y");
        for (int i = 1900; i<=n;i++){
            year.add(String.valueOf(i));
        }
        String[] yearr = year.toArray(new String[0]);

        // Jahrescombobox
        final JComboBox<String> jahr = new JComboBox<>(yearr);
        jahr.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 26));
        jahr.setBackground(white);
        jahr.setForeground(dark);
        jahr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jahr.setFocusable(false);
        jahr.setBorder(null);

        // Bot Panel Management
        // E-Mail Textfeld
        mail.setBorder(null);
        mail.setForeground(dark);
        mail.setBackground(white);
        mail.setCaretColor(dark);
        mail.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        mail.setSelectedTextColor(dark);
        mail.setSelectionColor(Color.gray);
        mail.setPlaceholder("E-Mail");
        // Telefonnumer Textfeld
        nummer.setBorder(null);
        nummer.setForeground(dark);
        nummer.setBackground(white);
        nummer.setCaretColor(dark);
        nummer.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        nummer.setSelectedTextColor(dark);
        nummer.setSelectionColor(Color.gray);
        nummer.setPlaceholder("Telefonnummer");
        // PW Textfeld
        pw.setBorder(null);
        pw.setForeground(dark);
        pw.setBackground(white);
        pw.setCaretColor(dark);
        pw.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        pw.setSelectedTextColor(dark);
        pw.setSelectionColor(Color.gray);
        pw.setPlaceholder("Passwort");
        // PW Bestätigen Textfeld
        pwb.setBorder(null);
        pwb.setForeground(dark);
        pwb.setBackground(white);
        pwb.setCaretColor(dark);
        pwb.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        pwb.setSelectedTextColor(dark);
        pwb.setSelectionColor(Color.gray);
        pwb.setPlaceholder("Passwort bestätigen");

        // Bot Text Panel Management

        // Bot Registrieren Button Management

        // JButton "Registrieren"
        reg.addActionListener(this);
        reg.setText("Registrieren");
        reg.setBackground(hellb);
        reg.setForeground(white);
        reg.setHorizontalTextPosition(JLabel.CENTER);
        reg.setVerticalTextPosition(JLabel.CENTER);
        reg.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        reg.setHorizontalAlignment(JLabel.CENTER);
        reg.setVerticalAlignment(JLabel.CENTER);
        reg.setFocusable(false);
        reg.setBorderPainted(false);
        reg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reg.setBounds(140,-10,190,50);

        // Hauptfenster
        this.setSize(600,800);
        this.setTitle("Schwarzfahrer Projekt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(dark);

        // Add Befehle

        // Add für einzelne Elemente innerhalb der Panel
        Text.add(label);
        Top.add(bname);
        Top.add(name);
        Top.add(vname);
        Top.add(gender);
        Top.add(rollen);

        Mid.add(tage);
        Mid.add(monat);
        Mid.add(jahr);

        dMid.add(mail);
        dMid.add(nummer);
        dMid.add(pw);
        dMid.add(pwb);

        Bot.add(reg);

        // Add für vollständige Panel
        this.add(Text);
        this.add(Top);
        this.add(Mid);
        this.add(dMid);
        this.add(Bot);
        this.add(fix);


        // Placeholder der JComboboxen löschen
        rollen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rollen.getItemAt(0).equals("Rolle")){
                    rollen.removeItemAt(0);
                    rollen.setForeground(dark);
                }
            }
        });
        gender.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gender.getItemAt(0).equals("Geschlecht")){
                    gender.removeItemAt(0);
                    gender.setPrototypeDisplayValue(null);
                    gender.setForeground(dark);
                    //gender.setPreferredSize(new Dimension(100, gender.getHeight()));
                }
            }
        });
        tage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tage.getItemAt(0).equals("D")){
                    tage.removeItemAt(0);
                    tage.setPrototypeDisplayValue(null);
                }
            }
        });
        monat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (monat.getItemAt(0).equals("M")){
                    monat.removeItemAt(0);
                    monat.setPrototypeDisplayValue(null);
                }
            }
        });

        jahr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (jahr.getItemAt(0).equals("Y")){
                    jahr.removeItemAt(0);
                    jahr.setPrototypeDisplayValue(null);
                }
            }
        });

    }



    // ActionListener deklariert -> Was bei Klick auf den Button "Registrieren" passiert
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==reg) {
            System.out.println("Nutzer anlegen wenn alles richtig und Hauptmenü der jeweiligen Rolle öffnen");
        }
    }

}