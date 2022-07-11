package src.users;

import src.Foo;

import java.io.IOException;
import java.nio.file.Path;

public class Kontrolleur extends Mitarbeiter{
     /* Attribute:
    String name;
    String vorname;
    String namenszusatz;
    String geschlecht;
    String telefonnummer;
    String email;
    int mitarbeiternummer;
    String benutzername;
    String passwort;
    * */

    //Konstruktoren

    public Kontrolleur(String benutzername, String passwort) throws IOException {
        this.mitarbeiternummer = "K" + Foo.konCount+1;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.userFile = Path.of
                (Foo.konPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        System.out.println(this.benutzername);
        createUserFile();
        System.out.println("Created Kontrolleur mit Benutzername " + benutzername + " und mitarbeiternummer " + mitarbeiternummer);
        System.out.println("Gespeichert: " + this.userFile);
    }
}
