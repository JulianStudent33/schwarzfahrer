package src.GUI.Kon;

import src.Foo;
import src.GUI.EinstellungenGUI;
import src.GUI.Parent_GUI;
import src.GUI.elements.PlaceholderTextField;
import src.GUI.elements.SizeFilter;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LinieFestlegenGUI extends Parent_GUI{

    PlaceholderTextField linienTextfield = new PlaceholderTextField();
    JLabel linienText = new JLabel();

    private JButton SpeicherButton1 = new JButton();
    private JButton AbbrechenButton1 = new JButton();

    private JPanel BG = new JPanel();

    private JPanel buttonPanel = new JPanel();
    SizeFilter sfilter = new SizeFilter(4);

    public LinieFestlegenGUI(Parent_GUI parent) {
        setupGUI(parent, "LinieFestlegenGUI");

        buttonPanel.setBackground(dark);
        buttonPanel.setBounds(45,80,200,30);
        buttonPanel.setLayout(new GridLayout(1,2,10,0));

        SpeicherButton1.setText("Speichern");
        SpeicherButton1.setForeground(white);
        SpeicherButton1.setBackground(hellb);
        SpeicherButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        AbbrechenButton1.setText("Abbrechen");
        AbbrechenButton1.setForeground(white);
        AbbrechenButton1.setBackground(notSoDark);
        AbbrechenButton1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        styleTextField(linienTextfield, "z.B. S41");
        linienTextfield.setBounds(110,30,150,30);
        ((AbstractDocument)linienTextfield.getDocument()).setDocumentFilter(sfilter);
        if (KontrolleurGUI.currentLine!=null & KontrolleurGUI.currentLine!=""){
            linienTextfield.setText(KontrolleurGUI.currentLine);
        }




        linienText.setText("Linie:");
        linienText.setForeground(white); //same
        linienText.setBackground(whitebg); //same
        linienText.setFont(fontMedium); //same
        linienText.setBounds(30,30,150,30);


        BG.setBackground(dark);
        BG.setBounds(0,0,300,180);
        BG.setLayout(null);

        this.setTitle("Linie festlegen");
        this.setSize(300, 180);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setBackground(dark);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(parent);
        this.setLayout(null);

        buttonPanel.add(SpeicherButton1);
        buttonPanel.add(AbbrechenButton1);

        BG.add(linienTextfield);
        BG.add(linienText);
        BG.add(buttonPanel);

        this.add(BG);

        AbbrechenButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                parentGUI.Kachel2.setEnabled(true);
                dispose();
            }
        });

        SpeicherButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                KontrolleurGUI.currentLine = linienTextfield.getText();
                parentGUI.Kachel2.setEnabled(true);
                dispose();
            }
        });
    }

    private void styleTextField(PlaceholderTextField field, String txt) {
        //field.setBorder(new CompoundBorder(border, margin)); // same
        field.setForeground(white); //same
        field.setBackground(whitebg); //same
        field.setCaretColor(notSoDark); //same
        field.setFont(fontMedium); //same
        field.setSelectedTextColor(dark); //same
        field.setSelectionColor(notSoDark); //same
        field.setPlaceholder(txt);
    }

    public static void openLfErfassen(Parent_GUI parent) {
        Foo.getDirectoryData();
        LinieFestlegenGUI gui = new LinieFestlegenGUI(parent);
    }
}
