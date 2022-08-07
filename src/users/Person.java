package src.users;

import javax.swing.text.DateFormatter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;

public abstract class Person implements Serializable {
    //Attribute
    String name;
    String vorname;
    String geschlecht;

    String geburtsdatum;
    String telefonnummer;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String setGeburtsdatum(int Tag, int Monat, int Jahr) {
        LocalDate date = LocalDate.of(Jahr, Monat, Tag);
        String geburtsdatum = Tag + "." + Monat + "." + Jahr;
        // geburtsdatum = date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        System.out.println(geburtsdatum);
        return geburtsdatum;
    }

    public String getGeburtsdatum() {

        return this.geburtsdatum;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
