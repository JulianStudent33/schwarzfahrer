package src.GUI;
import src.Foo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static src.Foo.*;

public class StartfensterGUI extends GUI_Mama implements ActionListener {

    //
    private JButton reg = new JButton();
    private JButton anm = new JButton();







    //Konstruktor
    StartfensterGUI(GUI_Mama parent) {

        // Start des Fensters
        frame(parent);
    }

    private void frame(GUI_Mama parent) {

        getDirectoryData();

        // Panelmanagement
        JPanel Background = new JPanel();
        Background.setBackground(dark);
        Background.setLayout(new BorderLayout());

        JPanel Bot = new JPanel();
        Bot.setBackground(dark);
        Bot.setPreferredSize(new Dimension(100, 200));
        Bot.setLayout(null);

        JPanel Text = new JPanel();
        Text.setBackground(dark);
        Text.setPreferredSize(new Dimension(100,180));
        Text.setLayout(null);

        JPanel Trennlinie = new JPanel();
        Trennlinie.setBackground(dark);
        Trennlinie.setPreferredSize(new Dimension(100,20));

        JPanel minitxt = new JPanel();
        minitxt.setBackground(dark);
        minitxt.setPreferredSize(new Dimension(100,200));
        minitxt.setLayout(null);

        JPanel regb = new JPanel();
        regb.setBackground(dark);
        regb.setPreferredSize(new Dimension(100 ,100));
        regb.setLayout(null);

        // Trennlinie
        Border border = BorderFactory.createLineBorder(white, 20);
        JSeparator trenn = new JSeparator();
        trenn.setForeground(white);
        trenn.setPreferredSize(new Dimension(350,10));
        trenn.setAlignmentX(CENTER_ALIGNMENT);
        trenn.setBorder(border);
        trenn.setAlignmentY(BOTTOM_ALIGNMENT);

        // "Willkommen auf der" Text
        JLabel label = new JLabel();
        label.setText("<html><body><center><p>Willkommen auf der<br>Startoberfläche</p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(fontLargeLarge);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(-8,70, 500,100);

        // Mini Text unter Trennlinie
        JLabel label1 = new JLabel();
        label1.setText("<html><body><center><p>Wählen sie ob sie sich registrieren<br>oder anmelden wollen</p></center></body></html>");
        label1.setForeground(white);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setFont(fontSmall);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setBounds(-9,-10, 500,100);

        // JButton "registrieren"
        reg.addActionListener(this);
        reg.setText("Registrieren");
        reg.setBackground(hellb);
        reg.setForeground(white);
        reg.setHorizontalTextPosition(JLabel.CENTER);
        reg.setVerticalTextPosition(JLabel.CENTER);
        reg.setFont(fontMedium);
        reg.setHorizontalAlignment(JLabel.CENTER);
        reg.setVerticalAlignment(JLabel.CENTER);
        reg.setFocusable(false);
        reg.setBorderPainted(false);
        reg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reg.setBounds(140,0,200,100);


        // JButton "anmelden"
        anm.addActionListener(this);
        anm.setText("Anmelden");
        anm.setBackground(dunkelb);
        anm.setForeground(white);
        anm.setHorizontalTextPosition(JLabel.CENTER);
        anm.setVerticalTextPosition(JLabel.CENTER);
        anm.setFont(fontMedium);
        anm.setHorizontalAlignment(JLabel.CENTER);
        anm.setVerticalAlignment(JLabel.CENTER);
        anm.setFocusable(false);
        anm.setBorderPainted(false);
        anm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        anm.setBounds(140,10,200,100);





        // Gesamt Window
        int width = 500;
        int height = 650;
        this.setSize(width,height);
        this.setTitle("Schwarzfahrer Projekt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setLocationRelativeTo(parent);
        this.setVisible(true);
        this.getContentPane().setBackground(dark);

        // Add Befehle

        // Daten aktualisieren
        Foo.getDirectoryData();

        // Add für einzelnen Elemente innerhalb der Panels
        Text.add(label, BorderLayout.SOUTH);
        minitxt.add(label1, BorderLayout.CENTER);
        Trennlinie.add(trenn, BorderLayout.CENTER);
        regb.add(reg, BorderLayout.CENTER);
        Bot.add(anm, BorderLayout.NORTH);

        // Add für gesamte Panels
        this.add(Background, BorderLayout.CENTER);
        this.add(Text, BorderLayout.NORTH);
        Background.add(Trennlinie, BorderLayout.NORTH);
        Background.add(minitxt, BorderLayout.CENTER);
        Background.add(regb, BorderLayout.SOUTH);
        this.add(Bot, BorderLayout.SOUTH);

        //Button Anmelden Deaktivieren, wenn App zum ersten mal startet

        if (Foo.firstUsage){
            if (anm instanceof AbstractButton) {
                AbstractButton btn = (AbstractButton) anm;
                btn.setText("");
                label1.setText("<html><body><center><p>Registrieren sie einen<br>Administrator</p></center></body></html>");
                btn.setBackground(dark);
                btn.setContentAreaFilled(false);
                btn.setEnabled(false);
                System.out.println("Anmelden: enabled");

            }else{
                System.out.println("Anmelden: enabled");
            }
        }









    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==reg) {
            if (Foo.firstUsage){
                System.out.println("Öffne First-Register-GUI");
                RegisterWindow.openRegisterGUI(getFrame());
                dispose();
            }else{
                System.out.println("Öffne Register-Window");
                RegisterWindow.openRegisterGUI(getFrame());
                dispose();
            }
        } else if (e.getSource()==anm) {
            System.out.println("Öffne Login-Window");
            LoginGUI.openLogin(getFrame());
            dispose();
        }
    }



    public static void openStartFenster(GUI_Mama parent){
        Foo.getDirectoryData();
        StartfensterGUI gui = new StartfensterGUI(parent);
    }



}