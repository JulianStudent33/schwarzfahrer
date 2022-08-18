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
    JButton AbbrechenButton = new JButton();
    JButton AngabenAendern = new JButton();
    JLabel AngabenAendernLabel = new JLabel();

    public ProfilGUI(GUI_Mama parent){
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
        Text.setText("<html><body><center><p>Profil von <br>... </p></center></body></html>");
        Text.setBounds(140,0,400,100);

        Benutzername.setForeground(white);
        Benutzername.setBackground(dark);
        Benutzername.setFont(fontMedium);
        Benutzername.setEnabled(false);
        Benutzername.setBounds(75,20,250,40);
        Benutzername.setPlaceholder("Benutzer");

        Name.setForeground(white);
        Name.setBackground(dark);
        Name.setFont(fontMedium);
        Name.setEnabled(true);
        Name.setBounds(75,80,250,40);
        Name.setPlaceholder("Nachname");

        Vorname.setForeground(white);
        Vorname.setBackground(dark);
        Vorname.setFont(fontMedium);
        Vorname.setEnabled(false);
        Vorname.setBounds(75,140,250,40);
        Vorname.setText("Vorname");

        Gender.setForeground(white);
        Gender.setBackground(dark);
        Gender.setFont(fontMedium);
        Gender.setEnabled(false);
        Gender.setBounds(75,200,250,40);
        Gender.setText("Gender");

        Rolle.setForeground(white);
        Rolle.setBackground(dark);
        Rolle.setFont(fontMedium);
        Rolle.setEnabled(false);
        Rolle.setBounds(75,260,250,40);
        Rolle.setText("Rolle");

        Geburtstag.setForeground(white);
        Geburtstag.setBackground(dark);
        Geburtstag.setFont(fontMedium);
        Geburtstag.setEnabled(false);
        Geburtstag.setBounds(75,320,250,40);
        Geburtstag.setText("Geburtstag");

        EMail.setForeground(white);
        EMail.setBackground(dark);
        EMail.setFont(fontMedium);
        EMail.setEnabled(false);
        EMail.setBounds(75,380,250,40);
        EMail.setText("E-Mail");

        Telefonnummer.setForeground(white);
        Telefonnummer.setBackground(dark);
        Telefonnummer.setFont(fontMedium);
        Telefonnummer.setEnabled(false);
        Telefonnummer.setBounds(75,440,250,40);
        Telefonnummer.setText("Telefonnummer");


        AbbrechenButton.setBackground(hellb);
        AbbrechenButton.setForeground(white);
        AbbrechenButton.setText("Abbrechen");
        AbbrechenButton.setBounds(225,20,100,40);

        AngabenAendernLabel.setForeground(white);
        AngabenAendernLabel.setText("<html><body><p><center>Angaben <br>ändern?</center></p></body></html>");
        AngabenAendernLabel.setBorder(new EmptyBorder(0,10,18,10));

        AbbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        AngabenAendern.addActionListener(this);
        AngabenAendern.setBackground(dunkelb);
        AngabenAendern.add(AngabenAendernLabel);
        AngabenAendern.setBounds(75,20,100,40);


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


        // Panels zu Frame adden

        add(label,BorderLayout.NORTH);
        add(Textfelder,BorderLayout.CENTER);
        add(Buttons,BorderLayout.SOUTH);


        setSize(400, 800);
        setTitle("Profil");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setVisible(true);



        AbbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                SachbearbeiterGUI.Profil.setEnabled(true);
                AdminGUI.Profil.setEnabled(true);
                KontrolleurGUI.Profil.setEnabled(true);
            }
        });


    }




    public static void openProfilGUI(GUI_Mama parent){
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
