package src.GUI.SB;
import src.Foo;
import src.GUI.Parent_GUI;
import src.Rollen.Schwarzfahrt;

import static src.Foo.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransaktionbearbeitenGUI extends Parent_GUI implements ActionListener {

    String[] schwarzfahrten;
    final DefaultListModel<String> model = new DefaultListModel<>();
    final JList<String> list = new JList<>(model);
    JScrollPane scrollpane = new JScrollPane(list);

    JPanel Textpan = new JPanel();
    JPanel listpan = new JPanel();
    JPanel Buttonpan = new JPanel();

    JLabel label = new JLabel();
    JButton bearbeiten = new JButton();
    JButton loeschen = new JButton();
    JButton abbrechen = new JButton();


    public TransaktionbearbeitenGUI(Parent_GUI parent){
        //Setup
        //getMitarbeiter();
        setupGUI(parent, "MitarbeiterBearbeitenGUI");
        displaySft();



        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setBackground(notSoDark);
        list.setForeground(white);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                bearbeiten.setEnabled(true);
                loeschen.setEnabled(true);
            }
        });


        Textpan.setLayout(new BorderLayout());
        Textpan.setBackground(dark);
        Textpan.setPreferredSize(new Dimension(100,150));


        listpan.setLayout(new BorderLayout());
        listpan.setBackground(dark);
        listpan.setPreferredSize(new Dimension(100,150));


        Buttonpan.setLayout(new BorderLayout());
        Buttonpan.setBackground(dark);
        Buttonpan.setPreferredSize(new Dimension(100,150));
        Buttonpan.setLayout(null);

        label.setText("<html><body><center><p>Transaktion bearbeiten</p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 28));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(200,50, 500,50);


        styleButton(bearbeiten, "Bearbeiten");
        bearbeiten.setBackground(dunkelb);
        bearbeiten.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        bearbeiten.setBounds(70,10,100,30);

        //Button löschen
        styleButton(loeschen, "Löschen");
        loeschen.setBackground(hellb);
        loeschen.setBounds(195,10,100,30);

        //Button abbrechen
        styleButton(abbrechen, "Abbrechen");
        abbrechen.setBackground(dunkelb);
        abbrechen.setEnabled(true);
        abbrechen.setBounds(315,10,100,30);


        listpan.setBorder(BorderFactory.createEmptyBorder(0, 70, 20, 70));
        scrollpane.setBounds(0,200,300,400);
        scrollpane.setBackground(notSoDark);



        //Add to panel
        Textpan.add(label);
        listpan.add(new JScrollPane(list));
        Buttonpan.add(bearbeiten);
        Buttonpan.add(loeschen);
        Buttonpan.add(abbrechen);



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


        bearbeiten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                ListSelectionModel selmodel = list.getSelectionModel();
                int index = selmodel.getMinSelectionIndex();

                if (index>=0){
                    System.out.println(index);
                    SchwarzfahrtenListe.get(index).incrementStatus();
                    displaySft();
                }
                bearbeiten.setEnabled(false);
                loeschen.setEnabled(false);
            }
        });

        loeschen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ListSelectionModel selmodel = list.getSelectionModel();
                int index = selmodel.getMinSelectionIndex();
                if (index >= 0){
                    model.remove(index);
                    SchwarzfahrtenListe.get(index).deleteSFT();
                    displaySft();
                }

                bearbeiten.setEnabled(false);
                loeschen.setEnabled(false);

            }

        });

        abbrechen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentGUI.Kachel1.setEnabled(true);
                dispose();
            }
        });

    }
    void styleButton(JButton btn, String txt){
        btn.setText(txt);
        btn.setBackground(dunkelb);
        btn.setForeground(white);
        btn.setHorizontalTextPosition(JLabel.CENTER);
        btn.setVerticalTextPosition(JLabel.CENTER);
        btn.setFont(fontSmallSmall);
        btn.setHorizontalAlignment(JLabel.CENTER);
        btn.setVerticalAlignment(JLabel.CENTER);
        btn.setEnabled(false);
        btn.setFocusable(true);
        btn.setBorderPainted(false);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }
    public static void main(String[] args) {
        openTransaktionbearbeiten(null);
    }
    public static void openTransaktionbearbeiten(Parent_GUI parent){

        TransaktionbearbeitenGUI gui = new TransaktionbearbeitenGUI(parent);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void displaySft() {



        Foo.getDirectoryData();

        String[] stringArray = new String[sftCount];


            for (int i = 0; i < SchwarzfahrtenListe.size(); i++){

                    Schwarzfahrt sft = SchwarzfahrtenListe.get(i);
                    System.out.println(sft.sf.getVorname());
                    stringArray[i]  = sft.getLinie() + "   " + sft.getZeitpunkt() + "   " + sft.getSf().getVorname() + " " + sft.getSf().getNachname() + "   " +sft.getStatus().status;
            }


        this.schwarzfahrten = stringArray;

        model.clear();
        for (int i = 0; i< schwarzfahrten.length; i++){
            model.addElement(String.valueOf(schwarzfahrten[i]));
        }

    }
}
