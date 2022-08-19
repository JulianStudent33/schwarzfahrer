package src.GUI;
import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.PlaceholderTextField;
import src.nickcode.pass;
import src.roles.Administrator;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static src.Foo.*;
public class ProfilGUI extends GUI_Mama implements ActionListener {

    public SachbearbeiterGUI parentS = null;
    public KontrolleurGUI parentK = null;
    public AdminGUI parentA = null;

    JPanel label = new JPanel();
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
    JButton SpeichernButton = new JButton();
    JButton AbbrechenButton = new JButton();
    JButton AngabenAendern = new JButton();
    JButton PasswortAendernButton = new JButton();
    JLabel AngabenAendernLabel = new JLabel();
    JLabel PasswortVergessenLabel = new JLabel();
    String rollenString;

    JButton SpeicherButton = new JButton();

    public ProfilGUI(GUI_Mama parent){

        setupGUI(parent, "ProfilGUI");


        //Panelmanagement

        label.setBackground(dark);
        label.setPreferredSize(new Dimension(400,100));
        label.setLayout(null);

        Textfelder.setLayout(null);
        Textfelder.setBackground(dark);
        Textfelder.setPreferredSize(new Dimension(400,600));


        Buttons.setBackground(dark);
        Buttons.setPreferredSize(new Dimension(400,150));
        Buttons.setLayout(null);

        // Elemente

        Text.setForeground(white);
        Text.setFont(fontMediumMedium);
        Text.setText("<html><body><center><p>Profil von <br>"+ currentUser.getVorname() + "</p></center></body></html>");
        Text.setBounds(140,0,400,100);

        Benutzername.setForeground(white);
        Benutzername.setBackground(dark);
        Benutzername.setFont(fontMedium);
        Benutzername.setEnabled(false);
        Benutzername.setBounds(75,440,250,40);
        Benutzername.setPlaceholder(currentUser.getBenutzername());

        Name.setForeground(white);
        Name.setBackground(dark);
        Name.setFont(fontMedium);
        Name.setEnabled(false);
        Name.setBounds(75,80,250,40);
        Name.setPlaceholder(currentUser.getName());

        Vorname.setForeground(white);
        Vorname.setBackground(dark);
        Vorname.setFont(fontMedium);
        Vorname.setEnabled(false);
        Vorname.setBounds(75,20,250,40);
        Vorname.setPlaceholder(currentUser.getVorname());

        Gender.setForeground(white);
        Gender.setBackground(dark);
        Gender.setFont(fontMedium);
        Gender.setEnabled(false);
        Gender.setBounds(75,140,250,40);
        Gender.setPlaceholder(currentUser.getGeschlecht());

        Rolle.setForeground(white);
        Rolle.setBackground(dark);
        Rolle.setFont(fontMedium);
        Rolle.setEnabled(false);
        Rolle.setBounds(75,200,250,40);
        Rolle.setPlaceholder("");

        Geburtstag.setForeground(white);
        Geburtstag.setBackground(dark);
        Geburtstag.setFont(fontMedium);
        Geburtstag.setEnabled(false);
        Geburtstag.setBounds(75,260,250,40);
        Geburtstag.setPlaceholder("Geburtstag");

        EMail.setForeground(white);
        EMail.setBackground(dark);
        EMail.setFont(fontMedium);
        EMail.setEnabled(false);
        EMail.setBounds(75,320,250,40);
        EMail.setPlaceholder("E-Mail");

        Telefonnummer.setForeground(white);
        Telefonnummer.setBackground(dark);
        Telefonnummer.setFont(fontMedium);
        Telefonnummer.setEnabled(false);
        Telefonnummer.setBounds(75,380,250,40);
        Telefonnummer.setPlaceholder("Telefonnummer");


        AbbrechenButton.setBackground(hellb);
        AbbrechenButton.setForeground(white);
        AbbrechenButton.setText("Abbrechen");
        AbbrechenButton.setBounds(150,100,100,40);

        AngabenAendernLabel.setForeground(white);
        AngabenAendernLabel.setText("<html><body><p><center>Angaben <br>ändern?</center></p></body></html>");
        AngabenAendernLabel.setBorder(new EmptyBorder(0,10,18,10));



        AngabenAendern.setBackground(dunkelb);
        AngabenAendern.add(AngabenAendernLabel);
        AngabenAendern.setBounds(75,55,100,40);

        AngabenAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angabenAendernMethod(false);
            }
        });

        PasswortVergessenLabel.setForeground(white);
        PasswortVergessenLabel.setText("<html><body><p><center>Passwort<br>ändern</center></p></body></html>");
        PasswortVergessenLabel.setBorder(new EmptyBorder(0,0,18,13));

        PasswortAendernButton.addActionListener(this);
        PasswortAendernButton.setBackground(dunkelb);
        PasswortAendernButton.add(PasswortVergessenLabel);
        PasswortAendernButton.setBounds(225, 55, 100, 40);

        SpeicherButton.setBackground(hellb);
        SpeicherButton.setForeground(white);
        SpeicherButton.setFont(fontSmall);
        SpeicherButton.setText("Speichern");
        SpeicherButton.setBounds(150,0,100,40);
        SpeicherButton.setVisible(false);


        // Elemente zu Panels adden

        label.add(Text);

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
        Buttons.add(PasswortAendernButton);
        Buttons.add(SpeicherButton);


        // Panels zu Frame adden

        add(label,BorderLayout.NORTH);
        add(Textfelder,BorderLayout.CENTER);
        add(Buttons,BorderLayout.SOUTH);


        setSize(400, 800);
        setTitle("Profil");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(parent);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(parent);

        SpeichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



            }
        });


        AbbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                parentGUI.StartAutoLogout();
                System.out.println("Starte AutoLogout für " + parentGUI.name);
                parentGUI.Kachel4.setEnabled(true);
                dispose();
            }
        });


    }




    public static void openProfilGUI(GUI_Mama parent){

            ProfilGUI gui1 = new ProfilGUI(parent);
    }

    @Override
    public void actionPerformed(ActionEvent e){
    }

   public void angabenAendernMethod(boolean angabenAendern){
        if(angabenAendern == false){


            SpeicherButton.setVisible(true);

            Telefonnummer.setEnabled(true);
            EMail.setEnabled(true);
            Benutzername.setEnabled(true);
            AngabenAendern.setEnabled(false);


        }
    }



    public static void main(String[] args) {
        new ProfilGUI(null);
    }
}
