package src.Rollen;

import src.Foo;
import static src.Foo.*;

import java.io.IOException;
import java.nio.file.Path;

public class Administrator extends Mitarbeiter{
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
    public Administrator(String benutzername, String passwort, String vorname, String nachname, String geschlecht, String telefonnummer, String email, int[] date) throws IOException {
        Foo.adminCount +=1;
        this.isAdmin = true;
        this.mitarbeiternummer = "A" + Foo.adminCount;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.geburtsdatum = numberToDate(date[0], date[1], date[2]);
        this.userFile = Path.of
                (Foo.adminPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        display();
        createUserFile();
        System.out.println("Administrator erstellt.");
    }
}
