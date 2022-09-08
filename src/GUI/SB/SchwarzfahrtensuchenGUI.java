package src.GUI.SB;
import src.Foo;
import src.GUI.Parent_GUI;
import src.GUI.elements.DatePick;
import src.GUI.elements.PlaceholderTextField;
import src.Rollen.*;

import static src.Foo.*;
import src.GUI.elements.customComboBox;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

public class SchwarzfahrtensuchenGUI extends Parent_GUI implements ActionListener {

    String[] options = {"Filter","Ausweisnr.", "Linie", "Status", "Jahr", "Monat", "Tag", "Datum"};
    List<String> schwarzfahrten = new ArrayList<>();
    customComboBox dropDown = new customComboBox();
    final DefaultListModel<String> model = new DefaultListModel<>();
    final JList<String> list = new JList<>(model);
    JScrollPane scrollpane = new JScrollPane(list);

    JButton abbrechen = new JButton();

    JButton suchen = new JButton();

    JButton datePickerfilter = new JButton();
    customComboBox Status = new customComboBox();
    String[] Statusfilter = {"Status", "Offen","Ausstehend" ,"Bezahlt"};

    PlaceholderTextField textSearchfield = new PlaceholderTextField();




    public SchwarzfahrtensuchenGUI(Parent_GUI parent){

        //Setup
        //getMitarbeiter();
        setupGUI(parent, "Schwarzfahrten suchen");


        dropDown.addItem(options[0]);
        dropDown.addItem(options[1]);
        dropDown.addItem(options[2]);
        dropDown.addItem(options[3]);
        dropDown.addItem(options[4]);
        dropDown.addItem(options[5]);
        dropDown.addItem(options[6]);
        dropDown.addItem(options[7]);

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

        // Oberes Panel mit Suchbegriff !!!.setBounds!!! immer gleich

        //Textfeld -> Linie, Tag, Monat, Jahr, Ausweisnr.
        textSearchfield.setBackground(whitebg);
        textSearchfield.setForeground(white);
        textSearchfield.setPlaceholder("Suchbegriff");
        textSearchfield.setCaretColor(notSoDark); //same
        textSearchfield.setFont(fontMedium); //same
        textSearchfield.setSelectedTextColor(dark); //same
        textSearchfield.setSelectionColor(notSoDark); //same
        textSearchfield.setBounds(0,0,350,30);

        // Status Dropdown
        Status.addItem(Statusfilter[0]);
        Status.addItem(Statusfilter[1]);
        Status.addItem(Statusfilter[2]);
        Status.addItem(Statusfilter[3]);
        if(Status.getItemAt(0)=="Status") {
            Status.setForeground(notSoDark);
        } else {
            Status.setForeground(white);
        }
        Status.setBackground(dark);
        Status.setFont(fontMedium);
        Status.setBounds(0,0,350,30);

        // Datepick Button
        datePickerfilter.setBackground(whitebg);
        datePickerfilter.setForeground(white);
        datePickerfilter.setText("Datum auswählen");
        datePickerfilter.setFont(fontMedium);
        datePickerfilter.setHorizontalAlignment(SwingConstants.CENTER);
        datePickerfilter.setVerticalAlignment(SwingConstants.CENTER);
        datePickerfilter.setFocusable(true);
        datePickerfilter.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        datePickerfilter.setBounds(0,0,350,30);

        // Unteres Panel

        if (dropDown.getItemAt(0).equals("Filter")){
            suchen.setEnabled(false);
        }

        if(dropDown.getItemAt(0)=="Filter") {
            dropDown.setForeground(notSoDark);
        } else {
            dropDown.setForeground(white);
        }
        dropDown.setBackground(dark);
        dropDown.setFont(fontverySmall);
        dropDown.setBorder(new LineBorder(dunkelb));

        dropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               switch (dropDown.getSelectedIndex()){
                   case 0:
                       System.out.println("Ausweisnummer");
                       textSearchfield.setText("");
                       textSearch.remove(0);
                       textSearch.add(textSearchfield);
                       textSearchfield.setPlaceholder("z.B. " + SchwarzfahrtenListe.get(0).getSf().getAusweisnummer());
                       textSearch.repaint();
                   break;
                   case 1:
                       System.out.println("Linie");
                       textSearchfield.setText("");
                       textSearch.remove(0);
                       textSearch.add(textSearchfield);
                       textSearchfield.setPlaceholder("z.B. " + SchwarzfahrtenListe.get(0).getLinie());
                       textSearch.repaint();

                   break;
                   case 2:
                       System.out.println("Status");
                       textSearchfield.setText("");
                       textSearch.remove(0);
                       textSearch.add(Status);
                       textSearch.repaint();
                       break;
                   case 3:
                       System.out.println("Jahr");
                       textSearchfield.setText("");
                       textSearch.remove(0);
                       textSearch.add(textSearchfield);
                       textSearchfield.setPlaceholder("z.B. " + SchwarzfahrtenListe.get(0).YEAR);
                       textSearch.repaint();
                       break;
                   case 4:
                       System.out.println("Monat");
                       textSearchfield.setText("");
                       textSearch.remove(0);
                       textSearch.add(textSearchfield);
                       textSearchfield.setPlaceholder("z.B. " + SchwarzfahrtenListe.get(0).MONTH);
                       textSearch.repaint();
                       break;
                   case 5:
                       System.out.println("Tag");
                       textSearchfield.setText("");
                       textSearch.remove(0);
                       textSearch.add(textSearchfield);
                       textSearchfield.setPlaceholder("z.B. " + SchwarzfahrtenListe.get(0).DAY);
                       textSearch.repaint();
                       break;
                   case 6:
                       System.out.println("Datum");
                       textSearchfield.setText("");
                       textSearch.remove(0);
                       textSearch.add(datePickerfilter);
                       datePickerfilter.setText(SchwarzfahrtenListe.get(0).getDate());
                       textSearch.repaint();

                       break;
                   default:
                       System.out.println("default");
                       textSearchfield.setText("");
                       textSearch.remove(0);
                       textSearch.add(textSearchfield);
                       textSearchfield.setPlaceholder("dd-MM-yyyy");
                       textSearch.repaint();
                       break;

               }
            }
        });


        suchen.setBackground(hellb);
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
        Buttonsize.add(dropDown);
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


        textSearchfield.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!textSearchfield.getText().isBlank()){
                    suchen.setEnabled(true);
                }else{
                    suchen.setEnabled(false);
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (!textSearchfield.getText().isBlank()){
                    suchen.setEnabled(true);
                }else{
                    suchen.setEnabled(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (!textSearchfield.getText().isBlank()){
                    suchen.setEnabled(true);
                }else{
                    suchen.setEnabled(false);
                }
            }
        });

        suchen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selection = dropDown.getSelectedIndex();
                System.out.println("Selection: " + options[selection+1]);
                if (selection == 2){
                    displaySFT(dropDown.getItemAt(selection).toString(), Status.getSelectedItem().toString());

                } else if (selection == 6) {
                    displaySFT(dropDown.getItemAt(selection).toString(), datePickerfilter.getText() );
                }else{
                    displaySFT(dropDown.getItemAt(selection).toString(), textSearchfield.getText());
                    textSearchfield.setText("");
                }

                suchen.setEnabled(false);
            }
        });
        abbrechen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentGUI.Kachel2.setEnabled(true);
                dispose();
            }
        });

        dropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (dropDown.getItemAt(0).equals("Filter")){
                    dropDown.removeItemAt(0);
                    dropDown.setForeground(white);
                    dropDown.setPrototypeDisplayValue(null);
                }
                if (dropDown.getSelectedItem().toString().equals(options[7])){
                    suchen.setEnabled(true);
                } else if (dropDown.getSelectedItem().toString().equals(options[3])) {
                    if (!Status.getItemAt(0).equals(Statusfilter[0]))
                        suchen.setEnabled(true);
                } else{
                    suchen.setEnabled(false);
                }

            }
        });

        Status.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (Status.getItemAt(0).equals("Status")){
                    Status.removeItemAt(0);
                    Status.setForeground(white);
                    Status.setPrototypeDisplayValue(null);
                }
                if (!Status.getItemAt(0).equals(Statusfilter[0])){
                    suchen.setEnabled(true);
                }
                else{
                    suchen.setEnabled(false);
                }
            }
        });
        datePickerfilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String txt;
                DatePick calender;

                    calender = new DatePick(getFrame(), datePickerfilter.getText());
                    txt = calender.Set_Picked_Date();
                    datePickerfilter.setForeground(white);


                if (txt==""){
                }else{
                    datePickerfilter.setText(calender.Set_Picked_Date());
                    datePickerfilter.setForeground(white);
                }
            }
        });

    }

    public void displaySFT(String param, String arg){
        Foo.getDirectoryData();
        List<String> stringList = new ArrayList<>();
        schwarzfahrten.clear();

        if (param.equals(options[1])){
            System.out.println("Suche alle SFT von Schwarzfahrer " + arg);
            for (Schwarzfahrer S : SchwarzfahrerListe){
                if (S.getAusweisnummer().equals(arg)){

                    for (Schwarzfahrt sft : S.sftList){
                        stringList.add(formatLinie(sft.getLinie()) + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                    }
                    this.schwarzfahrten = stringList;
                }else{
                    System.out.println("Keine Treffer");
                }
            }

        } else if (param.equals(options[2])) {
            System.out.println("Suche alle SFT von Linie " + arg);

            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (sft.getLinie().equals(arg)){
                    stringList.add(formatLinie(sft.getLinie()) + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }


        }else if (param.equals(options[3])) {
            System.out.println("Suche alle SFT nach Status " + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (sft.getStatus().equals(arg)){
                    stringList.add(formatLinie(sft.getLinie()) + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }

        }else if (param.equals(options[4])) {
            System.out.println("Suche alle SFT von Jahr" + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (String.valueOf(sft.getYEAR()).equals(arg)){
                    stringList.add(formatLinie(sft.getLinie()) + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }

        }else if (param.equals(options[5])) {
            System.out.println("Suche alle SFT von Monat" + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (String.valueOf(sft.getMONTH()).equals(arg)){
                    stringList.add(formatLinie(sft.getLinie()) + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }
        }else if (param.equals(options[6])) {
            System.out.println("Suche alle SFT von Tag" + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (String.valueOf(sft.getDAY()).equals(arg)){
                    stringList.add(formatLinie(sft.getLinie()) + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }

        }else if (param.equals(options[7])) {
            System.out.println("Suche alle SFT von Datum " + arg);
            for (Schwarzfahrt sft : SchwarzfahrtenListe){
                if (sft.getZeitpunkt().equals(arg)){
                    stringList.add(formatLinie(sft.getLinie()) + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status);
                }
            }
            if (stringList.isEmpty()){
                System.out.println("Keine Treffer");
            }else{
                this.schwarzfahrten = stringList;
            }

        }
        model.clear();
        if (!schwarzfahrten.isEmpty()){
            for (String s : schwarzfahrten){
                model.addElement(s);
            }
            model.addElement(schwarzfahrten.size() + " Treffer");
        }else{
            model.addElement("Keine Treffer");
        }


    }
    private String formatLinie(String l){
        switch (l.length()) {
            case 1 -> l = l.concat("      ");
            case 2 -> l = l.concat("    ");
            case 3 -> l = l.concat("  ");
        }
        return l;
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
