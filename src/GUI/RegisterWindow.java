package src.GUI;

import src.Foo;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.PlaceholderPasswordField;
import src.GUI.elements.PlaceholderTextField;
import src.nickcode.pass;
import src.GUI.elements.*;
import src.roles.Kontrolleur;
import src.roles.Sachbearbeiter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.*;
import java.util.List;

import static src.Foo.*;
import static src.Main.colorchange;

public class RegisterWindow extends JFrame {

    // Top Textfelder
    PlaceholderTextField bname = new PlaceholderTextField();
    PlaceholderTextField name = new PlaceholderTextField();
    PlaceholderTextField vname = new PlaceholderTextField();

    String[] rollen = {"Rolle*", "Kontrolleur", "Sachbearbeiter"};

    customComboBox rollenBox = new customComboBox();

    String[] geschlechter = {"Geschlecht*", "Männlich", "Weiblich", "Divers"};

    customComboBox genderBox = new customComboBox();

    customButton dateButton = new customButton();
    PlaceholderTextField mail = new PlaceholderTextField();
    PlaceholderTextField nummer = new PlaceholderTextField();
    PlaceholderPasswordField pw = new PlaceholderPasswordField();
    PlaceholderPasswordField pwb = new PlaceholderPasswordField();


    // Mid Texfelder
    // PlaceholderTextField rolle = new PlaceholderTextField();
    // PlaceholderTextField gender = new PlaceholderTextField();

    // Registrieren Button deklaration
    JButton reg = new JButton();

    //Konstruktor
    public RegisterWindow(Container parent) {

        // Erneuter Aufruf des L&F sodass bei Rückgang auf vorheriges Fenster, das L&F bestehen bleibt


        // Start des Fensters mit der void Methode frame()
        frame(parent);
    }

    private void frame(Container parent) {

        if(Foo.firstUsage){
            rollen[0]="Admin";
            rollenBox.addItem(rollen[0]);
            rollenBox.setEnabled(false);
        } else {
            rollen[0]="*Rolle";
            rollenBox.addItem(rollen[0]);
            rollenBox.addItem(rollen[1]);
            rollenBox.addItem(rollen[2]);
        }







        genderBox.addItem(geschlechter[0]);
        genderBox.addItem(geschlechter[1]);
        genderBox.addItem(geschlechter[2]);
        genderBox.addItem(geschlechter[3]);

        // Panelmanagement

        // Panel für Text "Registrieren"
        JPanel Text = new JPanel();
        Text.setBackground(dark);
        Text.setSize(new Dimension(600, 100));
        Text.setLocation(0, 0);
        Text.setLayout(null);

        // Panel für Oberen drei Textfelder
        JPanel Top = new JPanel();
        Top.setBackground(dark);
        Top.setSize(400, 250);
        Top.setLocation(93, 100);
        Top.setLayout(new GridLayout(5, 1, 0, 20));

        // Panel für die Mittleren Felder (Rolle, Gender, Geburtsdatum)
        JPanel Mid = new JPanel();
        Mid.setBackground(dark);
        Mid.setSize(401, 35);
        Mid.setLocation(92, 370);
        Mid.setLayout(new GridLayout(1, 3, 10, 0));

        JPanel dMid = new JPanel();
        dMid.setBackground(dark);
        dMid.setSize(401, 205);
        dMid.setLocation(92, 425);
        dMid.setLayout(new GridLayout(4, 1, 0, 20));

        // Panel für die Unterden Felder
        JPanel Bot = new JPanel();
        Bot.setBackground(dark);
        Bot.setSize(300, 50);
        Bot.setLocation(145, 655);
        Bot.setLayout(new GridLayout());

        // Panel für den Fehlertext unterhalb der Textfelder

        // Panel für den Registrieren Button

        // Panel zum fixen
        JPanel fix = new JPanel();
        fix.setBackground(dark);
        fix.setSize(400, 140);
        fix.setLocation(100, 240);
        fix.setLayout(new GridLayout());

        // JLabel für Titel
        JLabel label = new JLabel();
        if(firstUsage){
            label.setText("Admin Registrieren");
        } else {
            label.setText("Registrieren");
        }
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 35));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(-8, 0, 600, 100);

        // Top Panel Textfelder
        // bname anpassungen

        // Border Variablen Erstellung
        Border border = bname.getBorder();
        Border margin = new EmptyBorder(0,5,0,0);


        bname.setBorder(new CompoundBorder(border, margin));
        bname.setForeground(white);
        bname.setBackground(whitebg);
        bname.setCaretColor(dark);
        bname.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        bname.setSelectedTextColor(dark);
        bname.setSelectionColor(notSoDark);
        bname.setPlaceholder("Benutzername*");
        //bname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Benutzername");

        // name anpassungen
        name.setBorder(new CompoundBorder(border, margin));
        String focus = name.getText();
        name.setForeground(white);
        name.setBackground(whitebg);
        name.setCaretColor(dark);
        name.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        name.setSelectedTextColor(dark);
        name.setSelectionColor(notSoDark);
        name.setPlaceholder("Nachname*");

        // vname anpassungen
        vname.setBorder(new CompoundBorder(border, margin));
        vname.setForeground(white);
        vname.setBackground(whitebg);
        vname.setCaretColor(dark);
        vname.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        vname.setSelectedTextColor(dark);
        vname.setSelectionColor(notSoDark);
        vname.setPlaceholder("Vorname*");

        // Mid Panel Management
        // Rolle Auswahlmenü
        // Auswahlmöglichkeiten
        if(colorchange) {
            Color[] colorrollen = {Grey,Grey,Grey};
            ComboBoxRenderer renderer = new ComboBoxRenderer(rollenBox);
            renderer.setColors(colorrollen);
            renderer.setStrings(rollen);
            rollenBox.setRenderer(renderer);
        }


        rollenBox.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 26));
        rollenBox.setBackground(whitebg);
        rollenBox.setForeground(white);
        rollenBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rollenBox.setFocusable(false);
        rollenBox.setBorder(new CompoundBorder(border, margin));

        // Gender Auswahlmenü

        //gender.setPrototypeDisplayValue("XXXXXXXXXXXX");
        genderBox.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 26));
        genderBox.setBackground(whitebg);
        if(genderBox.getItemAt(0)=="Geschlecht*") {
            genderBox.setForeground(notSoDark);
        } else {
            genderBox.setForeground(white);
        }
        genderBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        genderBox.setFocusable(false);
        genderBox.setBorder(new CompoundBorder(border, margin));

        // Geburtsdatum Button
        dateButton.setText("Bitte Geburtsdatum auswählen*");
        dateButton.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        dateButton.setBackground(whitebg);
        dateButton.setForeground(notSoDark);
        dateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dateButton.setFocusable(true);
        dateButton.setBorder(new CompoundBorder(border, margin));
        dateButton.setHorizontalTextPosition(SwingConstants.LEFT);


        // Geburtsdatum Eingabefeld
        // Tag
        String[] days = {"D","1", "2","3","4","5","6","7","8","9","10","11","12","13","14","15","16",
                "17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};

        final JComboBox<String> tage = new JComboBox<>(days);
        tage.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 26));
        tage.setBackground(whitebg);
        tage.setForeground(dark);
        tage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        tage.setFocusable(false);
        tage.setBorder(new CompoundBorder(border, margin));

        // Monat
        String[] month = {"M","1", "2","3","4","5","6","7","8","9","10","11","12"};

        final JComboBox<String> monat = new JComboBox<>(month);
        monat.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 26));
        monat.setBackground(whitebg);
        monat.setForeground(dark);
        monat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        monat.setFocusable(false);
        monat.setBorder(new CompoundBorder(border, margin));

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
        jahr.setBackground(whitebg);
        jahr.setForeground(dark);
        jahr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        jahr.setFocusable(false);
        jahr.setBorder(new CompoundBorder(border, margin));

        // Bot Panel Management
        // E-Mail Textfeld
        mail.setBorder(new CompoundBorder(border, margin));
        mail.setForeground(white);
        mail.setBackground(whitebg);
        mail.setCaretColor(dark);
        mail.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        mail.setSelectedTextColor(dark);
        mail.setSelectionColor(notSoDark);
        mail.setPlaceholder("E-Mail*");
        // Telefonnumer Textfeld
        nummer.setBorder(new CompoundBorder(border, margin));
        nummer.setForeground(white);
        nummer.setBackground(whitebg);
        nummer.setCaretColor(dark);
        nummer.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        nummer.setSelectedTextColor(dark);
        nummer.setSelectionColor(notSoDark);
        nummer.setPlaceholder("Telefonnummer");
        // PW Textfeld
        pw.setBorder(new CompoundBorder(border, margin));
        pw.setForeground(white);
        pw.setBackground(whitebg);
        pw.setCaretColor(dark);
        pw.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        pw.setSelectedTextColor(dark);
        pw.setSelectionColor(notSoDark);
        pw.setPlaceholder("Passwort*");
        // PW Bestätigen Textfeld
        pwb.setBorder(new CompoundBorder(border, margin));
        pwb.setForeground(white);
        pwb.setBackground(whitebg);
        pwb.setCaretColor(dark);
        pwb.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 25));
        pwb.setSelectedTextColor(dark);
        pwb.setSelectionColor(notSoDark);
        pwb.setPlaceholder("Passwort bestätigen*");

        // Bot Text Panel Management

        // Bot Registrieren Button Management

        // JButton "Registrieren"

        reg.setText("Registrieren");
        reg.setBackground(hellb);
        reg.setForeground(whitebg);
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
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        this.getContentPane().setBackground(dark);

        // Add Befehle







        // Add für einzelne Elemente innerhalb der Panel
        Text.add(label);
        Top.add(vname);
        Top.add(name);
        Top.add(genderBox);
        Top.add(rollenBox);
        Top.add(dateButton);

        Mid.add(mail);

                /*
        Mid.add(tage);
        Mid.add(monat);
        Mid.add(jahr);
*/
        dMid.add(nummer);
        dMid.add(bname);
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

        //ActionListener für Buttons
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==reg) {
                    System.out.println("Nutzer anlegen wenn alles richtig und Hauptmenü der jeweiligen Rolle öffnen");
                    if (pflichtAusgefüllt()){
                        int rollenSelection;
                        int[] date = Dateswitcher.datetonumber(dateButton.getText());
                        if (rollenBox.getSelectedItem() == rollenBox.getItemAt(0)) {
                            rollenSelection = 1; //
                        } else {
                            rollenSelection = 2;
                        }




                        try {

                            switch (rollenSelection) {

                                case 1:



                                    Foo.currentKontrolleur = new Kontrolleur(bname.getText(), pw.getText(),
                                            vname.getText(), name.getText(), genderBox.getSelectedItem().toString(),
                                            nummer.getText(), mail.getText().toLowerCase(Locale.ROOT), date);
                                    Foo.angemeldet = true;
                                    dispose();
                                    KontrolleurGUI.openKonGUI();
                                    break;
                                case 2:
                                    Foo.currentSachbearbeiter = new Sachbearbeiter(bname.getText(), pw.getText(),
                                            vname.getText(), name.getText(), genderBox.getSelectedItem().toString(),
                                            nummer.getText(), mail.getText().toLowerCase(Locale.ROOT), date);
                                    Foo.angemeldet = true;
                                    dispose();
                                    SachbearbeiterGUI.openSBGUI();
                                    break;
                            }
                        } catch (IOException ex) {
                            dispose();
                            StartfensterGUI.startFenster(getRootPane().getParent());
                            ex.printStackTrace();
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });

        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                    DatePick calender = new DatePick((JFrame) dateButton.getRootPane().getParent(), null);
                    String txt = calender.Set_Picked_Date();
                    if (txt==""){

                    }else{
                        dateButton.setText(calender.Set_Picked_Date());
                    }
                }




        });
        //ActionListener für Benutzername

        bname.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(bname.getText()+e.getKeyChar());

                if (Foo.userExistiertBereits(bname.getText())){
                    float[] values = new float[3];
                    bname.setBackground(Foo.red);
                }else{
                    if(!bname.getText().isBlank()) {
                        bname.setBackground(Foo.green);
                    } else {
                        bname.setBackground(dark);
                    }
                }
            }
        });
        pw.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(pass.passwordOk(pw.getText())){
                    pw.setBackground(Foo.green);
                }else{
                    if(!pw.getText().isBlank()) {
                        pw.setBackground(Foo.red);
                    } else {
                        pw.setBackground(dark);
                    }
                }
            }
        });

        pwb.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(pwb.getText().equals(pw.getText())){
                    pwb.setBackground(Foo.green);
                }else{
                    if(!pwb.getText().isBlank()) {
                        pwb.setBackground(Foo.red);
                    } else {
                        pwb.setBackground(dark);
                    }
                }
            }
        });

        // Placeholder der JComboboxen löschen
        rollenBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (rollenBox.getItemAt(0).equals("Rolle*")){
                    rollenBox.removeItemAt(0);
                    rollenBox.setForeground(white);
                }
            }
        });

        genderBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (genderBox.getItemAt(0).equals("Geschlecht*")){
                    genderBox.removeItemAt(0);
                    genderBox.setForeground(white);
                    genderBox.setPrototypeDisplayValue(null);
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



    //Allgemeine Methoden


    private boolean pflichtAusgefüllt() {
        if (rollenBox.getItemCount() == 2) {
            if (genderBox.getItemCount() == 3) {
                if (!vname.getText().isBlank()) {
                    if (!name.getText().isBlank()) {
                        if (!dateButton.getText().isBlank()){
                            if (!mail.getText().isBlank()) {
                                if (mail.getText().contains("@")) {
                                    if (!bname.getText().isBlank()) {
                                        if (!Foo.userExistiertBereits(bname.getText())) {
                                            if (pass.passwordOk(pw.getText())) {

                                                return true;
                                            } else {
                                                JOptionPane.showMessageDialog(new JDialog(), "Passwort erfüllt nicht die formalen Bedingungen!");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (rollenBox.getItemCount() == 3) {
            if(colorchange){
                rollenBox.addRedFlashEffect();
            } else {
                rollenBox.addRedFlashEffectWhiteField();
            }
            
        }
        if (genderBox.getItemCount() == 4) {
            if(colorchange){
                genderBox.addRedFlashEffect();
            } else {
                genderBox.addRedFlashEffectWhiteField();
            }
        }
        if (vname.getText().isBlank()) {
            if(colorchange){
                vname.addRedFlashEffect();
            } else {
                vname.addRedFlashEffectWhiteField();
            }
        }
        if (name.getText().isBlank()) {
            if(colorchange){
                name.addRedFlashEffect();
            } else {
                name.addRedFlashEffectWhiteField();
            }
        }
        if (dateButton.getText().isBlank()){
            if(colorchange){
                dateButton.addRedFlashEffect();
            } else {
                dateButton.addRedFlashEffectWhiteField();
            }
        }
        if (mail.getText().isBlank()) {
            if(colorchange){
                mail.addRedFlashEffect();
            } else {
                mail.addRedFlashEffectWhiteField();
            }
        }
        if (!mail.getText().contains("@")) {
            mail.setText("");
            if(colorchange){
                mail.addRedFlashEffect();
            } else {
                mail.addRedFlashEffectWhiteField();
            }
            mail.setPlaceholder("Bitte eine gültige E-Mail eingeben");
        }
        if (Foo.userExistiertBereits(bname.getText())) {
            bname.setText("");
            if(colorchange){
                bname.addRedFlashEffect();
            } else {
                bname.addRedFlashEffectWhiteField();
            }
            bname.setPlaceholder("Benutzername bereits vergeben");
        }
        if (bname.getText().isBlank()) {
            if(colorchange){
                bname.addRedFlashEffect();
            } else {
                bname.addRedFlashEffectWhiteField();
            }
        }
        if (!pass.passwordOk(pw.getText())) {
            if(colorchange){
                pw.addRedFlashEffect();
            } else {
                pw.addRedFlashEffectWhiteField();
            }
        }
        if (!pass.passwordOk(pw.getText())) {
            if(colorchange){
                pwb.addRedFlashEffect();
            } else {
                pwb.addRedFlashEffectWhiteField();
            }
        }
        if (!pw.getText().equals(pwb.getText())) {

            if(colorchange){
                pwb.addRedFlashEffect();
            } else {
                pwb.addRedFlashEffectWhiteField();
            }
        }



        return false;
    }




    public static void openRegisterGUI(Container parent){

        Foo.getDirectoryData();
        RegisterWindow gui = new RegisterWindow(parent);

    }

    public static void main(String[] args) {
        openRegisterGUI(null);
    }
}