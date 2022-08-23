package src.GUI;

import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.PlaceholderPasswordField;
import src.GUI.elements.PlaceholderTextField;
import src.PersFile;
import src.nickcode.pass;
import src.roles.Administrator;
import src.roles.Kontrolleur;
import src.roles.Mitarbeiter;
import src.roles.Sachbearbeiter;
import static src.Foo.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class LoginGUI extends GUI_Mama implements ActionListener {



    public LoginGUI(GUI_Mama parent){

        // Panelmanagement

        JPanel Bot = new JPanel();
        Bot.setBackground(dark);
        Bot.setPreferredSize(new Dimension(100, 100));
        Bot.setLayout(null);

        JPanel Text = new JPanel();
        Text.setBackground(dark);
        Text.setPreferredSize(new Dimension(200, 70));
        Text.setLayout(new GridLayout());

        JPanel Passwort = new JPanel();
        Passwort.setBackground(dark);
        Passwort.setPreferredSize(new Dimension(600, 100));
        Passwort.setLayout(null);

        // Button
        JPanel loginButton = new JPanel();
        loginButton.setBackground(dark);
        loginButton.setPreferredSize(new Dimension(100, 50));
        loginButton.setLayout(null);

        //AngemeldetBleiben
        JPanel AngemeldetBleiben = new JPanel();
        AngemeldetBleiben.setBackground(dark);
        AngemeldetBleiben.setPreferredSize((new Dimension(100, 50)));
        AngemeldetBleiben.setLayout(null);

        // "Login" Text
        JLabel label = new JLabel();
        label.setText("<html><body><center><p>Login</p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.BOTTOM);
        label.setBounds(250, 25, 100, 40);

        // Textfield Benutzer
        PlaceholderTextField benutzernameTextField = new PlaceholderTextField();
        benutzernameTextField.setBackground(whitebg);
        benutzernameTextField.setForeground(white);
        benutzernameTextField.setCaretColor(notSoDark);
        benutzernameTextField.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 12));
        benutzernameTextField.setBounds(200, 25, 200,30);
        benutzernameTextField.setPlaceholder("Benutzername");

        // Textfield Passwort
        PlaceholderPasswordField passwortPasswordField = new PlaceholderPasswordField();
        passwortPasswordField.setBackground(whitebg);
        passwortPasswordField.setForeground(white);
        passwortPasswordField.setCaretColor(notSoDark);
        passwortPasswordField.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 12));
        passwortPasswordField.setBounds(200,75, 200,30);
        passwortPasswordField.setPlaceholder("Passwort");

        // Passwort vergessen
        JButton passwortVergessenButton = new JButton();
        passwortVergessenButton.addActionListener(this);
        passwortVergessenButton.setText("<html><body>Passwort vergessen?</body></html>");
        passwortVergessenButton.setBackground(Color.darkGray);
        passwortVergessenButton.setForeground(white);
        passwortVergessenButton.setHorizontalTextPosition(JLabel.CENTER);
        passwortVergessenButton.setVerticalTextPosition(JLabel.CENTER);
        passwortVergessenButton.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 10));
        passwortVergessenButton.setVerticalAlignment(JLabel.CENTER);
        passwortVergessenButton.setHorizontalAlignment(JLabel.CENTER);
        passwortVergessenButton.setFocusable(false);
        passwortVergessenButton.setBorderPainted(false);
        passwortVergessenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        passwortVergessenButton.setBounds(225,120,150,20);

        // Angemeldet bleiben CheckBox
        JCheckBox angemeldetBleibenCheckBox = new JCheckBox();
        angemeldetBleibenCheckBox.setText("Angemeldet bleiben?");
        angemeldetBleibenCheckBox.addActionListener(this);
        angemeldetBleibenCheckBox.isEnabled();
        angemeldetBleibenCheckBox.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 8));
        angemeldetBleibenCheckBox.setBounds(235, 113, 200,20);


        //JButton "Login"
        JButton anmeldenButton = new JButton();
        anmeldenButton.addActionListener(this);
        anmeldenButton.setText("Login");
        anmeldenButton.setBackground(dunkelb);
        anmeldenButton.setForeground(dark);
        anmeldenButton.setHorizontalTextPosition(JLabel.CENTER);
        anmeldenButton.setVerticalTextPosition(JLabel.CENTER);
        anmeldenButton.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 10));
        anmeldenButton.setHorizontalAlignment(JLabel.CENTER);
        anmeldenButton.setVerticalAlignment(JLabel.CENTER);
        anmeldenButton.setFocusable(true);
        anmeldenButton.setBorderPainted(false);
        anmeldenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        anmeldenButton.setBounds(190, 0, 100, 30);

        // Button Abbrechen
        JButton abbrechenButton = new JButton();
        abbrechenButton.addActionListener(this);
        abbrechenButton.setText("Abbrechen");
        abbrechenButton.setBackground(notSoDark);
        abbrechenButton.setForeground(dark);
        abbrechenButton.setHorizontalTextPosition(JLabel.CENTER);
        abbrechenButton.setVerticalTextPosition(JLabel.CENTER);
        abbrechenButton.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 10));
        abbrechenButton.setHorizontalAlignment(JLabel.CENTER);
        abbrechenButton.setVerticalAlignment(JLabel.CENTER);
        abbrechenButton.setFocusable(false);
        abbrechenButton.setBorderPainted(false);
        abbrechenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        abbrechenButton.setBounds(310, 0, 100, 30);

        // Daten aktualisieren
        Foo.getDirectoryData();

        // Add für einzelnen Elemente innerhalb der Panels
        Text.add(label, BorderLayout.NORTH);
        Passwort.add(benutzernameTextField, BorderLayout.CENTER);
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

        benutzernameTextField.setPlaceholder("Benutzername");
        passwortPasswordField.setPlaceholder("Passwort");
        if (passwortVergessenButton instanceof AbstractButton) {
            AbstractButton btn = passwortVergessenButton;
            btn.setEnabled(false);

        }
        benutzernameTextField.addMouseListener(new MouseAdapter() {

        });

        benutzernameTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(benutzernameTextField.getText()+e.getKeyChar());

                if (Foo.userExistiertBereits(benutzernameTextField.getText())){
                    benutzernameTextField.setBackground(Foo.green);
                    if (passwortVergessenButton instanceof AbstractButton) {
                        AbstractButton btn = passwortVergessenButton;
                        btn.setEnabled(true);

                    }
                }else{
                    benutzernameTextField.setBackground(dark);
                    if (passwortVergessenButton instanceof AbstractButton) {
                        AbstractButton btn = passwortVergessenButton;
                        btn.setEnabled(false);

                    }
                }





            }
        });
        passwortVergessenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

                if (!benutzernameTextField.getText().isBlank()){
                    if (!passwortPasswordField.getText().isBlank()) {

                        if (Foo.AdminFileListe.contains(Path.of(Foo.adminPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile())) {
                            try {
                                Administrator mb = (Administrator) PersFile.laden(Path.of(Foo.adminPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile());
                                System.out.println("Datei gelesen");

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
                        if (Foo.KontrolleurFileListe.contains(Path.of(Foo.konPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile())) {
                            try {
                                Kontrolleur mb = (Kontrolleur) PersFile.laden(Path.of(Foo.konPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile());
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
                        if (Foo.SachbearbeiterFileListe.contains(Path.of(Foo.sbPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile())) {
                            try {
                                Sachbearbeiter mb = (Sachbearbeiter) PersFile.laden(Path.of(Foo.sbPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile());
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
                                    System.out.println("Starting Sachbearbeiter User-Interface.");
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

                if (benutzernameTextField.getText().isBlank()){
                    benutzernameTextField.addRedFlashEffectWhiteField();
                }
                if (!userExistiertBereits(benutzernameTextField.getText())){
                    benutzernameTextField.addRedFlashEffectWhiteField();
                }
                if (passwortPasswordField.getText().isBlank()){
                    passwortPasswordField.addRedFlashEffectWhiteField();
                }
                if (pass.passwordOk(passwortPasswordField.getText())){
                    passwortPasswordField.addRedFlashEffectWhiteField();
                }

            }
        });

    }

    public static void openLogin(GUI_Mama parent){
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
