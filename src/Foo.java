package src;

import src.GUI.*;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.roles.Administrator;
import src.roles.Kontrolleur;
import src.roles.Sachbearbeiter;
import src.roles.Schwarzfahrer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

public class Foo {
    public static FileSystem fs = FileSystems.getDefault();
    public static final String fileSeperator = fs.getSeparator();

    public static String currentDate;
    public static String currentTime;
    //File Struktur:
    /*Users/Admin/ ... .user PersFiles
     * Users/Kontrolleur/ ... .user PersFiles
     * Users/Sachbearbeiter/ ... .user PersFiles
     * /Schwarzfahrer/ ... .rider
     * /Schwarzfahrten ... .
     * */
    //Array File Variablen für Profile (Noch als Liste (Array alternative für einfache Suche) zu implementieren)
    public static File[] admins;
    public static List<File> AdminFileListe = new ArrayList<File>();
    public static File[] sachbearbeiter;
    public static List<File> SachbearbeiterFileListe = new ArrayList<File>();
    public static File[] kontrolleure;
    public static List<File> KontrolleurFileListe = new ArrayList<File>();
    public static File[] schwarzfahrer;
    public static List<File> SchwarzfahrerFileListe = new ArrayList<File>();
    public static List<Schwarzfahrer> SchwarzfahrerListe = new ArrayList<Schwarzfahrer>();
    public static List<Schwarzfahrt> SchwarzfahrtenListe = new ArrayList<Schwarzfahrt>();

    //Count Variablen (Noch Als Liste<int> zu implementieren)
    public static Color red = new Color(255, 107, 107);
    public static Color green = new Color(143, 255, 107);

    public static int adminCount;
    public static int konCount;
    public static int sbCount;
    public static int userCount;
    public static int sfCount;
    public static int sftCount;
    public static boolean angemeldet = false;
    public static boolean angemeldetBleiben;

    public static Sachbearbeiter currentSachbearbeiter;
    public static Kontrolleur currentKontrolleur;
    public static Administrator currentAdmin;



        public static Path savesPath = Paths.get("Saves");
        public static Path userPath = Paths.get("Saves" + fileSeperator + "Users");
        public static Path adminPath = Paths.get("Saves" + fileSeperator + "Users" + fileSeperator + "Admin");
        public static Path sbPath = Paths.get("Saves" + fileSeperator + "Users" + fileSeperator + "Sachbearbeiter");
        public static Path konPath = Paths.get("Saves" + fileSeperator + "Users" + fileSeperator + "Kontrolleur");
        public static Path sfPath = Paths.get("Saves" + fileSeperator + "Schwarzfahrer");
        public static Path loginPath = Paths.get("Saves" + fileSeperator + "loggedIN.save");

    public static File savesDir = savesPath.toFile();
    public static File userDir = userPath.toFile();
    public static File adminDir = adminPath.toFile();
    public static File sbDir = sbPath.toFile();
    public static File konDir = konPath.toFile();
    public static File sfDir = sfPath.toFile();
    public static File loggedINFile = loginPath.toFile();
    public static boolean firstUsage;
    private static String[] optionsUse = {"Register", "Login"};

    // Farbpalette
    public static Color dark = new Color(44,44,44);
    public static Color notSoDark = new Color(77, 77, 77);
    public static Color Grey = new Color(100, 100, 100);
    public static Color white = new Color(255,255,255);
    public static Color hellb = new Color(133, 179, 255);
    public static Color dunkelb = new Color(74,142,255);

    //Schriftart
    public static Font fontLargeLarge = new Font("IBM Plex Mono Medium", Font.BOLD, 38);
    public static Font fontLarge = new Font("IBM Plex Mono Medium", Font.BOLD, 28);
    public static Font fontMediumMedium = new Font ("IBM Plex Mono Medium", Font.BOLD, 25);
    public static Font fontMedium = new Font("IBM Plex Mono Medium", Font.BOLD, 20);
    public static Font fontSmall = new Font("IBM Plex Mono Medium", Font.BOLD, 15);
    public static Font fontSmallSmall = new Font("IBM Plex Mono Medium", Font.BOLD, 10);

    //Konstruktoren

    public Foo() throws IOException, ClassNotFoundException {
        //Programm startet grundsätzlich immer hier
        System.out.println("Starting Application");
        getDirectoryData();
        if (firstUsage = true){
            System.out.println("Erste Benutzung");
            createDirectories();
        }else{
            refreshStats();
        }
        angemeldetBleiben = getAngemeldetBleiben();
        setAngemeldet(angemeldetBleiben);

        if(!angemeldet){
            StartfensterGUI.startFenster();
        } else if (currentAdmin!=null) {
            AdminGUI.openAdminGUI();
        } else if (currentKontrolleur!=null) {
            KontrolleurGUI.openKonGUI();
        } else if (currentSachbearbeiter!=null) {
            SachbearbeiterGUI.openSBGUI();
        }

        currentDate = getCurrentDate();
        currentTime = getCurrentTime();

        System.out.println(currentDate);


    }




    private static void createDirectories(){
        if(savesDir.mkdir()){
            System.out.println("Created SavesDir succesfully");
        }else{
            System.out.println("Did not create SavesDir");
        }
        if (userDir.mkdir()){
            System.out.println("Created userDir succesfully.");
        }else{
            System.out.println("Did not create userDir");
        }
        if (adminDir.mkdir()){
            System.out.println("Created adminDir succesfully.");
        }else{
            System.out.println("Did not create adminDir");
        }
        if (sbDir.mkdir()){
            System.out.println("Created sachbearbeiterDir succesfully.");
        }else{
            System.out.println("Did not create sachbearbeiterDir");
        }
        if (konDir.mkdir()){
            System.out.println("Created kontrolleurDir succesfully.");
        }else{
            System.out.println("Did not create kontrolleurDir");
        }
        if (sfDir.mkdir()){
            System.out.println("Created schwarzfahrerDir succesfully.");
        }else{
            System.out.println("Did not create schwarzfahrerDir");
        }


    }
    public static void refreshStats(){


        adminCount = AdminFileListe.size();
        konCount = KontrolleurFileListe.size();
        sbCount = SachbearbeiterFileListe.size();
        userCount = adminCount+konCount+sbCount;
        sfCount = SchwarzfahrerFileListe.size();
        sftCount = SchwarzfahrtenListe.size();
    }
    public static void getDirectoryData(){
        //Check for Existance and fill lists and FileArrays (Dadurch werden automatisch die Count Variablen angepasst:
        /*
         * adminList
         * sbList
         * konList
         * sfList
         * sftList
         * admins[]
         * kontrolleure[]
         * sachbearbeiter[]
         * schwarzfahrer[]
         * schwarzfahrten[]
         * */


        if (adminDir.exists()){
            System.out.println(adminPath.toString() + " existiert.");
            if (adminDir.listFiles().length != 0){
                firstUsage = false;
                AdminFileListe.clear();
                for (int i = 0; i < adminDir.listFiles().length; i++){
                    Collections.addAll(AdminFileListe, adminDir.listFiles()[i]);
                }
                admins = adminDir.listFiles();
            } else{
                System.out.println("AdminDir Is Empty.");
                firstUsage = true;
            }
        }
        if (sbDir.exists()) {
            System.out.println(sbPath.toString() + " existiert.");
            if (sbDir.listFiles().length != 0) {
                SachbearbeiterFileListe.clear();
                for (int i = 0; i < sbDir.listFiles().length; i++){
                    Collections.addAll(SachbearbeiterFileListe, sbDir.listFiles()[i]);
                }
                sachbearbeiter = sbDir.listFiles();
            } else {
                System.out.println("SBDir Is Empty.");
            }
        }
        if (konDir.exists()) {
            KontrolleurFileListe.clear();
            System.out.println(konPath.toString() + " existiert.");
            if (konDir.listFiles().length != 0){
                for (int i = 0; i < konDir.listFiles().length; i++){
                    Collections.addAll(KontrolleurFileListe, konDir.listFiles()[i]);
                }
                kontrolleure = konDir.listFiles();

            }else{
                System.out.println("KonDir Is Empty.");
            }
        }
        if (sfDir.exists()){
            SchwarzfahrerFileListe.clear();
            System.out.println(sfPath.toString() + " existiert.");
            if (sfDir.listFiles().length != 0){
                for (int i = 0; i < sfDir.listFiles().length; i++){
                    Collections.addAll(SchwarzfahrerFileListe, sfDir.listFiles()[i]);
                }
                schwarzfahrer = sfDir.listFiles();
            } else {
                System.out.println("SFDir Is Empty.");
            }
        }
        fillSftList();
        refreshStats(); //aktualisiert count Variablen adminCount/sbCount/konCount/sfCount/sftCount/userCount
        System.out.println("Filled adminList with " + adminCount + " Files.");
        System.out.println("Filled sbList with " + sbCount + " Files.");
        System.out.println("Filled konList with " + konCount + " Files.");
        System.out.println("Filled sfList with " + sfCount + " Files.");
        System.out.println("Filled sftList with " + sftCount + " Files.");
        System.out.println("User in Total: " + userCount);
    }

    public static void fillSfList(){
        SchwarzfahrerListe.clear();
        int x = SchwarzfahrerFileListe.size();
        for (int i = 0; i < x; i++){
            try {
                SchwarzfahrerListe.add((Schwarzfahrer) PersFile.laden(SchwarzfahrerFileListe.get(i)));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
    public static void fillSftList(){
        SchwarzfahrtenListe.clear();
        fillSfList();
        int x = SchwarzfahrerListe.size();
        Schwarzfahrer s;

        for (int i = 0; i < x; i++){
            s  = SchwarzfahrerListe.get(i);
            for (int j = 0; j < s.sftList.size(); j++){
                SchwarzfahrtenListe.add(s.sftList.get(j));
                System.out.println("Alle Schwarzfahrten von " + s.getVorname() + " der SchwarzfahrtenListe hinzugefügt.");
            }
        }
    }

    public static boolean userExistiertBereits(String eingabe){
        if (AdminFileListe.contains(Path.of(adminPath + fileSeperator + eingabe + ".mb").toFile()) ||
                SachbearbeiterFileListe.contains(Path.of(sbPath + fileSeperator + eingabe + ".mb").toFile()) ||
                KontrolleurFileListe.contains(Path.of(konPath + fileSeperator + eingabe + ".mb").toFile())){
            return true;
        }else {
            return false;
        }
    }
    public static boolean sfIstBekannt(String ausweisnummer){
        getDirectoryData();
        if (SchwarzfahrerFileListe.contains(Path.of(sfPath + fileSeperator + ausweisnummer + ".sf").toFile())){
            return true;
        }else{
            return false;
        }
    }

    public static boolean isAngemeldet() {
        return angemeldet;
    }

    public static void setAngemeldet(boolean angemeldet) {
        Foo.angemeldet = angemeldet;
    }

    public static void saveAngemeldetBleiben(boolean angemeldetBleiben) throws IOException {
        if (angemeldetBleiben){
            angemeldetBleiben = true;
            System.out.println("Angemeldet bleiben auf true.");
            savedUser userToSave;
            if (currentKontrolleur!=null){
                userToSave = new savedUser(currentKontrolleur, true);
                userToSave.saveStatus(loggedINFile);
            } else if (currentAdmin!=null) {
                userToSave = new savedUser(currentAdmin, true);
                userToSave.saveStatus(loggedINFile);
            } else if (currentSachbearbeiter!=null) {
                userToSave = new savedUser(currentSachbearbeiter, true);
                userToSave.saveStatus(loggedINFile);
            }else{
                System.out.println("Fehler");
            }

        }else{
            angemeldetBleiben = false;
            savedUser userToSave = new savedUser(false);
            userToSave.saveStatus(loggedINFile);
            System.out.println("Angemeldet bleiben auf false.");
        }

    }
    public boolean getAngemeldetBleiben() throws IOException, ClassNotFoundException {
        if (!loggedINFile.exists()){
            return false;
        }
        savedUser userToGet;
        userToGet = (savedUser) PersFile.laden(loggedINFile);
        if(userToGet.isAdmin()){
            currentAdmin = userToGet.currentAdmin;
            return userToGet.angemeldetBleiben;
        } else if (userToGet.isKontrolleur()) {
            currentKontrolleur = userToGet.currentKon;
            return userToGet.angemeldetBleiben;
        } else if (userToGet.isSachbearbeiter()) {
            currentSachbearbeiter = userToGet.currentSb;
            return userToGet.angemeldetBleiben;
        }else{
            return userToGet.angemeldetBleiben;
        }

    }

    public static String getCurrentDate(){
        final int DATE_YEAR = java.util.Calendar.getInstance().get(Calendar.YEAR);
        final int DATE_MONTH = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        final int DATE_DAY = java.util.Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        java.text.SimpleDateFormat Simple_Date_Format = new java.text.SimpleDateFormat(
                "dd-MM-yyyy");
        java.util.Calendar Calendar = java.util.Calendar.getInstance();
        Calendar.set(DATE_YEAR, DATE_MONTH, DATE_DAY);
        return Simple_Date_Format.format(Calendar.getTime());
    }
    public static String getCurrentTime(){
        return String.valueOf(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)).concat(":").concat(String.valueOf(java.util.Calendar.getInstance().get(Calendar.MINUTE)));
    }



    public static void okWindow(String message){
        String[] option = {"OK"};
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel(message);
         lbl.setBorder(new EmptyBorder(0, 20, 0, 79));
        panel.add(lbl);
        int selectedOption = JOptionPane.showOptionDialog(null, panel,
                "Bestätigung", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, new ImageIcon("src/icons/bild_hilfe.png"), option , option[0]);

    }
    public static void deleteDirs(){ //Methode, damit ich die firstRegistration testen kann
        if(adminDir.list() == null || adminDir.list().length == 0){
            adminDir.delete();
            sbDir.delete();
            konDir.delete();
            sfDir.delete();
            userDir.delete();
            System.out.println("Directories gelöscht");
        }
    }
}

