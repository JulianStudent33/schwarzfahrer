package src.roles;

import src.Foo;
import src.PersFile;

import java.io.File;
import java.io.IOException;

public abstract class Mitarbeiter extends Person{


    /* Attribute:
    String name;
    String vorname;
    String geschlecht;
    String geburtsdatum;
    String telefonnummer;
    String email;
    * */
    String mitarbeiternummer;
    String benutzername;
    String passwort;

    String autoLogout;
    boolean isAdmin;
    boolean isKontrolleur;
    boolean isSachbearbeiter;
    File userFile;

    //Methoden
    public void setBenutzername(String oldBenutzername, String newBenutzername){
        this.benutzername = newBenutzername;
    }
    public void setPasswort(String oldPW, String newPW){

    }

    public void createUserFile() throws IOException {
        PersFile.speichern(this, this.userFile);
        System.out.println("File geschrieben");
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
            System.out.println(getVorname() + "Ist Administrator");
        } else if (isKontrolleur) {
            System.out.println(getVorname() + "Ist Kontrolleur");
        } else if (isSachbearbeiter) {
            System.out.println(getVorname() + "Ist Sachbearbeiter");
        }
    }


    //Getter und setter
    public String getMitarbeiternummer(){
        System.out.println(this.mitarbeiternummer);
        return this.mitarbeiternummer;
    }

    public String getAutoLogout() {
        return autoLogout;
    }

    public void setAutoLogout(String autoLogout) throws IOException {
        this.autoLogout = autoLogout;
        PersFile.speichern(this, this.userFile);
        Foo.autoLogoutTime = autoLogout;
    }

    public void setMitarbeiternummer(String mitarbeiternummer) throws IOException {
        this.mitarbeiternummer = mitarbeiternummer;
        PersFile.speichern(this, this.userFile);
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) throws IOException {
        this.benutzername = benutzername;
        PersFile.speichern(this, this.userFile);
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) throws IOException {
        this.passwort = passwort;
        PersFile.speichern(this, this.userFile);

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
