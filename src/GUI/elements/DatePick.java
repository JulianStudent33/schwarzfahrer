package src.GUI.elements;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.security.Key;
import java.util.Calendar;

import static src.Foo.*;

public class DatePick {
    int DATE_MONTH = java.util.Calendar.getInstance().get(Calendar.MONTH);
    final int DATE_MONTH_ACTUAL = java.util.Calendar.getInstance().get(Calendar.MONTH);
    int DATE_YEAR = java.util.Calendar.getInstance().get(Calendar.YEAR);
    final int DATE_YEAR_ACTUAL = java.util.Calendar.getInstance().get(Calendar.YEAR);
    ;
    JLabel J_Label = new JLabel("", JLabel.CENTER);
    JTextField J_tfield = new JTextField("", JLabel.CENTER);
    String DATE_DAY = "";
    JDialog J_Dialog;
    JButton[] J_Button = new JButton[49];

    public DatePick(JFrame J_Frame_Parent, String alteEingabe) {

        if(alteEingabe!=null){
            int[] d = Dateswitcher.datetonumber(alteEingabe);

            DATE_MONTH = d[1]-1; //-1 weil ist bei Monaten so
            DATE_YEAR = d [2];
        }



        J_Dialog = new JDialog();
        J_Dialog.setModal(true);
        J_Dialog.setBackground(dark);
        String[] Header = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        JPanel J_Panel1 = new JPanel(new GridLayout(7, 7));
        J_Panel1.setPreferredSize(new Dimension(700, 120));

        for (int i = 0; i < J_Button.length; i++) {
            final int selection = i;
            J_Button[i] = new JButton();
            J_Button[i].setFocusPainted(false);
            J_Button[i].setBackground(dark);
            J_Button[i].setForeground(white);
            if (i > 6)
                J_Button[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent ae) {
                        DATE_DAY = J_Button[selection].getActionCommand();
                        J_Dialog.dispose();
                    }
                });
            if (i < 7) {
                J_Button[i].setText(Header[i]);
                J_Button[i].setFont(fontSmallSmall);
                J_Button[i].setForeground(dunkelb);
            }
            J_Panel1.add(J_Button[i]);
        }
        JPanel J_Panel2 = new JPanel(new GridLayout(1, 6));
        J_Panel2.setBackground(dark);
        J_Label.setForeground(J_Button[20].getForeground());
        J_Label.setFont(fontSmallSmall);
        J_tfield.setForeground(J_Button[20].getForeground());
        J_tfield.setFont(fontSmallSmall);
        ((AbstractDocument)J_tfield.getDocument()).setDocumentFilter(new NumberFilter());
        J_tfield.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {




            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {


                    System.out.println(e.getKeyCode());
                    if (e.getKeyCode() != KeyEvent.VK_ENTER){
                        System.out.println(e.getKeyCode());
                        if (e.getKeyCode() != KeyEvent.VK_BACK_SPACE){
                            System.out.println(e.getKeyChar());
                            DATE_YEAR = Integer.parseInt(J_tfield.getText());
                            Display_Date();
                        }
                    }
                    if (J_tfield.getText().length() > 4){
                        DATE_YEAR = DATE_YEAR_ACTUAL;
                        J_tfield.setText(String.valueOf(DATE_YEAR));
                        Display_Date();
                    }
                if(DATE_YEAR > DATE_YEAR_ACTUAL){
                    DATE_YEAR = DATE_YEAR_ACTUAL;
                    Display_Date();
                }
                if (DATE_YEAR == DATE_MONTH_ACTUAL && DATE_MONTH > DATE_MONTH_ACTUAL) {
                    DATE_MONTH = DATE_MONTH_ACTUAL;
                    Display_Date();
                }


            }
        });



        JButton Previous_Button1 = new JButton("<<<");
        Previous_Button1.setBackground(notSoDark);
        Previous_Button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DATE_YEAR--;
                Display_Date();
            }
        });
        JButton Previous_Button2 = new JButton(" < ");
        Previous_Button2.setBackground(notSoDark);
        Previous_Button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                DATE_MONTH--;
                Display_Date();
            }
        });
        J_Panel2.add(Previous_Button1);
        J_Panel2.add(Previous_Button2);
        J_Panel2.add(J_Label);
        J_Panel2.add(J_tfield);
        JButton Next_Button1 = new JButton(">>>");
        Next_Button1.setBackground(notSoDark);
        Next_Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(DATE_YEAR < DATE_YEAR_ACTUAL){
                    DATE_YEAR++;
                    if (DATE_YEAR == DATE_YEAR_ACTUAL){
                        DATE_MONTH = DATE_MONTH_ACTUAL;
                    }
                    Display_Date();
                } else{
                        if (DATE_MONTH < DATE_MONTH_ACTUAL){
                            DATE_YEAR++;
                            Display_Date();

                    }
                }

            }
        });
        JButton Next_Button2 = new JButton(" > ");
        Next_Button2.setBackground(notSoDark);
        Next_Button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if(DATE_YEAR != DATE_YEAR_ACTUAL){
                    DATE_MONTH++;
                    Display_Date();
                }else if (DATE_MONTH != DATE_MONTH_ACTUAL){
                    DATE_MONTH++;
                    Display_Date();
                }
                if (DATE_MONTH >=12){
                    DATE_MONTH = 0;
                    DATE_YEAR++;
                    Display_Date();
                }
            }
        });
        J_Panel2.add(Next_Button2);
        J_Panel2.add(Next_Button1);
        J_Dialog.add(J_Panel1, BorderLayout.CENTER);
        J_Dialog.add(J_Panel2, BorderLayout.SOUTH);
        J_Dialog.pack();
        J_Dialog.setLocationRelativeTo(J_Frame_Parent);
        Display_Date();
        J_Dialog.setVisible(true);
    }

    public void Display_Date() {
        for (int i = 7; i < J_Button.length; i++)
            J_Button[i].setText("");
        java.text.SimpleDateFormat Simple_Date_Format = new java.text.SimpleDateFormat(
                "MMMM yyyy");
        java.util.Calendar Calendar = java.util.Calendar.getInstance();
        Calendar.set(DATE_YEAR, DATE_MONTH, 1);
        int Day_Of_Week = Calendar.get(java.util.Calendar.DAY_OF_WEEK);
        int Days_In_Month = Calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
        for (int i = 6 + Day_Of_Week, Day = 1; Day <= Days_In_Month; i++, Day++)
            J_Button[i].setText("" + Day);
        String t = Simple_Date_Format.format(Calendar.getTime());
        J_Label.setText(t.split(" ")[0]);
        J_tfield.setText(t.split(" ")[1]);
        J_Dialog.setTitle("Date Picker");
    }

    public String Set_Picked_Date() {
        if (DATE_DAY.equals("")) {
            return DATE_DAY;
        }

        java.text.SimpleDateFormat Simple_Date_Format = new java.text.SimpleDateFormat(
                "dd-MM-yyyy");
        java.util.Calendar Calendar = java.util.Calendar.getInstance();
        Calendar.set(DATE_YEAR, DATE_MONTH, Integer.parseInt(DATE_DAY));
        return Simple_Date_Format.format(Calendar.getTime());
    }
}
