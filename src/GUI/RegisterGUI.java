package src.GUI;

import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.SB.SachbearbeiterGUI;
import src.GUI.elements.PlaceholderPasswordField;
import src.GUI.elements.PlaceholderTextField;
import src.GUI.elements.pass;
import src.GUI.elements.*;
import src.Rollen.Administrator;
import src.Rollen.Kontrolleur;
import src.Rollen.Sachbearbeiter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.*;

import static src.Foo.*;

public class RegisterGUI extends Parent_GUI implements ActionListener {

    // Deklaration Arrays String
    String[] rollen = {"Rolle*", "Kontrolleur", "Sachbearbeiter"};
    String[] geschlechter = {"Geschlecht*", "Männlich", "Weiblich", "Divers"};
    String datumButtonText = "Bitte Geburtsdatum auswählen*";

    //Deklaration Panel
    JPanel Text = new JPanel();
    JPanel Top = new JPanel();
    JPanel Mid = new JPanel();
    JPanel dMid = new JPanel();
    JPanel Bot = new JPanel();
    JPanel fix = new JPanel();

    //Deklaration Label
    JLabel label = new JLabel();
    JLabel bed = new JLabel();
    // Deklaration bname Benutzername, name Nachname, vname Vorname
    PlaceholderTextField bname = new PlaceholderTextField();
    PlaceholderTextField name = new PlaceholderTextField();
    PlaceholderTextField vname = new PlaceholderTextField();

    // Deklaration JComboBoxen
    customComboBox rollenBox = new customComboBox();


    customComboBox genderBox = new customComboBox();

    customButton dateButton = new customButton();
    // Deklaration der restlichen Textfelder und Passwortfelder
    PlaceholderTextField mail = new PlaceholderTextField();
    PlaceholderTextField nummer = new PlaceholderTextField();
    PlaceholderPasswordField pw = new PlaceholderPasswordField();
    PlaceholderPasswordField pwb = new PlaceholderPasswordField();

   //Deklaration der Button Registrieren und Abbrechen
    private JButton regbt = new JButton();

    private JButton abr = new JButton();

    //Deklaration von Borders
    Border border;
    Border margin;
    Border margin2;

    //Deklaration von TextField Filtern
    LetterFilter lfilter = new LetterFilter();
    NumberFilter nfilter = new NumberFilter();
    SizeFilter sfilter = new SizeFilter(15);
    //Hilfsvariable
    boolean onlyAdmin;

    //Konstruktor
    public RegisterGUI(Parent_GUI parent, boolean onlyAdmin) {

        if (onlyAdmin || firstUsage){
            this.onlyAdmin = true;  //Damit Ausschließlich ein Admin Registriert werden kann
        }

        // Start des Fensters mit der void Methode frame()
        frame(parent);
    }

    private void frame(Parent_GUI parent) {

        parentGUI = parent;
        try {
            getColorChange();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (onlyAdmin){
            rollen[0]="Admin";
            rollenBox.addItem(rollen[0]);
            rollenBox.setEnabled(false);
        }else{
            rollen[0]="Rolle*";
            rollenBox.addItem(rollen[0]);
            rollenBox.addItem(rollen[1]);
            rollenBox.addItem(rollen[2]);
        }

        genderBox.addItem(geschlechter[0]);
        genderBox.addItem(geschlechter[1]);
        genderBox.addItem(geschlechter[2]);
        genderBox.addItem(geschlechter[3]);

        //Filter Definition

        // Panelmanagement

        // Panel für Text "Registrieren"

        Text.setBackground(dark);
        Text.setSize(new Dimension(600, 100));
        Text.setLocation(0, 0);
        Text.setLayout(null);

        // Panel für Oberen drei Textfelder

        Top.setBackground(dark);
        Top.setSize(400, 250);
        Top.setLocation(93, 100);
        Top.setLayout(new GridLayout(5, 1, 0, 20));

        // Panel für die Mittleren Felder (Rolle, Gender, Geburtsdatum)

        Mid.setBackground(dark);
        Mid.setSize(401, 35);
        Mid.setLocation(92, 370);
        Mid.setLayout(new GridLayout(1, 3, 10, 0));


        dMid.setBackground(dark);
        dMid.setSize(401, 200);
        dMid.setLocation(92, 425);
        dMid.setLayout(new GridLayout(4, 1, 0, 20));

        // Panel für die Unterden Felder

        Bot.setBackground(dark);
        Bot.setSize(400, 50);
        Bot.setLocation(93, 700);
        Bot.setLayout(new GridLayout(1,2,20,0));

        // Panel für den Fehlertext unterhalb der Textfelder

        // Panel für den Registrieren Button

        // Panel zum fixen

        fix.setBackground(dark);
        fix.setSize(400, 140);
        fix.setLocation(100, 240);
        fix.setLayout(null);

        // JLabel für Titel

        if(firstUsage){
            label.setText("Admin Registrieren");
        } else {
            label.setText("Registrieren");
        }
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(fontLargeLarge);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(-8, 0, 600, 100);


        bed.setText("<html><body><center><p>Passwort benötigt: 6-15 Zeichen, mind. 1 Großbuchstabe,<br>mind. 1 Kleinbuchstabe und mind. 1 Zahl</p></center></body></html>");
        bed.setForeground(Grey);
        bed.setHorizontalTextPosition(JLabel.CENTER);
        bed.setVerticalTextPosition(JLabel.BOTTOM);
        bed.setFont(fontSmallSmall);
        bed.setHorizontalAlignment(JLabel.CENTER);
        bed.setVerticalAlignment(JLabel.BOTTOM);
        bed.setBounds(100,585,400,100);

        //ColorChange
        if(colorChange) {
            Color[] colorrollen = {Grey,Grey,Grey};
            ComboBoxRenderer renderer = new ComboBoxRenderer(rollenBox);
            renderer.setColors(colorrollen);
            renderer.setStrings(rollen);
            rollenBox.setRenderer(renderer);
        }

        if(colorChange) {
            Color[] colorrollenn = {Grey,Grey,Grey,Grey};
            ComboBoxRenderer rendererr = new ComboBoxRenderer(genderBox);
            rendererr.setColors(colorrollenn);
            rendererr.setStrings(geschlechter);
            genderBox.setRenderer(rendererr);
        }


        // Top Panel Textfelder
        // bname anpassungen

        // Border Variablen Erstellung
        border = bname.getBorder();
        margin = new EmptyBorder(0,5,0,0);
        margin2 = new EmptyBorder(0,0,0,0);


        styleTextField(bname, "Benutzername*");
        ((AbstractDocument)bname.getDocument()).setDocumentFilter(sfilter);
        //bname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Benutzername");


        // name anpassungen
        styleTextField(name, "Nachname*");
        ((AbstractDocument)name.getDocument()).setDocumentFilter(lfilter);

        // vname anpassungen
        styleTextField(vname, "Vorname*");
        ((AbstractDocument)vname.getDocument()).setDocumentFilter(lfilter);

        // Mid Panel Management
        // Rolle Auswahlmenü
        // Auswahlmöglichkeiten

        rollenBox.setFont(fontMedium);
        rollenBox.setBackground(whitebg);
        if(rollenBox.getItemAt(0)=="Rolle*") {
            rollenBox.setForeground(notSoDark);
        } else {
            rollenBox.setForeground(white);
        }
        rollenBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        rollenBox.setFocusable(true);
        rollenBox.setBorder(new CompoundBorder(border, margin));

        // Gender Auswahlmenü

        //gender.setPrototypeDisplayValue("XXXXXXXXXXXX");
        genderBox.setFont(fontMedium);
        genderBox.setBackground(whitebg);
        if(genderBox.getItemAt(0)=="Geschlecht*") {
            genderBox.setForeground(notSoDark);
        } else {
            genderBox.setForeground(white);
        }
        genderBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        genderBox.setFocusable(true);
        genderBox.setBorder(new CompoundBorder(border, margin));

        // Geburtsdatum Button
        dateButton.setBorder(new CompoundBorder(border, margin2));
        dateButton.setText(datumButtonText);
        dateButton.setFont(fontMedium);
        dateButton.setBackground(whitebg);
        dateButton.setForeground(notSoDark);
        dateButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dateButton.setFocusable(true);
        dateButton.setHorizontalAlignment(SwingConstants.LEFT);

        // Bot Panel Management
        // E-Mail Textfeld

        styleTextField(mail, "E-Mail*");

        // Telefonnumer Textfeld
        styleTextField(nummer, "Telefonnummer");
        ((AbstractDocument)nummer.getDocument()).setDocumentFilter(nfilter);

        // PW Textfelds
        stylePwField(pw, "Passwort");
        stylePwField(pwb, "Passwort bestätigen");

        // Bot Text Panel Management
        // JButton "Registrieren"

        regbt.setText("Registrieren");
        regbt.setBackground(hellb);
        regbt.setForeground(whitebg);
        regbt.setHorizontalTextPosition(JLabel.CENTER);
        regbt.setVerticalTextPosition(JLabel.CENTER);
        regbt.setFont(fontMedium);
        regbt.setFocusable(true);
        regbt.setBorderPainted(false);
        regbt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        abr.setText("Abbrechen");
        abr.setBackground(notSoDark);
        abr.setForeground(whitebg);
        abr.setHorizontalTextPosition(JLabel.CENTER);
        abr.setVerticalTextPosition(JLabel.CENTER);
        abr.setFont(fontMedium);
        abr.setFocusable(true);
        abr.setBorderPainted(false);
        abr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        // Hauptfenster
        this.setSize(600,820);
        this.setTitle("Schwarzfahrer Projekt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        this.getContentPane().setBackground(dark);
        this.setLayout(null);

        // Add Befehle


        // Add für einzelne Elemente innerhalb der Panel
        Text.add(label);
        Top.add(vname);
        Top.add(name);
        Top.add(genderBox);
        Top.add(rollenBox);
        Top.add(dateButton);

        Mid.add(mail);

        dMid.add(nummer);
        dMid.add(bname);
        dMid.add(pw);
        dMid.add(pwb);
        dMid.add(bed);

        Bot.add(regbt);
        Bot.add(abr);

        // Add für vollständige Panel
        this.add(Text);
        this.add(Top);
        this.add(Mid);
        this.add(dMid);
        this.add(bed);
        this.add(Bot);
        //this.add(fix);

        //ActionListener für Buttons
        regbt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource()==regbt) {
                    System.out.println("Nutzer anlegen wenn alles richtig und Hauptmenü der jeweiligen Rolle öffnen");
                    if (pflichtAusgefüllt()){

                        int[] date = dateToNumber(dateButton.getText());

                        if (onlyAdmin){



                            try {

                                if (parent.getClass().getName().equals("src.GUI.Admin.AdminGUI")){
                                    parent.currentUser.abmelden();
                                    parent.dispose();

                                }

                                Foo.currentUser = new Administrator(bname.getText(), pw.getText(),
                                        vname.getText(), name.getText(), genderBox.getSelectedItem().toString(),
                                        nummer.getText(), mail.getText().toLowerCase(Locale.ROOT), date);
                                angemeldet = true;



                                AdminGUI.openAdminGUI(getFrame());
                                dispose();
                            } catch (IOException ex) {
                                ex.printStackTrace();
                                throw new RuntimeException(ex);
                            }


                        }else{


                        int rollenSelection;
                        if (rollenBox.getSelectedItem() == rollenBox.getItemAt(0)) {
                            rollenSelection = 1; //
                        } else {
                            rollenSelection = 2;
                        }
                        try {

                            switch (rollenSelection) {

                                case 1:



                                    Foo.currentUser = new Kontrolleur(bname.getText(), pw.getText(),
                                            vname.getText(), name.getText(), genderBox.getSelectedItem().toString(),
                                            nummer.getText(), mail.getText().toLowerCase(Locale.ROOT), date);
                                    Foo.angemeldet = true;
                                    KontrolleurGUI.openKonGUI(getFrame());
                                    dispose();
                                    break;
                                case 2:
                                    Foo.currentUser = new Sachbearbeiter(bname.getText(), pw.getText(),
                                            vname.getText(), name.getText(), genderBox.getSelectedItem().toString(),
                                            nummer.getText(), mail.getText().toLowerCase(Locale.ROOT), date);
                                    Foo.angemeldet = true;
                                    SachbearbeiterGUI.openSBGUI(getFrame());
                                    dispose();
                                    break;
                            }
                        } catch (IOException ex) {

                            StartfensterGUI.openStartFenster(getFrame());
                            ex.printStackTrace();
                            dispose();
                            throw new RuntimeException(ex);
                        }
                    }
                    }
                }
            }
        });
        abr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!parent.getClass().getName().equals("src.GUI.Admin.AdminGUI")){
                    StartfensterGUI.openStartFenster(getFrame());
                    dispose();
                }else{
                    parent.setVisible(true);
                    dispose();
                }
            }
        });

        dateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String txt;
                DatePick calender;
                    if (!dateButton.getText().equals(datumButtonText)){
                        calender = new DatePick((JFrame) dateButton.getRootPane().getParent(), dateButton.getText());
                        txt = calender.Set_Picked_Date();
                        dateButton.setForeground(white);
                    }else{
                        calender = new DatePick((JFrame) dateButton.getRootPane().getParent(), null);
                        txt = calender.Set_Picked_Date();

                    }

                    if (txt==""){
                    }else{
                        dateButton.setText(calender.Set_Picked_Date());
                        dateButton.setForeground(white);
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
                    bname.setBackground(red);
                }else{
                    if(!bname.getText().isBlank()) {
                        bname.setBackground(green);
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
                    pw.setBackground(green);
                }else{
                    if(!pw.getText().isBlank()) {
                        pw.setBackground(red);
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
                    if (pw.getText().isBlank()) {
                        pwb.setBackground(dark);
                    } else if (pwb.getText().equals(pw.getText()) && !pwb.getText().isBlank()) {
                        pwb.setBackground(green);
                    }

                }else{
                    if(!pwb.getText().isBlank()) {
                        pwb.setBackground(red);
                    } else {
                        pwb.setBackground(dark);
                    }
                }
            }
        });
        rollenBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (rollenBox.getItemAt(0).equals("Rolle*")){
                    rollenBox.removeItemAt(0);
                    rollenBox.setForeground(white);
                    genderBox.setPrototypeDisplayValue(null);
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

    }
    //Allgemeine Methoden
    private boolean pflichtAusgefüllt() {
        if (rollenBox.getItemCount() == 2 || (onlyAdmin)) {
            if (genderBox.getItemCount() == 3) {
                if (!vname.getText().isBlank()) {
                    if (!name.getText().isBlank()) {
                        if (!dateButton.getText().isBlank()){
                            if (!mail.getText().isBlank()) {
                                if (mail.getText().contains("@")) {
                                    if (!bname.getText().isBlank()) {
                                        if (!userExistiertBereits(bname.getText())) {
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
            if(!colorChange){
                rollenBox.addRedFlashEffect();
            } else {
                rollenBox.addRedFlashEffectWhiteField();
            }
            
        }
        if (genderBox.getItemCount() == 4) {
            if(!colorChange){
                genderBox.addRedFlashEffect();
            } else {
                genderBox.addRedFlashEffectWhiteField();
            }
        }
        if (vname.getText().isBlank()) {
            if(!colorChange){
                vname.addRedFlashEffect();
            } else {
                vname.addRedFlashEffectWhiteField();
            }
        }
        if (name.getText().isBlank()) {
            if(!colorChange){
                name.addRedFlashEffect();
            } else {
                name.addRedFlashEffectWhiteField();
            }
        }
        if (dateButton.getText().equals(datumButtonText)){
            if(!colorChange){
                dateButton.addRedFlashEffect();
            } else {
                dateButton.addRedFlashEffectWhiteField();
            }
        }
        if (mail.getText().isBlank()) {
            if(!colorChange){
                mail.addRedFlashEffect();
            } else {
                mail.addRedFlashEffectWhiteField();
            }
        }
        if (!mail.getText().contains("@")) {
            mail.setText("");
            if(!colorChange){
                mail.addRedFlashEffect();
            } else {
                mail.addRedFlashEffectWhiteField();
            }
            mail.setPlaceholder("Bitte eine gültige E-Mail eingeben");
        }
        if (userExistiertBereits(bname.getText())) {
            bname.setText("");
            if(!colorChange){
                bname.addRedFlashEffect();
            } else {
                bname.addRedFlashEffectWhiteField();
            }
            bname.setPlaceholder("Benutzername bereits vergeben");
        }
        if (bname.getText().isBlank()) {
            if(!colorChange){
                bname.addRedFlashEffect();
            } else {
                bname.addRedFlashEffectWhiteField();
            }
        }
        if (!pass.passwordOk(pw.getText())) {
            if(!colorChange){
                pw.addRedFlashEffect();
            } else {
                pw.addRedFlashEffectWhiteField();
            }
        }
        if (!pass.passwordOk(pw.getText())) {
            if(!colorChange){
                pwb.addRedFlashEffect();
            } else {
                pwb.addRedFlashEffectWhiteField();
            }
        }
        if (!pw.getText().equals(pwb.getText())) {

            if(!colorChange){
                pwb.addRedFlashEffect();
            } else {
                pwb.addRedFlashEffectWhiteField();
            }
        }



        return false;
    }
    public void styleTextField(PlaceholderTextField field, String txt){
        field.setBorder(new CompoundBorder(border, margin)); // same
        field.setForeground(white); //same
        field.setBackground(whitebg); //same
        field.setCaretColor(notSoDark); //same
        field.setFont(fontMedium); //same
        field.setSelectedTextColor(dark); //same
        field.setSelectionColor(notSoDark); //same
        field.setPlaceholder(txt);
    }
    public void stylePwField(PlaceholderPasswordField field, String txt){
        field.setBorder(new CompoundBorder(border, margin));
        field.setForeground(white);
        field.setBackground(whitebg);
        field.setCaretColor(notSoDark);
        field.setFont(fontMedium);
        field.setSelectedTextColor(dark);
        field.setSelectionColor(notSoDark);
        field.setPlaceholder(txt);
        ((AbstractDocument)pwb.getDocument()).setDocumentFilter(sfilter);
    }
    public static void openRegisterGUI(Parent_GUI parent){

        Foo.getDirectoryData();
        RegisterGUI gui = new RegisterGUI(parent, false);
    }
    public static void openAdminRegisterGUI(Parent_GUI parent){
        Foo.getDirectoryData();
        RegisterGUI gui = new RegisterGUI(parent, true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}