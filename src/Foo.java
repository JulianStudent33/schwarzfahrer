package src;

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

    static boolean firstUsage;
    private static String[] optionsUse = {"Register", "Login"};
    //Konstruktoren

    public Foo(){

    }

    public static boolean startFenster() throws IOException, ClassNotFoundException {
        //Check ob File existiert
        System.out.println("Starting Application");
        System.out.println(adminPath);

        if(savesDir.mkdir()){
            System.out.println("Erste Benutzung");
            firstUsage = true; //First Usage true gesetzt, weil keine Directories mit Benutzern vorhanden sind,
            createDirectories();

        }else{
            //Check ob die unterVerzeichnisse existieren und falls ja ob sie leer sind.
            getDirectoryData();
        }
        System.out.println(adminDir.getAbsolutePath());
        System.out.println(adminDir.getCanonicalPath());

        //Register oder Login
        String message1;

        JOptionPane myOptionPane = new JOptionPane("Select",
                JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION,
                null, optionsUse, optionsUse[0]);
        JDialog registerLoginDialog = myOptionPane.createDialog(null, "Black Rides");
        if(firstUsage){
            inactivateOption(registerLoginDialog, optionsUse[1]);
            message1 = "Wähle einen Benutzername für deinen ersten Administrator.";
        }else{
            message1 = "Wähle einen Benutzernamen";
        }
        registerLoginDialog.setModal(true);
        registerLoginDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        registerLoginDialog.setVisible(true);
        Object result = myOptionPane.getValue();

        if(result.equals(optionsUse[0])){
            boolean succesfulRegistration = registrationWindow(registerLoginDialog, message1);
            return succesfulRegistration;
        }else if (result.equals(optionsUse[1])){
            boolean succesfulLogin = loginWindow(registerLoginDialog);
            return succesfulLogin;
        }else if(result == null){
            okWindow();
            boolean pressedLoginOrRegistration = false;
            return pressedLoginOrRegistration;
        }else{
            okWindow();
            boolean pressedLoginOrRegistration = false;
            return pressedLoginOrRegistration;
        }



        // Note: result might be null if the option is cancelled

    }
    private static boolean registrationWindow(JDialog registerDialog, String message1) throws IOException, ClassNotFoundException {
        boolean passwortBestaetigt = false;

        String nameInput = JOptionPane.showInputDialog(message1);
        if (nameInput == null){
            System.out.println("Returning.");
            return false;
        }
        while (userExistiertBereits(nameInput)){
            nameInput = JOptionPane.showInputDialog("Username bereits vergeben.");
        }

        while(!passwortBestaetigt) {
            String pwInput = pass.passwordinput();
            if (pwInput == null){
                System.out.println("Returning");
                return false;
            }

                String pwConfirm = JOptionPane.showInputDialog("Bestätige dein Passwort");
                if (pwConfirm.equals(pwInput)) {
                    JOptionPane.showMessageDialog(registerDialog, "Passwort Bestätigt");//Eventuell ein anderes Parent Component
                    currentAdmin = new Administrator(nameInput, pwInput);
                    passwortBestaetigt = true;

                } else if (pwConfirm == null) {
                    System.out.println("Returning.");
                    return false;
                } else {

                }


        }
        return passwortBestaetigt;
    }
    private static boolean loginWindow(JDialog loginDialog) throws IOException, ClassNotFoundException {

        String input = JOptionPane.showInputDialog(loginDialog, "Gib deinen Benutzernamen ein.");
        if(input==null){
            okWindow();
            return false;
        }
        if (!checkForUsernameExistanceAndLogin(input)){
            boolean userFound = false;
            while(!userFound){
                String newInput = JOptionPane.showInputDialog(loginDialog, "Benutzer nicht gefunden. Nochmal probieren?");
                if (newInput==null){
                    System.out.println("Returning.");
                    return false;
                }
                userFound = checkForUsernameExistanceAndLogin(newInput);
            }
        }
        return true; //wenn der compiler hier landet, dann hat die Username suche und die Passwortabfrage geklappt.
    }





    public static void menu(){
        String options[] = {""};
        JOptionPane myOptionPane = new JOptionPane("Wyd?",
                JOptionPane.QUESTION_MESSAGE, JOptionPane.YES_NO_OPTION, null, options);
        JDialog myDialog = myOptionPane.createDialog(null, "Kontrolleur Hauptmenü");
        myDialog.setModal(true);
        myDialog.setVisible(true);


    }
    private static void createDirectories(){
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
            System.out.println(sbDir.toPath());
            System.out.println("Created sachbearbeiterDir succesfully.");
        }else{
            System.out.println("Did not create sachbearbeiterDir");
        }
        if (konDir.mkdir()){
            System.out.println("Created kontrolleurDir succesfully.");
        }else{
            System.out.println(konDir.toPath());
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
    private static void getDirectoryData(){
        //Check for Existance and fill FileArrays (Dadurch werden automatisch die Count Variablen angepasst:
        /*
         * admins[]
         * kontrolleure[]
         * sachbearbeiter[]
         * schwarzfahrer[]
         * schwarzfahrten[]
         * */
        if (adminDir.exists()){
            System.out.print(adminPath.toString() + " existiert.");
            if (adminDir.listFiles().length != 0){
                for (int i = 0; i < adminDir.listFiles().length; i++){
                    Collections.addAll(adminList, adminDir.listFiles()[i]);
                }
                admins = adminDir.listFiles();
            } else{
                System.out.print(" Is Empty.");
            }
        }
        if (sbDir.exists()) {
            System.out.print(sbPath.toString() + " existiert.");
            if (sbDir.listFiles().length != 0) {
                for (int i = 0; i < sbDir.listFiles().length; i++){
                    Collections.addAll(sbList, sbDir.listFiles()[i]);
                }
                sachbearbeiter = sbDir.listFiles();
            } else {
                System.out.print(" Is Empty.");
            }
        }
        if (konDir.exists()) {
            System.out.println(konPath.toString() + " existiert.");
            if (konDir.listFiles().length != 0){
                for (int i = 0; i < konDir.listFiles().length; i++){
                    Collections.addAll(konList, konDir.listFiles()[i]);
                }
                kontrolleure = konDir.listFiles();

            }else{
                System.out.print(" Is Empty.");
            }
        }
        if (sfDir.exists()){
            System.out.println(sfPath.toString() + " existiert.");
            if (sfDir.listFiles().length != 0){
                for (int i = 0; i < sfDir.listFiles().length; i++){
                    Collections.addAll(sfList, sfDir.listFiles()[i]);
                }
                schwarzfahrer = sfDir.listFiles();
            } else {
                System.out.print(" Is Empty.");
            }
        }
        if (sftDir.exists()){
            System.out.println(sftPath.toString() + " existiert.");
            if (sftDir.listFiles().length != 0){
                for (int i = 0; i < sftDir.listFiles().length; i++){
                    Collections.addAll(sftList, sftDir.listFiles()[i]);
                }
                schwarzfahrten = sftDir.listFiles();

            }else {
                System.out.print(" Is Empty.");
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
    private static boolean userExistiertBereits(String eingabe){
        if (adminList.contains(Path.of(adminPath + fileSeperator + eingabe + ".mb").toFile()) ||
                sbList.contains(Path.of(sbPath + fileSeperator + eingabe + ".mb").toFile()) ||
                konList.contains(Path.of(konPath + fileSeperator + eingabe + ".mb").toFile())){
            return true;
        }else {
            return false;
        }
    }
    private static boolean checkForUsernameExistanceAndLogin(String eingabe) throws IOException, ClassNotFoundException {
        //search Lists for username
        /* FilenameFilter filter = new FilenameFilter() {

            public boolean accept(File f, String name)
            {
                return name.startsWith("Datei1");
            } //--FileName Filter
        };
*/
        if (adminList.contains(Path.of(adminPath + fileSeperator + eingabe + ".mb").toFile())){
            try{
                Administrator ob = (Administrator) PersFile.readOuttaFile(Path.of(adminPath + fileSeperator + eingabe).toFile());
                if(ob.login()){
                    currentAdmin = ob;
                    return true;
                }else{
                    System.out.println("Anmeldung fehlgeschlagen.");
                    return false;
                }
            }catch (Exception e){
                System.err.println(e.getMessage());
            }



        }else if (sbList.contains(Path.of(sbPath + fileSeperator + eingabe + ".mb").toFile())){
            return true;
        } else if (konList.contains(Path.of(konPath + fileSeperator + eingabe + ".mb").toFile())) {
            return true;
        }else {
            return false;
        }
        return false;
    }
    private static String loginInto(){
        String pw;
        return "pw";
    }
    private static boolean checkForPasswortCorectness(String passwort){
        return true;
    }
    private static boolean passwortUeberprüfung(String password){

        return true;
    }

    public static void refreshStats(){


        adminCount = adminList.size();
        konCount = konList.size();
        sbCount = sbList.size();
        userCount = adminCount+konCount+sbCount;
        sfCount = sfList.size();
        sftCount = sftList.size();
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


    //Wird noch gelöscht, brauch ich nur für die struktur
    public static int actionRequest() {
        String[] optionsToChoose = {"Choose...", "Aufnahme eines Giro-/Sparkontos", "Anzeigen der gespeicherten Daten", "Beenden des Programms", "Konto als Datei ausgeben", "Konto aus Datei einlesen"};
        String getAction = (String) JOptionPane.showInputDialog(
                null,
                "What do you want to do?",
                "Action Menue",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsToChoose,
                optionsToChoose[0]);

        switch (getAction) {
            case "Aufnahme eines Giro-/Sparkontos":
                return 1;
            case "Anzeigen der gespeicherten Daten":
                return 2;
            case "Beenden des Programms":
                return 3;
            case "Konto als Datei ausgeben":
                return 4;
            case "Konto aus Datei einlesen":
                return 5;
            default:
                System.out.println("ERROR");
                break;
        }
        return 0;
    }


}

