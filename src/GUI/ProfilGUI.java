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

    public ProfilGUI(Container parent){
        //Panelmanagement

        label.setBackground(dark);
        label.setPreferredSize(new Dimension(400,100));
        label.setLayout(null);

        Textfelder.setLayout(new BorderLayout());
        Textfelder.setBackground(dark);
        Textfelder.setPreferredSize(new Dimension(300,400));

        Buttons.setBackground(dark);
        Buttons.setPreferredSize(new Dimension(400,150));
        Buttons.setLayout(null);

        // Elemente

        Text.setForeground(white);
        Text.setFont(fontMedium);
        Text.setText("<html><body><p>Profil von <br>... </p></body></html>");
        Text.setBounds(100,0,200,100);

        Benutzername.setForeground(white);
        Benutzername.setBackground(dark);
        Benutzername.setFont(fontSmall);
        Benutzername.setBorder(new EmptyBorder(0,0,0,0));
        Benutzername.setBounds(20,20,200,20);
        Benutzername.setText("Die Variable");

        Name.setForeground(white);
        Name.setBackground(dark);
        Name.setFont(fontSmall);
        Name.setBorder(new EmptyBorder(0,0,0,0));
        Name.setBounds(20,40,200,20);
        Name.setText("Die Variable 2");

        Vorname.setForeground(white);
        Vorname.setBackground(dark);
        Vorname.setFont(fontSmall);
        Vorname.setBorder(new EmptyBorder(0,0,0,0));
        Vorname.setBounds(20,60,200,20);
        Vorname.setText("Die Variable 3");

        Gender.setForeground(white);
        Gender.setBackground(dark);
        Gender.setFont(fontSmall);
        Gender.setBorder(new EmptyBorder(0,0,0,0));
        Gender.setBounds(20,80,200,20);
        Gender.setText("Die Variable 4");

        Rolle.setForeground(white);
        Rolle.setBackground(dark);
        Rolle.setFont(fontSmall);
        Rolle.setBorder(new EmptyBorder(0,0,0,0));
        Rolle.setBounds(20,100,200,20);
        Rolle.setText("Die Variable 5");

        Geburtstag.setForeground(white);
        Geburtstag.setBackground(dark);
        Geburtstag.setFont(fontSmall);
        Geburtstag.setBorder(new EmptyBorder(0,0,0,0));
        Geburtstag.setBounds(20,120,200,20);
        Geburtstag.setText("Die Variable 6");

        EMail.setForeground(white);
        EMail.setBackground(dark);
        EMail.setFont(fontSmall);
        EMail.setBorder(new EmptyBorder(0,0,0,0));
        EMail.setBounds(20,140,200,20);
        EMail.setText("Die Variable 7");

        Telefonnummer.setForeground(white);
        Telefonnummer.setBackground(dark);
        Telefonnummer.setFont(fontSmall);
        Telefonnummer.setBorder(new EmptyBorder(0,0,0,0));
        Telefonnummer.setBounds(20,160,200,20);
        Telefonnummer.setText("Die Variable 8");


        AbbrechenButton.setBackground(hellb);
        AbbrechenButton.setForeground(white);
        AbbrechenButton.setText("Abbrechen");
        AbbrechenButton.setBounds(225,20,100,60);

        AbbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


        AngabenAendern.addActionListener(this);
        AngabenAendern.setBackground(dunkelb);
        AngabenAendern.setForeground(white);
        AngabenAendern.setText("<html><body><p><center>Angaben <br>ändern?</center></p></body></html>");
        AngabenAendern.setBounds(75,20,100,60);


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
            }
        });


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
