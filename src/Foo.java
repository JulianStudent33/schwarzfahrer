package src;

import src.GUI.LoginGUI;
import src.GUI.RegisterGUI;
import src.GUI.StartFensterGUI;
import src.GUI.firstRegistrationGUI;
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

    public static int adminCount;
    public static int konCount;
    public static int sbCount;
    public static int userCount;
    public static int sfCount;
    public static int sftCount;
    public static boolean angemeldet = false;

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

    public static File savesDir = savesPath.toFile();
    public static File userDir = userPath.toFile();
    public static File adminDir = adminPath.toFile();
    public static File sbDir = sbPath.toFile();
    public static File konDir = konPath.toFile();
    public static File sfDir = sfPath.toFile();
    public static File sftDir = sftPath.toFile();

    public static boolean firstUsage;
    private static String[] optionsUse = {"Register", "Login"};



    //Konstruktoren

    public Foo() throws IOException, ClassNotFoundException {
        //Programm startet grundsätzlich immer hier
        System.out.println("Starting Application");
        getDirectoryData();
        if(adminList.isEmpty()){
            System.out.println("Erste Benutzung");
            firstUsage = true; //First Usage true gesetzt, weil keine Directories mit Benutzern vorhanden sind,
            createDirectories();
        }else{
         refreshStats();
        }
        /*
        *
        if(savesDir.mkdir()){
            System.out.println("Erste Benutzung");
            firstUsage = true; //First Usage true gesetzt, weil keine Directories mit Benutzern vorhanden sind,
            createDirectories();
        }else{
            //Check ob die unterVerzeichnisse existieren und falls ja ob sie leer sind.
            getDirectoryData();
        }
        *
        * */
        //Login Fenster -> als GUI implementieren
        System.out.println("1 " + firstUsage);
        StartFensterGUI.openStartFenster();
    }


    //StartFensterGUI IMPLEMENTIEREN
    public void startFenster() throws IOException, ClassNotFoundException {
        //Register oder Login

        JOptionPane myOptionPane = new JOptionPane("Select",
                JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION,
                null, optionsUse, optionsUse[0]);
        JDialog registerLoginDialog = myOptionPane.createDialog(null, "Black Rides");
        //Bei der ersten Benutzung gibt es keine "Login"-Option
        //Implementiert ihr im GUI
        if(firstUsage) {
            inactivateOption(registerLoginDialog, optionsUse[1]);
        }
        registerLoginDialog.setModal(true);
        registerLoginDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        registerLoginDialog.setVisible(true);
        Object result = myOptionPane.getValue();

        if(result.equals(optionsUse[0])){
            if(firstUsage){
                firstRegistrationGUI.firstRegister();
            }else{
                RegisterGUI.register();
            }

        }else if (result.equals(optionsUse[1])){
            LoginGUI.openLogin();

        }else if(result == null){
            okWindow();
            System.exit(120);
        }else{
            okWindow();
            System.exit(121);
        }
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
    private static void getDirectoryData(){
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

    private static void inactivateOption(Container container, String text) {
        Component[] comps = container.getComponents();
        for (Component comp : comps) {
            if (comp instanceof AbstractButton) {
                AbstractButton btn = (AbstractButton) comp;
                if (btn.getActionCommand().equals(text)) {
                    btn.setEnabled(false);
                    return;
                }
            } else if (comp instanceof Container) {
                inactivateOption((Container) comp, text);
            }
        }

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

