package src;

import javax.swing.*;
import java.awt.*;

public class GameGui extends JFrame {

    private JButton menu;
    private ImageIcon icon;
    private Image imageIcon;
    public GameGui(String titel){

        setTitle(titel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setSize(500, 350);
        setResizable(false);

        initComponents();
        add(menu);
        setIconImage(imageIcon);

        setLocationRelativeTo(null);
        setVisible(true);
        }

    private void initComponents(){

        menu = new JButton("Menu");
        icon = new ImageIcon("icons" + Foo.fileSeperator + "Hut.png");
        imageIcon = icon.getImage();
}
}
