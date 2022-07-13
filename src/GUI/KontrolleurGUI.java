package src.GUI;

import javax.swing.*;
import org.openide.awt.DropDownButtonFactory;
import src.Foo;
import src.users.Kontrolleur;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KontrolleurGUI extends JFrame implements ActionListener {
    Kontrolleur currentUser;
    private JToolBar konToolBar;
    private JPanel mainPanel;
    private JToggleButton schwarzfahrerSuchenToggleButton;
    private JToggleButton einstellungenToggleButton;
    private JToggleButton profilToggleButton;
    private JToggleButton abmeldenToggleButton;
    private JToggleButton schwarzfahrtErfassenToggleButton;
    private JToggleButton statistikenToggleButton;

    public KontrolleurGUI()  {
        currentUser = Foo.currentKontrolleur;
        setContentPane(mainPanel);
        setTitle("Kontrolleur Menü");
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        int width = 700;
        int height = 600;
        this.setBounds(center.x - width / 2, center.y - height / 2, width, height);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.createLookAndFeel("Windows"));
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        JButton dropDownButton = createDropDownButton();
        konToolBar.add(dropDownButton);
        konToolBar.add(new JSeparator());
        /*
        String text = "Angemeldet als " + currentUser.getBenutzername();
        konToolBar.add(new JLabel(text));
*/


        setVisible(true);

        //Button Funktionen Zuweisungen:

        abmeldenToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                currentUser.abmelden();
                StartFensterGUI.openStartFenster();
            }
        });



    }
    private JButton createDropDownButton(){
        JPopupMenu popupMenu = createDropDownMenu();

        ImageIcon icon = new ImageIcon("icons/Hut.ico");


        JButton dropDownButton = DropDownButtonFactory.createDropDownButton(icon, popupMenu);
        dropDownButton.addActionListener(this);

        return dropDownButton;
    }
    private JPopupMenu createDropDownMenu() {
        JPopupMenu popupMenu = new JPopupMenu();

        JMenuItem menuItemCreateSpringProject = new JMenuItem("Schwarzfahrt erfassen");
        popupMenu.add(menuItemCreateSpringProject);

        JMenuItem menuItemCreateHibernateProject = new JMenuItem("Schwarzfahrer anlegen");
        popupMenu.add(menuItemCreateHibernateProject);

        JMenuItem menuItemCreateStrutsProject = new JMenuItem("Suche starten");
        popupMenu.add(menuItemCreateStrutsProject);

        menuItemCreateSpringProject.addActionListener(this);
        menuItemCreateHibernateProject.addActionListener(this);
        menuItemCreateStrutsProject.addActionListener(this);

        return popupMenu;
    }
    public static void openKonGUI() {
        KontrolleurGUI gui = new KontrolleurGUI();
    }

    public static void main(String[] args) {
        openKonGUI();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        Object source = evt.getSource();
        if (source instanceof JMenuItem) {
            JMenuItem clickedMenuItem = (JMenuItem) source;
            String menuText = clickedMenuItem.getText();
            System.out.println("Create a " + menuText);
        } else if (source instanceof JButton) {
            System.out.println("Create a default project");
        }
    }
}
