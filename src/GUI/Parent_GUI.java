package src.GUI;

import src.Foo;
import src.GUI.elements.InactivityListener;
import src.PersFile;
import src.Rollen.Administrator;
import src.Rollen.Kontrolleur;
import src.Rollen.Mitarbeiter;
import src.Rollen.Sachbearbeiter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

import static src.Foo.*;

public abstract class Parent_GUI extends JFrame {
    /** Die MAMA der GUIs
     * Superklasse für
     *
     * */



    //Statische Variablen
        //Farben
        public static Color dark;
        public static Color white;
        public static Color whitebg;
        public static Color notSoDark;
        public static Color darky = new Color(60,60,60);
        public static Color Grey = new Color(150, 150, 150);
        public static Color hellb = new Color(133, 179, 255);
        public static Color dunkelb = new Color(74, 142, 255);

        public static Color red = new Color(255, 107, 107);
        public static Color green = new Color(143, 255, 107);

        //Fonts
        public static Font fontLargeLarge = new Font("IBM Plex Mono Medium", Font.BOLD, 38);
        public static Font fontLarge = new Font("IBM Plex Mono Medium", Font.BOLD, 28);
        public static Font fontMediumMedium = new Font ("IBM Plex Mono Medium", Font.BOLD, 25);
        public static Font fontMedium = new Font("IBM Plex Mono Medium", Font.BOLD, 20);
        public static Font fontSmall = new Font("IBM Plex Mono Medium", Font.BOLD, 15);
        public static Font fontverySmall = new Font("IBM Plex Mono Medium", Font.BOLD, 12);
        public static Font fontSmallPlain = new Font("IBM Plex Mono Medium", Font.PLAIN, 15);
        public static Font fontSmallSmall = new Font("IBM Plex Mono Medium", Font.BOLD, 12);

    //Objektbezogene Variablen

        public String name;
        String[] optionenLogout = {"Aus", "5", "15", "30"};
        public Mitarbeiter currentUser;
        public boolean konAngemeldet;
        public boolean sbAngemeldet;
        public  boolean adminAngemeldet;
        public boolean autoLogoutON;
        public Parent_GUI parentGUI;

        public Action logout = new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                dispose();

                if (parentGUI!=null){
                    parentGUI.dispose();
                }
                StartfensterGUI.openStartFenster(null);


            }
        };
        public InactivityListener listener = new InactivityListener(this, logout, 0);

    //Objektbezogene graphische Element

        public JPanel gridPanel;
        public JPanel textPanel;
        public JLabel textLabel;

        public JButton Kachel1;
        public JButton Kachel2;
        public JButton Kachel3;
        public JButton Kachel4;
        public JButton Kachel5;
        public JButton Kachel6;

    public Parent_GUI(){

    }


    public void StartAutoLogout(){

        int time = 1;
        refreshCurrentUser();
        System.out.println(currentUser.getAutoLogout());
        System.out.println(optionenLogout[1]);
        if (!currentUser.getAutoLogout().equals(optionenLogout[0])){
            if (currentUser.getAutoLogout().equals(optionenLogout[1])){
                time = 5;
            }
            if (currentUser.getAutoLogout().equals(optionenLogout[2])){
                time = 15;
            }
            if (currentUser.getAutoLogout().equals(optionenLogout[3])){
                time = 30;
            }
            listener.setInterval(time);
            listener.start();
            this.autoLogoutON = true;
            System.out.println("Logout nach " + time + " Minuten");
        } else{
            listener.stop();
            System.out.println("Angemeldet bleiben false");
        }

    }

    public void StopAutoLogout(){
        listener.stop();
        autoLogoutON = false;
    }

    public Mitarbeiter getCurrentUser(){
        if (parentGUI!=null && parentGUI.currentUser!=null){
            if (parentGUI.currentUser.isKontrolleur()){
                this.konAngemeldet = true;
            } else if (parentGUI.currentUser.isAdmin()) {
                this.adminAngemeldet = true;
            } else if (parentGUI.currentUser.isSachbearbeiter()) {
                this.sbAngemeldet = true;
            }
            System.out.println("Current User aus ParentGUI geholt");
            return parentGUI.currentUser;

        }else{
            System.out.println("Current User aus Foo geholt");
            if (Foo.currentUser.isKontrolleur()){
                this.konAngemeldet = true;
            } else if (Foo.currentUser.isAdmin()) {
                this.adminAngemeldet = true;
            } else if (Foo.currentUser.isSachbearbeiter()) {
                this.sbAngemeldet = true;
            }
            return Foo.currentUser;

        }

    }
    public void setupGUI(Parent_GUI parent, String name){
        this.name = name;
        parentGUI = parent;
        Foo.getDirectoryData();
        this.currentUser = getCurrentUser();
        if (parentGUI!=null){
            if (parentGUI.autoLogoutON){
                parentGUI.StopAutoLogout();
            }
        }
        StartAutoLogout();

        try {
            getColorChange();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setCurrentUser(Mitarbeiter currentUser){
        this.currentUser = currentUser;
    }
    public void refreshCurrentUser(){

        if (this.currentUser.isAdmin()){
            try {
                this.currentUser = (Administrator) PersFile.laden(currentUser.getUserFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (this.currentUser.isKontrolleur()){
            try {
                this.currentUser = (Kontrolleur) PersFile.laden(currentUser.getUserFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        if (this.currentUser.isSachbearbeiter()){
            try {
                this.currentUser = (Sachbearbeiter) PersFile.laden(currentUser.getUserFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void styleMenu(String[] text){
        //Panelmanagement
        gridPanel = new JPanel();
        gridPanel.setBackground(dark);
        gridPanel.setLayout(new BorderLayout());
        gridPanel.setPreferredSize(new Dimension(100,100));
        gridPanel.setBounds(50,25,300,30);
        gridPanel.setLayout(new GridLayout(2,3,20,20));
        gridPanel.setBorder(BorderFactory.createEmptyBorder(0,70,70,70));

        //Willkommentext Panel
        textPanel = new JPanel();
        textPanel.setBackground(dark);
        textPanel.setPreferredSize(new Dimension(100,150));
        textPanel.setLayout(null);

        //Willkommen text
        textLabel = new JLabel();
        textLabel.setText("<html><body><center><p>Hallo " + currentUser.getVorname() + "(" + currentUser.getMitarbeiternummer() + ")</p></center></body></html>");
        textLabel.setForeground(white);
        textLabel.setHorizontalTextPosition(JLabel.CENTER);
        textLabel.setVerticalTextPosition(JLabel.CENTER);
        textLabel.setFont(new Font("IBM Plex Mono Medium", Font.BOLD, 28));
        textLabel.setHorizontalAlignment(JLabel.CENTER);
        textLabel.setVerticalAlignment(JLabel.CENTER);
        textLabel.setBounds(200,50, 500,50);

        JButton[] buttons = new JButton[6];
        for (int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton();
            buttons[i].setText(text[i]);
            buttons[i].setHorizontalTextPosition(JLabel.CENTER);
            buttons[i].setVerticalTextPosition(JLabel.CENTER);
            buttons[i].setFont(fontMedium);
            buttons[i].setHorizontalAlignment(JLabel.CENTER);
            buttons[i].setVerticalAlignment(JLabel.CENTER);
            buttons[i].setFocusable(true);
            buttons[i].setBorderPainted(false);
            buttons[i].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            buttons[i].setBounds(140,100,100,100);

            System.out.println("Styled Kachel" + (i+1));
        }
        Kachel1 = buttons[0];
        Kachel1.setBackground(hellb);
        Kachel1.setForeground(white);

        Kachel2 = buttons[1];
        Kachel2.setBackground(dunkelb);
        Kachel2.setForeground(white);

        Kachel3 = buttons[2];
        Kachel3.setBackground(hellb);
        Kachel3.setForeground(white);

        Kachel4 = buttons[3];
        Kachel4.setBackground(dunkelb);
        Kachel4.setForeground(white);

        Kachel5 = buttons[4];
        Kachel5.setBackground(hellb);
        Kachel5.setForeground(white);

        Kachel6 = buttons[5];
        Kachel6.setBackground(dunkelb);
        Kachel6.setForeground(white);

        //WillkommentextPanel befüllen
        textPanel.add(textLabel, BorderLayout.SOUTH);

        //KachelPanel befüllen
        gridPanel.add(Kachel1);
        gridPanel.add(Kachel2);
        gridPanel.add(Kachel3);
        gridPanel.add(Kachel4);
        gridPanel.add(Kachel5);
        gridPanel.add(Kachel6);


        //Frame konfigurieren
        this.setSize(900,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(parentGUI);
        this.setVisible(true);
        this.getContentPane().setBackground(dark);
        this.add(gridPanel, BorderLayout.CENTER);
        this.add(textPanel, BorderLayout.NORTH);

        if (currentUser.isAdmin()){
            this.setTitle("Administrator-Menü");
        }
        if (currentUser.isKontrolleur()){
            this.setTitle("Kontrolleur-Menü");
        }
        if (currentUser.isSachbearbeiter()){
            this.setTitle("SB");
        }
        //Gridpanel und TextPanel dem Frame hinzufügen


        enableButtons();
    }
    public  void enableButtons(){
        Kachel1.setEnabled(true);
        Kachel2.setEnabled(true);
        Kachel3.setEnabled(true);
        Kachel4.setEnabled(true);
        Kachel5.setEnabled(true);
        Kachel6.setEnabled(true);
    }
    public Parent_GUI getFrame(){

        return this;
    }


}
