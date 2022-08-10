package src.GUI.elements;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class PlaceholderTextField extends JTextField {

    public static void main(final String[] args) {
        final PlaceholderTextField tf = new PlaceholderTextField("");
        tf.setColumns(20);
        tf.setPlaceholder("All your base are belong to us!");
        final Font f = tf.getFont();
        tf.setFont(new Font(f.getName(), f.getStyle(), 30));
        JOptionPane.showMessageDialog(null, tf);
    }

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
        g.setColor(new Color(104,104,104));
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
                .getMaxAscent() + getInsets().top);
    }

    public void setPlaceholder(final String s) {
        placeholder = s;
    }

    public void addFlashEffect(){
        final Color baseColor = getBackground();

        System.out.println(baseColor.getRed() + " " + baseColor.getGreen() + " " + baseColor.getBlue());
        final int[] i = {baseColor.getRed(), baseColor.getGreen(), baseColor.getBlue()};
        final int[] ii = i;
        final int[] j = {15};
        Timer timer = new Timer(2, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try{
                    ii[0] += j[0];
                    ii[1] += j[0];
                    ii[2] += j[0];

                    if(ii[0] > 255 || ii[1] > 255 || ii[2] > 255) {

                        ii[0] -= 15;
                        ii[1] -= 15;
                        ii[2] -= 15;
                        j[0] = -15;
                    }else if(ii[0] < i[0] || ii[1] < i[1] || ii[2] < i[2]){
                        ii[0] += 15;
                        ii[1] += 15;
                        ii[2] += 15;
                        System.out.println("Kleiner als");
                        return;
                    }


                    setBackground(new Color(ii[0], ii[1], ii[2]));
                    System.out.println(ii[0] + " " + ii[1] + " " + ii[2]);
                }catch (IllegalArgumentException ex){

                    setBackground(baseColor);

                    return;
                }


            }
        });
        timer.start();

    }

}
