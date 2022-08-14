package src;

import src.GUI.elements.Dateswitcher;
import src.roles.Schwarzfahrer;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

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

    public Schwarzfahrt(Schwarzfahrer sf, String date, int hour, int minute , String linie, boolean isBezahlt){
        this.sf = sf;
        int[] date1 = Dateswitcher.datetonumber(date);
        this.DAY = date1[0];
        this.MONTH = date1[1];
        this.YEAR = date1[2];
        this.HOUR = hour;
        this.MINUTE = minute;
        this.linie = linie;


        this.zeitpunkt = date.concat(" um ").concat(String.valueOf(hour).concat(":").concat(String.valueOf(minute)));
        status = new Status();
        if (isBezahlt){
            status.setBezahlt();
        }else{
            status.setOffen();
        }

        //sf.sftList.add(this);

        try {
            sf.createSfFile();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        display();
    }

    public void display(){
        System.out.println("Schwarzfahrer: " + sf.getVorname() + " " + sf.getName());
        System.out.println("Schwarzfahrt zum Zeitpunkt: " + zeitpunkt);
        System.out.println("Auf der Linie: " + linie);
        System.out.println("Status: " + status.status);
    }

}
