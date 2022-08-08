package src;

public class Datum {
    int tag;
    int monat;
    int jahr;
    String datum;

    int stunden;
    int minuten;

    String Uhrzeit;


    public Datum(int Tag, int Monat, int Jahr){
        this.tag = Tag;
        this.monat = Monat;
        this.jahr = Jahr;

    }

    public Datum(int Tag, int Monat, int Jahr, int Stunden, int Minuten){
        this.tag = Tag;
        this.monat = Monat;
        this.jahr = Jahr;
        this.stunden = Stunden;
        this.minuten = Minuten;
        //this.datum = tag;

    }
}
