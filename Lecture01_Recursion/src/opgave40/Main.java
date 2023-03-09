package opgave40;

public class Main {
    public static void main(String[] args) {
        // Rekursive definition: At reverse en String, s, kan defineres ved følgende rekursive regler:

        // Termineringsregel: Hvis længden af s er 0 eller 1, returneres s uændret.
        // Rekurrensregel: Hvis længden af s er større end 1, returneres den sidste karakter i s,
        // konkatineret med resultatet af at reverse resten af s uden den sidste karakter.
    }
    public static String reverse(String s) {
        // Termineringsregel: Hvis længden af s er 0 eller 1, returneres s uændret.
        if (s.length() <= 1) {
            return s;
        }

        // Rekurrensregel: Hvis længden af s er større end 1, returneres
        // den sidste karakter i s, konkatineret med resultatet af at reverse
        // resten af s uden den sidste karakter.
        else {
            return s.charAt(s.length()-1) + reverse(s.substring(0, s.length()-1));
        }
    }

    //TODO Forklaring:
    // Metoden tjekker først længden af s. Hvis længden er mindre eller lig med 1, returneres s uændret.
    // Hvis længden er større end 1, returneres den sidste karakter i s, konkatineret med resultatet
    // af at reverse resten af s uden den sidste karakter.
    // Dette gentages indtil termineringsreglen opfyldes, og metoden vil returnere den omvendte String.
}
