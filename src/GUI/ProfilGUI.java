package src.GUI;
import src.Foo;
import src.GUI.elements.PlaceholderTextField;

import javax.swing.*;

import static src.Foo.*;
public class ProfilGUI {

    JFrame Frame = new JFrame();
    JPanel Background = new JPanel();
    PlaceholderTextField Benutzername = new PlaceholderTextField();
    PlaceholderTextField Rolle = new PlaceholderTextField();
    PlaceholderTextField Name = new PlaceholderTextField();
    PlaceholderTextField Vorname = new PlaceholderTextField();
    PlaceholderTextField Gender = new PlaceholderTextField();
    PlaceholderTextField Geburtstag = new PlaceholderTextField();
    PlaceholderTextField EMail = new PlaceholderTextField();
    PlaceholderTextField Telefonnummer = new PlaceholderTextField();


    public static void openProfilGUI(){
        Foo.getDirectoryData();
        ProfilGUI gui = new ProfilGUI();
    }
}
