package src.users;

import src.Foo;
import src.PersFile;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public abstract class Mitarbeiter extends Person{


    /* Attribute:
    String name;
    String vorname;
    String namenszusatz;
    String geschlecht;
    String geburtsdatum;
    String telefonnummer;
    String email;
    * */
    String mitarbeiternummer;
    String benutzername;
    String passwort;

    final String[] benutzerTypen = {"Kontrolleur", "Sachbearbeiter", "Administrator"};
    boolean isAdmin;
    boolean isKontrolleur;
    boolean isSachbearbeiter;
    String benutzerTyp;
    File userFile;

    //Methoden
    public void setBenutzername(String oldBenutzername, String newBenutzername){
        this.benutzername = newBenutzername;
    }
    public void setPasswort(String oldBenutzername, String oldPasswort, String newPasswort){
        if(this.benutzername == oldBenutzername && this.passwort == oldPasswort){
            this.passwort = newPasswort;
            System.out.println("New Password set.");
        }else{
            System.out.println("Falsche Credentials.");
        }

    }

    public void createUserFile() throws IOException {
        PersFile.writeInFile(this, this.userFile);
        System.out.println("Hallo test");
    }





    public void display(){
        System.out.println(getVorname() + " " + getName());
        System.out.println("Benutzername: " + getBenutzername() + " (" + getMitarbeiternummer() + ")");
        System.out.println("Geschlecht: " + getGeschlecht());
        System.out.println("Geboren am " + getGeburtsdatum());
        System.out.println("Telefonnummer: " + getTelefonnummer());
        System.out.println("E-Mail: " + getEmail());
        System.out.println("Dateipfad: " + getUserFile().toPath());
        if (isAdmin){
            System.out.println("Ist Administrator");
        } else if (isKontrolleur) {
            System.out.println("Ist Kontrolleur");
        } else if (isSachbearbeiter) {
            System.out.println("Ist Sachbearbeiter");
        }
    }

    public String getMitarbeiternummer(){
        System.out.println(this.mitarbeiternummer);
        return this.mitarbeiternummer;
    }
    //Getter und setter

    public void setMitarbeiternummer(String mitarbeiternummer) throws IOException {
        this.mitarbeiternummer = mitarbeiternummer;
        PersFile.writeInFile(this, this.userFile);
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) throws IOException {
        this.benutzername = benutzername;
        PersFile.writeInFile(this, this.userFile);
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) throws IOException {
        this.passwort = passwort;
        PersFile.writeInFile(this, this.userFile);

    }

    public String[] getBenutzerTypen() {
        return benutzerTypen;
    }

    public String getBenutzerTyp() {
        return benutzerTyp;
    }

    public void setBenutzerTyp(String benutzerTyp) {
        this.benutzerTyp = benutzerTyp;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isKontrolleur() {
        return isKontrolleur;
    }

    public void setKontrolleur(boolean kontrolleur) {
        isKontrolleur = kontrolleur;
    }

    public boolean isSachbearbeiter() {
        return isSachbearbeiter;
    }

    public void setSachbearbeiter(boolean sachbearbeiter) {
        isSachbearbeiter = sachbearbeiter;
    }

    public File getUserFile() {
        return userFile;
    }

    public void setUserFile(File userFile) {
        this.userFile = userFile;
    }

    public void abmelden(){
        if(this.isAdmin){
            Foo.currentAdmin = null;
            System.out.println("Admin ausgeloggt.");
        }else if(this.isKontrolleur){
            Foo.currentKontrolleur = null;
            System.out.println("Kontrolleur ausgeloggt.");
        } else if (this.isSachbearbeiter) {
            Foo.currentSachbearbeiter = null;
            System.out.println("Sachbearbeiter ausgeloggt");
        }
        Foo.setAngemeldet(false);
        try {
            Foo.saveAngemeldetBleiben(false);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
