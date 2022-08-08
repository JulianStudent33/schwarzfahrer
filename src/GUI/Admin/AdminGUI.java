package src.GUI.Admin;
import src.Foo;
import src.users.Administrator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminGUI extends JFrame implements ActionListener {

    private JButton Schwarzfahrterfassen = new JButton();
    private JButton Schwarzfahrerverwalten = new JButton();
    private JButton NeuerMitarbeiter  = new JButton();
    private JButton Mitarbeiterverwalten = new JButton();
    private JButton Einstellungen = new JButton();
    private JButton Abmelden = new JButton();

    public static Color dark = new Color(44,44,44);
    public static Color white = new Color(255,255,255);
    public static Color hellb = new Color(133, 179, 255);
    public static Color dunkelb = new Color(74,142,255);

    public AdminGUI(){
        // Panelmanagement
        JPanel gridpanel = new JPanel();
        gridpanel.setBackground(dark);
        gridpanel.setLayout(new BorderLayout());
        gridpanel.setPreferredSize(new Dimension(100,100));
        gridpanel.setBounds(50,25,300,30);
        gridpanel.setLayout(new GridLayout(2,3,20,20));
        gridpanel.setBorder(BorderFactory.createEmptyBorder(0,70,70,70));
        //Willkommentextpanel
        JPanel Text = new JPanel();
        Text.setBackground(dark);
        Text.setPreferredSize(new Dimension(100,150));
        Text.setLayout(null);

        // "Willkommen auf der" Text
        JLabel label = new JLabel();
        label.setText("<html><body><center><p><u>Willkommen, Admin<u></p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 28));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(200,50, 500,50);

        //JButton "Schwarzfahrt erfassen"
        Schwarzfahrterfassen.addActionListener(this);
        Schwarzfahrterfassen.setText("<html><body><center><p>Schwarzfahrt<br>erfassen</p></center></body></html>");
        Schwarzfahrterfassen.setBackground(hellb);
        Schwarzfahrterfassen.setForeground(white);
        Schwarzfahrterfassen.setHorizontalTextPosition(JLabel.CENTER);
        Schwarzfahrterfassen.setVerticalTextPosition(JLabel.CENTER);
        Schwarzfahrterfassen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Schwarzfahrterfassen.setHorizontalAlignment(JLabel.CENTER);
        Schwarzfahrterfassen.setVerticalAlignment(JLabel.CENTER);
        Schwarzfahrterfassen.setFocusable(false);
        Schwarzfahrterfassen.setBorderPainted(false);
        Schwarzfahrterfassen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Schwarzfahrterfassen.setBounds(140,100,100,100);


        // JButton "Schwarzfahrer verwalten"
        Schwarzfahrerverwalten.addActionListener(this);
        Schwarzfahrerverwalten.setText("<html><body><center><p>Schwarzfahrer<br>verwalten</p></center></body></html>");
        Schwarzfahrerverwalten.setBackground(dunkelb);
        Schwarzfahrerverwalten.setForeground(white);
        Schwarzfahrerverwalten.setHorizontalTextPosition(JLabel.CENTER);
        Schwarzfahrerverwalten.setVerticalTextPosition(JLabel.CENTER);
        Schwarzfahrerverwalten.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Schwarzfahrerverwalten.setHorizontalAlignment(JLabel.CENTER);
        Schwarzfahrerverwalten.setVerticalAlignment(JLabel.CENTER);
        Schwarzfahrerverwalten.setFocusable(false);
        Schwarzfahrerverwalten.setBorderPainted(false);
        Schwarzfahrerverwalten.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Schwarzfahrerverwalten.setBounds(140,100,100,100);


        //JButton "Neuer Mitarbeiter"
        NeuerMitarbeiter.addActionListener(this);
        NeuerMitarbeiter.setText("Neuer Mitarbeiter");
        NeuerMitarbeiter.setBackground(hellb);
        NeuerMitarbeiter.setForeground(white);
        NeuerMitarbeiter.setHorizontalTextPosition(JLabel.CENTER);
        NeuerMitarbeiter.setVerticalTextPosition(JLabel.CENTER);
        NeuerMitarbeiter.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        NeuerMitarbeiter.setHorizontalAlignment(JLabel.CENTER);
        NeuerMitarbeiter.setVerticalAlignment(JLabel.CENTER);
        NeuerMitarbeiter.setFocusable(false);
        NeuerMitarbeiter.setBorderPainted(false);
        NeuerMitarbeiter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        NeuerMitarbeiter.setBounds(140,100,100,100);

        //JButton "Mitarbeiter verwalten"
        Mitarbeiterverwalten.addActionListener(this);
        Mitarbeiterverwalten.setText("<html><body><center><p>Mitarbeiter<br>verwalten</p></center></body></html>");
        Mitarbeiterverwalten.setBackground(dunkelb);
        Mitarbeiterverwalten.setForeground(white);
        Mitarbeiterverwalten.setHorizontalTextPosition(JLabel.CENTER);
        Mitarbeiterverwalten.setVerticalTextPosition(JLabel.CENTER);
        Mitarbeiterverwalten.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Mitarbeiterverwalten.setHorizontalAlignment(JLabel.CENTER);
        Mitarbeiterverwalten.setVerticalAlignment(JLabel.CENTER);
        Mitarbeiterverwalten.setFocusable(false);
        Mitarbeiterverwalten.setBorderPainted(false);
        Mitarbeiterverwalten.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Mitarbeiterverwalten.setBounds(140,100,100,100);

        //JButton "Einstellungen"
        Einstellungen.addActionListener(this);
        Einstellungen.setText("Einstellungen");
        Einstellungen.setBackground(hellb);
        Einstellungen.setForeground(white);
        Einstellungen.setHorizontalTextPosition(JLabel.CENTER);
        Einstellungen.setVerticalTextPosition(JLabel.CENTER);
        Einstellungen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Einstellungen.setHorizontalAlignment(JLabel.CENTER);
        Einstellungen.setVerticalAlignment(JLabel.CENTER);
        Einstellungen.setFocusable(false);
        Einstellungen.setBorderPainted(false);
        Einstellungen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Einstellungen.setBounds(140,100,100,100);

        //JButton "Abmelden"
        Abmelden.addActionListener(this);
        Abmelden.setText("Abmelden");
        Abmelden.setBackground(dunkelb);
        Abmelden.setForeground(white);
        Abmelden.setHorizontalTextPosition(JLabel.CENTER);
        Abmelden.setVerticalTextPosition(JLabel.CENTER);
        Abmelden.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Abmelden.setHorizontalAlignment(JLabel.CENTER);
        Abmelden.setVerticalAlignment(JLabel.CENTER);
        Abmelden.setFocusable(false);
        Abmelden.setBorderPainted(false);
        Abmelden.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Abmelden.setBounds(140,100,100,100);



        // Gesamt Window
        this.setSize(900,550);
        this.setTitle("Admin-Panel");
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

        //Text.add(Trennlinie,BorderLayout.SOUTH);
        gridpanel.add(Schwarzfahrterfassen);
        gridpanel.add(Schwarzfahrerverwalten);
        gridpanel.add(NeuerMitarbeiter);
        gridpanel.add(Mitarbeiterverwalten);
        gridpanel.add(Einstellungen);
        gridpanel.add(Abmelden);

        // Add für gesamte Panels
        this.add(gridpanel, BorderLayout.CENTER);
        this.add(Text, BorderLayout.NORTH);
    }

    public static void openAdminGUI(){
        AdminGUI gui = new AdminGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        openAdminGUI();
    }
}
