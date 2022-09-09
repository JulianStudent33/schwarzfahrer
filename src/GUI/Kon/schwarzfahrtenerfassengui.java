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
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
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

    customComboBox genderBox = new customComboBox();

    Border border = genderBox.getBorder();

    Border margin = new EmptyBorder(0,5,0,0);
    Border margin2 = new EmptyBorder(0,0,0,0);
    String[] geschlechter = {"Geschlecht*", "Männlich", "Weiblich", "Divers"};
    JLabel erf = new JLabel();

    JPanel trennerf = new JPanel();

    PlaceholderTextField vname = new PlaceholderTextField();

    PlaceholderTextField name = new PlaceholderTextField();

    JButton datumr = new JButton();

    PlaceholderTextField ort = new PlaceholderTextField();

    PlaceholderTextField mail = new PlaceholderTextField();

    PlaceholderTextField nr = new PlaceholderTextField();

    PlaceholderTextField strasse = new PlaceholderTextField();

    PlaceholderTextField hausnr = new PlaceholderTextField();

    PlaceholderTextField plz = new PlaceholderTextField();

    PlaceholderTextField stadt = new PlaceholderTextField();

    customComboBox land = new customComboBox();

    PlaceholderTextField adr = new PlaceholderTextField();

    JButton erfs = new JButton();

    JButton abr = new JButton();

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

        schwarz.setText("Delikt");
        schwarz.setFont(fontLarge);
        schwarz.setForeground(white);
        schwarz.setBackground(dark);
        schwarz.setBounds(170,0,400,50);

        trennlinie.setBackground(white);
        trennlinie.setBounds(105,50,240,5);

        datuml.setBackground(dark);
        datuml.setForeground(white);
        datuml.setText("Ereignisdatum auswählen");
        datuml.setFont(fontverySmall);
        datuml.setBounds(75,70,300,30);
        datuml.setText(Foo.getCurrentDate());
        datuml.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        hour.setBackground(dark);
        hour.setForeground(white);
        hour.setFont(fontverySmall);
        hour.setBounds(75,110,145,30);
        for(String s : hours){
            hour.addItem(s);
        }
        hour.setSelectedIndex(java.util.Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
        hour.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));


        minute.setBackground(dark);
        minute.setForeground(white);
        minute.setFont(fontverySmall);
        minute.setBounds(230,110,145,30);
        for (String s : minutes){
            minute.addItem(s);
        }
        minute.setSelectedIndex(java.util.Calendar.getInstance().get(Calendar.MINUTE));
        minute.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        linie.setText("Linie:");
        linie.setFont(fontverySmall);
        linie.setBackground(dark);
        linie.setForeground(white);
        linie.setBounds(130,150,145,30);

        borderlinie.setBounds(125,150,60,30);
        borderlinie.setBackground(dark);
        borderlinie.setBorder(BorderFactory.createLineBorder(notSoDark));

        linienfield.setPlaceholder("z.B. S41");
        linienfield.setFont(fontverySmall);
        linienfield.setBackground(dark);
        linienfield.setForeground(white);
        linienfield.setBounds(175,150,145,30);

        bezahlt.setText("Bereits bezahlt");
        bezahlt.setFont(fontverySmall);
        bezahlt.setBackground(dark);
        bezahlt.setForeground(white);
        bezahlt.setBounds(160,185,200,30);
        bezahlt.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        info.setText("<html><body><center><p>Mit Auto-Fill bei bekannter Ausweisnr.<br>rechte Seite automatisch füllen</p></center></body></html>");
        info.setFont(fontverySmall);
        info.setBackground(dark);
        info.setForeground(notSoDark);
        info.setBounds(100,285,400,50);

        ausweis.setText("Ausweisnr:");
        ausweis.setFont(fontverySmall);
        ausweis.setBackground(dark);
        ausweis.setForeground(white);
        ausweis.setBounds(75,220,145,30);

        ausweislinie.setBounds(71,220,90,30);
        ausweislinie.setBackground(dark);
        ausweislinie.setBorder(BorderFactory.createLineBorder(notSoDark));

        ausweisfield.setPlaceholder("Hier Eingeben");
        ausweisfield.setFont(fontverySmall);
        ausweisfield.setBackground(dark);
        ausweisfield.setForeground(white);
        ausweisfield.setBounds(160,220,215,30);

        autofill.setBackground(dunkelb);
        autofill.setForeground(white);
        autofill.setText("Auto-Fill");
        autofill.setFont(fontverySmall);
        autofill.setBounds(150,260,150,30);
        autofill.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        //----------------------Einzelne Objekte rechtes Panel--------------------

        erf.setText("Schwarzfahrer");
        erf.setFont(fontLarge);
        erf.setForeground(white);
        erf.setBackground(dark);
        erf.setBounds(120,0,400,50);

        trennerf.setBackground(white);
        trennerf.setBounds(120,50,240,5);

        genderBox.addItem(geschlechter[0]);
        genderBox.addItem(geschlechter[1]);
        genderBox.addItem(geschlechter[2]);
        genderBox.addItem(geschlechter[3]);

        genderBox.setFont(fontverySmall);
        genderBox.setBackground(whitebg);
        if(genderBox.getItemAt(0)=="Geschlecht*") {
            genderBox.setForeground(notSoDark);
        } else {
            genderBox.setForeground(white);
        }
        genderBox.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        genderBox.setFocusable(true);
        genderBox.setBorder(new CompoundBorder(border, margin));
        genderBox.setBounds(15,65,150,30);

        vname.setPlaceholder("Vorname*");
        vname.setFont(fontverySmall);
        vname.setBackground(dark);
        vname.setForeground(white);
        vname.setBounds(175,65,150,30);

        name.setPlaceholder("Nachname*");
        name.setFont(fontverySmall);
        name.setBackground(dark);
        name.setForeground(white);
        name.setBounds(335,65,150,30);

        datumr.setBackground(dark);
        datumr.setForeground(notSoDark);
        datumr.setText("Geburtsdatum*");
        datumr.setFont(fontverySmall);
        datumr.setHorizontalAlignment(SwingConstants.LEFT);
        datumr.setBounds(15,105,230,30);
        datumr.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        ort.setPlaceholder("Geburtsort*");
        ort.setFont(fontverySmall);
        ort.setBackground(dark);
        ort.setForeground(white);
        ort.setBounds(255,105,230,30);

        mail.setPlaceholder("E-Mail");
        mail.setFont(fontverySmall);
        mail.setBackground(dark);
        mail.setForeground(white);
        mail.setBounds(15,145,200,30);

        nr.setPlaceholder("Telefonnummer");
        nr.setFont(fontverySmall);
        nr.setBackground(dark);
        nr.setForeground(white);
        nr.setBounds(225,145,260,30);

        strasse.setPlaceholder("Straße*");
        strasse.setFont(fontverySmall);
        strasse.setBackground(dark);
        strasse.setForeground(white);
        strasse.setBounds(15,185,310,30);

        hausnr.setPlaceholder("Hausnummer*");
        hausnr.setFont(fontverySmall);
        hausnr.setBackground(dark);
        hausnr.setForeground(white);
        hausnr.setBounds(335,185,150,30);

        plz.setPlaceholder("PLZ*");
        plz.setFont(fontverySmall);
        plz.setBackground(dark);
        plz.setForeground(white);
        plz.setBounds(15,225,150,30);

        stadt.setPlaceholder("Stadt*");
        stadt.setFont(fontverySmall);
        stadt.setBackground(dark);
        stadt.setForeground(white);
        stadt.setBounds(175,225,310,30);

        land.addItem("Staatsangehörigkeit*");

        land.setFont(fontverySmall);
        land.setBackground(whitebg);
        if(land.getItemAt(0)=="Staatsangehörigkeit*") {
            land.setForeground(notSoDark);
        } else {
            land.setForeground(white);
        }
        land.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        land.setFocusable(true);
        land.setBorder(new CompoundBorder(border, margin));
        land.setBounds(15,265,260,30);

        adr.setPlaceholder("Adresszusatz");
        adr.setFont(fontverySmall);
        adr.setBackground(dark);
        adr.setForeground(white);
        adr.setBounds(285,265,200,30);

        erfs.setBackground(dunkelb);
        erfs.setForeground(white);
        erfs.setText("Schwarzfahrt erfassen");
        erfs.setFont(fontverySmall);
        erfs.setBounds(15,305,290,30);
        erfs.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        abr.setBackground(notSoDark);
        abr.setForeground(white);
        abr.setText("Abbrechen");
        abr.setFont(fontverySmall);
        abr.setBounds(315,305,170,30);
        abr.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        //----------------------JFRAME BEFEHLE--------------------


        this.setTitle("Schwarzfahrt erfassen");
        this.setBackground(dark);
        this.setSize(1000,400);
        this.setLocationRelativeTo(parent);
        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
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
        rightp.add(genderBox);
        rightp.add(vname);
        rightp.add(name);
        rightp.add(datumr);
        rightp.add(ort);
        rightp.add(mail);
        rightp.add(nr);
        rightp.add(strasse);
        rightp.add(hausnr);
        rightp.add(plz);
        rightp.add(stadt);
        rightp.add(land);
        rightp.add(adr);
        rightp.add(erfs);
        rightp.add(abr);

        BGdark.add(leftp);
        BGdark.add(rightp);

        this.add(BGdark);


        datumr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (datumr.getText().equals("Geburtsdatum*")){
                    datumr.setForeground(white);
                }

            }
        });
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
    void addBorders(){

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




