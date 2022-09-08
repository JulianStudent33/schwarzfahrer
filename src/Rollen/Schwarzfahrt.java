package src.Rollen;

import src.PersFile;
import src.Status;

import java.io.IOException;
import java.io.Serializable;

import static src.Foo.*;

public class Schwarzfahrt implements Serializable {
    public Schwarzfahrer sf;
    public String zeitpunkt;
    public int DAY;
    public int MONTH;
    public int YEAR;
    public int HOUR;
    public int MINUTE;
    public String linie;
    public Status status;

    public Schwarzfahrt(Schwarzfahrer sf, String date, String hour, String minute , String linie, boolean isBezahlt){
        this.sf = sf;
        int[] date1 = dateToNumber(date);
        this.DAY = date1[0];
        this.MONTH = date1[1];
        this.YEAR = date1[2];
        this.HOUR = Integer.parseInt(hour);
        this.MINUTE = Integer.parseInt(minute);
        this.linie = linie;


        this.zeitpunkt = date.concat(" um ").concat(hour.concat(":").concat(minute));
        status = new Status();
        if (isBezahlt){
            status.setBezahlt();
        }else{
            status.setOffen();
        }

        try {
            sf.createSfFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        display();
    }

    public void display(){
        System.out.println("Schwarzfahrer: " + sf.getVorname() + " " + sf.getNachname());
        System.out.println("Schwarzfahrt zum Zeitpunkt: " + zeitpunkt);
        System.out.println("Auf der Linie: " + linie);
        System.out.println("Status: " + status.status);
    }

    public void incrementStatus(){
        if (status.isOffen){
            status.setAusstehend();
        } else if (status.isAusstehend) {
            status.setBezahlt();
        } else if (status.isBezahlt) {
            status.setOffen();
        }
        saveSFT();

    }
    public void saveSFT(){
        for (int i = 0; i < sf.sftList.size(); i++){
            if (this.equals(sf.sftList.get(i))){
                sf.sftList.set(i, this);
                System.out.println("Schwarzfahrt im Schwarzfahrer" + sf.getNachname() + " aktualisiert.");
            }
        }
        try {
            PersFile.speichern(sf, sf.getSfFile());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public void deleteSFT(){
        for (int i = 0; i < sf.sftList.size(); i++){
            if (this.equals(sf.sftList.get(i))){
                sf.sftList.remove(i);
                System.out.println("Schwarzfahrt entfernt.");
            }
        }
        try {
            PersFile.speichern(sf, sf.getSfFile());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    public Schwarzfahrer getSf() {
        return sf;
    }

    public void setSf(Schwarzfahrer sf) {
        this.sf = sf;
    }

    public String getZeitpunkt() {
        return zeitpunkt;
    }

    public void setZeitpunkt(String zeitpunkt) {
        this.zeitpunkt = zeitpunkt;
    }
    public String getDate(){
        String s = getZeitpunkt();
        s = s.substring(0, 10);
        return s;
    }

    public int getDAY() {
        return DAY;
    }

    public void setDAY(int DAY) {
        this.DAY = DAY;
    }

    public int getMONTH() {
        return MONTH;
    }

    public void setMONTH(int MONTH) {
        this.MONTH = MONTH;
    }

    public int getYEAR() {
        return YEAR;
    }

    public void setYEAR(int YEAR) {
        this.YEAR = YEAR;
    }

    public int getHOUR() {
        return HOUR;
    }

    public void setHOUR(int HOUR) {
        this.HOUR = HOUR;
    }

    public int getMINUTE() {
        return MINUTE;
    }

    public void setMINUTE(int MINUTE) {
        this.MINUTE = MINUTE;
    }

    public String getLinie() {
        return linie;
    }

    public void setLinie(String linie) {
        this.linie = linie;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
