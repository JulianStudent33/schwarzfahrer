package src;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import src.GUI.*;
import src.GUI.Admin.AdminGUI;
import src.GUI.Kon.KontrolleurGUI;
import src.GUI.Sachbearbeiter.SachbearbeiterGUI;
import src.roles.*;
import static src.GUI.GUI_Mama.*;

import javax.swing.*;
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
    //File Struktur:
    /*Users/Admin/ ... .user PersFiles
     * Users/Kontrolleur/ ... .user PersFiles
     * Users/Sachbearbeiter/ ... .user PersFiles
     * /Schwarzfahrer/ ... .rider
     * /Schwarzfahrten ... .
     * */
    public static FileSystem fs = FileSystems.getDefault();
    public static final String fileSeperator = fs.getSeparator();

        public static Path savesPath = Paths.get("Saves");
        public static Path userPath = Paths.get("Saves" + fileSeperator + "Users");
        public static Path adminPath = Paths.get("Saves" + fileSeperator + "Users" + fileSeperator + "Admin");
        public static Path sbPath = Paths.get("Saves" + fileSeperator + "Users" + fileSeperator + "Sachbearbeiter");
        public static Path konPath = Paths.get("Saves" + fileSeperator + "Users" + fileSeperator + "Kontrolleur");
        public static Path sfPath = Paths.get("Saves" + fileSeperator + "Schwarzfahrer");
        public static Path loginPath = Paths.get("Saves" + fileSeperator + "loggedIN.save");
        public static Path deleteFilePath = Path.of(savesPath + fileSeperator + "deleteFile.save");
        public static Path colorChangePath = Path.of(savesPath + fileSeperator + "colorChange.save");

        public static File savesDir = savesPath.toFile();
        public static File userDir = userPath.toFile();
        public static File adminDir = adminPath.toFile();
        public static File sbDir = sbPath.toFile();
        public static File konDir = konPath.toFile();
        public static File sfDir = sfPath.toFile();
        public static File loggedINFile = loginPath.toFile();
        public static File deleteFileFile = deleteFilePath.toFile();
        public static File colorChangeFile = colorChangePath.toFile();



    public static String currentDate;
    public static String currentTime;

    //Array File Variablen für Profile (Noch als Liste (Array alternative für einfache Suche) zu implementieren)
    public static List<File> AdminFileListe = new ArrayList<File>();
    public static List<File> SachbearbeiterFileListe = new ArrayList<File>();

    public static List<File> KontrolleurFileListe = new ArrayList<File>();
    public static File[] schwarzfahrer;
    public static List<File> SchwarzfahrerFileListe = new ArrayList<File>();
    public static List<Schwarzfahrer> SchwarzfahrerListe = new ArrayList<Schwarzfahrer>();
    public static List<Schwarzfahrt> SchwarzfahrtenListe = new ArrayList<Schwarzfahrt>();

    //Count Variablen (Noch Als Liste<int> zu implementieren)


    public static int adminCount;
    public static int konCount;
    public static int sbCount;
    public static int userCount;
    public static int sfCount;
    public static int sftCount;
    public static boolean angemeldet = false;
    public static boolean angemeldetBleiben;
    public static boolean colorChange = false;
    public static String autoLogoutTime = "Aus";

    public static Mitarbeiter currentUser;


    public static boolean firstUsage;



    //Schriftart
    public static Font fontLargeLarge = new Font("IBM Plex Mono Medium", Font.BOLD, 38);
    public static Font fontLarge = new Font("IBM Plex Mono Medium", Font.BOLD, 28);
    public static Font fontMediumMedium = new Font ("IBM Plex Mono Medium", Font.BOLD, 25);
    public static Font fontMedium = new Font("IBM Plex Mono Medium", Font.BOLD, 20);
    public static Font fontSmall = new Font("IBM Plex Mono Medium", Font.BOLD, 15);
    public static Font fontSmallPlain = new Font("IBM Plex Mono Medium", Font.PLAIN, 15);
    public static Font fontSmallSmall = new Font("IBM Plex Mono Medium", Font.BOLD, 10);

    //Konstruktoren

    public Foo() throws IOException, ClassNotFoundException {
        //Programmstart
        System.out.println("Starting Application");
        checkForDeleteRequest(); /////////////////////////Check zuerst, ob während der letzten Session Mitarbeiter gelöscht wurden, falls ja werden die Files gelöscht
        getDirectoryData();///////////////////////////////Überprüfe, ob die Verzeichnisse existieren und falls ja, werden die Anzahl der Mitarbeiter, Schwarzfahrer, Schwarzfahrten etc. in statischen count-Variablen gespeichert

        //////////////////////////////////////////////////Durch getDirectoryData wurde auch überprüft, ob die Anwendung zum ersten mal gestartet wird (firstUsage = true/false)
        if (firstUsage){
            createDirectories();//////////////////////////Bei erstmaliger Benutzung wird die Verzeichnis-Struktur erstellt
        }
        angemeldetBleiben = getAngemeldetBleiben();///////Überprüfe, ob in der "loggedIN.save"-file ein Benutzer liegt, der dann gleich ins Menü weitergeleitet wird
        setAngemeldet(angemeldetBleiben);


        currentDate = getCurrentDate();///////////////////Datum holen
        currentTime = getCurrentTime();///////////////////Zeit holen
        getColorChange();/////////////////////////////////True (whitemode) und false (darkmode) aus der File "colorChange.save" deserialisiert
        colormode(colorChange);///////////////////////////Anwendung auf das gesamte GUI-Styling
        System.out.println(currentDate);





        if(!angemeldet){
            StartfensterGUI.openStartFenster(null);///////////////////Ist kein Benutzer vorangemeldet, wird das Startfenster geöffnet
        } else if (Foo.currentUser!=null) {
            autoLogoutTime = getCurrentLogoutTime();
            System.out.println("AutoLogout: " + getCurrentLogoutTime());
            if (currentUser.isAdmin()){
                AdminGUI.openAdminGUI(null);//////////////////////////Wenn ein Admin bereits angemeldet ist, wird dieser in sein Hauptmenü (AdminGUI) weitergeleitet
            } else if (Foo.currentUser.isKontrolleur()) {
                KontrolleurGUI.openKonGUI(null);//////////////////////---------Kontrolleur-------------------------------------------------(KontrolleurGUI)---------
            } else if (Foo.currentUser.isSachbearbeiter()) {
                SachbearbeiterGUI.openSBGUI(null);////////////////////---------Sachbearbeiter----------------------------------------------(SachbearbeiterGUI)------
            }
        }
    }
    private static void createDirectories(){
        /** Erstellen aller Directories bei erstmaliger Nutzung
        * Bedingung: firstUsage = true
        * Uses:
        *  savesPath = "Saves"
        *  userPath = "Saves/Users"
        *  adminPath = "Saves/Users/Admin"
        *  sbPath = "Saves/Users/Sachbearbeiter"
        *  konPath = "Saves/Users/Kontrolleur"
        *  sfPath = "Saves/Schwarzfahrer"
        *  colorChangePath = "Saves/fileSeperator/colorChange.save"
        * */

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
        try {
            if (colorChangeFile.createNewFile()){
                System.out.println("Created colorChangeFile succesfully.");
                PersFile.speichern(colorChange, colorChangeFile);
            }else{
                System.out.println("Did not create colorChangeFile.");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


    }
    public static void refreshStats(){
        /** Aktualisiert alle Count Variablen */
        adminCount = AdminFileListe.size();
        konCount = KontrolleurFileListe.size();
        sbCount = SachbearbeiterFileListe.size();
        userCount = adminCount+konCount+sbCount;
        sfCount = SchwarzfahrerFileListe.size();
        sftCount = SchwarzfahrtenListe.size();
    }
    public static void getDirectoryData(){
        /** Check ob Verzeichnisse existieren und befüll Arraylists and FileArrays;
         * Am Ende durch refreshStats anhand der neuen Listen die Variablen befüllen
         * AdminFileListe
         * SachbearbeiterFileListe
         * KontrolleurFileListe
         * SchwarzfahrerFileListe
         * */

        if (adminDir.exists()){
            System.out.println(adminPath.toString() + " existiert.");
            if (adminDir.listFiles().length != 0){
                firstUsage = false;///////////////////////////////////////////////////Wenn mindestens ein Admin im System hinterlegt ist, wird firstUsage auf false gesetzt.
                AdminFileListe.clear();
                for (int i = 0; i < adminDir.listFiles().length; i++){
                    Collections.addAll(AdminFileListe, adminDir.listFiles()[i]);//////Für jede Datei im admin-Directory wird die statische AdminFileListe mit den File-Objekten befüllt.
                }
            } else{
                System.out.println("AdminDir ist Empty.");
                firstUsage = true;////////////////////////////////////////////////////FirstUsage wird auf true gesetzt, da ein Admin vorliegen muss.
            }
        }else{
            System.out.println("Erste Benutzung");
            firstUsage = true; ///////////////////////////////////////////////////////FirstUsage wird auf true gesetzt, da ein Admin vorliegen muss.
        }
        if (sbDir.exists()) {
            System.out.println(sbPath.toString() + " existiert.");
            if (sbDir.listFiles().length != 0) {
                SachbearbeiterFileListe.clear();
                for (int i = 0; i < sbDir.listFiles().length; i++){
                    Collections.addAll(SachbearbeiterFileListe, sbDir.listFiles()[i]);//Befüllen der SachbearbeiterFileListe
                }
            } else {
                System.out.println("SBDir Is Empty.");
            }
        }
        if (konDir.exists()) {
            KontrolleurFileListe.clear();
            System.out.println(konPath.toString() + " existiert.");
            if (konDir.listFiles().length != 0){
                for (int i = 0; i < konDir.listFiles().length; i++){
                    Collections.addAll(KontrolleurFileListe, konDir.listFiles()[i]);////Befüllen der KontrolleurFileListe
                }
            }else{
                System.out.println("KonDir Is Empty.");
            }
        }
        if (sfDir.exists()){
            SchwarzfahrerFileListe.clear();
            System.out.println(sfPath.toString() + " existiert.");
            if (sfDir.listFiles().length != 0){
                for (int i = 0; i < sfDir.listFiles().length; i++){
                    Collections.addAll(SchwarzfahrerFileListe, sfDir.listFiles()[i]);///Befüllen der SchwarzfahrerFileListe
                }
                schwarzfahrer = sfDir.listFiles();
            } else {
                System.out.println("SFDir Is Empty.");
            }
        }
        fillSftList(); /////////////////////////////////////////////////////////Dadurch, dass alle Schwarzfahrer ausgelesen wurden, können jetzt die Schwarzfahrten ausgelesen werden
        refreshStats(); ////////////////////////////////////////////////////////Aktualisiert count Variablen adminCount/sbCount/konCount/sfCount/sftCount/userCount
        System.out.println("Filled adminList with " + adminCount + " Files.");
        System.out.println("Filled sbList with " + sbCount + " Files.");
        System.out.println("Filled konList with " + konCount + " Files.");
        System.out.println("Filled sfList with " + sfCount + " Files.");
        System.out.println("Filled sftList with " + sftCount + " Files.");
        System.out.println("User in Total: " + userCount);
    }
    public static void fillSfList(){
        /** Für jede Datei in SchwarzfahrerFileListe wird das Schwarzfahrerobjekt deserialisiert
        und in die SchwarzfahrerListe vom Klassentyp "Schwarzfahrer hinzugefügt"
        *
        * */
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
        /** Für jedes Schwarzfahrer-Objekt in SchwarzfahrerListe wird aus der SchwarzfahrtenListe des Schwarzfahrers jede Schwarzfahrt in
        die statische SchwarzfahrtenListe in Foo hinzugefügt
        * */
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
        /** Check, ob Eine der drei Listen den als String-Parameter übergebenen Benutzer enthält
        *  return true falls ja, false falls nein
        * */
        if (AdminFileListe.contains(Path.of(adminPath + fileSeperator + eingabe + ".mb").toFile()) ||
                SachbearbeiterFileListe.contains(Path.of(sbPath + fileSeperator + eingabe + ".mb").toFile()) ||
                KontrolleurFileListe.contains(Path.of(konPath + fileSeperator + eingabe + ".mb").toFile())){
            return true;
        }else {
            return false;
        }
    }
    public static void setAngemeldet(boolean angemeldet) {
        //Set angemeldet
        Foo.angemeldet = angemeldet;
    }
    public static void saveAngemeldetBleiben(boolean angemeldetBleiben) throws IOException {
        /* Als Parameter wird übergeben, ob der Benutzer angemeldet bleiben möchte oder nicht.
        *  Der Boolean wird dem currentUser übergeben - danach wird CurrentUser in der LoggedInFile.save Datei gespeichert
        * */

        currentUser.setAngemeldetBleiben(angemeldetBleiben);
        Mitarbeiter userToSave = currentUser;
        userToSave.setUserFile(loggedINFile);
        Foo.angemeldetBleiben = angemeldetBleiben;
        PersFile.speichern(userToSave, userToSave.loggedInFile);
        System.out.println("Angemeldet bleiben auf " + angemeldetBleiben);
    }
    public static boolean getAngemeldetBleiben() throws IOException, ClassNotFoundException {
        /** Liest den User in der LoggedInFile aus und checkt, ob dieser angemeldet bleiben wollte
        * Falls ja, wird der currentUser mit diesem userToGet befüllt
        * Falls nein bleibt der currentUser vorerst leer
        * */

        if (!loggedINFile.exists()){
            return false;
        }
        Mitarbeiter userToGet;
        userToGet = (Mitarbeiter) PersFile.laden(loggedINFile);
        if (userToGet.angemeldetBleiben){
            Foo.currentUser = userToGet;
            return true;
        }else {
            Foo.currentUser = null;
            loggedINFile.delete();
            return false;
        }
    }

    public void checkForDeleteRequest() throws IOException, ClassNotFoundException {
        /** Methode zum Auslesen der zu löschenden Mitarbeiter aus der deleteFile Datei
         *
         */

        if (deleteFileFile.exists()) {
            ArrayList<File> filesToDelete = (ArrayList<File>) PersFile.laden(deleteFileFile);
            boolean deletedSomething = false;
            int deletedAccs = 0;
            for (int i = 0; i < filesToDelete.size(); i++) {
                if (filesToDelete.get(i).delete()) {
                    deletedAccs++;
                    deletedSomething = true;
                    System.out.println("Deleted UserFile succesfully");
                     }
            }
            if (deletedSomething){
                okWindow("Mitarbeiter wurde(n) erfolgreich aus dem System gelöscht (" + deletedAccs + "/" + filesToDelete.size() + ")", null);

            }

        }
          }
    public static String getCurrentDate(){
        /** Java.util liefert das jetzige Datum und formatiert es
         *  Wird als String zurückgegeben
         * */

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
    public static String numbertodate(int day, int month,int year){
       /** String datestring = String.valueOf(number);
        String daymonth = datestring.substring(0, datestring.length() / 2);  // gives 2606
        String year = datestring.substring(datestring.length() / 2);     //gives 2003
        String day = daymonth.substring(0,daymonth.length() / 2);
        String month = daymonth.substring(daymonth.length() / 2);*/

        String ges = day+"-"+ month+"-" + year;
        System.out.println(ges);

        return ges;
    }
    public static int[] datetonumber(String date){

        String[] parts = date.split("-");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];

        int day = Integer.parseInt(String.valueOf(part1));
        int month = Integer.parseInt(String.valueOf(part2));
        int year = Integer.parseInt(String.valueOf(part3));

        int[] array = new int[3];
        array[0] = day;
        array[1] = month;
        array[2] = year;

        // Im array returnen -> in 3 werten (ints)

        //Zum ausgeben testweise (kann dann auskommentiert werden.)
        for (int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }

        return array;
    }
    public static String getCurrentLogoutTime(){
        /** liefert einen String der mitteilt, wann der currentUser automatisch ausgeloggt werden möchte
        *
        * */
        String s = autoLogoutTime;
        autoLogoutTime = currentUser.getAutoLogout();
        return s;
    }
    public static void getColorChange() throws IOException, ClassNotFoundException {
        /** Liest den boolean aus der colorChangeFile aus und setzt dementsprechend das Farbdesign der GUIs
         *  True = Whitemode
         *  False = Darkmode
         * */

        boolean colorc = (boolean) PersFile.laden(colorChangeFile);
        colorChange = colorc;

        colormode(colorChange);
        if (colorChange) {
            try {
                UIManager.setLookAndFeel(new FlatLightLaf());
                System.out.println("Colormode: bright");
            } catch (UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
                System.out.println("Colormode: dark");
            } catch (UnsupportedLookAndFeelException e) {
                throw new RuntimeException(e);
            }
        }

        UIManager.put("ComboBox.disabledForeground", white);
        UIManager.put("ComboBox.disabledBackground", dark);
        UIManager.put("ComboBox.buttonDisabledArrowColor", dark);
        UIManager.put("ComboBox.buttonArrowColor", notSoDark);
        UIManager.put("ComboBox.buttonBackground", whitebg);
        UIManager.put("ComboBox.buttonHoverArrowColor", notSoDark);
        UIManager.put("ComboBox.buttonPressedArrowColor", white);
        UIManager.put("Component.arrowType", "triangle");
        UIManager.put("ComboBox.popupBackground", white);
        UIManager.put("ComboBox.selectionForeground", dark);
        UIManager.put("ComboBox.selectionBackground", dunkelb);
        UIManager.put("PasswordField.showRevealButton", true);

    }
    public static void setColorChange(boolean change) throws IOException {
        /** Speichert einen boolean in der colorChangeFile, der beim nächsten Start dann ausgelesen wird
         *
         * */
        colorChange = change;
        PersFile.speichern(colorChange, colorChangeFile);
        try {
            getColorChange();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void colormode(boolean colors) {
        /** Vertauscht bei aktiviertem Whitemode die Farben von weiß zu Schwarz und Schwarz zu weiß
         *
         * */
        if (colors) {
            white = new Color(44, 44, 44);
            whitebg = new Color(240,240,240);
            notSoDark = new Color(200, 200, 200);
            dark = new Color(255, 255, 255);
        } else {
            dark = new Color(44, 44, 44);
            whitebg = dark;
            notSoDark = new Color(77, 77, 77);
            white = new Color(255, 255, 255);
        }
    }
    public static void okWindow(String message, GUI_Mama parent){
        /** Einfaches Fenster zum Bestätigen einer Nachricht
         * */
        String[] option = {"OK"};
        JPanel panel = new JPanel();
        JLabel lbl = new JLabel(message);
        panel.add(lbl);
        int selectedOption = JOptionPane.showOptionDialog(parent, panel,
                "", JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, option , option[0]);
    }
}

