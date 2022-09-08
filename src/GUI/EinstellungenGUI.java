package src.GUI;
import src.Foo;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.SB.SachbearbeiterGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static src.Foo.*;

public class EinstellungenGUI extends Parent_GUI implements ActionListener {

    String[] optionenLogout = {"Aus", "5", "15", "30"};
    int optionAusgewaehlt;
    boolean angemeldetBleiben;

    JFrame Frame = new JFrame();
    JPanel Background = new JPanel();
    JLabel Ueberschrift = new JLabel();
    JButton AnButton = new JButton();
    JButton LogoutButton = new JButton();

    JButton ColorChange = new JButton();
    JButton SpeichernButton = new JButton();
    JLabel ButtonTextAn = new JLabel();
    JLabel ButtonTextAus = new JLabel();
    JLabel ButtonUeberschriftAnmelden = new JLabel();

    JLabel ButtonUeberschriftColor = new JLabel();

    JLabel ButtonTextColor = new JLabel();
    JLabel ButtonAutoLogoutUeberschrift = new JLabel();
    JLabel ButtonAutoLogoutText = new JLabel();
    public EinstellungenGUI(Parent_GUI parent) {

        //Setup
        setupGUI(parent, "EinstellungenGUI");
        this.angemeldetBleiben = Foo.angemeldetBleiben;

        // Panelmanagement
        Background.setBackground(dark);
        Background.setBounds(0, 0, 300, 500);
        Background.setLayout(null);

        // Elementemanagement

        Ueberschrift.setForeground(white);
        Ueberschrift.setFont(fontMediumMedium);
        Ueberschrift.setText("Einstellungen");
        Ueberschrift.setBounds(40, 45, 250, 40);

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
        if (colorChange){
            ButtonTextColor.setText("White");
        }else{
            ButtonTextColor.setText("Dark");
        }


        ButtonTextAn.setText("An");
        ButtonTextAn.setBorder(new EmptyBorder(35, 8, 0, 0));
        ButtonTextAus.setText("Aus");
        ButtonTextAus.setBorder(new EmptyBorder(35, 90, 0, 0));

        ButtonTextColor.setForeground(white);
        ButtonTextColor.setFont(fontSmall);
        ButtonTextColor.setBorder(new EmptyBorder(28, 40, 0, 0));




        ButtonUeberschriftAnmelden.setForeground(dark);
        ButtonUeberschriftAnmelden.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 18));
        ButtonUeberschriftAnmelden.setText("<html><body><center><p>Angemeldet<br>bleiben</p></center></body></html>");
        ButtonUeberschriftAnmelden.setBorder(new EmptyBorder(10, 2, 40, 2));

        ButtonUeberschriftColor.setForeground(dark);
        ButtonUeberschriftColor.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 18));
        ButtonUeberschriftColor.setText("<html><body><center><p>Color-Mode</p></center></body></html>");
        ButtonUeberschriftColor.setBorder(new EmptyBorder(10, 2, 40, 2));

        AnButton.addActionListener(this);
        AnButton.setBackground(dunkelb);
        AnButton.setForeground(white);
        AnButton.setFont(fontSmall);
        AnButton.add(ButtonUeberschriftAnmelden);
        AnButton.add(ButtonTextAn);
        AnButton.add(ButtonTextAus);
        AnButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AnButton.setBounds(75, 110, 150, 80);

        ButtonAutoLogoutUeberschrift.setForeground(dark);
        ButtonAutoLogoutUeberschrift.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 16));
        ButtonAutoLogoutUeberschrift.setText("Auto-Logout");
        ButtonAutoLogoutUeberschrift.setBorder(new EmptyBorder(10, 0, 40, 0));

        System.out.println("AutoLogout: " + this.currentUser.getAutoLogout());
        //ButtonAutoLogoutText
        if (this.currentUser.getAutoLogout().equals(optionenLogout[0])) {
            ButtonAutoLogoutText.setText(optionenLogout[0]);
            optionAusgewaehlt = 0;
        } else if (this.currentUser.getAutoLogout().equals(optionenLogout[1])) {
            ButtonAutoLogoutText.setText(optionenLogout[1]);
            optionAusgewaehlt = 1;
        } else if (this.currentUser.getAutoLogout().equals(optionenLogout[2])) {
            ButtonAutoLogoutText.setText(optionenLogout[2]);
            optionAusgewaehlt = 2;
        } else if (this.currentUser.getAutoLogout().equals(optionenLogout[3])) {
            ButtonAutoLogoutText.setText(optionenLogout[3]);
            optionAusgewaehlt = 3;
        }

        ButtonAutoLogoutText.setForeground(white);
        ButtonAutoLogoutText.setFont(fontSmall);
        ButtonAutoLogoutText.setBorder(new EmptyBorder(28, 46, 0, 0));

        LogoutButton.addActionListener(this);
        LogoutButton.setBackground(hellb);
        LogoutButton.setForeground(dark);
        LogoutButton.setFont(fontSmall);
        LogoutButton.add(ButtonAutoLogoutUeberschrift);
        LogoutButton.add(ButtonAutoLogoutText);
        LogoutButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        LogoutButton.setBounds(75, 210, 150, 80);

        SpeichernButton.addActionListener(this);
        SpeichernButton.setBackground(dunkelb);
        SpeichernButton.setForeground(white);
        SpeichernButton.setFont(fontSmall);
        SpeichernButton.setText("<html><body>Speichern</body></html>");
        SpeichernButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SpeichernButton.setBounds(75, 410, 150, 80);

        ColorChange.addActionListener(this);
        ColorChange.add(ButtonUeberschriftColor);
        ColorChange.add(ButtonTextColor);
        ColorChange.setBackground(dunkelb);
        ColorChange.setForeground(white);
        ColorChange.setFont(fontSmall);
        ColorChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ColorChange.setBounds(75, 310, 150, 80);

        Background.add(Ueberschrift);
        Background.add(AnButton);
        Background.add(LogoutButton);
        Background.add(ColorChange);
        Background.add(SpeichernButton);


        this.setSize(300, 600);
        this.setTitle("Einstellungen");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.add(Background);

        this.setLocationRelativeTo(parent);

        ColorChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ButtonTextColor.getText().equals("White")){
                    ButtonTextColor.setText("Dark");
                }else{
                    ButtonTextColor.setText("White");
                }
            }
        });
        SpeichernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (colorChange){
                    if (ButtonTextColor.getText().equals("Dark")){
                        try {
                            setColorChange(false);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            throw new RuntimeException(ex);
                        }
                    }
                }else{
                    if (ButtonTextColor.getText().equals("White")){
                        try {
                            setColorChange(true);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            throw new RuntimeException(ex);
                        }
                    }
                }

                try {
                    currentUser.setAutoLogout(ButtonAutoLogoutText.getText());
                    Foo.saveAngemeldetBleiben(angemeldetBleiben);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }


                if (konAngemeldet){
                    KontrolleurGUI.openKonGUI(parentGUI.parentGUI);
                }
                if (adminAngemeldet){
                    AdminGUI.openAdminGUI(parentGUI.parentGUI);
                }
                if (sbAngemeldet){
                    SachbearbeiterGUI.openSBGUI(parentGUI.parentGUI);
                }
                parentGUI.dispose();
                dispose();
            }
        });

        AnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (angemeldetBleiben) {

                    ButtonTextAn.setForeground(Color.lightGray);
                    ButtonTextAn.setFont(fontSmallPlain);
                    ButtonTextAus.setForeground(white);
                    ButtonTextAus.setFont(fontSmall);

                    angemeldetBleiben = false;
                    System.out.println("Angemeldet bleiben jetzt false");
                } else {

                    ButtonTextAn.setForeground(white);
                    ButtonTextAn.setFont(fontSmall);
                    ButtonTextAus.setForeground(Color.lightGray);
                    ButtonTextAus.setFont(fontSmallPlain);

                    angemeldetBleiben = true;
                    System.out.println("Angemeldet bleiben jetzt true");
                }

            }
        });

        LogoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (optionAusgewaehlt!=3){
                    optionAusgewaehlt++;
                } else{
                    optionAusgewaehlt = 0;
                }
                ButtonAutoLogoutText.setText(optionenLogout[optionAusgewaehlt]);

            }
        });


    }
        public static void openEinstellungenGUI (Parent_GUI parent){

            if (parent.getClass().equals(KontrolleurGUI.class)){
                System.out.println("ParentFrame ist KontrolleurGUI");
                    EinstellungenGUI gui = new EinstellungenGUI(parent);
            }else if(parent.getClass().equals(SachbearbeiterGUI.class)){
                System.out.println("ParentFrame ist SachbearbeiterGUI");
                EinstellungenGUI gui = new EinstellungenGUI(parent);
            } else if (parent.getClass().equals(AdminGUI.class)) {
                System.out.println("ParentFrame ist AdminGUI");
                EinstellungenGUI gui = new EinstellungenGUI(parent);
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
