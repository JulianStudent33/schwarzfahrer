package src.GUI;
import javax.swing.*;
import java.awt.*;
import static src.Foo.*;

public class OkayWindow {

    JFrame frame = new JFrame();
    JPanel Bild = new JPanel();
    JPanel Background = new JPanel();
    JLabel label = new JLabel();
    JButton OkBtn = new JButton();
    ImageIcon hilfe_bild = new ImageIcon("src/icons/hilfe_bild.png");
    JLabel BildLabel = new JLabel();

    public OkayWindow(String message){


        // Panelmanagement
        Background.setBackground(dark);
        Background.setBounds(1,1,200,150);
        Background.setLayout(null);

        Bild.setBackground(dark);
        Bild.setBounds(1,1,50,50);
        Bild.setLayout(null);

        // Elemente
        label.setText(message);
        label.setForeground(white);
        label.setFont(fontMedium);
        label.setBounds(100,15,80,20);

        OkBtn.setBackground(hellb);
        OkBtn.setForeground(white);
        OkBtn.setText("Ok");
        OkBtn.setBounds(100,55,80,40);

        BildLabel.setIcon(hilfe_bild);
        BildLabel.setBounds(1,1,50,50);

        // Einfügen der Elemente in die Panels
        Background.add(label);
        Background.add(OkBtn);
        Background.add(BildLabel);


        // Adden der Panels in den Frame
        frame.add(Background, BorderLayout.CENTER);

        // Frame Properties
        frame.setBackground(dark);
        frame.setSize(250,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void openOkayWindow(String message){
        OkayWindow gui = new OkayWindow(message);
    }
    public static void main(String[] args) {
        new OkayWindow("test");
    }
}
