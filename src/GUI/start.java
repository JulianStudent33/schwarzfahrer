package src.GUI;
import src.Foo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class start extends JFrame implements ActionListener {

    //
    private JButton reg = new JButton();
    private JButton anm = new JButton();


    // Farbpalette
    private Color dark = new Color(44,44,44);
    private Color white = new Color(255,255,255);
    private Color hellb = new Color(133, 179, 255);
    private Color dunkelb = new Color(74,142,255);

    //Konstruktor
    start() {

        // Start des Fensters
        frame();
    }

    private void frame() {

        // Panelmanagement
        JPanel Background = new JPanel();
        Background.setBackground(Color.red);
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
        Border border = BorderFactory.createLineBorder(Color.white, 20);
        JSeparator trenn = new JSeparator();
        trenn.setForeground(white);
        trenn.setPreferredSize(new Dimension(350,10));
        trenn.setAlignmentX(CENTER_ALIGNMENT);
        trenn.setBorder(border);
        trenn.setAlignmentY(BOTTOM_ALIGNMENT);

        // "Willkommen auf der" Text
        JLabel label = new JLabel();
        label.setText("<html><body><center><p>Wilkommen auf der<br>Startoberfläche</p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 38));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(-8,70, 500,100);

        // Mini Text unter Trennlinie
        JLabel label1 = new JLabel();
        label1.setText("<html><body><center><p>Wählen sie ob sie sich registrieren<br>oder anmelden wollen</p></center></body></html>");
        label1.setForeground(white);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 15));
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
        reg.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        reg.setHorizontalAlignment(JLabel.CENTER);
        reg.setVerticalAlignment(JLabel.CENTER);
        reg.setFocusable(false);
        reg.setBorderPainted(false);
        reg.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        reg.setBounds(140,-10,200,100);


        // JButton "anmelden"
        anm.addActionListener(this);
        anm.setText("Anmelden");
        anm.setBackground(dunkelb);
        anm.setForeground(white);
        anm.setHorizontalTextPosition(JLabel.CENTER);
        anm.setVerticalTextPosition(JLabel.CENTER);
        anm.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        anm.setHorizontalAlignment(JLabel.CENTER);
        anm.setVerticalAlignment(JLabel.CENTER);
        anm.setFocusable(false);
        anm.setBorderPainted(false);
        anm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        anm.setBounds(140,10,200,100);





        // Gesamt Window
        this.setSize(500,650);
        this.setTitle("Schwarzfahrer Projekt");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
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
                btn.setBackground(dark);
                btn.setEnabled(false);


            }
        }









    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==reg) {
            if (Foo.firstUsage){
                System.out.println("Öffne First-Register-GUI");
                dispose();
                firstRegistrationGUI.firstRegister();
            }else{
                System.out.println("Öffne Register-Window");
                dispose();
                RegisterGUI.register();
            }
        } else if (e.getSource()==anm) {
            System.out.println("Öffne Login-Window");
            dispose();
            LoginGUI.openLogin();
        }
    }


    public static void startFenster(){
        start gui = new start();
    }



}