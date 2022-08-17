package src.GUI.Admin;
import org.w3c.dom.Text;
import src.Foo;

import static src.Foo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.Vector;

public class MitarbeiterVerwaltenGUI extends JFrame implements ActionListener {

    String[] mitarbeiter = {"Jürgen","Hans","Peter Ulllrich","Hönnoblatt","Michael Wipprecht mhm","Evgenimehr","Jürgen","Hans","Peter Ulllrich","Hönnoblatt","Michael Wipprecht mhm","Evgenimehr","Jürgen","Hans","Peter Ulllrich","Hönnoblatt","Michael Wipprecht mhm","Evgenimehr","Jürgen","Hans","Peter Ulllrich","Hönnoblatt","Michael Wipprecht mhm","Evgenimehr","Jürgen","Hans","Peter Ulllrich","Hönnoblatt","Michael Wipprecht mhm","Evgenimehr","Jürgen","Hans","Peter Ulllrich","Hönnoblatt","Michael Wipprecht mhm","Evgenimehr"};
    final DefaultListModel<String> model = new DefaultListModel<>();
    final JList<String> list = new JList<>(model);
    JScrollPane scrollpane = new JScrollPane(list);
    JButton loeschen = new JButton();

    JButton abbrechen = new JButton();


     public MitarbeiterVerwaltenGUI(){

        for (int i = 0; i< mitarbeiter.length;i++){
            model.addElement(String.valueOf(mitarbeiter[i]));
        }

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
         Buttonpan.setLayout(new BorderLayout());
         Buttonpan.setBackground(dark);
         Buttonpan.setPreferredSize(new Dimension(100,150));
         Buttonpan.setLayout(null);

         JLabel label = new JLabel();
         label.setText("<html><body><center><p>Mitarbeiter verwalten</p></center></body></html>");
         label.setForeground(white);
         label.setHorizontalTextPosition(JLabel.CENTER);
         label.setVerticalTextPosition(JLabel.CENTER);
         label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 28));
         label.setHorizontalAlignment(JLabel.CENTER);
         label.setVerticalAlignment(JLabel.CENTER);
         label.setBounds(200,50, 500,50);

         //Button löschen
         loeschen.addActionListener(this);
         loeschen.setText("Löschen");
         loeschen.setBackground(dunkelb);
         loeschen.setForeground(white);
         loeschen.setHorizontalTextPosition(JLabel.CENTER);
         loeschen.setVerticalTextPosition(JLabel.CENTER);
         loeschen.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 12));
         loeschen.setHorizontalAlignment(JLabel.CENTER);
         loeschen.setVerticalAlignment(JLabel.CENTER);
         loeschen.setFocusable(false);
         loeschen.setBorderPainted(false);
         loeschen.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
         loeschen.setBounds(70,10,100,30);

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
         abbrechen.setBounds(315,10,100,30);


         listpan.setBorder(BorderFactory.createEmptyBorder(0, 70, 20, 70));
         scrollpane.setBounds(0,200,300,400);
         scrollpane.setBackground(notSoDark);

         //scrollpane.setForeground(white);

         //Add to panel
         Textpan.add(label);
         listpan.add(new JScrollPane(list));
         Buttonpan.add(loeschen);
         Buttonpan.add(abbrechen);

//         listepan.add(scrollpeen);

         //add panels to window
         this.add(Textpan,BorderLayout.NORTH);
         this.add(Buttonpan, BorderLayout.SOUTH);
         this.add(listpan,BorderLayout.CENTER);

         this.setSize(500,700);
         this.setTitle("Mitarbeiter verwalten");
         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setResizable(false);
         this.setLocationRelativeTo(null);
         this.setVisible(true);
         this.setBackground(dark);

         loeschen.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent event) {
                 ListSelectionModel selmodel = list.getSelectionModel();
                 int index = selmodel.getMinSelectionIndex();
                 if (index >= 0)
                     model.remove(index);
             }

         });
         
         abbrechen.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                dispose();
             }
         });

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
