package src.GUI;

import src.Rollen.Schwarzfahrt;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

import static src.Foo.*;

public class StatistikenGUI extends Parent_GUI implements ActionListener {

    JButton AnzahlSchwarzfahrer = new JButton();
    JLabel AnzahlSchwarzfahrerUeberschrift = new JLabel();
    JLabel AnzahlschwarzfahrerWert = new JLabel();
    JButton AnzahlMitarbeiter = new JButton();
    JLabel AnzahlKontrolleureUeberschrift = new JLabel();
    JLabel AnzahlKontrolleureWert = new JLabel();
    JLabel AnzahlSacharbeiterUeberschrift = new JLabel();
    JLabel AnzahlSacharbeiterWert = new JLabel();
    JButton sfHotspot = new JButton();
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



    public StatistikenGUI(Parent_GUI parent){

        //Setup
        setupGUI(parent, "StatistikenGUI");



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


        //Styling
        AnzahlSchwarzfahrerUeberschrift.setForeground(white);
        AnzahlSchwarzfahrerUeberschrift.setFont(fontSmall);
        AnzahlSchwarzfahrerUeberschrift.setText("<html><body><center><p>Anzahl Schwarzfahrer</p></center></body></html>");
        AnzahlSchwarzfahrerUeberschrift.setBorder(new EmptyBorder(0,40,80,40));

        AnzahlschwarzfahrerWert.setForeground(dark);
        AnzahlschwarzfahrerWert.setFont(fontSmall);
        AnzahlschwarzfahrerWert.setText(String.valueOf(sfCount));
        AnzahlschwarzfahrerWert.setBorder(new EmptyBorder(30,100,30,0));

        styleKachel(AnzahlSchwarzfahrer);
        AnzahlSchwarzfahrer.setBackground(hellb);
        AnzahlSchwarzfahrer.add(AnzahlSchwarzfahrerUeberschrift);
        AnzahlSchwarzfahrer.add(AnzahlschwarzfahrerWert);
        AnzahlSchwarzfahrer.setBounds(140,100,100,100);


        //Styling
        AnzahlKontrolleureUeberschrift.setForeground(white);
        AnzahlKontrolleureUeberschrift.setFont(fontSmall);
        AnzahlKontrolleureUeberschrift.setText("<html><body><center><p>Anzahl Kontrolleure</p></center></body></html>");
        AnzahlKontrolleureUeberschrift.setBorder(new EmptyBorder(0,40,80,40));

        AnzahlKontrolleureWert.setForeground(dark);
        AnzahlKontrolleureWert.setFont(fontSmall);
        AnzahlKontrolleureWert.setText(String.valueOf(konCount));
        AnzahlKontrolleureWert.setBorder(new EmptyBorder(30,100,40,0));

        AnzahlSacharbeiterUeberschrift.setForeground(white);
        AnzahlSacharbeiterUeberschrift.setFont(fontSmall);
        AnzahlSacharbeiterUeberschrift.setText("<html><body><center><p>Anzahl Sacharbeiter</p></center></body></html>");
        AnzahlSacharbeiterUeberschrift.setBorder(new EmptyBorder(45,40,0,40));

        AnzahlSacharbeiterWert.setForeground(dark);
        AnzahlSacharbeiterWert.setFont(fontSmall);
        AnzahlSacharbeiterWert.setText(String.valueOf(sbCount));
        AnzahlSacharbeiterWert.setBorder(new EmptyBorder(110,100,0,0));

        styleKachel(AnzahlMitarbeiter);
        AnzahlMitarbeiter.setBackground(dunkelb);
        AnzahlMitarbeiter.setForeground(white);
        AnzahlMitarbeiter.add(AnzahlKontrolleureUeberschrift);
        AnzahlMitarbeiter.add(AnzahlKontrolleureWert);
        AnzahlMitarbeiter.add(AnzahlSacharbeiterUeberschrift);
        AnzahlMitarbeiter.add(AnzahlSacharbeiterWert);
        AnzahlMitarbeiter.setBounds(140,100,100,100);


        //Styling
        HaeufigsteSchwarzfahrtUeberschrift.setForeground(white);
        HaeufigsteSchwarzfahrtUeberschrift.setFont(fontSmall);
        HaeufigsteSchwarzfahrtUeberschrift.setText("<html><body><center><p>Schwarzfahrer Hotspot</p></center></body></html>");
        HaeufigsteSchwarzfahrtUeberschrift.setBorder(new EmptyBorder(0,40,80,40));

        HaeufigsteSchwarzfahrtWert.setForeground(dark);
        HaeufigsteSchwarzfahrtWert.setFont(fontSmall);
        HaeufigsteSchwarzfahrtWert.setText(getHotspot());
        HaeufigsteSchwarzfahrtWert.setBorder(new EmptyBorder(0,45,0,0));

        styleKachel(sfHotspot);
        sfHotspot.setBackground(hellb);
        sfHotspot.add(HaeufigsteSchwarzfahrtUeberschrift);
        sfHotspot.add(HaeufigsteSchwarzfahrtWert);
        sfHotspot.setBounds(140,100,100,100);



        //Styling
        ErfassteSchwarzfahrtenUeberschrift.setForeground(white);
        ErfassteSchwarzfahrtenUeberschrift.setFont(fontSmall);
        ErfassteSchwarzfahrtenUeberschrift.setText("<html><body><center><p>Erfasste Schwarzfahrten</p></center></body></html>");
        ErfassteSchwarzfahrtenUeberschrift.setBorder(new EmptyBorder(0,40,80,40));

        ErfassteSchwarzfahrtenWert.setForeground(dark);
        ErfassteSchwarzfahrtenWert.setFont(fontSmall);
        ErfassteSchwarzfahrtenWert.setText(String.valueOf(sftCount));
        ErfassteSchwarzfahrtenWert.setBorder(new EmptyBorder(0,100,0,0));

        styleKachel(ErfassteSchwarzfahrten);
        ErfassteSchwarzfahrten.setBackground(dunkelb);
        ErfassteSchwarzfahrten.setForeground(white);
        ErfassteSchwarzfahrten.add(ErfassteSchwarzfahrtenUeberschrift);
        ErfassteSchwarzfahrten.add(ErfassteSchwarzfahrtenWert);
        ErfassteSchwarzfahrten.setBounds(140,100,100,100);


        //Daten holen

        int[] sftStatus = getStati();

        //Styling
        SchwarzfahrtenStatusUeberschrift.setForeground(white);
        SchwarzfahrtenStatusUeberschrift.setFont(fontSmall);
        SchwarzfahrtenStatusUeberschrift.setText("<html><body><center><p>Schwarzfahrten-Status</p></center></body></html>");
        SchwarzfahrtenStatusUeberschrift.setBorder(new EmptyBorder(0,0,90,20));

        SchwarzfahrtenStatusText.setForeground(white);
        SchwarzfahrtenStatusText.setFont(fontSmall);
        SchwarzfahrtenStatusText.setText("<html><body><p>offen: <br>ausstehend: <br> bezahlt: </p></body></html>");
        SchwarzfahrtenStatusText.setBorder(new EmptyBorder(0,0,0,0));

        SchwarzfahrtenStatusOffen.setForeground(dark);
        SchwarzfahrtenStatusOffen.setFont(fontSmall);
        SchwarzfahrtenStatusOffen.setText(String.valueOf(sftStatus[0]));
        SchwarzfahrtenStatusOffen.setBorder(new EmptyBorder(0,110,40,0));

        SchwarzfahrtenStatusAusstehend.setForeground(dark);
        SchwarzfahrtenStatusAusstehend.setFont(fontSmall);
        SchwarzfahrtenStatusAusstehend.setText(String.valueOf(sftStatus[1]));
        SchwarzfahrtenStatusAusstehend.setBorder(new EmptyBorder(0,110,0,0));

        SchwarzfahrtenStatusBezahlt.setForeground(dark);
        SchwarzfahrtenStatusBezahlt.setFont(fontSmall);
        SchwarzfahrtenStatusBezahlt.setText(String.valueOf(sftStatus[2]));
        SchwarzfahrtenStatusBezahlt.setBorder(new EmptyBorder(40,110,0,0));

        styleKachel(SchwarzfahrtenStatus);
        SchwarzfahrtenStatus.setBackground(hellb);
        SchwarzfahrtenStatus.setForeground(white);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusUeberschrift);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusText);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusOffen);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusAusstehend);
        SchwarzfahrtenStatus.add(SchwarzfahrtenStatusBezahlt);
        SchwarzfahrtenStatus.setBounds(140,100,100,100);


        //Styling

        Abbrechen.addActionListener(this);
        Abbrechen.setText("Abbrechen");
        Abbrechen.setBackground(dunkelb);
        Abbrechen.setForeground(white);
        Abbrechen.setHorizontalTextPosition(JLabel.CENTER);
        Abbrechen.setVerticalTextPosition(JLabel.CENTER);
        Abbrechen.setFont(fontMedium);
        Abbrechen.setHorizontalAlignment(JLabel.CENTER);
        Abbrechen.setVerticalAlignment(JLabel.CENTER);
        Abbrechen.setBounds(140,100,100,100);
        Abbrechen.setRolloverEnabled(true);
        Abbrechen.setFocusable(true);
        Abbrechen.setFocusPainted(true);
        Abbrechen.setBorderPainted(false);
        Abbrechen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));



        // Gesamt Window
        this.setSize(900,550);
        this.setTitle("Statistiken");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        this.getContentPane().setBackground(dark);


        // Add Befehle

        // Daten aktualisieren

        // Add für einzelnen Elemente innerhalb der Panels
        Text.add(label, BorderLayout.SOUTH);

        //Text.add(Trennlinie,BorderLayout.SOUTH);
        gridpanel.add(AnzahlSchwarzfahrer);
        gridpanel.add(AnzahlMitarbeiter);
        gridpanel.add(sfHotspot);
        gridpanel.add(ErfassteSchwarzfahrten);
        gridpanel.add(SchwarzfahrtenStatus);
        gridpanel.add(Abbrechen);

        // Add für gesamte Panels
        this.add(gridpanel, BorderLayout.CENTER);
        this.add(Text, BorderLayout.NORTH);




        //ActionListener

        sfHotspot.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                getHotspot();

            }
        });


        Abbrechen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                parentGUI.StartAutoLogout();
                System.out.println("Starte AutoLogout für " + parentGUI.name);
                parentGUI.Kachel3.setEnabled(true);
                dispose();
            }

        });




    }

    void styleKachel(JButton btn){
        btn.setRolloverEnabled(false);
        btn.setFocusable(false);
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
    }
    public int[] getStati(){
        fillSftList();
        int offenCount = 0;
        int ausstehendCount = 0;
        int bezahltCount = 0;

        for (int i = 0; i < SchwarzfahrtenListe.size(); i++){

            if (SchwarzfahrtenListe.get(i).status.isOffen){
                offenCount++;
            } else if (SchwarzfahrtenListe.get(i).status.isAusstehend) {
                ausstehendCount++;
            } else if (SchwarzfahrtenListe.get(i).status.isBezahlt) {
                bezahltCount++;
            }
        }
        System.out.println("Offen: " + offenCount);
        System.out.println("Ausstehend: " + ausstehendCount);
        System.out.println("Bezahlt: " + bezahltCount);
        int[] arr = {offenCount, ausstehendCount, bezahltCount};
        return arr;
    }
    public String getHotspot(){
        List<String> linien = new ArrayList<>();
        Map<String,Integer> valueCounter = new HashMap<>();
        for (Schwarzfahrt sft : SchwarzfahrtenListe){
            linien.add(sft.linie);
            System.out.println(SchwarzfahrtenListe.indexOf(sft));
        }
        for (String str : linien){
            Integer val = valueCounter.get(str);
            if (valueCounter.get(str) == null){
                valueCounter.put(str, 1);

            } else{
                val = val+1;
                valueCounter.put(str, val);
            }
        }
        int highestCount = 0;
        String hotspotLinie = "Kein Hotspot";
        Set<Map.Entry<String, Integer>> entrySet = valueCounter.entrySet();
        for (Map.Entry<String, Integer> entry : entrySet){
            if (entry.getValue() > 0){
                System.out.println(entry.getKey() + "=>" + entry.getValue());
                if (entry.getValue() > highestCount){
                    highestCount = entry.getValue();
                    hotspotLinie = entry.getKey();
                } else if (entry.getValue() == highestCount) {
                    hotspotLinie = hotspotLinie.concat(", " + entry.getKey());
                }
            }
        }

        System.out.println(hotspotLinie);
       // System.out.println(linien.size());
        return hotspotLinie;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void openStatistikenGUI(Parent_GUI parent){

        StatistikenGUI gui = new StatistikenGUI(parent);
    }




}