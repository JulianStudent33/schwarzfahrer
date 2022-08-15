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

    public savedUser(Kontrolleur currentKon, boolean angemeldetBleiben){
        this.currentKon = currentKon;
        this.angemeldetBleiben = angemeldetBleiben;
        this.setKontrolleur(true);
    }
    public savedUser(Administrator currentAdmin, boolean angemeldetBleiben){
        this.currentAdmin = currentAdmin;
        this.angemeldetBleiben = angemeldetBleiben;
        this.setAdmin(true);
    }
    public savedUser(Sachbearbeiter currentSb, boolean angemeldetBleiben){
        this.currentSb = currentSb;
        this.angemeldetBleiben = angemeldetBleiben;
        this.setSachbearbeiter(true);
    }
    public savedUser(boolean angemeldetBleiben){
        this.angemeldetBleiben = angemeldetBleiben;
    }
    public void saveStatus(File file) throws IOException {
        PersFile.speichern(this, file);

    }

}
