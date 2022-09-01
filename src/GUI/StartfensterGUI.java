package src.GUI;
import src.Foo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static src.Foo.*;

public class StartfensterGUI extends Parent_GUI {

    //
    JPanel Background = new JPanel();
    JPanel Bot = new JPanel();
    JPanel Text = new JPanel();
    JPanel Trennlinie = new JPanel();
    JPanel minitxt = new JPanel();
    JPanel regb = new JPanel();
    JSeparator trenn = new JSeparator();
    JLabel label = new JLabel();
    JLabel label1 = new JLabel();
    private JButton reg = new JButton();
    private JButton anm = new JButton();
    //Konstruktor
    public StartfensterGUI(Parent_GUI parent) {

        // Start des Fensters
        getDirectoryData();
        try {
            getColorChange();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Panelmanagement

        Background.setBackground(dark);
        Background.setLayout(new BorderLayout());


        Bot.setBackground(dark);
        Bot.setPreferredSize(new Dimension(100, 200));
        Bot.setLayout(null);


        Text.setBackground(dark);
        Text.setPreferredSize(new Dimension(100,180));
        Text.setLayout(null);


        Trennlinie.setBackground(dark);
        Trennlinie.setPreferredSize(new Dimension(100,20));


        minitxt.setBackground(dark);
        minitxt.setPreferredSize(new Dimension(100,200));
        minitxt.setLayout(null);


        regb.setBackground(dark);
        regb.setPreferredSize(new Dimension(100 ,100));
        regb.setLayout(null);

        // Trennlinie

        trenn.setForeground(white);
        trenn.setPreferredSize(new Dimension(350,10));
        trenn.setAlignmentX(CENTER_ALIGNMENT);
        trenn.setBorder(BorderFactory.createLineBorder(white, 20));
        trenn.setAlignmentY(BOTTOM_ALIGNMENT);

        // "Willkommen auf der" Text

        label.setText("<html><body><center><p>Willkommen auf der<br>Startoberfläche</p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(fontLargeLarge);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(-8,70, 500,100);

        // Mini Text unter Trennlinie

        label1.setText("<html><body><center><p>Wählen sie ob sie sich registrieren<br>oder anmelden wollen</p></center></body></html>");
        label1.setForeground(white);
        label1.setHorizontalTextPosition(JLabel.CENTER);
        label1.setVerticalTextPosition(JLabel.CENTER);
        label1.setFont(fontSmall);
        label1.setHorizontalAlignment(JLabel.CENTER);
        label1.setVerticalAlignment(JLabel.CENTER);
        label1.setBounds(-9,-10, 500,100);

        // JButton "registrieren"
        styleButtons(reg);
        reg.setText("Registrieren");
        reg.setBackground(hellb);
        reg.setBounds(140,0,200,100);
        reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.out.println("Öffne Register GUI");
                    RegisterGUI.openRegisterGUI(getFrame());
                    dispose();
            }
        });

        // JButton "anmelden"
        styleButtons(anm);
        anm.setText("Anmelden");
        anm.setBackground(dunkelb);
        anm.setBounds(140,10,200,100);
        anm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Öffne Login-Window");
                LoginGUI.openLogin(getFrame());
                dispose();
            }
        });

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
                System.out.println("Anmelden: disabled");
            }else{
                System.out.println("Anmelden: enabled");
            }
        }
    }

        void styleButtons(JButton btn){
            btn.setForeground(white);
            btn.setHorizontalTextPosition(JLabel.CENTER);
            btn.setVerticalTextPosition(JLabel.CENTER);
            btn.setFont(fontMedium);
            btn.setHorizontalAlignment(JLabel.CENTER);
            btn.setVerticalAlignment(JLabel.CENTER);
            btn.setFocusable(true);
            btn.setBorderPainted(false);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
    public static void openStartFenster(Parent_GUI parent){
        StartfensterGUI gui = new StartfensterGUI(parent);
    }
}