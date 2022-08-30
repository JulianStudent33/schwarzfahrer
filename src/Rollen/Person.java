package src.Rollen;

import java.io.IOException;
import java.io.Serializable;

public abstract class Person implements Serializable {
    //Attribute
    String nachname;
    String vorname;
    String geschlecht;

    String geburtsdatum;
    int geburtsTag;
    int geburtsMonat;
    int geburtsJahr;
    String telefonnummer;
    String email;

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }


    public String getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(String geschlecht) {
        this.geschlecht = geschlecht;
    }


    public String getGeburtsdatum() {

        return this.geburtsdatum;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }


    public int getGeburtsTag() {
        return geburtsTag;
    }

    public void setGeburtsTag(int geburtsTag) {
        this.geburtsTag = geburtsTag;
    }

    public int getGeburtsMonat() {
        return geburtsMonat;
    }

    public void setGeburtsMonat(int geburtsMonat) {
        this.geburtsMonat = geburtsMonat;
    }

    public int getGeburtsJahr() {
        return geburtsJahr;
    }

    public void setGeburtsJahr(int geburtsJahr) {
        this.geburtsJahr = geburtsJahr;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws IOException {
        this.email = email;
    }
}
