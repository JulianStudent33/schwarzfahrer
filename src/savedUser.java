package src;

import src.users.Administrator;
import src.users.Kontrolleur;
import src.users.Mitarbeiter;
import src.users.Sachbearbeiter;

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
        PersFile.writeInFile(this, file);

    }

}
