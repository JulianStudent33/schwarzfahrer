package src.GUI;

import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Kontrolleur.KontrolleurGUI_alt;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.PlaceholderPasswordField;
import src.GUI.elements.PlaceholderTextField;
import src.PersFile;
import src.users.Administrator;
import src.users.Kontrolleur;
import src.users.Sachbearbeiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class LoginGUI extends JFrame {
    private JPanel mainPanel;
    private PlaceholderPasswordField passwortPasswordField;
    private PlaceholderTextField benutzernameTextField;
    private JButton abbrechenButton;
    private JButton anmeldenButton;
    private JCheckBox angemeldetBleibenCheckBox;
    private JButton passwortVergessenButton;

//test

    public LoginGUI(){
        setContentPane(mainPanel);
        setTitle("LoginWindow");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 400;
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
            public void mouseReleased(MouseEvent e){
                benutzernameTextField.setText("");
            }
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
                start.startFenster();
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
                                //Foo.saveAngemeldetBleiben(true);
                            }else{
                                //Foo.saveAngemeldetBleiben(false);
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
                        start.startFenster();
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
                        start.startFenster();
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
                        start.startFenster();
                    }
                }

            }
        });

    }

    public static void openLogin(){
        LoginGUI gui = new LoginGUI();
    }

}
