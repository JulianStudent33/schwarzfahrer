package src;

import src.roles.Administrator;
import src.roles.Kontrolleur;
import src.roles.Mitarbeiter;
import src.roles.Sachbearbeiter;

import java.io.File;
import java.io.IOException;

public class savedUser extends Mitarbeiter {
    public Kontrolleur currentKon;
    public Administrator currentAdmin;
    public Sachbearbeiter currentSb;

    public boolean angemeldetBleiben;
    public String autoLogoutTime;

    public savedUser(Kontrolleur currentKon, boolean angemeldetBleiben, String autoLogoutTime){
        this.currentKon = currentKon;
        this.angemeldetBleiben = angemeldetBleiben;
        this.autoLogoutTime = autoLogoutTime;
        this.setKontrolleur(true);
    }
    public savedUser(Administrator currentAdmin, boolean angemeldetBleiben, String autoLogoutTime){
        this.currentAdmin = currentAdmin;
        this.angemeldetBleiben = angemeldetBleiben;
        this.autoLogoutTime = autoLogoutTime;
        this.setAdmin(true);
    }
    public savedUser(Sachbearbeiter currentSb, boolean angemeldetBleiben, String autoLogoutTime){
        this.currentSb = currentSb;
        this.angemeldetBleiben = angemeldetBleiben;
        this.autoLogoutTime = autoLogoutTime;
        this.setSachbearbeiter(true);
    }
    public savedUser(boolean angemeldetBleiben){
        this.angemeldetBleiben = angemeldetBleiben;
    }
    public void saveStatus(File file) throws IOException {
        PersFile.speichern(this, file);

    }

}
