package src.GUI.Admin;
import src.Foo;
import src.GUI.Parent_GUI;
import src.PersFile;
import src.Rollen.Administrator;
import src.Rollen.Kontrolleur;
import src.Rollen.Sachbearbeiter;

import static src.Foo.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MitarbeiterVerwaltenGUI extends Parent_GUI implements ActionListener {

    String[] mitarbeiterStrings;
    File[] mitarbeiterFiles;
    final DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> list = new JList<>(model);
    JScrollPane scrollpane = new JScrollPane(list);

    JPanel Textpan = new JPanel();
    JPanel listpan = new JPanel();
    JPanel Buttonpan = new JPanel();
    JLabel label = new JLabel();
    JButton loeschen = new JButton();

    JButton abbrechen = new JButton();



     public MitarbeiterVerwaltenGUI(Parent_GUI parent){
        //Setup

        setupGUI(parent, "MitarbeiterVerwaltenGUI");
         displayMitarbeiter();


        for (int i = 0; i< mitarbeiterStrings.length; i++){
            model.addElement(String.valueOf(mitarbeiterStrings[i]));
        }

         list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
         list.setBackground(notSoDark);
         list.setForeground(white);


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


         label.setText("<html><body><center><p>Mitarbeiter verwalten</p></center></body></html>");
         label.setForeground(white);
         label.setHorizontalTextPosition(JLabel.CENTER);
         label.setVerticalTextPosition(JLabel.CENTER);
         label.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 28));
         label.setHorizontalAlignment(JLabel.CENTER);
         label.setVerticalAlignment(JLabel.CENTER);
         label.setBounds(200,50, 500,50);

         //Button löschen
         if (mitarbeiterStrings.length == 0){
            loeschen.setEnabled(false);
         }
         styleButton(loeschen, "Löschen");
         loeschen.setBounds(70,10,100,30);

         //Button abbrechen
         styleButton(abbrechen, "Abbrechen");
         abbrechen.setEnabled(true);
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

         list.addListSelectionListener(new ListSelectionListener() {
             @Override
             public void valueChanged(ListSelectionEvent e) {
                 loeschen.setEnabled(true);
             }
         });
         loeschen.addActionListener(new ActionListener() {
             public void actionPerformed(ActionEvent event) {

                 String[] options = {"Ja","Abbrechen"};
                 JPanel panel = new JPanel();
                 JLabel lbl = new JLabel("Sind Sie sicher, dass Sie diesen Mitarbeiter löschen wollen?");
                 panel.add(lbl);
                 int result = JOptionPane.showOptionDialog(getFrame(), lbl,"Bestätigung",
                         JOptionPane.YES_NO_OPTION,
                         JOptionPane.WARNING_MESSAGE, null,options,options[1]);

                 if(result == 0){

                     ListSelectionModel selmodel = list.getSelectionModel();
                     int index = selmodel.getMinSelectionIndex();
                     if (index >= 0){

                         System.out.println("Index" + index);
                         System.out.println(mitarbeiterStrings[index]);


                         try {
                             writeDeleteRequest(mitarbeiterFiles[index]);
                             model.remove(index);
                         } catch (IOException e) {
                             e.printStackTrace();
                             throw new RuntimeException(e);
                         }

                         okWindow("Die Änderungen treten beim nächsten Programm-Neustart in Kraft!" , getFrame());

                     }
                     if (index == 0){
                         System.out.println("Index = 0");
                     }
                     System.out.println("Ja gedrückt");

                 }else{
                     System.out.println("Nein gedrückt");
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
        openMitarbeiterVerwaltenGUI(null);
    }
    public static void openMitarbeiterVerwaltenGUI(Parent_GUI parent){

        MitarbeiterVerwaltenGUI gui = new MitarbeiterVerwaltenGUI(parent);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void displayMitarbeiter() {
        Foo.getDirectoryData();
        int anzahlMitarbeiter = userCount;
        String[] stringArray = new String[anzahlMitarbeiter-(1+deletedFiles.size())];
        File[] fileArray = new File[anzahlMitarbeiter-(1+deletedFiles.size())];
        int foundDeletedFiles = 0;

        if (konCount>=1){
            for (int i = 0; i < konCount; i++){
                try {
                    Kontrolleur k = (Kontrolleur) PersFile.laden(KontrolleurFileListe.get(i));
                    if (!deletedFiles.contains(k.getUserFile())){
                        stringArray[i-foundDeletedFiles]  = k.getNachname() + ", " + k.getVorname() + " (" + k.getMitarbeiternummer() + ")";
                        fileArray[i-foundDeletedFiles] = k.getUserFile();
                    }else{
                        foundDeletedFiles++;
                    }

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
                    if (!deletedFiles.contains(s.getUserFile())){
                        stringArray[i-foundDeletedFiles]  = s.getNachname() + ", " + s.getVorname() + " (" + s.getMitarbeiternummer() + ")";
                        fileArray[i-foundDeletedFiles] = s.getUserFile();
                    }else{
                        foundDeletedFiles++;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        boolean hitYourself = false;
        for (int i = konCount + sbCount; i < userCount; i++){
            try {

                Administrator a = (Administrator) PersFile.laden(AdminFileListe.get(i-konCount-sbCount));

                if (!a.getMitarbeiternummer().equals(currentUser.getMitarbeiternummer())){
                    if (hitYourself){
                        stringArray[i-1-foundDeletedFiles] = a.getNachname() + ", " + a.getVorname() + " (" + a.getMitarbeiternummer() + ")";
                        fileArray[i-1-foundDeletedFiles] = a.getUserFile();
                    }else{
                        if (!deletedFiles.contains(a.getUserFile())){
                            stringArray[i-foundDeletedFiles]  = a.getNachname() + ", " + a.getVorname() + " (" + a.getMitarbeiternummer() + ")";
                            fileArray[i-foundDeletedFiles] = a.getUserFile();
                        }else{
                            foundDeletedFiles++;
                        }
                    }
                }else{
                    System.out.println("Sich selbst excluded");
                    hitYourself = true;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }

        this.mitarbeiterStrings = stringArray;
        this.mitarbeiterFiles = fileArray;

        if (mitarbeiterStrings.length==0){
            loeschen.setEnabled(false);
        }
    }
    public void writeDeleteRequest(File userToDelete) throws IOException {
        deletedFiles.add(userToDelete);
         PersFile.speichern(deletedFiles, deleteFileFile);
    }
}
