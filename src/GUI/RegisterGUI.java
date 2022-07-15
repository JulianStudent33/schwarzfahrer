package src.GUI;

import src.Foo;
import src.GUI.Kontrolleur.KontrolleurGUI;
import src.GUI.elements.*;
import src.nickcode.pass;
import src.users.Kontrolleur;
import src.users.Sachbearbeiter;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

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
    private PlaceholderTextField tagField;
    private PlaceholderTextField monatField;
    private PlaceholderTextField jahrField;
    private JSpinner daySpinner;
    private JSpinner monthSpinner;
    private JSpinner yearSpinner;
    SizeFilter nameFilter; //20



    public RegisterGUI(){

        setContentPane(mainPanel);
        setTitle("Registration");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1000;
        int height = 350;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        try {
            UIManager.setLookAndFeel(UIManager.createLookAndFeel("Windows"));
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        setVisible(true);
        vornameTextField.setPlaceholder("Vorname*");
        nachnameTextField.setPlaceholder("Nachname*");
        nachnameTextField.setPreferredSize(new Dimension(30, 10));
        benutzernameTextField.setPlaceholder("Benutzername*");
        passwortTextField.setPlaceholder("Passwort*");
        telefonnummerTextField.setPlaceholder("Telefonnummer");

        emailTextField.setPlaceholder("E-Mail Adresse*");

        daySpinner.setValue(1);
        monthSpinner.setValue(1);
        yearSpinner.setValue(2000);
        benutzernameTextField.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                benutzernameTextField.setText("");
            }
        });
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

                if (Integer.parseInt(monthSpinner.getValue().toString()) == 4 || Integer.parseInt(monthSpinner.getValue().toString()) == 6 || Integer.parseInt(monthSpinner.getValue().toString()) == 9 || Integer.parseInt(monthSpinner.getValue().toString()) == 11){
                    if (Integer.parseInt(daySpinner.getValue().toString()) > 30){
                        monthSpinner.setValue(30);
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
        /*
        SizeFilter sizeFilter2 = new SizeFilter(2);
        SizeFilter sizeFilter4 = new SizeFilter(4);
        SizeFilter sizeFilter15 = new SizeFilter(15);


        ChainableFilter chainFilterDay = new ChainableFilter();
        chainFilterDay.addFilter(numberFilter);
        ((AbstractDocument) tagField.getDocument()).setDocumentFilter(chainFilterDay);

        ChainableFilter chainFilterMonth = new ChainableFilter();
        chainFilterMonth.addFilter(numberFilter);
        chainFilterMonth.addFilter(sizeFilter2);
        ((AbstractDocument) monatField.getDocument()).setDocumentFilter(chainFilterMonth);

        ChainableFilter chainFilterYear = new ChainableFilter();
        chainFilterYear.addFilter(numberFilter);
        chainFilterYear.addFilter(sizeFilter4);
        ((AbstractDocument) jahrField.getDocument()).setDocumentFilter(chainFilterYear);



        */
        NumberFilter numberFilter = new NumberFilter();
        ((AbstractDocument)telefonnummerTextField.getDocument()).setDocumentFilter(numberFilter);

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
        geschlechtBox.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {

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
                start.startFenster();
            }
        });

        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (benutzerBox.getSelectedItem() == benutzerBox.getItemAt(0)){
                    rollenSelection = 1; //
                }else{
                    rollenSelection = 2;
                }

                if(pflichtfelderAusgefüllt){

                }
                if (!benutzernameTextField.getText().isBlank()) {

                    if (!Foo.userExistiertBereits(benutzernameTextField.getText())) {

                        if (pass.passwordOk(passwortTextField.getText())) {
                            String pwConfirm = JOptionPane.showInputDialog("Bestätige dein Passwort");

                            if (pwConfirm.equals(passwortTextField.getText())) {
                                JOptionPane.showMessageDialog(new JDialog(), "Passwort bestätigt");
                                pwBestaetigt = true;

                                try {
                                    switch (rollenSelection){
                                        case 1: Foo.currentKontrolleur = new Kontrolleur(benutzernameTextField.getText(), passwortTextField.getText(),
                                                vornameTextField.getText(), nachnameTextField.getText(), geschlechtBox.getSelectedItem().toString(),
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
    private boolean pflichtAusgefüllt(){
        if (!vornameTextField.getText().isBlank()) {

            if (!nachnameTextField.getText().isBlank()) {

                if (!emailTextField.getText().isBlank()) {

                    if(emailTextField.getText().contains("@")) {


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
                                        return false;
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(new JDialog(), "Passwort erfüllt nicht die formalen Bedingungen!");
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
                    }else{
                        emailTextField.setBackground(Foo.red);
                        emailTextField.setToolTipText("Bitte gültige E-Mail eingeben");
                        emailTextField.setText("Bitte gültige E-Mail eingeben");
                        return false;
                    }
                }else{
                    emailTextField.setBackground(Foo.red);
                    emailTextField.setPlaceholder("E-Mail ist Pflicht");
                    return false;
                }
            }else{
                nachnameTextField.setBackground(Foo.red);
                nachnameTextField.setPlaceholder("Nachname ist Pflicht");
                return false;
            }
        }else{
            vornameTextField.setBackground(Foo.red);
            vornameTextField.setPlaceholder("Vorname ist Pflicht");
            return false;
        }
    }

    public static void register(){

        RegisterGUI gui = new RegisterGUI();

    }


}
