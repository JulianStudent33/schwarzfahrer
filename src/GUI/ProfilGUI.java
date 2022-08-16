package src.GUI;
import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.PlaceholderTextField;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static src.Foo.*;
public class ProfilGUI extends JFrame implements ActionListener {

    public static SachbearbeiterGUI parentS = null;
    public static KontrolleurGUI parentK = null;
    public static AdminGUI parentA = null;

    JFrame Frame = new JFrame();
    JPanel Ueberschrift = new JPanel();
    JLabel Text = new JLabel();
    JPanel Textfelder = new JPanel();
    JPanel Buttons = new JPanel();
    PlaceholderTextField Benutzername = new PlaceholderTextField();
    PlaceholderTextField Name = new PlaceholderTextField();
    PlaceholderTextField Vorname = new PlaceholderTextField();
    PlaceholderTextField Gender = new PlaceholderTextField();
    PlaceholderTextField Rolle = new PlaceholderTextField();
    PlaceholderTextField Geburtstag = new PlaceholderTextField();
    PlaceholderTextField EMail = new PlaceholderTextField();
    PlaceholderTextField Telefonnummer = new PlaceholderTextField();
    JButton AbbrechenButton = new JButton();
    JButton AngabenAendern = new JButton();

    public ProfilGUI(Container parent){
        //Panelmanagement

        Ueberschrift.setBackground(dark);
        Ueberschrift.setPreferredSize(new Dimension(400,100));
        Ueberschrift.setLayout(null);

        Textfelder.setBackground(dark);
        Textfelder.setPreferredSize(new Dimension(400,800));
        Textfelder.setLayout(null);

        Buttons.setBackground(dark);
        Buttons.setPreferredSize(new Dimension(400,100));
        Buttons.setLayout(null);

        // Elemente

        Text.setForeground(white);
        Text.setBackground(dark);
        Text.setFont(fontMedium);
        Text.setText("<html><body><center><p>Profil von <br>... </p></center></body></html>");
        Text.setBorder(new EmptyBorder(0,0,0,0));

        Benutzername.setForeground(white);
        Benutzername.setBackground(dark);
        Benutzername.setFont(fontSmall);
        Benutzername.setBorder(new EmptyBorder(0,0,0,0));
        Benutzername.setText("Die Variable");

        Name.setForeground(white);
        Name.setBackground(dark);
        Name.setFont(fontSmall);
        Name.setBorder(new EmptyBorder(0,0,0,0));
        Name.setText("Die Variable 2");

        Vorname.setForeground(white);
        Vorname.setBackground(dark);
        Vorname.setFont(fontSmall);
        Vorname.setBorder(new EmptyBorder(0,0,0,0));
        Vorname.setText("Die Variable 3");

        Gender.setForeground(white);
        Gender.setBackground(dark);
        Gender.setFont(fontSmall);
        Gender.setBorder(new EmptyBorder(0,0,0,0));
        Gender.setText("Die Variable 4");

        Rolle.setForeground(white);
        Rolle.setBackground(dark);
        Rolle.setFont(fontSmall);
        Rolle.setBorder(new EmptyBorder(0,0,0,0));
        Rolle.setText("Die Variable 5");

        Geburtstag.setForeground(white);
        Geburtstag.setBackground(dark);
        Geburtstag.setFont(fontSmall);
        Geburtstag.setBorder(new EmptyBorder(0,0,0,0));
        Geburtstag.setText("Die Variable 6");

        EMail.setForeground(white);
        EMail.setBackground(dark);
        EMail.setFont(fontSmall);
        EMail.setBorder(new EmptyBorder(0,0,0,0));
        EMail.setText("Die Variable 7");

        Telefonnummer.setForeground(white);
        Telefonnummer.setBackground(dark);
        Telefonnummer.setFont(fontSmall);
        Telefonnummer.setBorder(new EmptyBorder(0,0,0,0));
        Telefonnummer.setText("Die Variable 8");


        AbbrechenButton.addActionListener(this);
        AbbrechenButton.setBackground(hellb);
        AbbrechenButton.setForeground(white);
        AbbrechenButton.setText("Abbrechen");
        AbbrechenButton.setBounds(0,0,100,50);

        AngabenAendern.addActionListener(this);
        AngabenAendern.setBackground(dunkelb);
        AngabenAendern.setForeground(white);
        AngabenAendern.setText("Angaben ändern?");
        AngabenAendern.setBounds(0,0,100,50);


        // Elemente zu Panels adden

        Ueberschrift.add(Text, BorderLayout.CENTER);

        Textfelder.add(Benutzername);
        Textfelder.add(Name);
        Textfelder.add(Vorname);
        Textfelder.add(Gender);
        Textfelder.add(Rolle);
        Textfelder.add(Geburtstag);
        Textfelder.add(EMail);
        Textfelder.add(Telefonnummer);

        Buttons.add(AbbrechenButton);
        Buttons.add(AngabenAendern);


        // Panels zu Frame adden

        this.add(Ueberschrift);
        this.add(Textfelder);
        this.add(Buttons);


        this.setSize(400, 1000);
        this.setTitle("Profil");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        this.setLocationRelativeTo(parent);





    }


    public static void openProfilGUI(Container parent){
        if (parent.getClass().equals(KontrolleurGUI.class)){
            System.out.println("ParentFrame ist KontrolleurGUI");
            ProfilGUI gui1 = new ProfilGUI(parent);
        }else if(parent.getClass().equals(SachbearbeiterGUI.class)){
            System.out.println("ParentFrame ist SachbearbeiterGUI");
            ProfilGUI gui1 = new ProfilGUI(parent);
        } else if (parent.getClass().equals(AdminGUI.class)) {
            System.out.println("ParentFrame ist AdminGUI");
            ProfilGUI gui1 = new ProfilGUI(parent);
        } else{
            System.out.println("Du hast verkackt mhm mhm");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new ProfilGUI(null);
    }
}
