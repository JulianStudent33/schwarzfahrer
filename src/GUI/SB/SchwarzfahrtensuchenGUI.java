package src.GUI.SB;
import src.Foo;
import src.GUI.Parent_GUI;
import src.GUI.elements.PlaceholderTextField;
import src.PersFile;
import src.Rollen.*;

import static src.Foo.*;
import src.GUI.elements.customComboBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SchwarzfahrtensuchenGUI extends Parent_GUI implements ActionListener {

    String[] options = {"Schwarzfahrer", "Linie", "Status", "Jahr", "Monat", "Tag", "Datum"};
    List<String> schwarzfahrten = new ArrayList<>();
    customComboBox dropDown = new customComboBox();
    final DefaultListModel<String> model = new DefaultListModel<>();
    final JList<String> list = new JList<>(model);
    JScrollPane scrollpane = new JScrollPane(list);

    JButton loeschen = new JButton();
    JButton abbrechen = new JButton();

    JButton suchen = new JButton();

    customComboBox suchFilter = new customComboBox();

    String[] filter = {"Filter", "Linie", "Status","Ausweisnr.","Datum", "Jahr","Monat","Tag"};

    PlaceholderTextField textSearchfield = new PlaceholderTextField();




    public SchwarzfahrtensuchenGUI(Parent_GUI parent){

        suchFilter.addItem(filter[0]);
        suchFilter.addItem(filter[1]);
        suchFilter.addItem(filter[2]);
        suchFilter.addItem(filter[3]);
        suchFilter.addItem(filter[4]);
        suchFilter.addItem(filter[5]);
        suchFilter.addItem(filter[6]);
        suchFilter.addItem(filter[7]);

        if(suchFilter.getItemAt(0)=="Geschlecht*") {
            suchFilter.setForeground(notSoDark);
        } else {
            suchFilter.setForeground(white);
        }
        suchFilter.setBackground(dark);
        suchFilter.setFont(fontverySmall);

        //Setup
        //getMitarbeiter();
        setupGUI(parent, "Schwarzfahrten suchen");


        dropDown.addStringArray(options);

        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBackground(notSoDark);
        list.setForeground(white);

        JPanel Textpan = new JPanel();
        Textpan.setLayout(new BorderLayout());
        Textpan.setBackground(dark);
        Textpan.setPreferredSize(new Dimension(100,150));

        JPanel listpan = new JPanel();
        listpan.setLayout(new BorderLayout());
        listpan.setBackground(dark);
        listpan.setPreferredSize(new Dimension(100,150));

        JPanel Buttonpan = new JPanel();
        Buttonpan.setBackground(dark);
        Buttonpan.setPreferredSize(new Dimension(100,150));
        Buttonpan.setLayout(null);

        JPanel Buttonsize = new JPanel();
        Buttonsize.setBackground(dark);
        Buttonsize.setBounds(66,60,350,30);
        Buttonsize.setLayout(new GridLayout(1,3,10,0));

        JPanel textSearch = new JPanel();
        textSearch.setBackground(dark);
        textSearch.setBounds(66,10,350,30);
        textSearch.setLayout(null);



        JLabel label = new JLabel();
        label.setText("<html><body><center><p>Schwarzfahrten suchen</p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 28));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(200,50, 500,50);

        textSearchfield.setBackground(whitebg);
        textSearchfield.setForeground(white);
        textSearchfield.setPlaceholder("Suchbegriff");
        textSearchfield.setCaretColor(notSoDark); //same
        textSearchfield.setFont(fontMedium); //same
        textSearchfield.setSelectedTextColor(dark); //same
        textSearchfield.setSelectionColor(notSoDark); //same
        textSearchfield.setBounds(0,0,350,30);

        suchen.setBackground(dunkelb);
        suchen.setForeground(white);
        suchen.setText("Suchen");
        suchen.setHorizontalTextPosition(JLabel.CENTER);
        suchen.setVerticalTextPosition(JLabel.CENTER);
        suchen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 12));
        suchen.setHorizontalAlignment(JLabel.CENTER);
        suchen.setVerticalAlignment(JLabel.CENTER);
        suchen.setFocusable(false);
        suchen.setBorderPainted(false);
        suchen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));


        abbrechen.addActionListener(this);
        abbrechen.setText("Abbrechen");
        abbrechen.setBackground(dunkelb);
        abbrechen.setForeground(white);
        abbrechen.setHorizontalTextPosition(JLabel.CENTER);
        abbrechen.setVerticalTextPosition(JLabel.CENTER);
        abbrechen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 12));
        abbrechen.setHorizontalAlignment(JLabel.CENTER);
        abbrechen.setVerticalAlignment(JLabel.CENTER);
        abbrechen.setFocusable(false);
        abbrechen.setBorderPainted(false);
        abbrechen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        listpan.setBorder(BorderFactory.createEmptyBorder(0, 70, 20, 70));
        scrollpane.setBounds(0,200,300,400);
        scrollpane.setBackground(notSoDark);

        //Add to panel
        Textpan.add(label);
        listpan.add(new JScrollPane(list));
        textSearch.add(textSearchfield);
        Buttonsize.add(suchFilter);
        Buttonsize.add(suchen);
        Buttonsize.add(abbrechen);
        Buttonpan.add(textSearch);
        Buttonpan.add(Buttonsize);


        //add panels to window
        this.add(Textpan,BorderLayout.NORTH);
        this.add(Buttonpan, BorderLayout.SOUTH);
        this.add(listpan,BorderLayout.CENTER);

        this.setSize(500,700);
        this.setTitle("Transaktion bearbeiten");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(parent);
        this.setVisible(true);
        this.setBackground(dark);

        loeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ListSelectionModel selmodel = list.getSelectionModel();
                int index = selmodel.getMinSelectionIndex();
                if (index >= 0){
                    model.remove(index);
                }
                if (index == 0){
                    System.out.println("Index = 0");
                }

            }

        });

        abbrechen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentGUI.Kachel2.setEnabled(true);
                dispose();
            }
        });

        suchFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (suchFilter.getItemAt(0).equals("Filter")){
                    suchFilter.removeItemAt(0);
                    suchFilter.setForeground(white);
                    suchFilter.setPrototypeDisplayValue(null);
                }
            }
        });

    }

    public void displaySFT(String param, String arg){
        Foo.getDirectoryData();
        List<String> stringList = new ArrayList<>();

        if (param.equals(options[0])){
            System.out.println("Suche alle SFT von Schwarzfahrer " + arg);
            for (Schwarzfahrer S : SchwarzfahrerListe){
                if (S.getAusweisnummer().equals(arg)){

                    for (Schwarzfahrt sft : S.sftList){
                        stringList.add(sft.getLinie() + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);

                    }
                    this.schwarzfahrten = stringList;
                }else{
                    System.out.println("Keine Treffer");
                }
                return;
            }

        } else if (param.equals(options[1])) {
            System.out.println("Suche alle SFT von Linie " + arg);

            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (sft.getLinie().equals(arg)){
                    stringList.add(sft.getLinie() + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }


        }else if (param.equals(options[2])) {
            System.out.println("Suche alle SFT nach Status " + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (sft.getStatus().equals(arg)){
                    stringList.add(sft.getLinie() + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }

        }else if (param.equals(options[3])) {
            System.out.println("Suche alle SFT von Jahr" + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (String.valueOf(sft.getYEAR()).equals(arg)){
                    stringList.add(sft.getLinie() + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }

        }else if (param.equals(options[4])) {
            System.out.println("Suche alle SFT von Monat" + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (String.valueOf(sft.getMONTH()).equals(arg)){
                    stringList.add(sft.getLinie() + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }
        }else if (param.equals(options[5])) {
            System.out.println("Suche alle SFT von Tag" + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (String.valueOf(sft.getDAY()).equals(arg)){
                    stringList.add(sft.getLinie() + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }

        }else if (param.equals(options[6])) {
            System.out.println("Suche alle SFT von Datum " + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (sft.getZeitpunkt().equals(arg)){
                    stringList.add(sft.getLinie() + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }

        }

    }
    public static void main(String[] args) {
        openSchwarzfahrtensuchenGUI(null);
    }
    public static void openSchwarzfahrtensuchenGUI(Parent_GUI parent){

        SchwarzfahrtensuchenGUI gui = new SchwarzfahrtensuchenGUI(parent);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}
