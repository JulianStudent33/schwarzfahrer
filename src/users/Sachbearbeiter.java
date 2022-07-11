package src.users;

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
        this.mitarbeiternummer = "S" + Foo.sbCount+1;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.userFile = Path.of
                (Foo.sbPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        System.out.println(this.benutzername);
        createUserFile();
        System.out.println("Created Sachbearbeiter mit Benutzername " + benutzername + " und mitarbeiternummer " + mitarbeiternummer);
        System.out.println("Gespeichert: " + this.userFile);
    }


}
