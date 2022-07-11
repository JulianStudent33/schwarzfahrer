package src;

public class Adresse {
   String Land;
   String PLZ;
   String Ort;
   String Strasse;
   String Hausnummer;
   String Zusatz;

    public Adresse(String land, String plz, String ort, String strasse, String hausnummer, String zusatz) {
        Land = land;
        PLZ = plz;
        Ort = ort;
        Strasse = strasse;
        Hausnummer = hausnummer;
        Zusatz = zusatz;
    }
}
