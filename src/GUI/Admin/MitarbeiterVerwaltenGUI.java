package src.GUI.Admin;
import src.Foo;

import static src.Foo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MitarbeiterVerwaltenGUI extends JFrame implements ActionListener {

    String[] ArrayList = {"RRRRRRRRRRR","Jürgen","Der Jude","Türke","Achim","RRRRRRRRRRR","Jürgen","Der Jude","Türke","Achim","RRRRRRRRRRR","Jürgen","Der Jude","Türke","Achim","RRRRRRRRRRR","Jürgen","Der Jude","Türke","Achim","RRRRRRRRRRR","Jürgen","Der Jude","Türke","Achim","RON"};
    Vector<JPanel> listElements = new Vector<JPanel>();
    JList mitarbeiterlist;

    JScrollPane scrollpan;
    JPanel listepan = new JPanel();

    private JButton loeschen = new JButton();

     public MitarbeiterVerwaltenGUI(){

         JPanel panel1 = new JPanel();
         panel1.setLayout(new GridLayout(1, 4));

         JButton btn1 = new JButton();
         btn1.setBackground(dark);
         JButton btn2 = new JButton();
         btn2.setBackground(white);
         JButton btn3 = new JButton();
         btn3.setBackground(white);
         JButton btn4 = new JButton();
btn4.setBackground(white);

         panel1.add(btn1);
         panel1.add(btn2);
         panel1.add(btn3);
         panel1.add(btn4);
         panel1.setBackground(notSoDark);
         panel1.setPreferredSize(new Dimension(100,150));
         listElements.addElement(panel1);



         mitarbeiterlist = new JList(listElements);






         listepan.setBackground(dark);
         listepan.setPreferredSize(new Dimension(100,150));
         listepan.setLayout(null);


         JPanel Buttonpan = new JPanel();
         Buttonpan.setLayout(new BorderLayout());
         Buttonpan.setBackground(dark);
         Buttonpan.setPreferredSize(new Dimension(100,150));
         Buttonpan.setLayout(null);

         //Button löschen
         loeschen.addActionListener(this);
         loeschen.setText("Löschen");
         loeschen.setBackground(dunkelb);
         loeschen.setForeground(white);
         loeschen.setHorizontalTextPosition(JLabel.CENTER);
         loeschen.setVerticalTextPosition(JLabel.CENTER);
         loeschen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 20));
         loeschen.setHorizontalAlignment(JLabel.CENTER);
         loeschen.setVerticalAlignment(JLabel.CENTER);
         loeschen.setFocusable(false);
         loeschen.setBorderPainted(false);
         loeschen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         loeschen.setBounds(170,10,150,50);

         scrollpan = new JScrollPane();
         scrollpan.setBounds(95,100,300,400);
         scrollpan.setBackground(notSoDark);
         scrollpan.setForeground(white);

         scrollpan.add(mitarbeiterlist);

         //Add to panel

         Buttonpan.add(loeschen);
         listepan.add(scrollpan);
//         listepan.add(scrollpeen);

         //add panels to window

         this.add(Buttonpan, BorderLayout.SOUTH);
         this.add(listepan);

         this.setSize(500,700);
         this.setTitle("Sachbearbeiter");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
         this.getContentPane().setBackground(dark);



    }



    public static void main(String[] args) {
        openMitarbeiterVerwaltenGUI();
    }
    public static void openMitarbeiterVerwaltenGUI(){
        Foo.getDirectoryData();
        MitarbeiterVerwaltenGUI gui = new MitarbeiterVerwaltenGUI();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
