package src.GUI;

import src.Foo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFensterGUI extends JFrame {

    private JPanel mainPanel;
    private JButton registrierenButton;
    private JButton anmeldenButton;
    private JButton beendenButton;


    public StartFensterGUI(){
        setContentPane(mainPanel);
        setTitle("Willkommen");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 300;
        int height = 100;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setVisible(true);
        System.out.println("2 " + Foo.firstUsage);

        if (Foo.firstUsage){
            if (anmeldenButton instanceof AbstractButton) {
                AbstractButton btn = (AbstractButton) anmeldenButton;
                    btn.setEnabled(false);

                }
            }




        beendenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Programm beendet.");
                System.exit(144);
            }
        });
        anmeldenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginGUI.openLogin();
            }
        });
        registrierenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Foo.firstUsage){
                    dispose();
                    firstRegistrationGUI.firstRegister();
                }else{
                    dispose();
                    RegisterGUI.register();
                }
            }
        });
    }

    public static void main(String[] args) {
        StartFensterGUI gui = new StartFensterGUI();
    }

    public static void openStartFenster(){
        StartFensterGUI gui = new StartFensterGUI();
    }
}
