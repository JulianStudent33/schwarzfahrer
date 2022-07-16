package src.users;

import src.Adresse;
import src.Schwarzfahrt;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Schwarzfahrer extends Person{
    /* Attribute
    String name;
    String vorname;
    String namenszusatz;
    String geschlecht;
    String telefonnummer;
    String email;
     */
    String ausweisnummer;
    String geburtsort;
    Date Geburtsdatum;
    Adresse adresse;

    public static List<Schwarzfahrt> sftList = new ArrayList<Schwarzfahrt>();

    public Schwarzfahrer(){

    }
}
