package src.GUI;
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
    JPanel label = new JPanel();
    JLabel Text = new JLabel();
    JPanel Textfelder = new JPanel();
    JPanel Buttons = new JPanel();
    PlaceholderTextField Benutzername = new PlaceholderTextField();
    PlaceholderTextField Vorname = new PlaceholderTextField();
    PlaceholderTextField Nachname = new PlaceholderTextField();
    PlaceholderTextField Gender = new PlaceholderTextField();
    PlaceholderTextField Rolle = new PlaceholderTextField();
    PlaceholderTextField Geburtstag = new PlaceholderTextField();
    PlaceholderTextField EMail = new PlaceholderTextField();
    PlaceholderTextField Telefonnummer = new PlaceholderTextField();
    JButton AbbrechenButton = new JButton();
    JButton AngabenAendern = new JButton();

    public ProfilGUI(Container parent){
        //Panelmanagement

        label.setBackground(dark);
        label.setPreferredSize(new Dimension(400,100));
        label.setLayout(null);

        Textfelder.setBackground(dark);
        Textfelder.setPreferredSize(new Dimension(400,800));
        Textfelder.setLayout(null);

        Buttons.setBackground(dark);
        Buttons.setPreferredSize(new Dimension(400,50));
        Buttons.setLayout(null);

        // Elemente

        Text.setForeground(white);
        Text.setFont(fontMedium);
        Text.setText("<html><body><p>Profil von <br>... </p></body></html>");
        Text.setBounds(100,0,100,100);

        Benutzername.setForeground(white);
        Benutzername.setBackground(dark);
        Benutzername.setFont(fontSmall);
        Benutzername.setBorder(new EmptyBorder(0,0,0,0));
        Benutzername.setText("Die Variable");

        Nachname.setForeground(white);
        Nachname.setBackground(dark);
        Nachname.setFont(fontSmall);
        Nachname.setBorder(new EmptyBorder(0,0,0,0));
        Nachname.setText("Die Variable 2");

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
        Telefonnummer.setBounds(100,200,200,50);
        Telefonnummer.setText("Die Variable 8");


        AbbrechenButton.addActionListener(this);
        AbbrechenButton.setBackground(hellb);
        AbbrechenButton.setForeground(white);
        AbbrechenButton.setText("Abbrechen");
        AbbrechenButton.setBounds(225,700,100,60);

        AngabenAendern.addActionListener(this);
        AngabenAendern.setBackground(dunkelb);
        AngabenAendern.setForeground(white);
        AngabenAendern.setText("<html><body><p><center>Angaben <br>ändern?</center></p></body></html>");
        AngabenAendern.setBounds(75,700,100,60);


        // Elemente zu Panels adden

        label.add(Text);

        Textfelder.add(Benutzername);
        Textfelder.add(Vorname);
        Textfelder.add(Nachname);
        Textfelder.add(Gender);
        Textfelder.add(Rolle);
        Textfelder.add(Geburtstag);
        Textfelder.add(EMail);
        Textfelder.add(Telefonnummer);

        Buttons.add(AbbrechenButton);
        Buttons.add(AngabenAendern);


        // Panels zu Frame adden

        Frame.add(label);
        Frame.add(Textfelder);
        Frame.add(Buttons);


        Frame.setSize(400, 800);
        Frame.setTitle("Profil");
        Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Frame.setResizable(false);
        Frame.setVisible(true);

        Frame.setLocationRelativeTo(parent);





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
