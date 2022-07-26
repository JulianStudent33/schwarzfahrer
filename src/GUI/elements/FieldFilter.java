package src.GUI.elements;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FieldFilter {


    public FieldFilter() {
        /*
        JTextField field = new JTextField();
        field.setPreferredSize(new Dimension(300, 300));
        JFrame frame = new JFrame();
        frame.setLayout(new GridBagLayout());
        frame.setSize(300, 300);
        field = createFilteredField();
        frame.add(field);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        */
    }

    public JTextField createFilteredField(int maxCharacters) {
        JTextField field = new JTextField();
        AbstractDocument document = (AbstractDocument) field.getDocument();

        document.setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offs, int length,
                                String str, AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if ((fb.getDocument().getLength() + str.length() - length) <= maxCharacters
                        && text.matches("^[0-9]+[.]?[0-9]{0,1}$")) {
                    super.replace(fb, offs, length, str, a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }

            public void insertString(FilterBypass fb, int offs, String str,
                                     AttributeSet a) throws BadLocationException {

                String text = fb.getDocument().getText(0,
                        fb.getDocument().getLength());
                text += str;
                if ((fb.getDocument().getLength() + str.length()) <= maxCharacters
                        && text.matches("^[0-9]+[.]?[0-9]{0,1}$")) {
                    super.insertString(fb, offs, str, a);
                } else {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        return field;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FieldFilter();
            }
        });



    }}
