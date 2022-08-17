package src.roles;

import src.Foo;

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
    public Administrator(String benutzername, String passwort, String vorname, String nachname, String geschlecht, String telefonnummer, String email) throws IOException {
        Foo.adminCount +=1;
        this.isAdmin = true;
        this.mitarbeiternummer = "A" + Foo.adminCount;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.vorname = vorname;
        this.name = nachname;
        this.geschlecht = geschlecht;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.userFile = Path.of
                (Foo.adminPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        display();
        createUserFile();
        System.out.println("Administrator erstellt.");
    }
    public Administrator(String benutzername, String passwort) throws IOException {
        Foo.adminCount +=1;
        this.isAdmin = true;
        this.mitarbeiternummer = "A" + Foo.adminCount;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.userFile = Path.of
                (Foo.adminPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        System.out.println(this.benutzername);
        createUserFile();
        System.out.println("Created Admin mit Benutzername " + benutzername + " und mitarbeiternummer " + mitarbeiternummer);
    }

        private void benutzerSuchen(){

        }
        private void benutzerBearbeiten(){

        }

        private void benutzerAnlegen(){
            //Dokumente\Screenshots Handbuch\benutzer_erstellen_maske.jpeg
            

        }

        private void benutzerLoeschen(){

        }




}
