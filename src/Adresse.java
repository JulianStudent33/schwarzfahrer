package src;

import java.io.Serializable;

public class Adresse implements Serializable {
    String Land;
    String PLZ;
    String Ort;
    String Strasse;
    String Hausnummer;
    String Zusatz;

    public Adresse(String land, String plz, String ort, String strasse, String hausnummer, String zusatz) {
        this.Land = land;
        this.PLZ = plz;
        this.Ort = ort;
        this.Strasse = strasse;
        this.Hausnummer = hausnummer;
        this.Zusatz = zusatz;
    }

    public String getLand() {
        return Land;
    }

    public void setLand(String land) {
        Land = land;
    }

    public String getPLZ() {
        return PLZ;
    }

    public void setPLZ(String PLZ) {
        this.PLZ = PLZ;
    }

    public String getOrt() {
        return Ort;
    }

    public void setOrt(String ort) {
        Ort = ort;
    }

    public String getStrasse() {
        return Strasse;
    }

    public void setStrasse(String strasse) {
        Strasse = strasse;
    }

    public String getHausnummer() {
        return Hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        Hausnummer = hausnummer;
    }

    public String getZusatz() {
        return Zusatz;
    }

    public void setZusatz(String zusatz) {
        Zusatz = zusatz;
    }
}

