package src.GUI;

import src.Foo;
import src.nickcode.pass;
import src.users.Administrator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class firstRegistrationGUI extends JFrame {
    private boolean pwBestaetigt = false;
    private JTextField benutzernameTextField;
    private JTextField passwortTextField;
    private JButton registrierenButton;
    private JButton beendenButton;
    private JPanel mainPanel;

    public firstRegistrationGUI(){
    setContentPane(mainPanel);
    setTitle("First Registration");
    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    int width = 700;
    int height = 200;
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
        beendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(200);
            }
        });
        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("TEST" + benutzernameTextField.getText().toString());


                if (!benutzernameTextField.getText().isBlank()) {
                    if (!Foo.userExistiertBereits(benutzernameTextField.getText())) {
                        if (pass.passwordOk(passwortTextField.getText())) {
                            String pwConfirm = JOptionPane.showInputDialog("Bestätige dein Passwort");
                            if (pwConfirm.equals(passwortTextField.getText())) {
                                JOptionPane.showMessageDialog(new JDialog(), "Passwort bestätigt");
                                pwBestaetigt = true;
                                try {
                                    Foo.currentAdmin = new Administrator(benutzernameTextField.getText(), passwortTextField.getText());

                                } catch (IOException ex) {
                                    dispose();
                                    throw new RuntimeException(ex);
                                } finally {
                                    dispose();
                                }
                            }
                        }else{
                            JOptionPane.showMessageDialog(new JDialog(), "Passwort erfüllt nicht die formalen Bedingungen!");
                        }
                    } else {
                        benutzernameTextField.setText("Benutzername bereits vergeben");
                    }
                } else {
                        benutzernameTextField.setText("Ein Benutzername braucht Zeichen :)");
                }
            }
        });

}

    public static void main(String[] args) {
        firstRegistrationGUI gui1 = new firstRegistrationGUI();
    }

}
