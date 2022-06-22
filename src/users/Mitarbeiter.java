package src.users;

import java.io.File;

public abstract class Mitarbeiter extends Person{


    /* Attribute:
    String name;
    String vorname;
    String namenszusatz;
    String geschlecht;
    String telefonnummer;
    String email;
    * */
    String mitarbeiternummer;
    String benutzername;
    String passwort;

    final String[] benutzerTypen = {"Kontrolleur", "Sachbearbeiter", "Administrator"};
    String benutzerTyp;

    //Methoden
    public void setBenutzername(String oldBenutzername, String newBenutzername){
        this.benutzername = newBenutzername;
    }
    public void setPasswort(String oldBenutzername, String oldPasswort, String newPasswort){
        if(this.benutzername == oldBenutzername && this.passwort == oldPasswort){
            this.passwort = newPasswort;
            System.out.println("New Password set.");
        }else{
            System.out.println("Falsche Credentials.");
        }

    }
    public String getMitarbeiternummer(){
        System.out.println(this.mitarbeiternummer);
        return this.mitarbeiternummer;
    }
    //Getter und setter

    public void setMitarbeiternummer(String mitarbeiternummer) {
        this.mitarbeiternummer = mitarbeiternummer;
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) {
        this.benutzername = benutzername;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String[] getBenutzerTypen() {
        return benutzerTypen;
    }

    public String getBenutzerTyp() {
        return benutzerTyp;
    }

    public void setBenutzerTyp(String benutzerTyp) {
        this.benutzerTyp = benutzerTyp;
    }
}
