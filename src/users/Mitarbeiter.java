package src.users;

import src.PersFile;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

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
    File userFile;

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
    public boolean login(){
        //Login Window
        boolean correctPW = false;
        try{
        String input = JOptionPane.showInputDialog("Gib dein Passwort ein.");
        if(!input.equals(this.passwort)){
            while (correctPW == false){
                String newInput = JOptionPane.showInputDialog("Falsches Passwort. Nochmal probieren?");
                if(newInput.equals(this.passwort)){
                    correctPW = true;
                }
            }
            return correctPW;
        }else {
            correctPW = true;
            System.out.println("Passwort korrekt.");
            return correctPW;
        }}catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }

    }

    public String getMitarbeiternummer(){
        System.out.println(this.mitarbeiternummer);
        return this.mitarbeiternummer;
    }
    //Getter und setter

    public void setMitarbeiternummer(String mitarbeiternummer) throws IOException {
        this.mitarbeiternummer = mitarbeiternummer;
        PersFile.writeInFile(this, this.userFile);
    }

    public String getBenutzername() {
        return benutzername;
    }

    public void setBenutzername(String benutzername) throws IOException {
        this.benutzername = benutzername;
        PersFile.writeInFile(this, this.userFile);
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) throws IOException {
        this.passwort = passwort;
        PersFile.writeInFile(this, this.userFile);

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
