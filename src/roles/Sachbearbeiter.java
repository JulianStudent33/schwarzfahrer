package src.roles;

import src.Foo;

import java.io.IOException;
import java.nio.file.Path;

public class Sachbearbeiter extends Mitarbeiter{
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

    public Sachbearbeiter(String benutzername, String passwort) throws IOException {
        Foo.sbCount +=1;
        this.isSachbearbeiter = true;
        this.mitarbeiternummer = "S" + Foo.sbCount;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.userFile = Path.of
                (Foo.sbPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        System.out.println(this.benutzername);
        createUserFile();
        System.out.println("Created Sachbearbeiter mit Benutzername " + benutzername + " und mitarbeiternummer " + mitarbeiternummer);
        System.out.println("Gespeichert: " + this.userFile);
    }
    public Sachbearbeiter(String benutzername, String passwort, String vorname, String nachname, String geschlecht, String telefonnummer, String email) throws IOException {
        this.isSachbearbeiter = true;
        this.mitarbeiternummer = "S" + Foo.sbCount++;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.vorname = vorname;
        this.name = nachname;
        this.geschlecht = geschlecht;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.userFile = Path.of
                (Foo.sbPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        display();
        createUserFile();
        System.out.println("Sachbearbeiter erstellt.");
    }


}
