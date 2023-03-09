package opgave2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println(palindrom("abba"));

    }

    public static boolean palindrom(String tekst) {
        return palindrom(tekst, 0, tekst.length() - 1);
    }

    private static boolean palindrom(String tekst, int startIndex, int endIndex) {
        // Basis tilfælde: Hvis start og slutindex mødes eller overskrider hinanden, er teksten et palindrom
        if (startIndex >= endIndex) {
            return true;
        }
        // Tjekker om de aktuelle tegn på start- og endIndex matcher
        if (tekst.charAt(startIndex) != tekst.charAt(endIndex)) {
            return false;
        }
        // Rekursivt kalder metoden for det næste tegn i begge retninger
        return palindrom(tekst, startIndex + 1, endIndex - 1);
    }




}
