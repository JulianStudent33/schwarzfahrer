package src.GUI;

import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.PlaceholderPasswordField;
import src.GUI.elements.PlaceholderTextField;
import src.PersFile;
import src.users.Administrator;
import src.users.Kontrolleur;
import src.users.Sachbearbeiter;
import static src.Foo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class LoginGUI extends JFrame implements ActionListener {

    private JPanel mainPanel;
    private PlaceholderPasswordField passwortPasswordField;
    private PlaceholderTextField benutzernameTextField;
    private JButton abbrechenButton;
    private JButton anmeldenButton;
    private JCheckBox angemeldetBleibenCheckBox;
    private JButton passwortVergessenButton;



    public LoginGUI(){

        // Panelmanagement

        JPanel Bot = new JPanel();
        Bot.setBackground(dark);
        Bot.setPreferredSize(new Dimension(100, 100));
        Bot.setLayout(null);

        JPanel Text = new JPanel();
        Text.setBackground(dark);
        Text.setPreferredSize(new Dimension(200, 100));
        Text.setLayout(null);

        JPanel Passwort = new JPanel();
        Passwort.setBackground(dark);
        Passwort.setPreferredSize(new Dimension(600, 100));
        Passwort.setLayout(null);

        // Button
        JPanel AnmeldButton = new JPanel();
        AnmeldButton.setBackground(dark);
        AnmeldButton.setPreferredSize(new Dimension(100, 50));
        AnmeldButton.setLayout(null);

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
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 30));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(250, 50, 100, 35);

        // Textfield Benutzer
        PlaceholderTextField benutzernameTextField = new PlaceholderTextField();
        benutzernameTextField.setBackground(white);
        benutzernameTextField.setForeground(dark);
        benutzernameTextField.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 12));
        benutzernameTextField.setBounds(200, 25, 200,30);
        benutzernameTextField.setPlaceholder("Benutzername");

        // Textfield Passwort
        PlaceholderPasswordField passwortPasswordField = new PlaceholderPasswordField();
        passwortPasswordField.setBackground(white);
        passwortPasswordField.setForeground(dark);
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
        angemeldetBleibenCheckBox.setBounds(244, 150, 112,20);


        //JButton "Login"
        JButton anmeldenButton = new JButton();
        anmeldenButton.addActionListener(this);
        anmeldenButton.setText("Login");
        anmeldenButton.setBackground(dunkelb);
        anmeldenButton.setForeground(white);
        anmeldenButton.setHorizontalTextPosition(JLabel.CENTER);
        anmeldenButton.setVerticalTextPosition(JLabel.CENTER);
        anmeldenButton.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 10));
        anmeldenButton.setHorizontalAlignment(JLabel.CENTER);
        anmeldenButton.setVerticalAlignment(JLabel.CENTER);
        anmeldenButton.setFocusable(false);
        anmeldenButton.setBorderPainted(false);
        anmeldenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        anmeldenButton.setBounds(190, 10, 100, 30);

        // Button Abbrechen
        JButton abbrechenButton = new JButton();
        abbrechenButton.addActionListener(this);
        abbrechenButton.setText("Abbrechen");
        abbrechenButton.setBackground(notSoDark);
        abbrechenButton.setForeground(white);
        abbrechenButton.setHorizontalTextPosition(JLabel.CENTER);
        abbrechenButton.setVerticalTextPosition(JLabel.CENTER);
        abbrechenButton.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 10));
        abbrechenButton.setHorizontalAlignment(JLabel.CENTER);
        abbrechenButton.setVerticalAlignment(JLabel.CENTER);
        abbrechenButton.setFocusable(false);
        abbrechenButton.setBorderPainted(false);
        abbrechenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        abbrechenButton.setBounds(310, 10, 100, 30);

        // Daten aktualisieren
        Foo.getDirectoryData();

        // Add für einzelnen Elemente innerhalb der Panels
        Text.add(label, BorderLayout.NORTH);
        Passwort.add(benutzernameTextField, BorderLayout.CENTER);
        Passwort.add(passwortPasswordField, BorderLayout.CENTER);
        Passwort.add(passwortVergessenButton, BorderLayout.CENTER);
        Passwort.add(angemeldetBleibenCheckBox, BorderLayout.SOUTH);

        Bot.add(abbrechenButton, BorderLayout.SOUTH);
        Bot.add(anmeldenButton, BorderLayout.SOUTH);


        // Add für gesamte Panels
        this.add(Text, BorderLayout.NORTH);
        //this.add(Benutzer, BorderLayout.CENTER);
        this.add(Passwort, BorderLayout.CENTER);
        this.add(AngemeldetBleiben, BorderLayout.SOUTH);
        this.add(Bot, BorderLayout.SOUTH);

        // Gesamt Window

        setTitle("Login");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 600;
        int height = 400;
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(dark);
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
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
                    benutzernameTextField.setBackground(Color.lightGray);
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
                dispose();
                StartfensterGUI.startFenster();
            }
        });

        anmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (Foo.adminList.contains(Path.of(Foo.adminPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile())){
                    try{
                        Administrator mb = (Administrator) PersFile.laden(Path.of(Foo.adminPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile());
                        System.out.println("Datei gelesen");
                        if (Arrays.equals(mb.getPasswort().toCharArray(), passwortPasswordField.getPassword())){
                            System.out.println("Passwort stimmt");
                            Foo.currentAdmin = mb;
                            if (angemeldetBleibenCheckBox.isSelected()){
                                Foo.saveAngemeldetBleiben(true);
                            }else{
                                Foo.saveAngemeldetBleiben(false);
                            }
                            dispose();
                            AdminGUI.openAdminGUI();
                            System.out.println("Starting Admin User-Interface.");
                        }else{
                            System.out.println("Passwort falsch");
                            JOptionPane.showMessageDialog(new JDialog(), "Das eingegebene Passwort ist nicht korrekt");
                            passwortPasswordField.requestFocus();
                            passwortPasswordField.setText("");
                        }


                    }catch (IOException | ClassNotFoundException io){
                        dispose();
                        io.printStackTrace();
                        StartfensterGUI.startFenster();
                    }
                }
                if(Foo.konList.contains(Path.of(Foo.konPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile())){
                    try{
                        Kontrolleur mb = (Kontrolleur) PersFile.laden(Path.of(Foo.konPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile());
                        Foo.currentKontrolleur = mb;
                        System.out.println("Datei gelesen");
                        if (Arrays.equals(mb.getPasswort().toCharArray(), passwortPasswordField.getPassword())){
                            System.out.println("Passwort stimmt");
                            Foo.currentKontrolleur = mb;
                            if (angemeldetBleibenCheckBox.isSelected()){
                                Foo.saveAngemeldetBleiben(true);
                            }else{
                                Foo.saveAngemeldetBleiben(false);
                            }
                            dispose();
                            KontrolleurGUI.openKonGUI();
                            System.out.println("Starting Kontrolleur User-Interface.");
                        }
                    }catch (IOException | ClassNotFoundException io){
                        dispose();
                        io.printStackTrace();
                        StartfensterGUI.startFenster();
                    }
                }
                if(Foo.sbList.contains(Path.of(Foo.sbPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile())){
                    try{
                        Sachbearbeiter mb = (Sachbearbeiter) PersFile.laden(Path.of(Foo.sbPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile());
                        Foo.currentSachbearbeiter = mb;
                        System.out.println("Datei gelesen");
                        if (Arrays.equals(mb.getPasswort().toCharArray(), passwortPasswordField.getPassword())){
                            System.out.println("Passwort stimmt");
                            Foo.currentSachbearbeiter = mb;
                            if (angemeldetBleibenCheckBox.isSelected()){
                                // Foo.saveAngemeldetBleiben(true);
                            }else{
                                // Erneuter Aufruf des L&F sodass bei Rückgang auf vorheriges Fenster, das L&F bestehen bleibt            // Foo.saveAngemeldetBleiben(false);
                            }
                            dispose();
                            SachbearbeiterGUI.openSBGUI();
                            System.out.println("Starting Sachbearbeiter User-Interface.");
                        }
                    }catch (IOException | ClassNotFoundException io){
                        dispose();
                        io.printStackTrace();
                        StartfensterGUI.startFenster();
                    }
                }

            }
        });

    }

    public static void openLogin(){
        LoginGUI gui = new LoginGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
