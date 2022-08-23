package src.GUI.elements;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import static src.Foo.*;

public class DatePick {
    int DATE_MONTH = java.util.Calendar.getInstance().get(Calendar.MONTH);
    final int DATE_MONTH_ACTUAL = java.util.Calendar.getInstance().get(Calendar.MONTH);
    int DATE_YEAR = java.util.Calendar.getInstance().get(Calendar.YEAR);
    final int DATE_YEAR_ACTUAL = java.util.Calendar.getInstance().get(Calendar.YEAR);
    ;
    JLabel J_Label = new JLabel("", JLabel.CENTER);
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
        JPanel J_Panel2 = new JPanel(new GridLayout(1, 5));
        J_Panel2.setBackground(dark);
        J_Label.setForeground(J_Button[20].getForeground());
        J_Label.setFont(fontSmallSmall);
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
        JButton Next_Button1 = new JButton(">>>");
        Next_Button1.setBackground(notSoDark);
        Next_Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(DATE_YEAR != DATE_YEAR_ACTUAL){
                    DATE_YEAR++;
                    Display_Date();
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
        J_Label.setText(Simple_Date_Format.format(Calendar.getTime()));
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
