package src.GUI;

import src.Foo;
import src.PersFile;
import src.users.Administrator;
import src.users.Kontrolleur;
import src.users.Sachbearbeiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.nio.file.Path;

public class LoginGUI extends JFrame {
    private JPanel mainPanel;
    private JPasswordField passwortPasswordField;
    private JTextField benutzernameTextField;
    private JButton abbrechenButton;
    private JButton anmeldenButton;
    private JCheckBox angemeldetBleibenCheckBox;
    private JButton passwortVergessenButton;

    public static void main(String[] args) {
        LoginGUI gui = new LoginGUI();
    }

    public LoginGUI(){
        setContentPane(mainPanel);
        setTitle("LoginWindow");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 400;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

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
                    benutzernameTextField.setBackground(Color.green);
                }else{
                    benutzernameTextField.setBackground(Color.lightGray);
                }
            }
        });

        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(200);
            }
        });

        anmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (Foo.adminList.contains(Path.of(Foo.adminPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile())){
                    try{
                        Administrator mb = (Administrator) PersFile.readOuttaFile(Path.of(Foo.adminPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile());
                        System.out.println("Datei gelesen");
                        if (mb.getPasswort().equals(passwortPasswordField.getPassword())){
                            System.out.println("Passwort stimmt");
                            Foo.currentAdmin = mb;
                            System.exit(111);
                        }


                    }catch (IOException | ClassNotFoundException io){

                    }
                }
                if(Foo.konList.contains(Path.of(Foo.konPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile())){
                    try{
                        Kontrolleur mb = (Kontrolleur) PersFile.readOuttaFile(Path.of(Foo.konPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile());
                        Foo.currentKontrolleur = mb;
                        System.out.println("Datei gelesen");
                        if (mb.getPasswort().equals(passwortPasswordField.getPassword())){
                            System.out.println("Passwort stimmt");
                            Foo.currentKontrolleur = mb;
                            System.exit(111);
                        }
                    }catch (IOException | ClassNotFoundException io){

                    }
                }
                if(Foo.sbList.contains(Path.of(Foo.sbPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile())){
                    try{
                        Sachbearbeiter mb = (Sachbearbeiter) PersFile.readOuttaFile(Path.of(Foo.sbPath + Foo.fileSeperator + benutzernameTextField.getText() + ".mb").toFile());
                        Foo.currentSachbearbeiter = mb;
                        System.out.println("Datei gelesen");
                        System.out.println(mb.getPasswort());
                        System.out.println(passwortPasswordField.getEchoChar());
                        if (mb.getPasswort().contains(passwortPasswordField.getPassword().toString())){
                            System.out.println("Passwort stimmt");
                            Foo.currentSachbearbeiter = mb;
                            System.exit(111);
                        }
                    }catch (IOException | ClassNotFoundException io){

                    }
                }

            }
        });

    }

    public static void login(){
        LoginGUI gui = new LoginGUI();
    }

}
