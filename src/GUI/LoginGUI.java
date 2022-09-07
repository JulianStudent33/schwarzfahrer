package src.GUI;

import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.SB.SachbearbeiterGUI;
import src.GUI.elements.PlaceholderPasswordField;
import src.GUI.elements.PlaceholderTextField;
import src.PersFile;
import src.GUI.elements.pass;
import src.Rollen.Administrator;
import src.Rollen.Kontrolleur;
import src.Rollen.Mitarbeiter;
import src.Rollen.Sachbearbeiter;
import static src.Foo.*;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class LoginGUI extends Parent_GUI implements ActionListener {


    JPanel Bot = new JPanel();
    JPanel Text = new JPanel();
    JPanel Passwort = new JPanel();
    JPanel loginButton = new JPanel();
    JPanel AngemeldetBleiben = new JPanel();
    JLabel label = new JLabel();
    PlaceholderTextField bname = new PlaceholderTextField();
    PlaceholderPasswordField passwortPasswordField = new PlaceholderPasswordField();
    JCheckBox angemeldetBleibenCheckBox = new JCheckBox();
    JButton anmeldenButton = new JButton();
    JButton abbrechenButton = new JButton();

    public LoginGUI(Parent_GUI parent){

        try {
            getColorChange();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Panelmanagement



        Bot.setBackground(dark);
        Bot.setPreferredSize(new Dimension(100, 100));
        Bot.setLayout(null);


        Text.setBackground(dark);
        Text.setPreferredSize(new Dimension(200, 70));
        Text.setLayout(new GridLayout());


        Passwort.setBackground(dark);
        Passwort.setPreferredSize(new Dimension(600, 100));
        Passwort.setLayout(null);

        // Button

        loginButton.setBackground(dark);
        loginButton.setPreferredSize(new Dimension(100, 50));
        loginButton.setLayout(null);

        //AngemeldetBleiben

        AngemeldetBleiben.setBackground(dark);
        AngemeldetBleiben.setPreferredSize((new Dimension(100, 50)));
        AngemeldetBleiben.setLayout(null);

        // "Login" Text

        label.setText("<html><body><center><p>Login</p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setBounds(250, 25, 100, 40);

        // Textfield Benutzer
        styleTextField(bname, "Benutzername");

        bname.setBounds(200, 25, 200,30);


        // Textfield Passwort
        stylePwField(passwortPasswordField, "Passwort");

        passwortPasswordField.setBounds(200,75, 200,30);


        // Angemeldet bleiben CheckBox

        angemeldetBleibenCheckBox.setText("Angemeldet bleiben?");
        angemeldetBleibenCheckBox.addActionListener(this);
        angemeldetBleibenCheckBox.isEnabled();
        angemeldetBleibenCheckBox.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 8));
        angemeldetBleibenCheckBox.setBounds(235, 113, 200,20);


        //JButton "Login"
       styleButton(anmeldenButton, "Login");
        anmeldenButton.setBackground(dunkelb);
        anmeldenButton.setBounds(190, 0, 100, 30);

        // Button Abbrechen
        styleButton(abbrechenButton, "Abbrechen");
        abbrechenButton.setBackground(notSoDark);
        abbrechenButton.setBounds(310, 0, 100, 30);

        // Daten aktualisieren
        Foo.getDirectoryData();

        // Add für einzelnen Elemente innerhalb der Panels
        Text.add(label, BorderLayout.NORTH);
        Passwort.add(bname, BorderLayout.CENTER);
        Passwort.add(passwortPasswordField, BorderLayout.CENTER);
        //Passwort.add(passwortVergessenButton, BorderLayout.CENTER);
        Passwort.add(angemeldetBleibenCheckBox, BorderLayout.SOUTH);

        Bot.add(abbrechenButton, BorderLayout.SOUTH);
        Bot.add(anmeldenButton, BorderLayout.SOUTH);

        // Add für gesamte Panels
        add(Text, BorderLayout.NORTH);
        //this.add(Benutzer, BorderLayout.CENTER);
        add(Passwort, BorderLayout.CENTER);
        add(Bot, BorderLayout.SOUTH);



        // Gesamt Window

        setTitle("Login");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 600;
        int height = 350;
        setResizable(false);
        getContentPane().setBackground(dark);
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);

        bname.setPlaceholder("Benutzername");
        passwortPasswordField.setPlaceholder("Passwort");
        bname.addMouseListener(new MouseAdapter() {
        });
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
                    bname.setBackground(green);

                }else{
                    bname.setBackground(dark);

                }
            }
        });
        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StartfensterGUI.openStartFenster(getFrame());
                dispose();
            }
        });
        anmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!bname.getText().isBlank()){
                    if (!passwortPasswordField.getText().isBlank()) {

                        if (Foo.AdminFileListe.contains(Path.of(Foo.adminPath + Foo.fileSeperator + bname.getText() + ".mb").toFile())) {
                            try {
                                Mitarbeiter mb = (Mitarbeiter) PersFile.laden(Path.of(Foo.adminPath + Foo.fileSeperator + bname.getText() + ".mb").toFile());
                                System.out.println("Datei gelesen, telefonnummer: " + mb.getTelefonnummer());

                                if (Arrays.equals(mb.getPasswort().toCharArray(), passwortPasswordField.getPassword())) {
                                    System.out.println("Passwort stimmt");
                                    Foo.currentUser = mb;
                                    if (angemeldetBleibenCheckBox.isSelected()) {
                                        Foo.saveAngemeldetBleiben(true);
                                    } else {
                                        Foo.saveAngemeldetBleiben(false);
                                    }
                                    AdminGUI.openAdminGUI(getFrame());
                                    System.out.println("Starting Admin User-Interface.");
                                    dispose();
                                } else {
                                    System.out.println("Passwort falsch");
                                    JOptionPane.showMessageDialog(new JDialog(), "Das eingegebene Passwort ist nicht korrekt");
                                    passwortPasswordField.requestFocus();
                                    passwortPasswordField.setText("");
                                }


                            } catch (IOException | ClassNotFoundException io) {
                                io.printStackTrace();
                                StartfensterGUI.openStartFenster(getFrame());
                                dispose();
                            }
                        }
                        if (Foo.KontrolleurFileListe.contains(Path.of(Foo.konPath + Foo.fileSeperator + bname.getText() + ".mb").toFile())) {
                            try {
                                Kontrolleur mb = (Kontrolleur) PersFile.laden(Path.of(Foo.konPath + Foo.fileSeperator + bname.getText() + ".mb").toFile());
                                System.out.println("Datei gelesen");
                                if (Arrays.equals(mb.getPasswort().toCharArray(), passwortPasswordField.getPassword())) {
                                    System.out.println("Passwort stimmt");
                                    Foo.currentUser = mb;
                                    if (angemeldetBleibenCheckBox.isSelected()) {
                                        Foo.saveAngemeldetBleiben(true);
                                    } else {
                                        Foo.saveAngemeldetBleiben(false);
                                    }

                                    KontrolleurGUI.openKonGUI(getFrame());
                                    System.out.println("Starting Kontrolleur User-Interface.");
                                    dispose();
                                }
                            } catch (IOException | ClassNotFoundException io) {

                                io.printStackTrace();
                                StartfensterGUI.openStartFenster(getFrame());
                                dispose();
                            }
                        }
                        if (Foo.SachbearbeiterFileListe.contains(Path.of(Foo.sbPath + Foo.fileSeperator + bname.getText() + ".mb").toFile())) {
                            try {
                                Sachbearbeiter mb = (Sachbearbeiter) PersFile.laden(Path.of(Foo.sbPath + Foo.fileSeperator + bname.getText() + ".mb").toFile());
                                System.out.println("Datei gelesen");
                                if (Arrays.equals(mb.getPasswort().toCharArray(), passwortPasswordField.getPassword())) {
                                    System.out.println("Passwort stimmt");
                                    Foo.currentUser = mb;
                                    if (angemeldetBleibenCheckBox.isSelected()) {
                                        // Foo.saveAngemeldetBleiben(true);
                                    } else {
                                        // Erneuter Aufruf des L&F sodass bei Rückgang auf vorheriges Fenster, das L&F bestehen bleibt            // Foo.saveAngemeldetBleiben(false);
                                    }

                                    SachbearbeiterGUI.openSBGUI(getFrame());
                                    System.out.println("Starting SB User-Interface.");
                                    dispose();
                                }
                            } catch (IOException | ClassNotFoundException io) {

                                io.printStackTrace();
                                StartfensterGUI.openStartFenster(getFrame());
                                dispose();
                            }
                        }


                    }
                }
                if (colorChange){
                    if (bname.getText().isBlank()){
                        bname.addRedFlashEffectWhiteField();
                    }
                    if (!userExistiertBereits(bname.getText())){
                        bname.addRedFlashEffectWhiteField();
                    }
                    if (passwortPasswordField.getText().isBlank()){
                        passwortPasswordField.addRedFlashEffectWhiteField();
                    }
                    if (pass.passwordOk(passwortPasswordField.getText())){
                        passwortPasswordField.addRedFlashEffectWhiteField();
                    }
                }else{
                    if (bname.getText().isBlank()){
                        bname.addRedFlashEffect();
                    }
                    if (!userExistiertBereits(bname.getText())){
                        bname.addRedFlashEffect();
                    }
                    if (passwortPasswordField.getText().isBlank()){
                        passwortPasswordField.addRedFlashEffect();
                    }
                    if (pass.passwordOk(passwortPasswordField.getText())){
                        passwortPasswordField.addRedFlashEffect();
                    }
                }


            }
        });

    }
    void stylePwField(PlaceholderPasswordField field, String txt){
        field.setBackground(whitebg);
        field.setForeground(white);
        field.setCaretColor(notSoDark);
        field.setFont(fontSmallSmall);
        field.setPlaceholder(txt);
    }
    void styleTextField(PlaceholderTextField field, String txt){
        field.setBackground(whitebg);
        field.setForeground(white);
        field.setCaretColor(notSoDark);
        field.setFont(fontSmallSmall);
        field.setPlaceholder(txt);
    }
    void styleButton(JButton btn, String txt){
        btn.setText(txt);
        btn.setForeground(dark);
        btn.setHorizontalTextPosition(JLabel.CENTER);
        btn.setVerticalTextPosition(JLabel.CENTER);
        btn.setFont(fontSmallSmall);
        btn.setHorizontalAlignment(JLabel.CENTER);
        btn.setVerticalAlignment(JLabel.CENTER);
        btn.setFocusable(true);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    public static void openLogin(Parent_GUI parent){
        Foo.getDirectoryData();
        LoginGUI gui = new LoginGUI(parent);

    }


    public static void main(String[] args) {
        openLogin(null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
