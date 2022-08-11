package src.GUI.Kon;

import com.formdev.flatlaf.FlatDarkLaf;
import src.Adresse;
import src.Foo;
import src.GUI.elements.DatePick;
import src.GUI.elements.Dateswitcher;
import src.GUI.elements.PlaceholderTextField;
import src.users.Kontrolleur;
import src.users.Schwarzfahrer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SchwarzfahrtErfassenGUI extends JFrame{

    private static Kontrolleur currentUser;
    private static Schwarzfahrer currentSf;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private PlaceholderTextField linieTextField;
    private PlaceholderTextField ausweisnummerTextField;
    private JToggleButton suchenToggleButton;
    private JComboBox geschlechtBox;
    private PlaceholderTextField vornameTextField;
    private PlaceholderTextField nachnameTextField;
    private PlaceholderTextField geburtsortTextField;
    private PlaceholderTextField emailTextField;
    private PlaceholderTextField telefonTextField;
    private PlaceholderTextField strasseTextField;
    private PlaceholderTextField hausnummerTextField;
    private PlaceholderTextField plzTextField;
    private PlaceholderTextField ortTextField;
    private PlaceholderTextField zusatzTextField;
    private JComboBox landComboBox;
    private JToggleButton speichernToggleButton;
    private JLabel nameLabel;
    private JToggleButton abbrechenToggleButton;
    private JLabel linieLabel;
    private JLabel datumUhrzeitLabel;
    private JToggleButton datumButton2;
    private PlaceholderTextField datumTextField2;
    private JToggleButton datumButton1;
    private PlaceholderTextField datumTextField1;
    private JComboBox stundenBox;
    private JComboBox minutenBox;

    public SchwarzfahrtErfassenGUI(){
        this.currentUser = KontrolleurGUI.currentUser;
        setContentPane(mainPanel);
        setTitle("Kontrolleur Menü");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1000;
        int height = 400;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }


        datumTextField1.setEnabled(false);
        datumTextField1.setText(Foo.currentDate);
        System.out.println(" Time: " + Foo.currentTime + "substr: " + Foo.currentTime.charAt(0));
        stundenBox.setSelectedIndex(Integer.valueOf(Foo.currentTime.substring(0, 1)));
        minutenBox.setSelectedIndex(Integer.valueOf(Foo.currentTime.substring(3, 4)));
        datumTextField2.setEnabled(false);
        linieTextField.setPlaceholder("z.B. S41");




        nameLabel.setText("Angemeldet als " + currentUser.getVorname() + " " + currentUser.getName() + " (" + currentUser.getMitarbeiternummer() + ").");


        setVisible(true);


        //Eventlistener


        datumButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                DatePick calender = new DatePick((JFrame) datumButton1.getRootPane().getParent());
                String txt = calender.Set_Picked_Date();
                if (txt==""){
                    datumTextField1.setEnabled(false);
                }else{
                    datumTextField1.setText(calender.Set_Picked_Date());
                }


            }
        });


        datumButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                DatePick calender = new DatePick((JFrame) datumButton2.getRootPane().getParent());
                String txt = calender.Set_Picked_Date();
                if (txt==""){
                    datumTextField2.setEnabled(false);
                }else{
                    datumTextField2.setText(calender.Set_Picked_Date());
                }


            }
        });




        landComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (landComboBox.getSelectedIndex() == 1){
                    landComboBox.setSelectedIndex(0);
                }
            }
        });



        //Button Funktion Zuweisung



        suchenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Suchen nach Schwarzfahrer anhand von Ausweisnummer
                try {
                    currentSf = currentUser.schwarzfahrerSuchen(ausweisnummerTextField.getText());
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                if (currentSf == null){
                    ausweisnummerTextField.setBackground(Foo.red);
                    Foo.okWindow("Keine Treffer");
                }else{
                    ausweisnummerTextField.setBackground(Foo.green);
                    autofill();
                }


            }
        });

        speichernToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pflichtAusgefuellt()){
                    Adresse neueAdresse = new Adresse(landComboBox.getSelectedItem().toString(), plzTextField.getText(), ortTextField.getText(), strasseTextField.getText(), hausnummerTextField.getText(), zusatzTextField.getText(), landComboBox.getSelectedIndex());
                    try {

                        int date[] = Dateswitcher.datetonumber(datumTextField2.getText());


                        new Schwarzfahrer(ausweisnummerTextField.getText(), geburtsortTextField.getText(), neueAdresse, vornameTextField.getText(), nachnameTextField.getText(), geschlechtBox.getSelectedItem().toString(), telefonTextField.getText(), emailTextField.getText(), date[0], date[1], date[2]);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        throw new RuntimeException(ex);
                    }
                    dispose();
                }else{
                   // OkayWindow.openOkayWindow("Es wurden nicht alle Pflichtfelder ausgefüllt");
                }

            }
        });

        abbrechenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentSf = null;
                dispose();
            }
        });
    }

    void autofill(){
        if (currentSf.getGeschlecht() == "M"){
            geschlechtBox.setSelectedIndex(0);
        } else if (currentSf.getGeschlecht() == "W") {
            geschlechtBox.setSelectedIndex(1);
        } else if (currentSf.getGeschlecht() == "D"){
            geschlechtBox.setSelectedIndex(2);
        }

        vornameTextField.setText(currentSf.getVorname());
        nachnameTextField.setText(currentSf.getName());
        /*
        daySpinner.setValue(currentSf.getGeburtsTag());
        monthSpinner.setValue(currentSf.getGeburtsMonat());
        yearSpinner.setValue(currentSf.getGeburtsJahr());
       */
        geburtsortTextField.setText(currentSf.getGeburtsort());
        emailTextField.setText(currentSf.getEmail());
        telefonTextField.setText(currentSf.getTelefonnummer());
        strasseTextField.setText(currentSf.getAdresse().getStrasse());
        hausnummerTextField.setText(currentSf.getAdresse().getHausnummer());
        plzTextField.setText(currentSf.getAdresse().getPLZ());
        ortTextField.setText(currentSf.getAdresse().getOrt());
        zusatzTextField.setText(currentSf.getAdresse().getZusatz());
        landComboBox.setSelectedIndex(currentSf.getAdresse().getLandIndex());
    }

    private boolean pflichtAusgefuellt(){
        if (!datumTextField1.getText().isBlank()){
            if (!linieTextField.getText().isBlank()){
                if (!ausweisnummerTextField.getText().isBlank()){
                    if (!vornameTextField.getText().isBlank()){
                        if (!nachnameTextField.getText().isBlank()){
                            if (!telefonTextField.getText().isBlank()){
                                if (!strasseTextField.getText().isBlank()){
                                    if (!hausnummerTextField.getText().isBlank()){
                                        if (!plzTextField.getText().isBlank()){
                                            if (!ortTextField.getText().isBlank()){
                                                return true;
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


        if(datumTextField1.getText().isBlank()){

        }
        if (linieTextField.getText().isBlank()){
            linieTextField.addRedFlashEffect();
        }
        if (ausweisnummerTextField.getText().isBlank()){
            ausweisnummerTextField.addRedFlashEffect();

        }
        if (vornameTextField.getText().isBlank()){
            vornameTextField.addRedFlashEffect();
        }
        if (nachnameTextField.getText().isBlank()){
            nachnameTextField.addRedFlashEffect();
        }
        if (telefonTextField.getText().isBlank()){
            telefonTextField.addRedFlashEffect();
        }
        if (strasseTextField.getText().isBlank()){
            strasseTextField.addRedFlashEffect();
        }
        if (hausnummerTextField.getText().isBlank()){
            hausnummerTextField.addRedFlashEffect();
        }
        if (plzTextField.getText().isBlank()){
            plzTextField.addRedFlashEffect();
        }
        if (ortTextField.getText().isBlank()){
            ortTextField.addRedFlashEffect();
        }








        return false;
    }
    public static void open() {
        SchwarzfahrtErfassenGUI gui = new SchwarzfahrtErfassenGUI();
    }

    public static void main(String[] args) {
        open();

    }
}
