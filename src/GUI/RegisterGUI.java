package src.GUI;

import src.Foo;
import src.GUI.Kontrolleur.KontrolleurGUI;
import src.GUI.elements.PlaceholderTextField;
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
    private JComboBox benutzerBox;
    private JComboBox geschlechtBox;
    private JPasswordField passwortTextField;
    private JPanel mainPanel;
    private JButton registrierenButton;
    private JButton abbrechenButton;
    private PlaceholderTextField benutzernameTextField;
    private PlaceholderTextField vornameTextField;
    private PlaceholderTextField nachnameTextField;
    private PlaceholderTextField zusatznameTextField;
    private PlaceholderTextField telefonnummerTextField;
    private PlaceholderTextField emailTextField;



    public RegisterGUI(){

        setContentPane(mainPanel);
        setTitle("Registration");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 350;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.createLookAndFeel("Windows"));
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        setVisible(true);
        vornameTextField.setPlaceholder("Vorname");
        nachnameTextField.setPlaceholder("Nachname");
        benutzernameTextField.setPlaceholder("Benutzername");
        zusatznameTextField.setPlaceholder("Namenszusatz");
        telefonnummerTextField.setPlaceholder("Telefonnummer");
        emailTextField.setPlaceholder("E-Mail Adresse");
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
                    float[] values = new float[3];
                    benutzernameTextField.setBackground(Foo.red);
                }else{
                    benutzernameTextField.setBackground(Foo.green);
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
                    passwortTextField.setBackground(Foo.green);
                }else{
                    passwortTextField.setBackground(Foo.red);
                }
            }
        });
        abbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                StartFensterGUI.openStartFenster();
            }
        });

        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (benutzerBox.getSelectedItem() == benutzerBox.getItemAt(0)){
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
                                String s;
                                if(zusatznameTextField.getText().isBlank()){
                                    s = null;
                                }else{
                                    s = zusatznameTextField.getText();
                                }
                                try {
                                    switch (selection){
                                        case 1: Foo.currentKontrolleur = new Kontrolleur(benutzernameTextField.getText(), passwortTextField.getText(),
                                                vornameTextField.getText(), nachnameTextField.getText(), s, geschlechtBox.getSelectedItem().toString(),
                                                telefonnummerTextField.getText(), emailTextField.getText());
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
                        benutzernameTextField.setText("");
                        benutzernameTextField.setPlaceholder("Benutzername bereits vergeben");
                    }
                } else {
                    benutzernameTextField.setBackground(Foo.red);
                    benutzernameTextField.setPlaceholder("Ein Benutzername braucht Zeichen :)");
                }
            }
        });



    }


    public static void register(){

        RegisterGUI gui = new RegisterGUI();

    }


}
