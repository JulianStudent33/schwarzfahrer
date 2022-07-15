package src;

import src.GUI.*;
import src.GUI.Kontrolleur.KontrolleurGUI;
import src.users.Administrator;
import src.users.Kontrolleur;
import src.users.Sachbearbeiter;
import src.nickcode.pass;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Foo {
    public static FileSystem fs = FileSystems.getDefault();
    public static final String fileSeperator = fs.getSeparator();
    //File Struktur:
    /*Users/Admin/ ... .user PersFiles
     * Users/Kontrolleur/ ... .user PersFiles
     * Users/Sachbearbeiter/ ... .user PersFiles
     * /Schwarzfahrer/ ... .rider
     * /Schwarzfahrten ... .
     * */
    //Array File Variablen für Profile (Noch als Liste (Array alternative für einfache Suche) zu implementieren)
    public static File[] admins;
    public static List<File> adminList = new ArrayList<File>();
    public static File[] sachbearbeiter;
    public static List<File> sbList = new ArrayList<File>();
    public static File[] kontrolleure;
    public static List<File> konList = new ArrayList<File>();
    public static File[] schwarzfahrer;
    public static List<File> sfList = new ArrayList<File>();
    public static File[] schwarzfahrten;
    public static List<File> sftList = new ArrayList<File>();

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
        public static Path sftPath = Paths.get("Saves" + fileSeperator + "Schwarzfahrten");
        public static Path loginPath = Paths.get("Saves" + fileSeperator + "loggedIN.save");

    public static File savesDir = savesPath.toFile();
    public static File userDir = userPath.toFile();
    public static File adminDir = adminPath.toFile();
    public static File sbDir = sbPath.toFile();
    public static File konDir = konPath.toFile();
    public static File sfDir = sfPath.toFile();
    public static File sftDir = sftPath.toFile();
    public static File loggedINFile = loginPath.toFile();
    public static boolean firstUsage;
    private static String[] optionsUse = {"Register", "Login"};



    //Konstruktoren

    public Foo() throws IOException, ClassNotFoundException {
        //Programm startet grundsätzlich immer hier
        System.out.println("Starting Application");
        getDirectoryData();
        if(adminList.isEmpty()){
            System.out.println("Erste Benutzung");
            firstUsage = true; //First Usage true gesetzt, weil keine Admins vorhanden sind,
            createDirectories();
        }else{
         refreshStats();
        }
        angemeldetBleiben = getAngemeldetBleiben();
        setAngemeldet(angemeldetBleiben);

        if(!angemeldet){
            start.startFenster();
        } else if (currentAdmin!=null) {
            AdminGUI.openAdminGUI();
        } else if (currentKontrolleur!=null) {
            KontrolleurGUI.openKonGUI();
        } else if (currentSachbearbeiter!=null) {
            SachbearbeiterGUI.openSBGUI();
        }

    }


    //StartFensterGUI IMPLEMENTIEREN

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
        if (sftDir.mkdir()){
            System.out.println("Created schwarzfahrtenDir succesfully.");
        }else{
            System.out.println("Did not create schwarzfahrtenDir");
        }

    }
    public static void refreshStats(){

        adminCount = adminList.size();
        konCount = konList.size();
        sbCount = sbList.size();
        userCount = adminCount+konCount+sbCount;
        sfCount = sfList.size();
        sftCount = sftList.size();
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
                adminList.clear();
                for (int i = 0; i < adminDir.listFiles().length; i++){
                    Collections.addAll(adminList, adminDir.listFiles()[i]);
                }
                admins = adminDir.listFiles();
            } else{
                System.out.println("AdminDir Is Empty.");
            }
        }
        if (sbDir.exists()) {
            System.out.println(sbPath.toString() + " existiert.");
            if (sbDir.listFiles().length != 0) {
                sbList.clear();
                for (int i = 0; i < sbDir.listFiles().length; i++){
                    Collections.addAll(sbList, sbDir.listFiles()[i]);
                }
                sachbearbeiter = sbDir.listFiles();
            } else {
                System.out.println("SBDir Is Empty.");
            }
        }
        if (konDir.exists()) {
            konList.clear();
            System.out.println(konPath.toString() + " existiert.");
            if (konDir.listFiles().length != 0){
                for (int i = 0; i < konDir.listFiles().length; i++){
                    Collections.addAll(konList, konDir.listFiles()[i]);
                }
                kontrolleure = konDir.listFiles();

            }else{
                System.out.println("KonDir Is Empty.");
            }
        }
        if (sfDir.exists()){
            sfList.clear();
            System.out.println(sfPath.toString() + " existiert.");
            if (sfDir.listFiles().length != 0){
                for (int i = 0; i < sfDir.listFiles().length; i++){
                    Collections.addAll(sfList, sfDir.listFiles()[i]);
                }
                schwarzfahrer = sfDir.listFiles();
            } else {
                System.out.println("SFDir Is Empty.");
            }
        }
        if (sftDir.exists()){
            sftList.clear();
            System.out.println(sftPath.toString() + " existiert.");
            if (sftDir.listFiles().length != 0){
                for (int i = 0; i < sftDir.listFiles().length; i++){
                    Collections.addAll(sftList, sftDir.listFiles()[i]);
                }
                schwarzfahrten = sftDir.listFiles();

            }else {
                System.out.println("SFTDir Is Empty.");
            }
        }
        refreshStats(); //aktualisiert count Variablen adminCount/sbCount/konCount/sfCount/sftCount/userCount
        System.out.println("Filled adminList with " + adminCount + " Files.");
        System.out.println("Filled sbList with " + sbCount + " Files.");
        System.out.println("Filled konList with " + konCount + " Files.");
        System.out.println("Filled sfList with " + sfCount + " Files.");
        System.out.println("Filled sftList with " + sftCount + " Files.");
        System.out.println("User in Total: " + userCount);
    }

    public static boolean userExistiertBereits(String eingabe){
        getDirectoryData();
        if (adminList.contains(Path.of(adminPath + fileSeperator + eingabe + ".mb").toFile()) ||
                sbList.contains(Path.of(sbPath + fileSeperator + eingabe + ".mb").toFile()) ||
                konList.contains(Path.of(konPath + fileSeperator + eingabe + ".mb").toFile())){
            return true;
        }else {
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
        userToGet = (savedUser) PersFile.readOuttaFile(loggedINFile);
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

    public static void okWindow(){
        String[] option = {"OK"};
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel("Vorgang abgebrochen");
        panel.add(lbl);
        int selectedOption = JOptionPane.showOptionDialog(null, panel, "", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option , option[0]);
    }
    public static void deleteDirs(){ //Methode, damit ich die firstRegistration testen kann
        if(adminDir.list() == null || adminDir.list().length == 0){
            adminDir.delete();
            sbDir.delete();
            konDir.delete();
            sfDir.delete();
            sftDir.delete();
            userDir.delete();
            System.out.println("Directories gelöscht");
        }
    }
}

