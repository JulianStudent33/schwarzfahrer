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

    public OkayWindow(String message, String message2){


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
        label.setBounds(10,15,200,40);

        label2.setText(message2);
        label2.setForeground(white);
        label2.setHorizontalTextPosition(JLabel.CENTER);
        label2.setVerticalTextPosition(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        label2.setVerticalAlignment(JLabel.CENTER);
        label2.setFont(fontSmall);
        label2.setBounds(10,15,200,40);

        JPanel J_Panel1 = new JPanel(new GridLayout(2, 1));
        J_Panel1.setPreferredSize(new Dimension(200, 200));
        J_Panel1.setBackground(white);
        J_Panel1.add(label);
        J_Panel1.add(label2);


        OkBtn.setBackground(hellb);
        OkBtn.setForeground(white);
        OkBtn.setText("Ok");
        OkBtn.setBounds(85,55,80,40);

        BildLabel.setIcon(hilfe_bild);
        BildLabel.setBounds(15,50,50,50);

        // Einfügen der Elemente in die Panels
        Background.add(J_Panel1, BorderLayout.CENTER);
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
        new OkayWindow("<html><body><p>Ihre Passwörter</p></body></html>", "<html><body><p>stimmen nicht überein!</p></body></html>");
    }
}
