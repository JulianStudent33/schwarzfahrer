package src.GUI.Kon;

import com.formdev.flatlaf.FlatDarkLaf;
import src.Adresse;
import src.Foo;
import src.GUI.Parent_GUI;
import src.GUI.elements.*;
import src.Rollen.Kontrolleur;
import src.Rollen.Schwarzfahrer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

import static src.Foo.*;

public class SchwarzfahrtErfassenGUI extends Parent_GUI {

    public static boolean isOpen = false;
    private static Kontrolleur currentUser;
    private static Schwarzfahrer currentSf;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private PlaceholderTextField linieTextField;
    private PlaceholderTextField ausweisnummerTextField;
    private JToggleButton suchenToggleButton;
    private customComboBox geschlechtBox;
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
    private customComboBox landComboBox;
    private JToggleButton speichernToggleButton;
    private JLabel nameLabel;
    private JToggleButton abbrechenToggleButton;
    private JLabel linieLabel;
    private JLabel datumUhrzeitLabel;
    private customButton datumButton2;
    private customButton datumButton1;
    private JComboBox stundenBox;
    private JComboBox minutenBox;
    private JCheckBox bereitsBezahltCheckBox;
    private JToggleButton löschenToggleButton;

    public SchwarzfahrtErfassenGUI(Parent_GUI parent){
        parentGUI = parent;

        this.currentUser = (Kontrolleur) parentGUI.currentUser;
        setContentPane(mainPanel);
        setTitle("Kontrolleur Menü");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1000;
        int height = 400;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        setResizable(false);

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }



        datumButton1.setText(Foo.getCurrentDate());
        stundenBox.setSelectedIndex(java.util.Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        minutenBox.setSelectedIndex(java.util.Calendar.getInstance().get(Calendar.MINUTE));
        linieTextField.setPlaceholder("z.B. S41");




        nameLabel.setText("Angemeldet als " + currentUser.getVorname() + " " + currentUser.getNachname() + " (" + currentUser.getMitarbeiternummer() + ").");


        setVisible(true);


        //Eventlistener


        datumButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                DatePick calender = new DatePick((JFrame) datumButton1.getRootPane().getParent(), datumButton1.getText());
                String txt = calender.Set_Picked_Date();
                if (txt==""){

                }else{
                    datumButton1.setText(calender.Set_Picked_Date());
                }


            }
        });


        datumButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!datumButton2.getText().isBlank()){
                    DatePick calender = new DatePick((JFrame) datumButton2.getRootPane().getParent(), datumButton2.getText());
                    String txt = calender.Set_Picked_Date();
                    if (txt==""){

                    }else{
                        datumButton2.setText(calender.Set_Picked_Date());
                    }
                }else{
                    DatePick calender = new DatePick((JFrame) datumButton2.getRootPane().getParent(), null);
                    String txt = calender.Set_Picked_Date();
                    if (txt==""){

                    }else{
                        datumButton2.setText(calender.Set_Picked_Date());
                    }
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
                    ausweisnummerTextField.setBackground(red);
                    Foo.okWindow("Keine Treffer", getFrame());
                }else{
                    ausweisnummerTextField.setBackground(green);
                    autofill();
                    geschlechtBox.setEnabled(false);
                    vornameTextField.setEnabled(false);
                    nachnameTextField.setEnabled(false);
                    geburtsortTextField.setEnabled(false);
                    datumButton2.setEnabled(false);
                }


            }
        });

        speichernToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pflichtAusgefuellt()){
                    Adresse neueAdresse = new Adresse(landComboBox.getSelectedItem().toString(), plzTextField.getText(), ortTextField.getText(), strasseTextField.getText(), hausnummerTextField.getText(), zusatzTextField.getText());

                    try {


                        int geburtsdatum[] = dateToNumber(datumButton2.getText());



                        if (currentSf ==null){
                            currentSf = new Schwarzfahrer(ausweisnummerTextField.getText(), geburtsortTextField.getText(), neueAdresse, vornameTextField.getText(), nachnameTextField.getText(), geschlechtBox.getSelectedItem().toString(), telefonTextField.getText(), emailTextField.getText(), geburtsdatum[0], geburtsdatum[1], geburtsdatum[2]);
                            currentSf.appendSFT(datumButton1.getText(), Integer.parseInt(stundenBox.getSelectedItem().toString()), Integer.parseInt(minutenBox.getSelectedItem().toString()), linieTextField.getText(), bereitsBezahltCheckBox.isSelected());
                            //Übergibt dem Schwarzfahrerobjekt die Variablen zur Schwarzfahrt, int[], int, int, String, boolean
                        }

                        else{
                           Schwarzfahrer.updateExistingSF(ausweisnummerTextField.getText(), geburtsortTextField.getText(), neueAdresse, vornameTextField.getText(), nachnameTextField.getText(), geschlechtBox.getSelectedItem().toString(), telefonTextField.getText(), emailTextField.getText(), geburtsdatum[0], geburtsdatum[1], geburtsdatum[2], currentSf.sftList);
                                 currentSf.appendSFT(datumButton1.getText(), Integer.parseInt(stundenBox.getSelectedItem().toString()), Integer.parseInt(minutenBox.getSelectedItem().toString()), linieTextField.getText(), bereitsBezahltCheckBox.isSelected());
                            //Übergibt dem Schwarzfahrerobjekt die Variablen zur Schwarzfahrt, int[], int, int, String, boolean
                        }


                    } catch (IOException ex) {
                        ex.printStackTrace();
                        dispose();
                        throw new RuntimeException(ex);
                    }
                    parentGUI.Kachel1.setEnabled(true);
                    dispose();
                }else{
                   // OkayWindow.openOkayWindow("Es wurden nicht alle Pflichtfelder ausgefüllt");
                }

            }
        });

        löschenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                vornameTextField.setText("");
                nachnameTextField.setText("");
                datumButton2.setText("");
                geburtsortTextField.setText("");
                emailTextField.setText("");
                telefonTextField.setText("");
                strasseTextField.setText("");
                hausnummerTextField.setText("");
                plzTextField.setText("");
                ortTextField.setText("");
                zusatzTextField.setText("");
                geschlechtBox.setSelectedIndex(0);
                landComboBox.setSelectedIndex(0);

                geschlechtBox.setEnabled(true);
                vornameTextField.setEnabled(true);
                nachnameTextField.setEnabled(true);
                geburtsortTextField.setEnabled(true);
            }
        });




        abbrechenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                currentSf = null;
                parentGUI.Kachel1.setEnabled(true);
                dispose();
            }
        });
    }

    void autofill(){
        if (currentSf.getGeschlecht().equals("M")){
            geschlechtBox.setSelectedIndex(0);
        } else if (currentSf.getGeschlecht().equals("W")) {
            geschlechtBox.setSelectedIndex(1);
        } else if (currentSf.getGeschlecht().equals("D")){
            geschlechtBox.setSelectedIndex(2);
        }

        vornameTextField.setText(currentSf.getVorname());
        nachnameTextField.setText(currentSf.getNachname());
        datumButton2.setText(currentSf.getGeburtsdatum());
        geburtsortTextField.setText(currentSf.getGeburtsort());
        emailTextField.setText(currentSf.getEmail());
        telefonTextField.setText(currentSf.getTelefonnummer());
        strasseTextField.setText(currentSf.getAdresse().getStrasse());
        hausnummerTextField.setText(currentSf.getAdresse().getHausnummer());
        plzTextField.setText(currentSf.getAdresse().getPLZ());
        ortTextField.setText(currentSf.getAdresse().getOrt());
        zusatzTextField.setText(currentSf.getAdresse().getZusatz());

        vornameTextField.addFlashEffect();
        nachnameTextField.addFlashEffect();
        datumButton2.addFlashEffect();
        geburtsortTextField.addFlashEffect();

        telefonTextField.addFlashEffect();
        strasseTextField.addFlashEffect();
        hausnummerTextField.addFlashEffect();
        plzTextField.addFlashEffect();
        ortTextField.addFlashEffect();
        landComboBox.addFlashEffect();
        geschlechtBox.addFlashEffect();
        if (!emailTextField.getText().isBlank()){
            emailTextField.addFlashEffect();
        }
        if (!zusatzTextField.getText().isBlank()){
            zusatzTextField.addFlashEffect();
        }

    }

    private boolean pflichtAusgefuellt(){
        if (!datumButton1.getText().isBlank()){
            if (!linieTextField.getText().isBlank()){
                if (!ausweisnummerTextField.getText().isBlank()){
                    if (!vornameTextField.getText().isBlank()){
                        if (!nachnameTextField.getText().isBlank()){
                            if(!datumButton2.getText().isBlank()){
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
        }


        if(datumButton1.getText().isBlank()){

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
        if (datumButton2.getText().isBlank()){
            datumButton2.addRedFlashEffect();
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
    public static void open(Parent_GUI parent) {
        Foo.getDirectoryData();
        isOpen = true;
        SchwarzfahrtErfassenGUI gui = new SchwarzfahrtErfassenGUI(parent);
    }


}
