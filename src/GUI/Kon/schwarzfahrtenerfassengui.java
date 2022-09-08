package src.GUI.Kon;

import src.Foo;
import src.GUI.Parent_GUI;
import src.GUI.ProfilGUI;
import src.GUI.elements.DatePick;
import src.GUI.elements.PlaceholderTextField;
import src.GUI.elements.customComboBox;
import src.Rollen.Kontrolleur;
import src.Rollen.Schwarzfahrer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Calendar;

public class schwarzfahrtenerfassengui extends Parent_GUI {

    String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    String[] minutes = {"00", "01", "02", "03", "04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28", "29","30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
    private Kontrolleur currentKon;
    private Schwarzfahrer currentSf;
    //     MAIN
    JPanel BGdark = new JPanel();

    JPanel leftp = new JPanel();
    JPanel rightp = new JPanel();

    // LEFT PANEL
    JLabel schwarz = new JLabel();

    JPanel trennlinie = new JPanel();

    JButton datuml = new JButton();

    customComboBox hour = new customComboBox();

    customComboBox minute = new customComboBox();

    JLabel linie = new JLabel();
    JPanel borderlinie = new JPanel();

    PlaceholderTextField linienfield = new PlaceholderTextField();

    JCheckBox bezahlt = new JCheckBox();

    JLabel info = new JLabel();

    JLabel ausweis = new JLabel();
    JPanel ausweislinie = new JPanel();
    PlaceholderTextField ausweisfield = new PlaceholderTextField();

    JButton autofill = new JButton();

    // RIGHT PANEL

    JLabel erf = new JLabel();

    JPanel trennerf = new JPanel();


    public schwarzfahrtenerfassengui(Parent_GUI parent) {
        setupGUI(parent, "SchwarzfahrtenErfassungGUI");
        currentKon = (Kontrolleur) currentUser;

        //----------------------HAUPTPANEL--------------------

        BGdark.setLayout(null);
        BGdark.setBackground(dark);
        BGdark.setBounds(0,0,1000,400);

        leftp.setBounds(10,10,450,340);
        leftp.setBackground(dark);
        leftp.setLayout(null);
        leftp.setBorder(BorderFactory.createLineBorder(notSoDark));


        rightp.setBounds(470,10,503,340);
        rightp.setBackground(dark);
        rightp.setLayout(null);
        rightp.setBorder(BorderFactory.createLineBorder(notSoDark));

        //--------------------Einzelne Objekte linkes Panel---------------------

        schwarz.setText("Schwarzfahrt");
        schwarz.setFont(fontLargeLarge);
        schwarz.setForeground(white);
        schwarz.setBackground(dark);
        schwarz.setBounds(105,0,400,50);

        trennlinie.setBackground(white);
        trennlinie.setBounds(105,55,240,5);

        datuml.setBackground(dark);
        datuml.setForeground(white);
        datuml.setText("Datum auswählen");
        datuml.setFont(fontSmall);
        datuml.setBounds(75,75,300,30);
        datuml.setText(Foo.getCurrentDate());
        datuml.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        hour.setBackground(dark);
        hour.setForeground(white);
        hour.setFont(fontSmall);
        hour.setBounds(75,115,145,30);
        for(String s : hours){
            hour.addItem(s);
        }
        hour.setSelectedIndex(java.util.Calendar.getInstance().get(Calendar.HOUR_OF_DAY));


        minute.setBackground(dark);
        minute.setForeground(white);
        minute.setFont(fontSmall);
        minute.setBounds(230,115,145,30);
        for (String s : minutes){
            minute.addItem(s);
        }
        minute.setSelectedIndex(java.util.Calendar.getInstance().get(Calendar.MINUTE));


        linie.setText("Linie:");
        linie.setFont(fontSmall);
        linie.setBackground(dark);
        linie.setForeground(white);
        linie.setBounds(130,155,145,30);

        borderlinie.setBounds(125,155,60,30);
        borderlinie.setBackground(dark);
        borderlinie.setBorder(BorderFactory.createLineBorder(notSoDark));

        linienfield.setPlaceholder("z.B. S41");
        linienfield.setFont(fontSmall);
        linienfield.setBackground(dark);
        linienfield.setForeground(white);
        linienfield.setBounds(175,155,145,30);

        bezahlt.setText("Bereits bezahlt");
        bezahlt.setFont(fontSmall);
        bezahlt.setBackground(dark);
        bezahlt.setForeground(white);
        bezahlt.setBounds(160,190,145,30);

        info.setText("<html><body><center><p>Mit Auto-Fill bei bekannter<br>Ausweisnr. rechte Seite automatisch füllen</p></center></body></html>");
        info.setFont(fontverySmall);
        info.setBackground(dark);
        info.setForeground(notSoDark);
        info.setBounds(100,290,400,50);

        ausweis.setText("Ausweisnr.:");
        ausweis.setFont(fontSmall);
        ausweis.setBackground(dark);
        ausweis.setForeground(white);
        ausweis.setBounds(75,225,145,30);

        ausweislinie.setBounds(71,225,90,30);
        ausweislinie.setBackground(dark);
        ausweislinie.setBorder(BorderFactory.createLineBorder(notSoDark));

        ausweisfield.setPlaceholder("Hier Eingeben");
        ausweisfield.setFont(fontSmall);
        ausweisfield.setBackground(dark);
        ausweisfield.setForeground(white);
        ausweisfield.setBounds(160,225,215,30);

        autofill.setBackground(dunkelb);
        autofill.setForeground(white);
        autofill.setText("Auto-Fill");
        autofill.setFont(fontSmall);
        autofill.setBounds(150,265,150,30);
        autofill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //----------------------Einzelne Objekte rechtes Panel--------------------

        erf.setText("erfassen");
        erf.setFont(fontLargeLarge);
        erf.setForeground(white);
        erf.setBackground(dark);
        erf.setBounds(175,0,400,50);

        trennerf.setBackground(white);
        trennerf.setBounds(175,55,155,5);


        //----------------------JFRAME BEFEHLE--------------------

        this.setTitle("Schwarzfahrt erfassen");
        this.setBackground(dark);
        this.setSize(1000,400);
        this.setLayout(null);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        leftp.add(schwarz);
        leftp.add(trennlinie);
        leftp.add(datuml);
        leftp.add(hour);
        leftp.add(minute);
        leftp.add(linie);
        leftp.add(linienfield);
        leftp.add(borderlinie);
        leftp.add(bezahlt);
        leftp.add(ausweis);
        leftp.add(ausweisfield);
        leftp.add(ausweislinie);
        leftp.add(autofill);
        leftp.add(info);

        rightp.add(erf);
        rightp.add(trennerf);

        BGdark.add(leftp);
        BGdark.add(rightp);

        this.add(BGdark);


        datuml.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                DatePick calender = new DatePick((JFrame) datuml.getRootPane().getParent(), datuml.getText());
                String txt = calender.Set_Picked_Date();
                if (txt==""){

                }else{
                    datuml.setText(calender.Set_Picked_Date());
                }


            }
        });

        autofill.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    currentSf = currentKon.schwarzfahrerSuchen(ausweisfield.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    throw new RuntimeException(ex);
                }

                if (currentSf == null){
                    ausweisfield.setBackground(red);
                    Foo.okWindow("Keine Treffer", getFrame());
                }else{
                    ausweisfield.setBackground(green);
                    autofill();
                    /*
                    geschlechtBox.setEnabled(false);
                    vornameTextField.setEnabled(false);
                    nachnameTextField.setEnabled(false);
                    geburtsortTextField.setEnabled(false);
                    datumButton2.setEnabled(false);
                    */

                }

            }
        });

    }

    private void autofill(){
            /*
            if (currentSf.getGeschlecht().equals("M")){
                .setSelectedIndex(0);
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
*/

    }
    public static void openSfErfassung(Parent_GUI parent) {
        Foo.getDirectoryData();
        schwarzfahrtenerfassengui gui = new schwarzfahrtenerfassengui(parent);
    }
}




