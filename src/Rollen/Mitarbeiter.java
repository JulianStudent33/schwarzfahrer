package src.Rollen;

import src.Foo;
import src.PersFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    String autoLogout = "Aus"; //Initialer Wert der in den Einstellungen überschrieben werden kann
    boolean isAdmin;
    boolean isKontrolleur;
    boolean isSachbearbeiter;
    public File userFile;
    public File loggedInFile = Foo.loggedINFile;
    public boolean angemeldetBleiben;


    //Methoden

    public void createUserFile() throws IOException {
        PersFile.speichern(this, this.userFile);
        System.out.println("File geschrieben");
    }
    public void display(){
        System.out.println(getVorname() + " " + getNachname());
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
            System.out.println(getVorname() + "Ist SB");
        }
    }
    public void abmelden(){

        //Debugg
        System.out.println("Telefonnummer this " + this.telefonnummer);
        try {
            Mitarbeiter mb = (Mitarbeiter) PersFile.laden(this.userFile);
            System.out.println("Telefonnummer thisUserFile " + mb.telefonnummer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }



        try {
            Foo.saveAngemeldetBleiben(false);
            Foo.getAngemeldetBleiben();
            Foo.setAngemeldet(false);
            System.out.println("Ausgeloggt");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
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
        System.out.println("Auto Logout gespeichert: " + autoLogout);
    }

    public void setMitarbeiternummer(String mitarbeiternummer) throws IOException {
        this.mitarbeiternummer = mitarbeiternummer;
        PersFile.speichern(this, this.userFile);
    }
    public String getBenutzername() {
        return benutzername;
    }
    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) throws IOException {
        this.passwort = passwort;
        PersFile.speichern(this, this.userFile);
    }

    public void setEmail(String email) throws IOException {
        this.email = email;
        PersFile.speichern(this, this.userFile);
    }
    public void setTelefon(String telefon) throws IOException {
        this.telefonnummer = telefon;
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

    public File getLoggedInFile() {
        return loggedInFile;
    }

    public void setLoggedInFile(File loggedInFile) {
        this.loggedInFile = loggedInFile;
    }

    public boolean isAngemeldetBleiben() {
        return angemeldetBleiben;
    }

    public void setAngemeldetBleiben(boolean angemeldetBleiben) {
        this.angemeldetBleiben = angemeldetBleiben;
    }


}
