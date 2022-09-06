package src.GUI;
import src.GUI.elements.NumberFilter;
import src.GUI.elements.PlaceholderTextField;
import src.GUI.elements.pass;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AbstractDocument;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import static src.Foo.*;
public class ProfilGUI extends Parent_GUI implements ActionListener {

    JPanel label = new JPanel();
    JLabel Text = new JLabel();
    JPanel Textfelder = new JPanel();
    JPanel Buttons = new JPanel();
    JPanel Buttonsbg = new JPanel();
    PlaceholderTextField Benutzername = new PlaceholderTextField();
    PlaceholderTextField Name = new PlaceholderTextField();
    PlaceholderTextField Vorname = new PlaceholderTextField();
    PlaceholderTextField Gender = new PlaceholderTextField();
    PlaceholderTextField Rolle = new PlaceholderTextField();
    PlaceholderTextField Geburtstag = new PlaceholderTextField();
    PlaceholderTextField EMail = new PlaceholderTextField();
    PlaceholderTextField Telefonnummer = new PlaceholderTextField();
    JButton SpeicherButton = new JButton();
    JButton AbbrechenButton = new JButton();
    JButton AngabenAendern = new JButton();
    JButton PasswortAendernButton = new JButton();


    public ProfilGUI(Parent_GUI parent){

        setupGUI(parent, "ProfilGUI");

        NumberFilter nfilter = new NumberFilter();

        //Panelmanagement

        label.setBackground(dark);
        label.setPreferredSize(new Dimension(400,100));
        label.setLayout(null);

        Textfelder.setLayout(null);
        Textfelder.setBackground(dark);
        Textfelder.setPreferredSize(new Dimension(400,600));


        Buttonsbg.setBackground(dark);
        Buttonsbg.setPreferredSize(new Dimension(400,150));
        Buttonsbg.setLayout(null);

        Buttons.setBackground(dark);
        Buttons.setBounds(50,0,300,80);
        Buttons.setLayout(new GridLayout(2,2,10,10));

        // Elemente

        Text.setForeground(white);
        Text.setFont(fontMediumMedium);
        Text.setText("<html><body><center><p>Profil von <br>"+ currentUser.getVorname() + "</p></center></body></html>");
        Text.setBounds(140,0,400,100);


        styleTextField(Benutzername, currentUser.getBenutzername());
        Benutzername.setBounds(75,20,250,40);

        styleTextField(Name, currentUser.getNachname());
        Name.setBounds(75,140,250,40);

        styleTextField(Vorname, currentUser.getVorname());
        Vorname.setBounds(75,80,250,40);

        styleTextField(Gender, currentUser.getGeschlecht());
        Gender.setBounds(75,320,250,40);


        Rolle.setBounds(75,200,250,40);
        if(currentUser.isAdmin()){
            styleTextField(Rolle, "Admin");
        } else if (currentUser.isKontrolleur()) {
            styleTextField(Rolle, "Kontrolleur");
        }
        else{
            styleTextField(Rolle, "Sachbearbeiter");
        }

        styleTextField(Geburtstag, currentUser.getGeburtsdatum());
        Geburtstag.setBounds(75,260,250,40);

        styleTextField(EMail, currentUser.getEmail());
        EMail.setBounds(75,440,250,40);
        EMail.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

                if (EMail.getText().isBlank()){
                    EMail.setPlaceholder("E-Mail*");
                    EMail.setBackground(red);
                }else{
                    EMail.setBackground(dark);
                }
                if (!EMail.getText().contains("@")){
                    EMail.setBackground(red);
                }else{
                    EMail.setBackground(dark);
                }
            }
        });


        styleTextField(Telefonnummer, currentUser.getTelefonnummer());
        Telefonnummer.setBounds(75,380,250,40);
        ((AbstractDocument)Telefonnummer.getDocument()).setDocumentFilter(nfilter);

        Telefonnummer.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                if (Telefonnummer.getText().isBlank()){

                    Telefonnummer.setPlaceholder("Telefonnummer");
                }


            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        AbbrechenButton.setBackground(hellb);
        AbbrechenButton.setForeground(white);
        AbbrechenButton.setText("Abbrechen");
        AbbrechenButton.setFont(fontverySmall);
        AbbrechenButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AbbrechenButton.setBounds(150,100,100,40);




        AngabenAendern.setBackground(dunkelb);
        AngabenAendern.setText("Angaben ändern");
        AngabenAendern.setForeground(white);
        AngabenAendern.setFont(fontverySmall);
        AngabenAendern.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        AngabenAendern.setBounds(75,55,100,40);




        PasswortAendernButton.setBackground(dunkelb);
        PasswortAendernButton.setText("Passwort ändern");
        PasswortAendernButton.setForeground(white);
        PasswortAendernButton.setFont(fontverySmall);
        PasswortAendernButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        PasswortAendernButton.setBounds(225, 55, 100, 40);

        PasswortAendernButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

               String pwNeu = JOptionPane.showInputDialog(getFrame(), "Neues Passwort eingeben");
               if (pwNeu!=null){
                   if (pass.passwordOk(pwNeu)){
                       String pwConfirm = JOptionPane.showInputDialog(getFrame(), "Neues Passwort bestätigen");
                       if (pwConfirm!=null){
                           if (pwNeu.equals(pwConfirm)){
                               okWindow("Passwort wurde aktualisiert!", getFrame());
                               try {
                                   currentUser.setPasswort(pwNeu);
                               } catch (IOException ex) {
                                   ex.printStackTrace();
                                   throw new RuntimeException(ex);
                               }
                           }else{
                               okWindow("Die Passwörter stimmen nicht überein!", getFrame());
                           }
                       }
                   }else{
                       okWindow("Passwort muss enthalten: \n 6-10 zeichen \n Mindestens 1 Großbuchstabe \n Mindestens 1 Kleinbuchstabe \n Mindestens eine Zahl.", getFrame());
                   }


               }

            }
        });
        SpeicherButton.setBackground(hellb);
        SpeicherButton.setForeground(white);
        SpeicherButton.setFont(fontverySmall);
        SpeicherButton.setText("Speichern");
        SpeicherButton.setBounds(150,0,100,40);
        SpeicherButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        SpeicherButton.setEnabled(false);


        // Elemente zu Panels adden

        label.add(Text);

        Textfelder.add(Benutzername);
        Textfelder.add(Name);
        Textfelder.add(Vorname);
        Textfelder.add(Gender);
        Textfelder.add(Rolle);
        Textfelder.add(Geburtstag);
        Textfelder.add(EMail);
        Textfelder.add(Telefonnummer);


        Buttons.add(AngabenAendern);
        Buttons.add(PasswortAendernButton);
        Buttons.add(SpeicherButton);
        Buttons.add(AbbrechenButton);

        Buttonsbg.add(Buttons);


        // Panels zu Frame adden

        add(label,BorderLayout.NORTH);
        add(Textfelder,BorderLayout.CENTER);
        add(Buttonsbg,BorderLayout.SOUTH);


        setSize(400, 800);
        setTitle("Profil");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(parent);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(parent);

        AbbrechenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                parentGUI.StartAutoLogout();
                System.out.println("Starte AutoLogout für " + parentGUI.name);
                parentGUI.Kachel4.setEnabled(true);
                dispose();
            }
        });
        SpeicherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pflichtAusgefüllt()){
                    angabenAendern(false);
                    try {
                        currentUser.setEmail(EMail.getText());
                        currentUser.setTelefon(Telefonnummer.getText());
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

            }
        });
        AngabenAendern.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                angabenAendern(true);
            }
        });

    }
    private boolean pflichtAusgefüllt(){
        boolean b = false;
        if (!EMail.getText().isBlank()){
                if (EMail.getText().contains("@")){
                    return true;
                }
        }
        if (!EMail.getText().contains("@")){
            if(!colorChange){
                EMail.addRedFlashEffect();
            } else {
                EMail.addRedFlashEffectWhiteField();
            }
        }

        return b;
    }
    void styleTextField(PlaceholderTextField field, String txt){
        field.setForeground(white);
        field.setBackground(dark);
        field.setFont(fontMedium);
        field.setEnabled(false);
        field.setText(txt);
    }
    public static void openProfilGUI(Parent_GUI parent){

            ProfilGUI gui1 = new ProfilGUI(parent);
    }

    @Override
    public void actionPerformed(ActionEvent e){
    }

   public void angabenAendern(boolean angabenAendern){
        if(angabenAendern){

            SpeicherButton.setEnabled(true);

            Telefonnummer.setEnabled(true);
            EMail.setEnabled(true);
            AngabenAendern.setEnabled(false);
        }else{
            SpeicherButton.setEnabled(false);

            Telefonnummer.setEnabled(false);
            EMail.setEnabled(false);
            AngabenAendern.setEnabled(true);
        }
    }



    public static void main(String[] args) {
        new ProfilGUI(null);
    }
}
