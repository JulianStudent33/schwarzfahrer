package src.GUI.Admin;
import org.w3c.dom.Text;
import src.Foo;
import src.PersFile;
import src.roles.Administrator;
import src.roles.Kontrolleur;
import src.roles.Sachbearbeiter;

import static src.Foo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Vector;

public class MitarbeiterVerwaltenGUI extends JFrame implements ActionListener {

    String[] mitarbeiter;
    final DefaultListModel<String> model = new DefaultListModel<>();
    final JList<String> list = new JList<>(model);
    JScrollPane scrollpane = new JScrollPane(list);
    JButton loeschen = new JButton();

    JButton abbrechen = new JButton();


     public MitarbeiterVerwaltenGUI(Frame parent){

        getMitarbeiter();
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
                dispose();
                AdminGUI.MitarbeiterVerwalten.setEnabled(true);
             }
         });

    }



    public static void main(String[] args) {
        openMitarbeiterVerwaltenGUI(null);
    }
    public static void openMitarbeiterVerwaltenGUI(Frame parent){
        Foo.getDirectoryData();
        MitarbeiterVerwaltenGUI gui = new MitarbeiterVerwaltenGUI(parent);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void getMitarbeiter() {
        Foo.getDirectoryData();
        int anzahlMitarbeiter = userCount;
        String[] stringArray = new String[anzahlMitarbeiter];

        if (konCount>=1){
            for (int i = 0; i < konCount; i++){
                try {
                    Kontrolleur k = (Kontrolleur) PersFile.laden(KontrolleurFileListe.get(i));
                    System.out.println(k.getVorname());
                    stringArray[i]  = k.getName() + ", " + k.getVorname() + " (" + k.getMitarbeiternummer() + ")";
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        if (SachbearbeiterFileListe.size()>=1){
            for (int i = konCount; i < sbCount + konCount; i++){
                try {
                    Sachbearbeiter s = (Sachbearbeiter) PersFile.laden(SachbearbeiterFileListe.get(i-konCount));
                    System.out.println(s.getVorname());
                    stringArray[i] = s.getName() + ", " + s.getVorname() + " (" + s.getMitarbeiternummer() + ")";
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        }

        for (int i = konCount + sbCount; i < userCount; i++){
            try {
                Administrator a = (Administrator) PersFile.laden(AdminFileListe.get(i-konCount-sbCount));
                System.out.println(a.getVorname());
                stringArray[i] = a.getName() + ", " + a.getVorname() + " (" + a.getMitarbeiternummer() + ")";
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        this.mitarbeiter = stringArray;

    }
    public void deleteMitarbeiter(){

    }
}
