package src.GUI.Kon;

import src.Adresse;
import src.Foo;
import src.GUI.Parent_GUI;
import src.GUI.ProfilGUI;
import src.GUI.elements.DatePick;
import src.GUI.elements.PlaceholderTextField;
import src.GUI.elements.customButton;
import src.GUI.elements.customComboBox;
import src.Rollen.Kontrolleur;
import src.Rollen.Schwarzfahrer;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Calendar;

import static src.Foo.dateToNumber;

public class schwarzfahrtenerfassengui extends Parent_GUI {

    String[] hours = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
    String[] minutes = {"00", "01", "02", "03", "04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28", "29","30",
            "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};
    String[] countries = {"Deutschland", "------------","Afghanistan","\u00c4gypten","\u00c5landinseln","Albanien","Algerien","Amerikanisch-Samoa","Amerikanische Jungferninseln","Amerikanische \u00dcberseeinseln","Andorra","Angola","Anguilla","Antarktis","Antigua und Barbuda","\u00c4quatorialguinea","Argentinien","Armenien","Aruba","Aserbaidschan","\u00c4thiopien","Australien","Bahamas","Bahrain","Bangladesch","Barbados","Belarus",
            "Belgien","Belize","Benin", "Bermuda", "Bhutan","Bolivien","Bonaire, Sint Eustatius und Saba","Bosnien und Herzegowina","Botsuana","Bouvetinsel","Brasilien",
        "Britische Jungferninseln","Britisches Territorium im Indischen Ozean", "Brunei Darussalam","Bulgarien","Burkina Faso","Burundi","Cabo Verde","Chile",
        "China","Cookinseln","Costa Rica","C\u00f4te d\u2019Ivoire","Cura\u00e7ao","D\u00e4nemark","Dominica","Dominikanische Republik",
        "Dschibuti","Ecuador","El Salvador","Eritrea","Estland","Eswatini","Falklandinseln","F\u00e4r\u00f6er","Fidschi","Finnland","Frankreich",
        "Franz\u00f6sisch-Guayana","Franz\u00f6sisch-Polynesien","Franz\u00f6sische S\u00fcd- und Antarktisgebiete","Gabun","Gambia","Georgien","Ghana","Gibraltar",
        "Grenada","Griechenland","Gr\u00f6nland","Guadeloupe","Guam","Guatemala","Guernsey","Guinea","Guinea-Bissau","Guyana","Haiti","Heard und McDonaldinseln"
        ,"Honduras","Indien","Indonesien","Irak","Iran","Irland","Island","Isle of Man","Israel","Italien","Jamaika","Japan","Jemen","Jersey","Jordanien",
        "Kaimaninseln","Kambodscha","Kamerun","Kanada","Kasachstan","Katar","Kenia","Kirgisistan","Kiribati","Kokosinseln","Kolumbien","Komoren","Kongo-Brazzaville",
        "Kongo-Kinshasa","Kroatien","Kuba","Kuwait","Laos","Lesotho","Lettland","Libanon","Liberia","Libyen","Liechtenstein","Litauen","Luxemburg","Madagaskar",
        "Malawi","Malaysia","Malediven","Mali","Malta","Marokko","Marshallinseln","Martinique","Mauretanien","Mauritius","Mayotte","Mexiko","Mikronesien","Monaco",
        "Mongolei","Montenegro","Montserrat","Mosambik","Myanmar","Namibia","Nauru","Nepal","Neukaledonien","Neuseeland","Nicaragua","Niederlande","Niger","Nigeria",
        "Niue","Nordkorea","N\u00f6rdliche Marianen","Nordmazedonien","Norfolkinsel","Norwegen","Oman","\u00d6sterreich","Pakistan","Pal\u00e4stinensische Autonomiegebiete","Palau",
        "Panama","Papua-Neuguinea","Paraguay","Peru","Philippinen","Pitcairninseln","Polen","Portugal","Puerto Rico","Republik Moldau","R\u00e9union","Ruanda","Rum\u00e4nien",
        "Russland","Salomonen","Sambia","Samoa","San Marino","S\u00e3o Tom\u00e9 und Pr\u00edncipe","Saudi-Arabien","Schweden","Schweiz","Senegal","Serbien","Seychellen","Sierra Leone",
        "Simbabwe","Singapur","Sint Maarten","Slowakei","Slowenien","Somalia","Sonderverwaltungsregion Hongkong","Sonderverwaltungsregion Macau","Spanien","Spitzbergen und Jan Mayen","Sri Lanka",
        "St. Barth\u00e9lemy","St. Helena","St. Kitts und Nevis","St. Lucia","St. Martin","St. Pierre und Miquelon","St. Vincent und die Grenadinen","S\u00fcdafrika","Sudan",
        "S\u00fcdgeorgien und die S\u00fcdlichen Sandwichinseln","S\u00fcdkorea","S\u00fcdsudan","Suriname","Syrien","Tadschikistan","Taiwan","Tansania","Thailand","Timor-Leste","Togo","Tokelau",
        "Tonga","Trinidad und Tobago","Tschad","Tschechien","Tunesien","T\u00fcrkei","Turkmenistan","Turks- und Caicosinseln","Tuvalu","Uganda","Ukraine","Ungarn","Uruguay","Usbekistan",
        "Vanuatu","Vatikanstadt","Venezuela","Vereinigte Arabische Emirate","Vereinigte Staaten","Vereinigtes K\u00f6nigreich","Vietnam","Wallis und Futuna","Weihnachtsinsel","Westsahara","Zentralafrikanische Republik","Zypern"};

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

     customButton datumr = new customButton();

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
        addBorders();

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

        linie.setText("Linie*:");
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
        datumr.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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

        //----------------------Listener--------------------

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
        ausweisfield.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                ausweisfield.setBackground(dark);
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                ausweisfield.setBackground(dark);
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

        genderBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (genderBox.getItemAt(0).equals("Geschlecht*")){
                    genderBox.removeItemAt(0);
                    genderBox.setForeground(white);
                    genderBox.setPrototypeDisplayValue(null);
                    //gender.setPreferredSize(new Dimension(100, gender.getHeight()));
                }
            }
        });

        datumr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                DatePick calender = new DatePick((JFrame) datumr.getRootPane().getParent(), null);
                String txt = calender.Set_Picked_Date();
                if (txt==""){

                }else{
                    datumr.setText(calender.Set_Picked_Date());
                }
            }
        });
        land.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (land.getSelectedIndex() == 1){
                    land.setSelectedIndex(0);
                }
            }
        });
        erfs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pflichtAusgefuellt()){
                    Adresse neueAdresse = new Adresse(land.getSelectedItem().toString(), land.getSelectedIndex(), plz.getText(), ort.getText(), strasse.getText(), hausnr.getText(), adr.getText());

                    try {


                        int geburtsdatum[] = dateToNumber(datumr.getText());



                        if (currentSf ==null){
                            currentSf = new Schwarzfahrer(ausweisfield.getText(), ort.getText(), neueAdresse, vname.getText(), name.getText(), genderBox.getSelectedItem().toString(), nr.getText(), mail.getText(), geburtsdatum[0], geburtsdatum[1], geburtsdatum[2]);
                            currentSf.appendSFT(datuml.getText(), hour.getSelectedItem().toString(), minute.getSelectedItem().toString(), linienfield.getText(), bezahlt.isSelected());
                            //Übergibt dem Schwarzfahrerobjekt die Variablen zur Schwarzfahrt, int[], int, int, String, boolean
                        }

                        else{
                            Schwarzfahrer.updateExistingSF(ausweisfield.getText(), ort.getText(), neueAdresse, vname.getText(), name.getText(), genderBox.getSelectedItem().toString(), nr.getText(), mail.getText(), geburtsdatum[0], geburtsdatum[1], geburtsdatum[2], currentSf.sftList);
                            currentSf.appendSFT(datuml.getText(), hour.getSelectedItem().toString(), minute.getSelectedItem().toString(), linienfield.getText(), bezahlt.isSelected());
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
                     Foo.okWindow("Es wurden nicht alle Pflichtfelder ausgefüllt", getFrame());
                }
            }
        });
        abr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentSf = null;
                parentGUI.Kachel1.setEnabled(true);
                dispose();
            }
        });
    }
    void addBorders(){
        genderBox.setBorder(new LineBorder(Color.gray));
        vname.setBorder(new LineBorder(Color.gray));
        name.setBorder(new LineBorder(Color.gray));
        datumr.setBorder(new LineBorder(Color.gray));
        ort.setBorder(new LineBorder(Color.gray));
        mail.setBorder(new LineBorder(Color.gray));
        nr.setBorder(new LineBorder(Color.gray));
        strasse.setBorder(new LineBorder(Color.gray));
        hausnr.setBorder(new LineBorder(Color.gray));
        plz.setBorder(new LineBorder(Color.gray));
        stadt.setBorder(new LineBorder(Color.gray));
        land.setBorder(new LineBorder(Color.gray));
        adr.setBorder(new LineBorder(Color.gray));

    }
    private void autofill(){

            if (currentSf.getGeschlecht().equals("M")){
                genderBox.setSelectedIndex(0);
            } else if (currentSf.getGeschlecht().equals("W")) {
                genderBox.setSelectedIndex(1);
            } else if (currentSf.getGeschlecht().equals("D")){
                genderBox.setSelectedIndex(2);
            }

            vname.setText(currentSf.getVorname());
            name.setText(currentSf.getNachname());
            datumr.setText(currentSf.getGeburtsdatum());
            ort.setText(currentSf.getGeburtsort());
            mail.setText(currentSf.getEmail());
            nr.setText(currentSf.getTelefonnummer());
            strasse.setText(currentSf.getAdresse().getStrasse());
            hausnr.setText(currentSf.getAdresse().getHausnummer());
            plz.setText(currentSf.getAdresse().getPLZ());
            stadt.setText(currentSf.getAdresse().getOrt());
            adr.setText(currentSf.getAdresse().getZusatz());
            land.setSelectedIndex(currentSf.getAdresse().getLandIndex());

            vname.addFlashEffect();
            name.addFlashEffect();
            datumr.addFlashEffect();
            ort.addFlashEffect();
            strasse.addFlashEffect();
            hausnr.addFlashEffect();
            plz.addFlashEffect();
            stadt.addFlashEffect();
            ort.addFlashEffect();
            land.addFlashEffect();
            genderBox.addFlashEffect();
            if (!mail.getText().isBlank()){
                mail.addFlashEffect();
            }
            if (!nr.getText().isBlank()){
                nr.addFlashEffect();
            }
            if (!adr.getText().isBlank()){
                adr.addFlashEffect();
            }

    }
    private boolean pflichtAusgefuellt(){
        if (!datuml.getText().isBlank()){
            if (!datumr.getText().equals("Geburtsdatum auswählen*")){
                if (!linie.getText().isBlank()){
                    if (!ausweisfield.getText().isBlank()) {
                        if (!vname.getText().isBlank()) {
                            if (!name.getText().isBlank()) {
                                        if (!strasse.getText().isBlank()) {
                                            if (!hausnr.getText().isBlank()) {
                                                if (!plz.getText().isBlank()) {
                                                    if (!stadt.getText().isBlank()) {
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

        if (genderBox.getSelectedItem().equals("Geschlecht*")){
            genderBox.addRedFlashEffect();
        }
        if (land.getSelectedItem().equals("Staatsangehörigkeit*")){
            land.addRedFlashEffect();
        }
        if (linienfield.getText().isBlank()){
            linienfield.addRedFlashEffect();
        }
        if (ausweisfield.getText().isBlank()){
            ausweisfield.addRedFlashEffect();

        }
        if (vname.getText().isBlank()){
            vname.addRedFlashEffect();
        }
        if (name.getText().isBlank()){
            name.addRedFlashEffect();
        }
        if (datumr.getText().equals("Geburtsdatum auswählen*")){
            datumr.addRedFlashEffect();
        }
        if (strasse.getText().isBlank()){
            strasse.addRedFlashEffect();
        }
        if (hausnr.getText().isBlank()){
            hausnr.addRedFlashEffect();
        }
        if (plz.getText().isBlank()){
            plz.addRedFlashEffect();
        }
        if (stadt.getText().isBlank()){
            stadt.addRedFlashEffect();
        }
        if (ort.getText().isBlank()){
            ort.addRedFlashEffect();
        }
        return false;
    }
    public static void openSfErfassung(Parent_GUI parent) {
        Foo.getDirectoryData();
        schwarzfahrtenerfassengui gui = new schwarzfahrtenerfassengui(parent);
    }
}




