package src.GUI;

import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.elements.PlaceholderPasswordField;
import src.GUI.elements.PlaceholderTextField;
import src.nickcode.pass;
import src.users.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class firstRegistrationGUI extends JFrame {
    public boolean pwBestaetigt = false;
    private PlaceholderTextField benutzernameTextField;
    private PlaceholderPasswordField passwortTextField;
    private JButton registrierenButton;
    private JButton abbrechenButton;
    private JPanel mainPanel;
    private JLabel text1;

    public firstRegistrationGUI()  {
    setContentPane(mainPanel);
    setTitle("First Registration");
    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    int width = 700;
    int height = 200;
    this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setVisible(true);
        benutzernameTextField.setPlaceholder("Benutzername");
        passwortTextField.setPlaceholder("Passwort");
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
                    benutzernameTextField.setBackground(Color.red);
                }else{
                    benutzernameTextField.setBackground(Color.green);
                }
            }
        });
        passwortTextField.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                passwortTextField.setText("");
            }
        });
        passwortTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {

            }
            @Override
            public void keyReleased(KeyEvent e) {
                if(pass.passwordOk(passwortTextField.getText())){
                    passwortTextField.setBackground(Color.green);
                }else{
                    passwortTextField.setBackground(Color.red);
                }
            }
        });
        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                start.startFenster();
            }
        });

        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!benutzernameTextField.getText().isBlank()) {
                    if (!Foo.userExistiertBereits(benutzernameTextField.getText())) {
                        if (pass.passwordOk(passwortTextField.getText())) {
                            String pwConfirm = JOptionPane.showInputDialog("Bestätige dein Passwort");
                            if (pwConfirm.equals(passwortTextField.getText())) {
                                JOptionPane.showMessageDialog(new JDialog(), "Passwort bestätigt");
                                pwBestaetigt = true;
                                try {
                                    Foo.currentAdmin = new Administrator(benutzernameTextField.getText(), passwortTextField.getText());
                                    pwBestaetigt = true;
                                    Foo.angemeldet = true;
                                    dispose();
                                    AdminGUI.openAdminGUI();
                                } catch (IOException ex) {
                                    dispose();
                                    start.startFenster();
                                    ex.printStackTrace();
                                    throw new RuntimeException(ex);
                                }
                            }else{
                                JOptionPane.showMessageDialog(new JDialog(), "Keine Übereinstimmung!");
                            }
                        }else{

                            JOptionPane.showMessageDialog(new JDialog(), "Passwort erfüllt nicht die formalen Bedingungen!");
                        }
                    } else {
                        benutzernameTextField.setBackground(Color.red);
                        benutzernameTextField.setPlaceholder("Benutzername bereits vergeben");
                    }
                } else {
                    benutzernameTextField.setBackground(Color.red);
                    benutzernameTextField.setPlaceholder("Ein Benutzername braucht Zeichen :)");
                }
            }
        });



    }

    public static void firstRegister(){

        firstRegistrationGUI gui = new firstRegistrationGUI();

    }




}





