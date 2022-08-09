package src.GUI;
import javax.swing.*;
import java.awt.*;
import static src.Foo.*;

public class okWindow {

    JFrame frame = new JFrame();
    JPanel Bild = new JPanel();
    JPanel Background = new JPanel();
    JLabel label = new JLabel();
    JButton OkBtn = new JButton("Ok");
    ImageIcon hilfe_bild = new ImageIcon("src.icons.hilfe_bild.png");
    JLabel BildLabel = new JLabel();

    public okWindow(String message){


        // Panelmanagement
        Background.setBackground(dark);
        Background.setBounds(1,1,200,150);
        Background.setLayout(null);

        Bild.setBackground(dark);
        Bild.setBounds(1,1,50,50);
        Bild.setLayout(null);

        // Elemente
        label.setText(message);
        label.setBounds(60,15,80,20);
        label.setForeground(white);

        OkBtn.setBounds(60,35,80,40);
        OkBtn.setBackground(hellb);
        OkBtn.setForeground(white);

        BildLabel.setIcon(hilfe_bild);

        // Einfügen der Elemente in die Panels
        Background.add(label);
        Background.add(OkBtn);

        Bild.add(BildLabel);

        // Adden der Panels in den Frame
        frame.add(Background, BorderLayout.CENTER);
        frame.add(Bild, BorderLayout.WEST);

        // Frame Properties
        frame.setBackground(dark);
        frame.setSize(250,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        okWindow("test");
    }
}
