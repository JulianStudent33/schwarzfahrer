package src.Rollen;

import src.Foo;

import java.io.IOException;
import java.nio.file.Path;

import static src.Foo.*;

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

    public Sachbearbeiter(String benutzername, String passwort, String vorname, String nachname, String geschlecht, String telefonnummer, String email, int[] date) throws IOException {
        Foo.sbCount+=1;
        this.isSachbearbeiter = true;
        this.mitarbeiternummer = "S" + Foo.sbCount;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.geburtsdatum = numberToDate(date[0], date[1], date[2]);
        this.autoLogout = "Aus";
        this.userFile = Path.of
                (Foo.sbPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        display();
        createUserFile();
        System.out.println("SB erstellt.");
    }


}
