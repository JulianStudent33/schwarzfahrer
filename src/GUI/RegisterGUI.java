package src.GUI;

import src.Foo;
import src.nickcode.pass;
import src.users.Kontrolleur;
import src.users.Sachbearbeiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class RegisterGUI extends JFrame{
    int selection;
    boolean pwBestaetigt = false;
    private JComboBox comboBox1;
    private JTextField benutzernameTextField;
    private JTextField passwortTextField;
    private JPanel mainPanel;
    private JButton registrierenButton;
    private JButton beendenButton;
    private JLabel passwortMussAusSowohlLabel;


    public RegisterGUI(){

        setContentPane(mainPanel);
        setTitle("Registration");
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
                dispose();
                StartFensterGUI.openStartFenster();
            }
        });

        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (comboBox1.getSelectedItem() == comboBox1.getItemAt(0)){
                    selection = 1; //
                }else{
                    selection = 2;
                }
                if (!benutzernameTextField.getText().isBlank()) {
                    if (!Foo.userExistiertBereits(benutzernameTextField.getText())) {
                        if (pass.passwordOk(passwortTextField.getText())) {
                            String pwConfirm = JOptionPane.showInputDialog("Bestätige dein Passwort");
                            if (pwConfirm.equals(passwortTextField.getText())) {
                                JOptionPane.showMessageDialog(new JDialog(), "Passwort bestätigt");
                                pwBestaetigt = true;
                                try {
                                    switch (selection){
                                        case 1: Foo.currentKontrolleur = new Kontrolleur(benutzernameTextField.getText(), passwortTextField.getText());
                                        Foo.angemeldet = true;
                                        dispose();
                                        KontrolleurGUI.openKonGUI();
                                        break;
                                        case 2: Foo.currentSachbearbeiter = new Sachbearbeiter(benutzernameTextField.getText(), passwortTextField.getText());
                                        Foo.angemeldet = true;
                                        dispose();
                                        SachbearbeiterGUI.openSBGUI();
                                        break;
                                    }
                                } catch (IOException ex) {
                                    dispose();
                                    StartFensterGUI.openStartFenster();
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
                        benutzernameTextField.setText("Benutzername bereits vergeben");
                    }
                } else {
                    benutzernameTextField.setText("Ein Benutzername braucht Zeichen :)");
                }
            }
        });



    }


    public static void register(){

        RegisterGUI gui = new RegisterGUI();

    }


}
