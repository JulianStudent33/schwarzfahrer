package src;

import javax.swing.*;

public class pass {
    private static boolean containsUpperCase;

    public static void main(String[] args) {

        passwordinput();
        }

    public static String passwordinput(){
        String input = JOptionPane.showInputDialog("Wähle dein Passwort");
        if(input == null){
            System.out.println("Cancelled.");
            System.exit(1);
        }
        if (passwordOk(input) == false){
            System.out.println("Passwort ungueltig! \n Password muss enthalten: \n 6-10 zeichen \n Mindestens 1 Großbuchstabe \n Mindestens 1 Kleinbuchstabe \n Mindestens eine Zahl");
            passwordinput();
        }else{
            System.out.println("Passwort gesetzt");
        }
        return input;
    }
    public static boolean passwordOk(String password){
        if (password == null) return false;
        if (password.length() < 6 || password.length() > 15) return false;
        boolean containsUpperCase = false;
        boolean containsLowerCase = false;
        boolean containsDigit = false;
        for(char ch: password.toCharArray()){
            if(Character.isUpperCase(ch)) containsUpperCase = true;
            if(Character.isLowerCase(ch)) containsLowerCase = true;
            if(Character.isDigit(ch)) containsDigit = true;
        }
        return containsUpperCase && containsLowerCase && containsDigit;
    }
}
