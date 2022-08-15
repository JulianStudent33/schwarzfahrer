package src.GUI;
import javax.swing.*;
import java.awt.*;
import static src.Foo.*;

public class OkayWindow {

    JFrame frame = new JFrame();
    JPanel Background = new JPanel();
    JLabel label = new JLabel();
    JLabel label2 = new JLabel();
    JButton OkBtn = new JButton();
    ImageIcon hilfe_bild = new ImageIcon("src/icons/bild_hilfe.png");
    JLabel BildLabel = new JLabel();

    public OkayWindow(String message){


        // Panelmanagement
        Background.setBackground(dark);
        Background.setBounds(50,1,200,200);
        Background.setLayout(new BorderLayout(50, 50));

        // Elemente

        label.setText(message);
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setFont(fontSmall);
        label.setBounds(20,15,200,40);

        OkBtn.setBackground(hellb);
        OkBtn.setForeground(white);
        OkBtn.setText("Ok");
        OkBtn.setBounds(85,70,80,40);

        BildLabel.setIcon(hilfe_bild);
        BildLabel.setBounds(20,50,50,50);

        // Einfügen der Elemente in die Panels
        Background.add(label);
        Background.add(OkBtn);
        Background.add(BildLabel);


        // Adden der Panels in den Frame
        frame.add(Background, BorderLayout.CENTER);

        // Frame Properties
        frame.setBackground(dark);
        frame.setSize(250,200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new OkayWindow("<html><body><p>Ihre Passwörter <b>stimmen nicht überein</p></body></html>");
    }
}
