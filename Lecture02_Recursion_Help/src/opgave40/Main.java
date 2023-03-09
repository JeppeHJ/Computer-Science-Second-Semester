package opgave40;

public class Main {
    public static void main(String[] args) {
        System.out.println(ackermann(1,3));
    }

    // Formålet med Ackermann-funktionen er at undersøge, hvor hurtigt en funktion kan vokse og vise,
    // at nogle funktioner kan vokse meget hurtigere end andre.

    public static int ackermann(int x, int y) {
        // Termineringsregel 1: Hvis x er 0, returner y + 1
        if (x == 0) {
            return y + 1;
        }
        // Termineringsregel 2: Hvis y er 0, returner resultatet af ackermann(x-1, 1)
        else if (y == 0) {
            return ackermann(x - 1, 1);
        }
        // Rekurrensregel: Returner resultatet af ackermann(x-1, ackermann(x, y-1))
        else {
            return ackermann(x - 1, ackermann(x, y - 1));
        }
    }

    //Husk, at rekursionen vil fortsætte, indtil en termineringsregel opfyldes, dvs. enten x = 0 eller y = 0,
    // og at Ackermann-funktionen er en meget hurtigt voksende funktion, så det er vigtigt at være opmærksom
    // på den maksimale rekursionsdybde, som Java og andre programmeringssprog har, da den hurtigt
    // kan føre til en "Stack Overflow" -fejl.

}
