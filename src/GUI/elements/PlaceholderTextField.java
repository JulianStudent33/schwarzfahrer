package src.GUI.elements;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.Document;

import static src.Foo.notSoDark;

@SuppressWarnings("serial")
public class PlaceholderTextField extends JTextField implements Flash{


    public Timer timer;
    private String placeholder;

    public PlaceholderTextField() {
    }

    public PlaceholderTextField(
            final Document pDoc,
            final String pText,
            final int pColumns)
    {
        super(pDoc, pText, pColumns);
    }

    public PlaceholderTextField(final int pColumns) {
        super(pColumns);
    }

    public PlaceholderTextField(final String pText) {
        super(pText);
    }

    public PlaceholderTextField(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(notSoDark);
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
                .getMaxAscent() + getInsets().top);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }
    //    public void set

    public void addFlashEffect(){

        if (timer == null) {

            final Color baseColor = getBackground();

            //System.out.println(baseColor.getRed() + " " + baseColor.getGreen() + " " + baseColor.getBlue());
            final int[] i = {baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue()};
            final int i1 = baseColor.getRed();
            final int i2 = baseColor.getGreen();
            final int i3 = baseColor.getBlue();

            final int[] ii = i;
            final int[] j = {15};
            timer = new Timer(2, e -> {

                try {
                    ii[0] += j[0];
                    ii[1] += j[0];
                    ii[2] += j[0];

                    if (ii[0] > 255 || ii[1] > 255 || ii[2] > 255) {
                        //System.out.println("Switching from 15 to -15");
                        ii[0] -= 15;
                        ii[1] -= 15;
                        ii[2] -= 15;
                        j[0] = -15;
                    } else if (ii[0] < i1 || ii[1] < i2 || ii[2] < i3) {
                        ii[0] += 15;
                        ii[1] += 15;
                        ii[2] += 15;
                        //System.out.println("Kleiner als");
                        timer.stop();
                        return;
                    }


                    setBackground(new Color(ii[0], ii[1], ii[2]));
                    //System.out.println(ii[0] + " " + ii[1] + " " + ii[2]);
                } catch (IllegalArgumentException ex) {

                    setBackground(baseColor);
                    timer.stop();
                    return;
                }


            });
            timer.start();
        } else if (!timer.isRunning()) {
            final Color baseColor = getBackground();

            //System.out.println(baseColor.getRed() + " " + baseColor.getGreen() + " " + baseColor.getBlue());
            final int[] i = {baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue()};
            final int i1 = baseColor.getRed();
            final int i2 = baseColor.getGreen();
            final int i3 = baseColor.getBlue();

            final int[] ii = i;
            final int[] j = {15};
            timer = new Timer(2, e -> {

                try {
                    ii[0] += j[0];
                    ii[1] += j[0];
                    ii[2] += j[0];

                    if (ii[0] > 255 || ii[1] > 255 || ii[2] > 255) {
                        //System.out.println("Switching from 15 to -15");
                        ii[0] -= 15;
                        ii[1] -= 15;
                        ii[2] -= 15;
                        j[0] = -15;
                    } else if (ii[0] < i1 || ii[1] < i2 || ii[2] < i3) {
                        ii[0] += 15;
                        ii[1] += 15;
                        ii[2] += 15;
                        //System.out.println("Kleiner als");
                        timer.stop();
                        return;
                    }


                    setBackground(new Color(ii[0], ii[1], ii[2]));
                    //System.out.println(ii[0] + " " + ii[1] + " " + ii[2]);
                } catch (IllegalArgumentException ex) {

                    setBackground(baseColor);
                    timer.stop();
                    return;
                }


            });
            timer.start();
        }
    }

    public void addRedFlashEffect() {
        if (timer == null) {
            final Color baseColor = getBackground();

            //System.out.println(baseColor.getRed() + " " + baseColor.getGreen() + " " + baseColor.getBlue());
            final int[] i = {baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue()};
            final int i1 = baseColor.getRed();
            final int i2 = baseColor.getGreen();
            final int i3 = baseColor.getBlue();

            final int[] ii = i;
            final int[] j = {15};
            timer = new Timer(2, e -> {

                try {
                    ii[0] += j[0];


                    if (ii[0] > 255 || ii[1] > 255 || ii[2] > 255) {
                        //System.out.println("Switching from 15 to -15");
                        ii[0] -= 15;

                        j[0] = -15;
                    } else if (ii[0] < i1) {
                        ii[0] += 15;
                        //System.out.println("Kleiner als");
                        timer.stop();
                        return;
                    }


                    setBackground(new Color(ii[0], ii[1], ii[2]));
                    //System.out.println(ii[0] + " " + ii[1] + " " + ii[2]);
                } catch (IllegalArgumentException ex) {

                    setBackground(baseColor);
                    timer.stop();
                    return;
                }


            });
            timer.start();
        } else if (!timer.isRunning()) {
            final Color baseColor = getBackground();

            //System.out.println(baseColor.getRed() + " " + baseColor.getGreen() + " " + baseColor.getBlue());
            final int[] i = {baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue()};
            final int i1 = baseColor.getRed();
            final int i2 = baseColor.getGreen();
            final int i3 = baseColor.getBlue();

            final int[] ii = i;
            final int[] j = {15};
            timer = new Timer(2, e -> {

                try {
                    ii[0] += j[0];


                    if (ii[0] > 255 || ii[1] > 255 || ii[2] > 255) {
                        //System.out.println("Switching from 15 to -15");
                        ii[0] -= 15;

                        j[0] = -15;
                    } else if (ii[0] < i1) {
                        ii[0] += 15;
                        //System.out.println("Ausgangs RGB unterschritten");
                        timer.stop();
                        return;
                    }


                    setBackground(new Color(ii[0], ii[1], ii[2]));
                   // System.out.println(ii[0] + " " + ii[1] + " " + ii[2]);
                } catch (IllegalArgumentException ex) {

                    setBackground(baseColor);
                    timer.stop();
                    return;
                }


            });
            timer.start();
        }

    }
    public void addRedFlashEffectWhiteField() {
        if (timer == null) {
            final Color baseColor = getBackground();

            //System.out.println(baseColor.getRed() + " " + baseColor.getGreen() + " " + baseColor.getBlue());
            final int[] i = {baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue()};
            final int i1 = baseColor.getRed();
            final int i2 = baseColor.getGreen();
            final int i3 = baseColor.getBlue();

            final int[] ii = i;
            final int[] j = {-15};
            timer = new Timer(2, e -> {

                try {
                    ii[1] += j[0];
                    ii[2] += j[0];


                    if (ii[0] < 0 || ii[1] < 0 || ii[2] < 0) {
                        //System.out.println("Switching from -15 to 15");
                        ii[1] += 15;
                        ii[2] += 15;

                        j[0] = 15;
                    } else if (ii[1] > i2 || ii[2] > i3) {
                        ii[1] -= 15;
                        ii[2] -= 15;
                        //System.out.println("Ausgangs RGB überschritten");
                        timer.stop();
                        return;
                    }


                    setBackground(new Color(ii[0], ii[1], ii[2]));
                    //System.out.println(ii[0] + " " + ii[1] + " " + ii[2]);
                } catch (IllegalArgumentException ex) {

                    setBackground(baseColor);
                    timer.stop();
                    return;
                }


            });
            timer.start();
        } else if (!timer.isRunning()) {
            final Color baseColor = getBackground();

            //System.out.println(baseColor.getRed() + " " + baseColor.getGreen() + " " + baseColor.getBlue());
            final int[] i = {baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue()};
            final int i1 = baseColor.getRed();
            final int i2 = baseColor.getGreen();
            final int i3 = baseColor.getBlue();

            final int[] ii = i;
            final int[] j = {-15};
            timer = new Timer(2, e -> {

                try {
                    ii[1] += j[0];
                    ii[2] += j[0];


                    if (ii[0] < 0 || ii[1] < 0 || ii[2] < 0) {
                       // System.out.println("Switching from -15 to 15");
                        ii[1] += 15;
                        ii[2] += 15;

                        j[0] = 15;
                    } else if (ii[1] > i2 || ii[2] > i3) {
                        ii[1] -= 15;
                        ii[2] -= 15;
                        //System.out.println("Ausgangs RGB überschritten");
                        timer.stop();
                        return;
                    }


                    setBackground(new Color(ii[0], ii[1], ii[2]));
                    //System.out.println(ii[0] + " " + ii[1] + " " + ii[2]);
                } catch (IllegalArgumentException ex) {

                    setBackground(baseColor);
                    timer.stop();
                    return;
                }


            });
            timer.start();
        }

    }
    public void stopFlashEffect(){
        timer.stop();

    }
}
