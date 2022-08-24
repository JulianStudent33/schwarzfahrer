package src.GUI.elements;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class NumberFilter extends DocumentFilter {

    private int decimalPrecision = 2;
    private boolean allowNegative = false;

    public NumberFilter() {
    }

    public NumberFilter(int decimals, boolean negatives) {
        decimalPrecision = decimals;
        allowNegative = negatives;
    }

    protected boolean accept(FilterBypass fb, int offset, String str) throws BadLocationException {
        boolean accept = true;
        int length = fb.getDocument().getLength();
        String currentText = fb.getDocument().getText(0, length);

        if (str != null) {
            if (!isNumeric(str) && !str.equals(".") && !str.equals("-")) { //First, is it a valid character?
                Toolkit.getDefaultToolkit().beep();
                accept = false;
            } else if (str.equals(".") && currentText.contains(".")) { //Next, can we place a decimal here?
                Toolkit.getDefaultToolkit().beep();
                accept = false;
            } else if (isNumeric(str)
                    && currentText.indexOf(",") != -1
                    && offset > currentText.indexOf(",")
                    && length - currentText.indexOf(".") > decimalPrecision
                    && decimalPrecision > 0) { //Next, do we get past the decimal precision limit?
                Toolkit.getDefaultToolkit().beep();
                accept = false;
            } else if (str.equals("-") && (offset != 0 || !allowNegative)) { //Next, can we put a negative sign?
                Toolkit.getDefaultToolkit().beep();
                accept = false;
            }else if (str.equals(" ")){
                Toolkit.getDefaultToolkit().beep();
                accept = false;
            }
        }
        return accept;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String str, AttributeSet as) throws BadLocationException {
        if (accept(fb, offset, str)) {
            super.insertString(fb, offset, str, as);
        }
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (accept(fb, offset, text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    public boolean isNumeric(String str) {
        try {
            int x = Integer.parseInt(str);

            return true;
        } catch (NumberFormatException nFE) {
            System.out.println("Not an Integer");
            return false;
        }
    }
}