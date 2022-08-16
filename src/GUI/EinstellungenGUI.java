package src.GUI;
import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.GUI.elements.InactivityListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static src.Foo.*;

public class EinstellungenGUI extends JFrame implements ActionListener {


    String[] optionenLogout = {"Aus", "10", "15", "30"};
    int optionAusgewaehlt;

    public static SachbearbeiterGUI parentS = null;
    public static KontrolleurGUI parentK = null;
    public static AdminGUI parentA = null;

    JFrame Frame = new JFrame();
    JPanel Background = new JPanel();
    JLabel Ueberschrift = new JLabel();
    JButton AnButton = new JButton();
    JButton LogoutButton = new JButton();
    JButton AbbrechenButton = new JButton();
    JLabel ButtonTextAn = new JLabel();
    JLabel ButtonTextAus = new JLabel();
    JLabel ButtonUeberschriftAnmelden = new JLabel();
    JLabel ButtonAutoLogoutUeberschrift = new JLabel();
    JLabel ButtonAutoLogoutText = new JLabel();
    public EinstellungenGUI(Container parent) {

        Foo.getDirectoryData();

        Action logout = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
               dispose();
            }
        };
        InactivityListener listener = new InactivityListener(this, logout, 1);
        listener.start();



        // Panelmanagement
        Background.setBackground(dark);
        Background.setBounds(1, 1, 300, 500);
        Background.setLayout(null);

        // Elementemanagement

        Ueberschrift.setForeground(white);
        Ueberschrift.setFont(fontMediumMedium);
        Ueberschrift.setText("Einstellungen");
        Ueberschrift.setBounds(63, 45, 173, 40);

        if (angemeldetBleiben) {
            ButtonTextAn.setForeground(white);
            ButtonTextAn.setFont(fontSmall);
            ButtonTextAus.setForeground(Color.lightGray);
            ButtonTextAus.setFont(fontSmallPlain);

        } else {
            ButtonTextAn.setForeground(Color.lightGray);
            ButtonTextAn.setFont(fontSmallPlain);
            ButtonTextAus.setForeground(white);
            ButtonTextAus.setFont(fontSmall);
        }

        ButtonTextAn.setText("An");
        ButtonTextAn.setBorder(new EmptyBorder(35, 10, 0, 0));


        ButtonTextAus.setText("Aus");
        ButtonTextAus.setBorder(new EmptyBorder(35, 90, 0, 0));


        ButtonUeberschriftAnmelden.setForeground(dark);
        ButtonUeberschriftAnmelden.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 18));
        ButtonUeberschriftAnmelden.setText("<html><body><center><p>Angemeldet <br>bleiben</p></center></body></html>");
        ButtonUeberschriftAnmelden.setBorder(new EmptyBorder(10, 8, 40, 8));

        AnButton.addActionListener(this);
        AnButton.setBackground(dunkelb);
        AnButton.setForeground(white);
        AnButton.setFont(fontSmall);
        AnButton.add(ButtonUeberschriftAnmelden);
        AnButton.add(ButtonTextAn);
        AnButton.add(ButtonTextAus);
        AnButton.setBounds(75, 110, 150, 80);

        ButtonAutoLogoutUeberschrift.setForeground(dark);
        ButtonAutoLogoutUeberschrift.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 18));
        ButtonAutoLogoutUeberschrift.setText("Auto-Logout");
        ButtonAutoLogoutUeberschrift.setBorder(new EmptyBorder(10, 0, 40, 0));


        //ButtonAutoLogoutText
        if (autoLogoutTime.equals(optionenLogout[0])) {
            ButtonAutoLogoutText.setText(optionenLogout[0]);
            optionAusgewaehlt = 0;
        } else if (autoLogoutTime.equals(optionenLogout[1])) {
            ButtonAutoLogoutText.setText(optionenLogout[1] + " min");
            optionAusgewaehlt = 1;
        } else if (autoLogoutTime.equals(optionenLogout[2])) {
            ButtonAutoLogoutText.setText(optionenLogout[2] + " min");
            optionAusgewaehlt = 2;
        } else if (autoLogoutTime.equals(optionenLogout[3])) {
            ButtonAutoLogoutText.setText(optionenLogout[3] + " min");
            optionAusgewaehlt = 3;
        }
        ButtonAutoLogoutText.setForeground(white);
        ButtonAutoLogoutText.setFont(fontSmall);
        ButtonAutoLogoutText.setBorder(new EmptyBorder(28, 35, 0, 35));

        LogoutButton.addActionListener(this);
        LogoutButton.setBackground(hellb);
        LogoutButton.setForeground(dark);
        LogoutButton.setFont(fontSmall);
        LogoutButton.add(ButtonAutoLogoutUeberschrift);
        LogoutButton.add(ButtonAutoLogoutText);
        LogoutButton.setBounds(75, 210, 150, 80);

        AbbrechenButton.addActionListener(this);
        AbbrechenButton.setBackground(dunkelb);
        AbbrechenButton.setForeground(white);
        AbbrechenButton.setFont(fontSmall);
        AbbrechenButton.setText("<html><body>Abbrechen</body></html>");
        AbbrechenButton.setBounds(75, 310, 150, 80);

        Background.add(Ueberschrift);
        Background.add(AnButton);
        Background.add(LogoutButton);
        Background.add(AbbrechenButton);


        this.setSize(300, 500);
        this.setTitle("Einstellungen");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.add(Background);

        this.setLocationRelativeTo(parent);


        AnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (Foo.angemeldetBleiben) {

                    ButtonTextAn.setForeground(Color.lightGray);
                    ButtonTextAn.setFont(fontSmallPlain);
                    ButtonTextAus.setForeground(white);
                    ButtonTextAus.setFont(fontSmall);
                    try {
                        Foo.saveAngemeldetBleiben(false);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                    System.out.println("Angemeldet bleiben jetzt false");
                } else {

                    ButtonTextAn.setForeground(white);
                    ButtonTextAn.setFont(fontSmall);
                    ButtonTextAus.setForeground(Color.lightGray);
                    ButtonTextAus.setFont(fontSmallPlain);
                    try {
                        Foo.saveAngemeldetBleiben(true);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }

                    System.out.println("Angemeldet bleiben jetzt true");
                }

            }
        });

        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


            }
        });

        AbbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });

    }
        public static void openEinstellungenGUI (Container parent){
            if (parent.getClass().equals(KontrolleurGUI.class)){
                System.out.println("ParentFrame ist KontrolleurGUI");
                    EinstellungenGUI gui1 = new EinstellungenGUI(parent);
            }else if(parent.getClass().equals(SachbearbeiterGUI.class)){
                System.out.println("ParentFrame ist SachbearbeiterGUI");
                EinstellungenGUI gui1 = new EinstellungenGUI(parent);
            } else if (parent.getClass().equals(AdminGUI.class)) {
                System.out.println("ParentFrame ist AdminGUI");
                EinstellungenGUI gui1 = new EinstellungenGUI(parent);
            } else{
                System.out.println("Du hast verkackt mhm mhm");
            }

        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new EinstellungenGUI(null);
    }
}
