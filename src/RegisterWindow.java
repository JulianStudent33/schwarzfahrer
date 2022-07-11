package src;

import src.nickcode.pass;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterWindow extends JFrame{
    int selection;
    private JComboBox comboBox1;
    private JTextField benutzernameTextField;
    private JTextField passwortTextField;
    private JPanel mainPanel;
    private JButton registrierenButton;
    private JButton beendenButton;


    public RegisterWindow(){

        setContentPane(mainPanel);
        setTitle("Registration");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 500;
        int height = 200;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        benutzernameTextField.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                benutzernameTextField.setText("");
            }
        });
        passwortTextField.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                passwortTextField.setText("");
            }
        });
        beendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(200);
            }
        });
        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(comboBox1.getSelectedItem());
                if (comboBox1.getSelectedItem().equals(comboBox1.getItemAt(0))){
                    System.out.println("Ist Kontrolleur");
                    selection = 1;

                    boolean pwBestaetigt = false;
                    boolean pwOK = false;
                    while(Foo.userExistiertBereits(benutzernameTextField.getText())){
                        benutzernameTextField.setText("Username bereits vergeben");
                    }
                    while(!pass.passwordOk(passwortTextField.getText())){
                        passwortTextField.setText("Passwort erfüllte nicht die Vorgaben.");
                        try {
                            wait();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }







                }
                if (comboBox1.getSelectedItem().equals(comboBox1.getItemAt(1))){
                    System.out.println("Ist Sachbearbeiter");
                    selection = 2;
                }
            }
        });


    }

    public static int getSelection(){
        RegisterWindow window = new RegisterWindow();

        return window.selection;
    }

    public static void main(String[] args) {

        switch (getSelection()){
            case 1:
                System.out.println("Kontrolleur wurde ausgewählt");

                break;
            case 2:
                System.out.println("Sachbearbeiter wurde ausgewählt");
                break;

        }


    }
}
