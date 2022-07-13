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

    public Kontrolleur(String benutzername, String passwort, String vorname, String nachname, String namenszusatz, String geschlecht, String telefonnummer, String email) throws IOException {
        this.isKontrolleur = true;
        this.mitarbeiternummer = "K" + Foo.konCount++;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.vorname = vorname;
        this.name = nachname;
        if(namenszusatz==null){
            this.namenszusatz = "";
        }else{
            this.namenszusatz = namenszusatz;
        }
        this.geschlecht = geschlecht;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.userFile = Path.of
                (Foo.konPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        display();
        createUserFile();
        System.out.println("Kontrolleur erstellt.");
    }

    public void schwarzfahrtErfassen(){

    }
    public void schwarzfahrerSuchen(){

    }

}
