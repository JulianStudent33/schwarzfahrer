package src.GUI.Kontrolleur;

import src.Foo;
import src.users.Kontrolleur;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class erfassen extends JFrame{

    private static Kontrolleur currentUser;
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel rightPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JToggleButton suchenToggleButton;
    private JComboBox comboBox1;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JComboBox comboBox2;
    private JToggleButton speichernToggleButton;
    private JLabel nameLabel;

    public erfassen(){
        this.currentUser = KontrolleurGUI.currentUser;
        setContentPane(mainPanel);
        setTitle("Kontrolleur Menü");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1000;
        int height = 600;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.createLookAndFeel("Windows"));
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        nameLabel.setText("Angemeldet als " + currentUser.getVorname() + " " + currentUser.getName() + " (" + currentUser.getMitarbeiternummer() + ").");



        setVisible(true);
    }

    public static void open() {
        erfassen gui = new erfassen();
    }

    public static void main(String[] args) {
        open();

    }
}
