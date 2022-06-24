package src.users;

import src.Foo;
import src.PersFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
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
    public Administrator(String name, String vorname, String namenszusatz, String geschlecht,
                         String telefonnummer, String email, String benutzername, String passwort) throws IOException {
        this.name = name;
        this.vorname = vorname;
        this.namenszusatz = namenszusatz;
        this.geschlecht = geschlecht;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.mitarbeiternummer = "A" + Foo.adminCount+1;
        getMitarbeiternummer();
        this.benutzername = benutzername;
        this.passwort = passwort;
        createAdminFile(benutzername, mitarbeiternummer);
    }
    public Administrator(String benutzername, String passwort) throws IOException {
        this.mitarbeiternummer = "A" + Foo.adminCount+1;
        this.benutzername = benutzername;
        this.passwort = passwort;
        this.userFile = Path.of
                (Foo.adminPath + Foo.fileSeperator + benutzername +  ".mb").toFile();
        System.out.println(this.benutzername);
        createAdminFile(benutzername, mitarbeiternummer);
        System.out.println("Created Admin mit Benutzername " + benutzername + " und mitarbeiternummer " + mitarbeiternummer);
        System.out.println("Gespeichert: " + this.userFile);
    }
        private void createAdminFile(String benutzername, String mitarbeiternummer) throws IOException {

        //PersFile writeAdmin = new PersFile(this.userFile);
        PersFile.writeInFile(this, this.userFile);
        //writeAdmin.writeInFile(this);
            System.out.println("Hallo test");
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
