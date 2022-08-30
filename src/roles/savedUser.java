package src.roles;

import src.PersFile;
import src.roles.Administrator;
import src.roles.Kontrolleur;
import src.roles.Mitarbeiter;
import src.roles.Sachbearbeiter;

import java.io.File;
import java.io.IOException;

public class savedUser extends Mitarbeiter {


    public boolean angemeldetBleiben;
    public String autoLogoutTime;

    public savedUser(Mitarbeiter currentUser, boolean angemeldetBleiben, String autoLogoutTime){
        this.angemeldetBleiben = angemeldetBleiben;
        this.autoLogoutTime = autoLogoutTime;

    }

    public savedUser(boolean angemeldetBleiben){
        this.angemeldetBleiben = angemeldetBleiben;
    }
    public void saveStatus(File file) throws IOException {
        PersFile.speichern(this, file);

    }

}
