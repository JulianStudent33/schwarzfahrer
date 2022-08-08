package src.GUI;

import src.Foo;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Kontrolleur.KontrolleurGUI_alt;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.*;
import src.nickcode.pass;
import src.users.Kontrolleur;
import src.users.Sachbearbeiter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;
import static src.Foo.*;

public class RegisterGUI extends JFrame{
    int rollenSelection;
    boolean pwBestaetigt = false;
    boolean pflichtfelderAusgefüllt;
    private JComboBox benutzerBox;
    private JComboBox geschlechtBox;
    private PlaceholderPasswordField passwortTextField;
    private JPanel mainPanel;
    private JButton registrierenButton;
    private JButton abbrechenButton;
    private PlaceholderTextField benutzernameTextField;
    private PlaceholderTextField vornameTextField;
    private PlaceholderTextField nachnameTextField;
    private PlaceholderTextField telefonnummerTextField;
    private PlaceholderTextField emailTextField;
    private JSpinner daySpinner;
    private JSpinner monthSpinner;
    private JSpinner yearSpinner;
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

        //Felder die gefiltert werden

        FieldFilter filter = new FieldFilter();

        JTextField testField = new JTextField();

        testField = filter.createFilteredField(10); //Parameter die länge der Zahl
                                                                //sollte nur Zahlen annehmen

        benutzernameTextField.setDocument(new JTextFieldLimit(20));

        //Initialisieren von Datum-spinnern
        daySpinner.setValue(1);
        monthSpinner.setValue(1);
        yearSpinner.setValue(2000);

        daySpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (Integer.parseInt(daySpinner.getValue().toString()) > 31){
                    daySpinner.setValue(31);
                }
                if (Integer.parseInt(daySpinner.getValue().toString()) < 1){
                    daySpinner.setValue(1);
                }
            }
        });
        monthSpinner.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {

                System.out.println("Focus lost");
                if (Integer.parseInt(monthSpinner.getValue().toString()) == 4 || Integer.parseInt(monthSpinner.getValue().toString()) == 6 || Integer.parseInt(monthSpinner.getValue().toString()) == 9 || Integer.parseInt(monthSpinner.getValue().toString()) == 11){
                    if (Integer.parseInt(daySpinner.getValue().toString()) > 30){
                        daySpinner.setValue(30);
                    }
                }
                if (Integer.parseInt(monthSpinner.getValue().toString()) == 2){
                    if (Integer.parseInt(daySpinner.getValue().toString()) > 28){
                        daySpinner.setValue(28);
                    }
                }
            }
        });
        monthSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                if (Integer.parseInt(monthSpinner.getValue().toString()) > 12){
                    monthSpinner.setValue(12);
                }
                if (Integer.parseInt(monthSpinner.getValue().toString()) < 1){
                    monthSpinner.setValue(1);
                }

            }
        });
        yearSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {

                if (Integer.parseInt(yearSpinner.getValue().toString()) > LocalDate.now().getYear()){
                    yearSpinner.setValue(LocalDate.now().getYear());
                }
                if (Integer.parseInt(yearSpinner.getValue().toString()) <= 1900){
                    yearSpinner.setValue(1900);
                }
            }
        });

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
                                Foo.currentKontrolleur = new Kontrolleur(benutzernameTextField.getText(), passwortTextField.getText(),
                                        vornameTextField.getText(), nachnameTextField.getText(), geschlechtBox.getSelectedItem().toString(),
                                        telefonnummerTextField.getText(), emailTextField.getText().toLowerCase(Locale.ROOT), Integer.parseInt(daySpinner.getValue().toString()),
                                        Integer.parseInt(monthSpinner.getValue().toString()), Integer.parseInt(yearSpinner.getValue().toString()));
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
            benutzerBox.setBackground(Color.white);

            if (geschlechtBox.getItemCount() == 3) {
                geschlechtBox.setBackground(Color.white);

                if (!vornameTextField.getText().isBlank()) {
                    vornameTextField.setBackground(Color.white);

                    if (!nachnameTextField.getText().isBlank()) {
                        nachnameTextField.setBackground(Color.white);

                        if (!emailTextField.getText().isBlank()) {

                            if (emailTextField.getText().contains("@")) {
                                emailTextField.setBackground(Color.white);

                                if (!benutzernameTextField.getText().isBlank()) {

                                    if (!Foo.userExistiertBereits(benutzernameTextField.getText())) {
                                        benutzernameTextField.setBackground(Color.white);

                                        if (pass.passwordOk(passwortTextField.getText())) {
                                            String pwConfirm = JOptionPane.showInputDialog("Bestätige dein Passwort");

                                            if (pwConfirm.equals(passwortTextField.getText())) {
                                                passwortTextField.setBackground(Color.white);
                                                JOptionPane.showMessageDialog(new JDialog(), "Passwort bestätigt");
                                                pwBestaetigt = true;
                                                return true;
                                            } else {
                                                JOptionPane.showMessageDialog(new JDialog(), "Keine Übereinstimmung!");
                                                return false;
                                            }
                                        } else {
                                            JOptionPane.showMessageDialog(new JDialog(), "Passwort erfüllt nicht die formalen Bedingungen!");
                                            passwortTextField.setBackground(Foo.red);
                                            return false;
                                        }
                                    } else {
                                        benutzernameTextField.setText("");
                                        benutzernameTextField.setPlaceholder("Benutzername bereits vergeben");
                                        return false;
                                    }
                                } else {
                                    benutzernameTextField.setBackground(Foo.red);
                                    benutzernameTextField.setPlaceholder("Ein Benutzername braucht Zeichen :)");
                                    return false;
                                }
                            } else {
                                emailTextField.setBackground(Foo.red);
                                emailTextField.setText("");
                                emailTextField.setPlaceholder("Bitte eine gültige E-Mail eingeben");
                                return false;
                            }
                        } else {
                            emailTextField.setBackground(Foo.red);
                            emailTextField.setPlaceholder("E-Mail ist Pflicht");
                            return false;
                        }
                    } else {
                        nachnameTextField.setBackground(Foo.red);
                        nachnameTextField.setPlaceholder("Nachname ist Pflicht");
                        return false;
                    }
                } else {
                    vornameTextField.setBackground(Foo.red);
                    vornameTextField.setPlaceholder("Vorname ist Pflicht");
                    return false;
                }
            } else {
                benutzerBox.setBackground(Foo.red);
                return false;
            }
        } else {
            geschlechtBox.setBackground(Foo.red);
            return false;
        }
    }
    public static void register(){

        RegisterGUI gui = new RegisterGUI();

    }


}
