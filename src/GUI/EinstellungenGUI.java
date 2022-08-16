package src.GUI;
import src.Foo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static src.Foo.*;

public class EinstellungenGUI implements ActionListener {

    JFrame Frame = new JFrame();
    JPanel Background = new JPanel();
    JLabel Ueberschrift = new JLabel();
    JButton AnButton = new JButton();
    JButton LogButton = new JButton();
    JButton AbbrechenButton = new JButton();
    JLabel ButtonTextAn = new JLabel();
    JLabel ButtonTextAus = new JLabel();
    JLabel ButtonUeberschriftAnmelden = new JLabel();
    JLabel ButtonAutoLoginUeberschrift = new JLabel();
    JLabel ButtonAutoLoginText = new JLabel();
    public EinstellungenGUI(String AutoLogin) {

        Foo.getDirectoryData();

        // Panelmanagement
        Background.setBackground(dark);
        Background.setBounds(1,1,300,500);
        Background.setLayout(null);

        // Elementemanagement

        Ueberschrift.setForeground(white);
        Ueberschrift.setFont(fontMediumMedium);
        Ueberschrift.setText("Einstellungen");
        Ueberschrift.setBounds(63,45,173,40);

        ButtonTextAn.setForeground(white);
        ButtonTextAn.setFont(fontSmall);
        ButtonTextAn.setText("An");
        ButtonTextAn.setBorder(new EmptyBorder(35, 10, 0, 0));

        ButtonTextAus.setForeground(Grey);
        ButtonTextAus.setFont(new Font("IBM Plex Mono Medium", Font.PLAIN, 15));
        ButtonTextAus.setText("Aus");
        ButtonTextAus.setBorder(new EmptyBorder(35, 97, 0,10));

        ButtonUeberschriftAnmelden.setForeground(dark);
        ButtonUeberschriftAnmelden.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 18));
        ButtonUeberschriftAnmelden.setText("<html><body><center><p>Angemeldet <br>bleiben</p></center></body></html>");
        ButtonUeberschriftAnmelden.setBorder(new EmptyBorder(10,8,40,8));

        AnButton.addActionListener(this);
        AnButton.setBackground(dunkelb);
        AnButton.setForeground(white);
        AnButton.setFont(fontSmall);
        AnButton.add(ButtonUeberschriftAnmelden);
        AnButton.add(ButtonTextAn);
        AnButton.add(ButtonTextAus);
        AnButton.setBounds(75,110,150,80);

        ButtonAutoLoginUeberschrift.setForeground(dark);
        ButtonAutoLoginUeberschrift.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 18));
        ButtonAutoLoginUeberschrift.setText("Auto-Login");
        ButtonAutoLoginUeberschrift.setBorder(new EmptyBorder(10,14,40,14));

        ButtonAutoLoginText.setForeground(white);
        ButtonAutoLoginText.setFont(fontSmall);
        ButtonAutoLoginText.setText(AutoLogin + " min");
        ButtonAutoLoginText.setBorder(new EmptyBorder(28,35,0,35));

        LogButton.addActionListener(this);
        LogButton.setBackground(hellb);
        LogButton.setForeground(dark);
        LogButton.setFont(fontSmall);
        LogButton.add(ButtonAutoLoginUeberschrift);
        LogButton.add(ButtonAutoLoginText);
        LogButton.setBounds(75,210,150,80);

        AbbrechenButton.addActionListener(this);
        AbbrechenButton.setBackground(dunkelb);
        AbbrechenButton.setForeground(white);
        AbbrechenButton.setFont(fontSmall);
        AbbrechenButton.setText("<html><body>Abbrechen</body></html>");
        AbbrechenButton.setBounds(75,310,150,80);

        Background.add(Ueberschrift);
        Background.add(AnButton);
        Background.add(LogButton);
        Background.add(AbbrechenButton);

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        Frame.add(Background);
        Frame.setResizable(false);
        int width = 300;
        int height = 500;
        Frame.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        Frame.setTitle("Einstellungen");
        Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Frame.setVisible(true);


    }

    public static void openEinstellungenGUI(){

        new EinstellungenGUI("10");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new EinstellungenGUI("10");
    }
}
