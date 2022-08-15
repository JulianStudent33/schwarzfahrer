package src.GUI;

import src.Foo;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.*;
import src.nickcode.pass;
import src.roles.Kontrolleur;
import src.roles.Sachbearbeiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Locale;

public class RegisterGUI extends JFrame{
    int rollenSelection;
    boolean pwBestaetigt = false;
    boolean pflichtfelderAusgefüllt;
    private customComboBox benutzerBox;
    private customComboBox geschlechtBox;
    private PlaceholderPasswordField passwortTextField;
    private JPanel mainPanel;
    private JButton registrierenButton;
    private JButton abbrechenButton;
    private PlaceholderTextField benutzernameTextField;
    private PlaceholderTextField vornameTextField;
    private PlaceholderTextField nachnameTextField;
    private PlaceholderTextField telefonnummerTextField;
    private PlaceholderTextField emailTextField;
    private JToggleButton datumButton;
    private PlaceholderTextField datumTextField;


    SizeFilter nameFilter; //20
    NumberFilter numberFilter;
    LetterFilter letterFilter;
    JTextFieldLimit nameFieldLimit;



    public RegisterGUI(){

        setContentPane(mainPanel);
        setTitle("Registration");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1000;
        int height = 350;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);



        //Placeholder
        //vornameTextField.setPlaceholder("*Vorname*");
        nachnameTextField.setPlaceholder("*Nachname*");
        benutzernameTextField.setPlaceholder("*Benutzername*");
        passwortTextField.setPlaceholder("*Passwort*");
        telefonnummerTextField.setPlaceholder("Telefonnummer");
        emailTextField.setPlaceholder("*E-Mail Adresse*");
        datumTextField.setPlaceholder("tt-MM-jjjj");
        datumTextField.setEnabled(false);
        //Felder die gefiltert werden

        FieldFilter filter = new FieldFilter();

        JTextField testField = new JTextField();

        testField = filter.createFilteredField(10); //Parameter die länge der Zahl
                                                                //sollte nur Zahlen annehmen

        benutzernameTextField.setDocument(new JTextFieldLimit(20));



        benutzerBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (benutzerBox.getItemAt(0).equals("Rolle")){
                    benutzerBox.removeItemAt(0);
                }
            }
        });
        geschlechtBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (geschlechtBox.getItemAt(0).equals("Gender")){
                    geschlechtBox.removeItemAt(0);
                }
            }
        });

        datumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (!datumTextField.getText().isBlank()){
                    DatePick calender = new DatePick((JFrame) datumButton.getRootPane().getParent(), datumTextField.getText());
                    String txt = calender.Set_Picked_Date();
                    if (txt==""){
                        datumTextField.setEnabled(false);
                    }else{
                        datumTextField.setText(calender.Set_Picked_Date());
                    }
                }else{
                    DatePick calender = new DatePick((JFrame) datumButton.getRootPane().getParent(), null);
                    String txt = calender.Set_Picked_Date();
                    if (txt==""){
                        datumTextField.setEnabled(false);
                    }else{
                        datumTextField.setText(calender.Set_Picked_Date());
                    }
                }

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
                StartfensterGUI.startFenster();
            }
        });

        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (benutzerBox.getSelectedItem() == benutzerBox.getItemAt(0)) {
                    rollenSelection = 1; //
                } else {
                    rollenSelection = 2;
                }

                if (pflichtAusgefüllt()) {

                    try {
                        switch (rollenSelection) {
                            case 1:

                                int[] date = Dateswitcher.datetonumber(datumTextField.getText());

                                Foo.currentKontrolleur = new Kontrolleur(benutzernameTextField.getText(), passwortTextField.getText(),
                                        vornameTextField.getText(), nachnameTextField.getText(), geschlechtBox.getSelectedItem().toString(),
                                        telefonnummerTextField.getText(), emailTextField.getText().toLowerCase(Locale.ROOT), date);
                                Foo.angemeldet = true;
                                dispose();
                                KontrolleurGUI.openKonGUI();
                                break;
                            case 2:
                                Foo.currentSachbearbeiter = new Sachbearbeiter(benutzernameTextField.getText(), passwortTextField.getText());
                                Foo.angemeldet = true;
                                dispose();
                                SachbearbeiterGUI.openSBGUI();
                                break;
                        }
                    } catch (IOException ex) {
                        dispose();
                        StartfensterGUI.startFenster();
                        ex.printStackTrace();
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        setVisible(true);
    }
    private boolean pflichtAusgefüllt() {
        if (benutzerBox.getItemCount() == 2) {
            if (geschlechtBox.getItemCount() == 3) {
                if (!vornameTextField.getText().isBlank()) {
                    if (!nachnameTextField.getText().isBlank()) {
                        if (!datumTextField.getText().isBlank()){
                        if (!emailTextField.getText().isBlank()) {
                            if (emailTextField.getText().contains("@")) {
                                if (!benutzernameTextField.getText().isBlank()) {
                                    if (!Foo.userExistiertBereits(benutzernameTextField.getText())) {
                                        if (pass.passwordOk(passwortTextField.getText())) {
                                            String pwConfirm = JOptionPane.showInputDialog("Bestätige dein Passwort");
                                            if (pwConfirm.equals(passwortTextField.getText())) {
                                                JOptionPane.showMessageDialog(new JDialog(), "Passwort bestätigt");
                                                pwBestaetigt = true;
                                                return true;
                                            } else {
                                                JOptionPane.showMessageDialog(new JDialog(), "Keine Übereinstimmung!");
                                            }
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
        if (benutzerBox.getItemCount() == 3) {
            benutzerBox.addRedFlashEffect();
        }
        if (geschlechtBox.getItemCount() == 4) {
            geschlechtBox.addRedFlashEffect();
        }
        if (vornameTextField.getText().isBlank()) {
            vornameTextField.addRedFlashEffect();
        }
        if (nachnameTextField.getText().isBlank()) {
            nachnameTextField.addRedFlashEffect();
        }
        if (datumTextField.getText().isBlank()){
            datumTextField.addRedFlashEffect();
        }
        if (emailTextField.getText().isBlank()) {
            emailTextField.addRedFlashEffect();
        }
        if (!emailTextField.getText().contains("@")) {
            emailTextField.setText("");
            emailTextField.addRedFlashEffect();
            emailTextField.setPlaceholder("Bitte eine gültige E-Mail eingeben");
        }
        if (Foo.userExistiertBereits(benutzernameTextField.getText())) {
            benutzernameTextField.setText("");
            benutzernameTextField.addRedFlashEffect();
            benutzernameTextField.setPlaceholder("Benutzername bereits vergeben");
        }
        if (benutzernameTextField.getText().isBlank()) {
            benutzernameTextField.addRedFlashEffect();
        }
        if (!pass.passwordOk(passwortTextField.getText())) {
            passwortTextField.addRedFlashEffect();
        }



        return false;
    }












    public static void register(){
        Foo.getDirectoryData();
        RegisterGUI gui = new RegisterGUI();

    }


}
