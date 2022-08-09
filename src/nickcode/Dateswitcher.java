package src.nickcode;

import java.lang.reflect.Array;

public class Dateswitcher {

    public static void main(String[] args) {
        datetonumber("26-06-2003");
        numbertodate(26,06,2003);
    }

    public static String numbertodate(int day, int month,int year){ //3 eingaben ints

        //Code für eine zusammenhängende Zahl (Falls nötig iwann)
       /* String datestring = String.valueOf(number);
        String daymonth = datestring.substring(0, datestring.length() / 2);  // gives 2606
        String year = datestring.substring(datestring.length() / 2);     //gives 2003
        String day = daymonth.substring(0,daymonth.length() / 2);
        String month = daymonth.substring(daymonth.length() / 2);*/

        String ges = day+"-"+ month+"-" + year;
        System.out.println(ges);

        return ges;
    }
    public static int[] datetonumber(String date){

        String[] parts = date.split("-");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];

        int day = Integer.parseInt(String.valueOf(part1));
        int month = Integer.parseInt(String.valueOf(part2));
        int year = Integer.parseInt(String.valueOf(part3));

        int[] array = new int[3];
        array[0] = day;
        array[1] = month;
        array[2] = year;

        // Im array returnen -> in 3 werten (ints)

        //Zum ausgeben testweise (kann dann auskommentiert werden.)
        for (int i = 0; i<array.length;i++){
            System.out.println(array[i]);
        }

        return array;
    }
}
