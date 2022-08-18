package src.GUI;

import java.awt.*;
import static src.Main.*;

import static src.Foo.dark;
import static src.Foo.whitebg;

public class Coloradd {

    public static void coloradd(){
        // RGB Variablen die zu der anderen Farbe addiert werden soll
        Color firstvariable = new Color(50, 50, 50);
        Color secvariable = new Color(80, 80, 80);

        // Array Deklaration für die Color Addition
        int[] colorevar1 = {firstvariable.getRed(), firstvariable.getGreen(), firstvariable.getBlue()};
        int[] colorvar2 = {secvariable.getRed(), secvariable.getGreen(), secvariable.getBlue()};
        int[] forecolor = {dark.getRed(), dark.getGreen(), dark.getBlue()};
        int[] backcolor = {whitebg.getRed(), whitebg.getGreen(), whitebg.getBlue()};

        //Addition der Array und Ergebnis -> Deklaration als neue Farbe
        int[] addforecolor = new int[0];
        int[] addbackcolor = new int[0];
        if (colorchange) {
            addforecolor = new int[]{forecolor[0] - colorevar1[0], backcolor[1] - colorevar1[1], forecolor[2] - colorevar1[2]};
            addbackcolor = new int[]{backcolor[0] - colorvar2[0], backcolor[1] - colorvar2[1], backcolor[2] - colorvar2[2]};
        } else {
            addforecolor = new int[]{forecolor[0] + colorevar1[0], backcolor[1] + colorevar1[1], forecolor[2] + colorevar1[2]};
            addbackcolor = new int[]{backcolor[0] + colorvar2[0], backcolor[1] + colorvar2[1], backcolor[2] + colorvar2[2]};
        }
        Color forecolorr = new Color(addforecolor[0], addforecolor[1], addforecolor[2]);
        Color backcolorr = new Color(addbackcolor[0], addbackcolor[1], addbackcolor[2]);

        //Kurze Test Abfrage des Roten Wertes
        System.out.println(forecolorr.getRed() + "," + backcolorr.getRed());

    }


}
