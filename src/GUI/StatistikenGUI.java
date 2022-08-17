package src.GUI;
import src.Foo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static src.Foo.*;
public class StatistikenGUI extends JFrame implements ActionListener{

    JButton AnzahlSchwarzfahrer = new JButton();
    JLabel AnzahlSchwarzfahrerUeberschrift = new JLabel();
    JLabel AnzahlschwarzfahrerWert = new JLabel();
    JButton AnzahlMitarbeiter = new JButton();
    JLabel AnzahlKontrolleureUeberschrift = new JLabel();
    JLabel AnzahlKontrolleureWert = new JLabel();
    JLabel AnzahlSacharbeiterUeberschrift = new JLabel();
    JLabel AnzahlSacharbeiterWert = new JLabel();
    JButton HaeufigsteSchwarzfahrt  = new JButton();
    JLabel HaeufigsteSchwarzfahrtUeberschrift = new JLabel();
    JLabel HaeufigsteSchwarzfahrtWert = new JLabel();
    JButton ErfassteSchwarzfahrten = new JButton();
    JLabel ErfassteSchwarzfahrtenUeberschrift = new JLabel();
    JLabel ErfassteSchwarzfahrtenWert = new JLabel();
    JButton SchwarzfahrtenStatus = new JButton();
    JLabel SchwarzfahrtenStatusUeberschrift = new JLabel();
    JLabel SchwarzfahrtenStatusText = new JLabel();
    JLabel SchwarzfahrtenStatusOffen = new JLabel();
    JLabel SchwarzfahrtenStatusAusstehend = new JLabel();
    JLabel SchwarzfahrtenStatusBezahlt = new JLabel();
    JButton Abbrechen = new JButton();



    public StatistikenGUI(){

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
        label.setText("<html><body><center><p>Statistiken</p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 28));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(200,50, 500,50);

        //JButton "Schwarzfahrt erfassen"
        //Styling
        AnzahlSchwarzfahrerUeberschrift.setForeground(white);
        AnzahlSchwarzfahrerUeberschrift.setFont(fontSmall);
        AnzahlSchwarzfahrerUeberschrift.setText("<html><body><center><p>Anzahl Schwarzfahrer</p></center></body></html>");
        AnzahlSchwarzfahrerUeberschrift.setBorder(new EmptyBorder(0,0,0,0));

        AnzahlschwarzfahrerWert.setForeground(dark);
        AnzahlschwarzfahrerWert.setFont(fontSmall);
        AnzahlschwarzfahrerWert.setText("0");
        AnzahlschwarzfahrerWert.setBorder(new EmptyBorder(60,80,0,80));

        AnzahlSchwarzfahrer.setBackground(hellb);
        AnzahlSchwarzfahrer.add(AnzahlSchwarzfahrerUeberschrift);
        AnzahlSchwarzfahrer.add(AnzahlschwarzfahrerWert);
        AnzahlSchwarzfahrer.setFocusable(false);
        AnzahlSchwarzfahrer.setBorderPainted(false);
        AnzahlSchwarzfahrer.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AnzahlSchwarzfahrer.setBounds(140,100,100,100);

        // JButton "Schwarzfahrer suchen"
        //Styling
        AnzahlKontrolleureUeberschrift.setForeground(white);
        AnzahlKontrolleureUeberschrift.setFont(fontSmall);
        AnzahlKontrolleureUeberschrift.setText("<html><body><center><p>Anzahl Kontrolleure</p></center></body></html>");
        AnzahlKontrolleureUeberschrift.setBorder(new EmptyBorder(0,0,0,0));

        AnzahlKontrolleureWert.setForeground(dark);
        AnzahlKontrolleureWert.setFont(fontSmall);
        AnzahlKontrolleureWert.setText("0");
        AnzahlKontrolleureWert.setBorder(new EmptyBorder(0,0,0,0));

        AnzahlSacharbeiterUeberschrift.setForeground(white);
        AnzahlSacharbeiterUeberschrift.setFont(fontSmall);
        AnzahlSacharbeiterUeberschrift.setText("<html><body><center><p>Anzahl Sacharbeiter</p></center></body></html>");
        AnzahlSacharbeiterUeberschrift.setBorder(new EmptyBorder(0,0,0,0));

        AnzahlSacharbeiterWert.setForeground(white);
        AnzahlSacharbeiterWert.setFont(fontSmall);
        AnzahlSacharbeiterWert.setText("0");
        AnzahlSacharbeiterWert.setBorder(new EmptyBorder(0,0,0,0));

        AnzahlMitarbeiter.setBackground(dunkelb);
        AnzahlMitarbeiter.setForeground(white);
        AnzahlMitarbeiter.add(AnzahlKontrolleureUeberschrift);
        AnzahlMitarbeiter.add(AnzahlKontrolleureWert);
        AnzahlMitarbeiter.add(AnzahlSacharbeiterUeberschrift);
        AnzahlMitarbeiter.add(AnzahlSacharbeiterWert);
        AnzahlMitarbeiter.setFocusable(false);
        AnzahlMitarbeiter.setBorderPainted(false);
        AnzahlMitarbeiter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AnzahlMitarbeiter.setBounds(140,100,100,100);


        //JButton "Statistiken"
        //Styling
        HaeufigsteSchwarzfahrtUeberschrift.setForeground(white);
        HaeufigsteSchwarzfahrtUeberschrift.setFont(fontSmall);
        HaeufigsteSchwarzfahrtUeberschrift.setText("<html><body><center><p>Häufigste Schwarzfahrt</p></center></body></html>");
        HaeufigsteSchwarzfahrtUeberschrift.setBorder(new EmptyBorder(0,0,0,0));

        HaeufigsteSchwarzfahrtWert.setForeground(dark);
        HaeufigsteSchwarzfahrtWert.setFont(fontSmall);
        HaeufigsteSchwarzfahrtWert.setText("0");
        HaeufigsteSchwarzfahrtWert.setBorder(new EmptyBorder(0,0,0,0));

        HaeufigsteSchwarzfahrt.setBackground(hellb);
        HaeufigsteSchwarzfahrt.add(HaeufigsteSchwarzfahrtUeberschrift);
        HaeufigsteSchwarzfahrt.add(HaeufigsteSchwarzfahrtWert);
        HaeufigsteSchwarzfahrt.setFocusable(false);
        HaeufigsteSchwarzfahrt.setBorderPainted(false);
        HaeufigsteSchwarzfahrt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        HaeufigsteSchwarzfahrt.setBounds(140,100,100,100);


        //JButton "ProfilGUI"
        //Styling
        ErfassteSchwarzfahrtenUeberschrift.setForeground(white);
        ErfassteSchwarzfahrtenUeberschrift.setFont(fontSmall);
        ErfassteSchwarzfahrtenUeberschrift.setText("<html><body><center><p>Erfasste Schwarzfahrten</p></center></body></html>");
        ErfassteSchwarzfahrtenUeberschrift.setBorder(new EmptyBorder(0,0,0,0));

        ErfassteSchwarzfahrtenWert.setForeground(dark);
        ErfassteSchwarzfahrtenWert.setFont(fontSmall);
        ErfassteSchwarzfahrtenWert.setText("0");
        ErfassteSchwarzfahrtenWert.setBorder(new EmptyBorder(0,0,0,0));

        ErfassteSchwarzfahrten.setBackground(dunkelb);
        ErfassteSchwarzfahrten.setForeground(white);
        ErfassteSchwarzfahrten.add(ErfassteSchwarzfahrtenUeberschrift);
        ErfassteSchwarzfahrten.add(ErfassteSchwarzfahrtenWert);
        ErfassteSchwarzfahrten.setFocusable(false);
        ErfassteSchwarzfahrten.setBorderPainted(false);
        ErfassteSchwarzfahrten.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ErfassteSchwarzfahrten.setBounds(140,100,100,100);


        //JButton "Einstellungen"
        //Styling
        SchwarzfahrtenStatusUeberschrift.setForeground(white);
        SchwarzfahrtenStatusUeberschrift.setFont(fontSmall);
        SchwarzfahrtenStatusUeberschrift.setText("<html><body><center><p>Schwarzfahrten-Status</p></center></body></html>");
        SchwarzfahrtenStatusUeberschrift.setBorder(new EmptyBorder(0,0,0,0));

        SchwarzfahrtenStatusText.setForeground(white);
        SchwarzfahrtenStatusText.setFont(fontSmall);
        SchwarzfahrtenStatusText.setText("<html><body><p>offen: <br>ausstehend: <br> bezahlt: </p></body></html>");
        SchwarzfahrtenStatusText.setBorder(new EmptyBorder(0,0,0,0));

        SchwarzfahrtenStatusOffen.setForeground(dark);
        SchwarzfahrtenStatusOffen.setFont(fontSmall);
        SchwarzfahrtenStatusOffen.setText("0");
        SchwarzfahrtenStatusOffen.setBorder(new EmptyBorder(0,0,0,0));

        SchwarzfahrtenStatusAusstehend.setForeground(dark);
        SchwarzfahrtenStatusAusstehend.setFont(fontSmall);
        SchwarzfahrtenStatusAusstehend.setText("0");
        SchwarzfahrtenStatusAusstehend.setBorder(new EmptyBorder(0,0,0,0));

        SchwarzfahrtenStatusBezahlt.setForeground(dark);
        SchwarzfahrtenStatusBezahlt.setFont(fontSmall);
        SchwarzfahrtenStatusBezahlt.setText("0");
        SchwarzfahrtenStatusBezahlt.setBorder(new EmptyBorder(0,0,0,0));

        SchwarzfahrtenStatus.setBackground(hellb);
        SchwarzfahrtenStatus.setForeground(white);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusUeberschrift);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusText);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusOffen);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusAusstehend);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusBezahlt);
        SchwarzfahrtenStatus.setFocusable(false);
        SchwarzfahrtenStatus.setBorderPainted(false);
        SchwarzfahrtenStatus.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SchwarzfahrtenStatus.setBounds(140,100,100,100);



        //JButton "Abmelden"
        //Styling
        Abbrechen.addActionListener(this);
        Abbrechen.setText("Abbrechen");
        Abbrechen.setBackground(dunkelb);
        Abbrechen.setForeground(white);
        Abbrechen.setHorizontalTextPosition(JLabel.CENTER);
        Abbrechen.setVerticalTextPosition(JLabel.CENTER);
        Abbrechen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
        Abbrechen.setHorizontalAlignment(JLabel.CENTER);
        Abbrechen.setVerticalAlignment(JLabel.CENTER);
        Abbrechen.setFocusable(false);
        Abbrechen.setBorderPainted(false);
        Abbrechen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Abbrechen.setBounds(140,100,100,100);



        // Gesamt Window
        this.setSize(900,550);
        this.setTitle("Statistiken");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        gridpanel.add(AnzahlSchwarzfahrer);
        gridpanel.add(AnzahlMitarbeiter);
        gridpanel.add(HaeufigsteSchwarzfahrt);
        gridpanel.add(ErfassteSchwarzfahrten);
        gridpanel.add(SchwarzfahrtenStatus);
        gridpanel.add(Abbrechen);

        // Add für gesamte Panels
        this.add(gridpanel, BorderLayout.CENTER);
        this.add(Text, BorderLayout.NORTH);

    }
    public static void openStatistikenGUI(){
        Foo.getDirectoryData();
        StatistikenGUI gui = new StatistikenGUI();
    }

    public static void main(String[] args) {
        new StatistikenGUI();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
