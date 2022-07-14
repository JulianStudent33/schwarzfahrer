package src.GUI.Kontrolleur;

import src.users.Kontrolleur;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JToggleButton abbrechenToggleButton;

    public erfassen(){
        this.currentUser = KontrolleurGUI.currentUser;
        setContentPane(mainPanel);
        setTitle("Kontrolleur Menü");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 1000;
        int height = 400;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        try {
            UIManager.setLookAndFeel(UIManager.createLookAndFeel("Windows"));
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }

        nameLabel.setText("Angemeldet als " + currentUser.getVorname() + " " + currentUser.getName() + " (" + currentUser.getMitarbeiternummer() + ").");


        setVisible(true);

        //Button Funktion Zuweisung

        suchenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Suchen nach Schwarzfahrer anhand von Ausweisnummer
            }
        });

        speichernToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });

        abbrechenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();
            }
        });
    }


    public static void open() {
        erfassen gui = new erfassen();
    }

    public static void main(String[] args) {
        open();

    }
}
