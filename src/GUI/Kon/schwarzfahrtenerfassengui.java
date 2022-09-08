package src.GUI.Kon;

import src.Foo;
import src.GUI.Parent_GUI;
import src.GUI.ProfilGUI;
import src.GUI.elements.PlaceholderTextField;
import src.GUI.elements.customComboBox;
import src.Rollen.Kontrolleur;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class schwarzfahrtenerfassengui extends Parent_GUI {

    // MAIN
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
        schwarz.setFont(fontLargeLarge);
        schwarz.setForeground(white);
        schwarz.setBackground(dark);
        schwarz.setBounds(170,0,400,50);

        trennlinie.setBackground(white);
        trennlinie.setBounds(105,50,240,5);

        datuml.setBackground(dark);
        datuml.setForeground(white);
        datuml.setText("Ereignisdatum auswählen");
        datuml.setFont(fontSmall);
        datuml.setBounds(75,70,300,30);

        hour.addItem("Stunde");
        hour.setBackground(dark);
        hour.setForeground(white);
        hour.setFont(fontSmall);
        hour.setBounds(75,110,145,30);
        hour.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        minute.addItem("Minute");
        minute.setBackground(dark);
        minute.setForeground(white);
        minute.setFont(fontSmall);
        minute.setBounds(230,110,145,30);
        minute.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        linie.setText("Linie:");
        linie.setFont(fontSmall);
        linie.setBackground(dark);
        linie.setForeground(white);
        linie.setBounds(130,150,145,30);

        borderlinie.setBounds(125,150,60,30);
        borderlinie.setBackground(dark);
        borderlinie.setBorder(BorderFactory.createLineBorder(notSoDark));

        linienfield.setPlaceholder("z.B. S41");
        linienfield.setFont(fontSmall);
        linienfield.setBackground(dark);
        linienfield.setForeground(white);
        linienfield.setBounds(175,150,145,30);

        bezahlt.setText("Bereits bezahlt");
        bezahlt.setFont(fontSmall);
        bezahlt.setBackground(dark);
        bezahlt.setForeground(white);
        bezahlt.setBounds(160,185,145,30);
        bezahlt.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        info.setText("<html><body><center><p>Mit Auto-Fill bei bekannter Ausweisnr.<br>rechte Seite automatisch füllen</p></center></body></html>");
        info.setFont(fontverySmall);
        info.setBackground(dark);
        info.setForeground(notSoDark);
        info.setBounds(100,285,400,50);

        ausweis.setText("Ausweisnr.:");
        ausweis.setFont(fontSmall);
        ausweis.setBackground(dark);
        ausweis.setForeground(white);
        ausweis.setBounds(75,220,145,30);

        ausweislinie.setBounds(71,220,90,30);
        ausweislinie.setBackground(dark);
        ausweislinie.setBorder(BorderFactory.createLineBorder(notSoDark));

        ausweisfield.setPlaceholder("Hier Eingeben");
        ausweisfield.setFont(fontSmall);
        ausweisfield.setBackground(dark);
        ausweisfield.setForeground(white);
        ausweisfield.setBounds(160,220,215,30);

        autofill.setBackground(dunkelb);
        autofill.setForeground(white);
        autofill.setText("Auto-Fill");
        autofill.setFont(fontSmall);
        autofill.setBounds(150,260,150,30);

        //----------------------Einzelne Objekte rechtes Panel--------------------

        erf.setText("Schwarzfahrer");
        erf.setFont(fontLargeLarge);
        erf.setForeground(white);
        erf.setBackground(dark);
        erf.setBounds(120,0,400,50);

        trennerf.setBackground(white);
        trennerf.setBounds(120,50,260,5);

        genderBox.addItem(geschlechter[0]);
        genderBox.addItem(geschlechter[1]);
        genderBox.addItem(geschlechter[2]);
        genderBox.addItem(geschlechter[3]);

        genderBox.setFont(fontSmall);
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

        vname.setPlaceholder("Vorname");
        vname.setFont(fontSmall);
        vname.setBackground(dark);
        vname.setForeground(white);
        vname.setBounds(175,65,150,30);

        name.setPlaceholder("Nachname");
        name.setFont(fontSmall);
        name.setBackground(dark);
        name.setForeground(white);
        name.setBounds(335,65,150,30);

        datumr.setBackground(dark);
        datumr.setForeground(white);
        datumr.setText("Geburtsdatum auswählen");
        datumr.setFont(fontSmall);
        datumr.setBounds(15,105,230,30);
        datumr.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        ort.setPlaceholder("Geburtsort");
        ort.setFont(fontSmall);
        ort.setBackground(dark);
        ort.setForeground(white);
        ort.setBounds(255,105,230,30);

        mail.setPlaceholder("E-Mail");
        mail.setFont(fontSmall);
        mail.setBackground(dark);
        mail.setForeground(white);
        mail.setBounds(15,145,200,30);

        nr.setPlaceholder("Telefonnummer");
        nr.setFont(fontSmall);
        nr.setBackground(dark);
        nr.setForeground(white);
        nr.setBounds(225,145,260,30);

        strasse.setPlaceholder("Straße");
        strasse.setFont(fontSmall);
        strasse.setBackground(dark);
        strasse.setForeground(white);
        strasse.setBounds(15,185,310,30);

        hausnr.setPlaceholder("Hausnummer");
        hausnr.setFont(fontSmall);
        hausnr.setBackground(dark);
        hausnr.setForeground(white);
        hausnr.setBounds(335,185,150,30);

        plz.setPlaceholder("PLZ");
        plz.setFont(fontSmall);
        plz.setBackground(dark);
        plz.setForeground(white);
        plz.setBounds(15,225,150,30);

        stadt.setPlaceholder("Stadt");
        stadt.setFont(fontSmall);
        stadt.setBackground(dark);
        stadt.setForeground(white);
        stadt.setBounds(175,225,310,30);

        land.addItem("Staatsangehörigkeit");

        land.setFont(fontSmall);
        land.setBackground(whitebg);
        if(land.getItemAt(0)=="Staatsangehörigkeit") {
            land.setForeground(notSoDark);
        } else {
            land.setForeground(white);
        }
        land.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        land.setFocusable(true);
        land.setBorder(new CompoundBorder(border, margin));
        land.setBounds(15,265,260,30);

        adr.setPlaceholder("Adresszusatz");
        adr.setFont(fontSmall);
        adr.setBackground(dark);
        adr.setForeground(white);
        adr.setBounds(285,265,200,30);

        erfs.setBackground(dunkelb);
        erfs.setForeground(white);
        erfs.setText("Schwarzfahrt erfassen");
        erfs.setFont(fontSmall);
        erfs.setBounds(15,305,290,30);
        erfs.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

        abr.setBackground(notSoDark);
        abr.setForeground(white);
        abr.setText("Abbrechen");
        abr.setFont(fontSmall);
        abr.setBounds(315,305,170,30);
        abr.setCursor(Cursor.getPredefinedCursor(HAND_CURSOR));

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

    }

    public static void openSfErfassung(Parent_GUI parent) {
        Foo.getDirectoryData();
        schwarzfahrtenerfassengui gui = new schwarzfahrtenerfassengui(parent);
    }
}




