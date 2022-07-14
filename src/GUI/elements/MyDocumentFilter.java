package src.GUI.elements;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class MyDocumentFilter extends DocumentFilter {
    public void insertString(DocumentFilter.FilterBypass fb, int offset,
                             String text, AttributeSet attr)
            throws BadLocationException {
        StringBuilder buffer = new StringBuilder(text.length());
        for (int i = buffer.length() - 1; i >= 0; i--) {
            char ch = buffer.charAt(i);
            if (ch == '0' || ch == '1' || ch == '2' || ch == '3' || ch == '4'|| ch == '5'|| ch == '6' || ch == '7' || ch == '8' || ch == '9') {
                buffer.append(ch);
            }
        }
        super.insertString(fb, offset, buffer.toString(), attr);
    }

    @Override
    public void replace(DocumentFilter.FilterBypass fb,
                        int offset, int length, String string, AttributeSet attr) throws BadLocationException {
        if (length > 0) {
            fb.remove(offset, length);
        }
        insertString(fb, offset, string, attr);
    }

}