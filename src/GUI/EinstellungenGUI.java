package src.GUI;
import src.Foo;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static src.Foo.*;

import static src.Foo.*;
public class EinstellungenGUI implements ActionListener {

    JFrame Frame = new JFrame();
    JPanel Background = new JPanel();
    JLabel Ueberschrift = new JLabel();
    JButton AnButton = new JButton();
    JButton LogButton = new JButton();
    JButton AbbrechenButton = new JButton();

    public EinstellungenGUI() {

        // Panelmanagement
        Background.setBackground(dark);
        Background.setBounds(1,1,300,500);
        Background.setLayout(null);

        // Elementemanagement

        Ueberschrift.setForeground(white);
        Ueberschrift.setFont(fontMediumMedium);
        Ueberschrift.setText("Einstellungen");
        Ueberschrift.setBounds(63,45,173,40);

        AnButton.addActionListener(this);
        AnButton.setBackground(dunkelb);
        AnButton.setForeground(white);
        AnButton.setFont(fontSmall);
        AnButton.setText("<html><body>Angemeldet <br> Bleiben</body></html>");
        AnButton.setBounds(75,110,150,80);

        LogButton.addActionListener(this);
        LogButton.setBackground(hellb);
        LogButton.setForeground(white);
        LogButton.setFont(fontSmall);
        LogButton.setText("<html><body>Auto-Logout</body></html>");
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

        Frame.add(Background);
        Frame.setResizable(false);
        Frame.setSize(300,500);
        Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        Frame.setVisible(true);


    }

    public static void openEinstellungenGUI(){
        Foo.getDirectoryData();
        new EinstellungenGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new EinstellungenGUI();
    }
}
