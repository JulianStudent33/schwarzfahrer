package src.GUI.Sachbearbeiter;

import javax.swing.*;
import java.awt.*;

import static src.Foo.*;

public class Kachel1 extends JFrame {

    public Kachel1(){

        JPanel Background = new JPanel();
        Background.setBackground(Color.darkGray);
        Background.setLayout(new BorderLayout());

        JLabel label = new JLabel();
        label.setText("<html><body><center><p>Sachbearbeiter</p></center></body></html>");
        label.setForeground(white);
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.CENTER);
        label.setFont(fontLargeLarge);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setBounds(-8,70, 500,100);

        this.setSize(500,650);
        this.setTitle("Sachbearbeiter");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.getContentPane().setBackground(dark);


        this.add(Background, BorderLayout.CENTER);
        this.add(label, BorderLayout.NORTH);

        this.add(new scrollPane());

    }


    public static void main(String[] args) {
        Kachel1 gui = new Kachel1();
    }

}
class scrollPane extends JPanel {

    public scrollPane(){

        setLayout(new BorderLayout());
        setBackground(Color.GRAY);
        add(new WarehousePane(), BorderLayout.CENTER);

        setBounds(20, 20, 150, 150);


    }
}
class WarehousePane extends JPanel {
    WarehousePane(){
        ; // Set an appropriate layout for overall needs



        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        this.add(new WarehouseItem());
        this.add(new WarehouseItem());
        this.add(new WarehouseItem());
    }}

class WarehouseItem extends JPanel {
    WarehouseItem(){
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        JButton sell = new JButton("Sell");
        JButton tax = new JButton("Return tax");
        JLabel name = new JLabel("Item name");
        this.add(name);
        this.add(tax);
        this.add(sell);
    }}