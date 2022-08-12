package src.roles;

import src.Foo;
import src.GUI.elements.Dateswitcher;
import src.PersFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Kontrolleur extends Mitarbeiter{
     /* Attribute:
    String name;
    String vorname;
    String namenszusatz;
    String geschlecht;
    String telefonnummer;
    String E-Mail;
    String mitarbeiternummer;
    String benutzername;
    String passwort;
    boolean is Kontrolleur;
    File userFile;
    * */

    //Konstruktoren

    public Kontrolleur(String benutzername, String passwort) throws IOException {
        this.isKontrolleur = true;
        this.mitarbeiternummer = "K" + Foo.konCount++;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.userFile = Path.of
                (Foo.konPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        System.out.println(this.benutzername);
        createUserFile();
        System.out.println("Created Kontrolleur mit Benutzername " + benutzername + " und mitarbeiternummer " + mitarbeiternummer);
        System.out.println("Gespeichert: " + this.userFile);
    }

    public Kontrolleur(String benutzername, String passwort, String vorname, String nachname, String geschlecht, String telefonnummer, String email, int[] date) throws IOException {
        this.isKontrolleur = true;
        this.mitarbeiternummer = "K" + Foo.konCount++;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.vorname = vorname;
        this.name = nachname;
        this.geschlecht = geschlecht;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.geburtsdatum = Dateswitcher.numbertodate(date[0], date[1], date[2]);
        this.userFile = Path.of
                (Foo.konPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        display();
        createUserFile();
        System.out.println("Kontrolleur erstellt.");
    }

    public void schwarzfahrtErfassen(){

    }
    public Schwarzfahrer schwarzfahrerSuchen(String ausweisnummer) throws IOException, ClassNotFoundException {
        Foo.getDirectoryData();
        File gesuchtenSF = Path.of(Foo.sfPath + Foo.fileSeperator + ausweisnummer + ".sf").toFile();
        System.out.println(gesuchtenSF.toPath());

        if (Foo.SchwarzfahrerFileListe.contains(gesuchtenSF)){
            Schwarzfahrer gefundenerSF = (Schwarzfahrer) PersFile.laden(gesuchtenSF);
            return gefundenerSF;
        }else{
            System.out.println("Nicht gefunden");
            return null;
        }
    }

}
