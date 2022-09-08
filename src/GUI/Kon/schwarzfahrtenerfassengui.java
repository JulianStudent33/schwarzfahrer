package src.GUI.Kon;

import src.Foo;
import src.GUI.Parent_GUI;
import src.GUI.ProfilGUI;
import src.GUI.elements.PlaceholderTextField;
import src.GUI.elements.customComboBox;
import src.Rollen.Kontrolleur;

import javax.swing.*;
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

    JLabel erf = new JLabel();

    JPanel trennerf = new JPanel();


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

        hour.addItem("Stunde");
        hour.setBackground(dark);
        hour.setForeground(white);
        hour.setFont(fontSmall);
        hour.setBounds(75,115,145,30);

        minute.addItem("Minute");
        minute.setBackground(dark);
        minute.setForeground(white);
        minute.setFont(fontSmall);
        minute.setBounds(230,115,145,30);

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

        //----------------------Einzelne Objekte rechtes Panel--------------------

        schwarz.setText("Schwarzfahrt");
        schwarz.setFont(fontLargeLarge);
        schwarz.setForeground(white);
        schwarz.setBackground(dark);
        schwarz.setBounds(105,0,400,50);

        trennlinie.setBackground(white);
        trennlinie.setBounds(105,55,240,5);


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

        BGdark.add(leftp);
        BGdark.add(rightp);

        this.add(BGdark);

    }

    public static void openSfErfassung(Parent_GUI parent) {
        Foo.getDirectoryData();
        schwarzfahrtenerfassengui gui = new schwarzfahrtenerfassengui(parent);
    }
}




