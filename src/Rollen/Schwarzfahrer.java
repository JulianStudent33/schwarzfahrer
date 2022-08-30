package src.Rollen;

import src.Adresse;
import src.Foo;
import src.PersFile;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static src.Foo.*;

public class Schwarzfahrer extends Person{
    /* Attribute
    String name;
    String vorname;
    String geschlecht;
    String geburtsdatum;
    String telefonnummer;
    String email;
     */
    String ausweisnummer;
    String geburtsort;
    Adresse adresse;
    File sfFile;

    public List<Schwarzfahrt> sftList = new ArrayList<Schwarzfahrt>();

    //Konstruktoren

    public Schwarzfahrer(String ausweisnummer, String geburtsort,
                         Adresse adresse, String vorname, String nachname, String geschlecht,
                         String telefonnummer, String email, int day, int month, int year) throws IOException {
        this.ausweisnummer = ausweisnummer;
        this.geburtsort = geburtsort;
        this.geburtsdatum = numberToDate(day, month, year);
        this.adresse = adresse;
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.telefonnummer = telefonnummer;
        this.email = email;
        this.sfFile = Path.of(Foo.sfPath + Foo.fileSeperator + ausweisnummer + ".sf").toFile();

        System.out.println("gespeichert" + this.sfFile);
        display();
        createSfFile();
        System.out.println("Schwarzfahrer Profil erstellt.");
    }

    public static void updateExistingSF(String ausweisnummer, String geburtsort,
                                        Adresse adresse, String vorname, String nachname, String geschlecht,
                                        String telefonnummer, String email, int day, int month, int year, List<Schwarzfahrt> sftListe) throws IOException {

                Schwarzfahrer sf = new Schwarzfahrer(ausweisnummer, geburtsort,
                adresse, vorname, nachname, geschlecht,
                telefonnummer, email, day, month, year);

                sf.sftList = sftListe;
    }


    public void createSfFile() throws IOException {
        PersFile.speichern(this, this.sfFile);
        System.out.println("File geschrieben.");
    }

    public void appendSFT(String date, int hour, int minute, String linie, boolean isBezahlt) throws IOException {
        System.out.println("Elemente in sftList: " + sftList.size());
        Schwarzfahrt sft = new Schwarzfahrt(this, date, hour, minute, linie, isBezahlt);
        sftList.add(sft);
        System.out.println("Elemente in sftList: " + sftList.size());
        PersFile.speichern(this, this.sfFile);
    }

    public void display(){
        System.out.println(getVorname() + " " + getNachname());
        System.out.println("Ausweisnummer: " + getAusweisnummer());
        System.out.println("Geschlecht: " + getGeschlecht());
        System.out.println("Geboren am " + getGeburtsdatum());
        System.out.println("Telefonnummer: " + getTelefonnummer());
        System.out.println("E-Mail: " + getEmail());
        System.out.println("Dateipfad: " + getSfFile().toPath());
        System.out.println("Wohnhaft in " + this.adresse.getStrasse() + " " + this.adresse.getHausnummer() + " " + this.adresse.getZusatz() +  ", " + this.adresse.getPLZ() + " " + this.adresse.getOrt() + " (" + this.adresse.getLand() + ")");
        System.out.println("Erfasste Schwarzfahrten: " + getSftList().size());
        }
    public String getAusweisnummer() {
        return ausweisnummer;
    }

    public void setAusweisnummer(String ausweisnummer) {
        this.ausweisnummer = ausweisnummer;
    }

    public String getGeburtsort() {
        return geburtsort;
    }

    public void setGeburtsort(String geburtsort) {
        this.geburtsort = geburtsort;
    }

    @Override
    public String getGeburtsdatum() {
        return geburtsdatum;
    }


    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public File getSfFile() {
        return sfFile;
    }

    public void setSfFile(File sfFile) {
        this.sfFile = sfFile;
    }

    public List<Schwarzfahrt> getSftList() {
        return sftList;
    }

    public void setSftList(List<Schwarzfahrt> sftList) {
        this.sftList = sftList;
    }
}
