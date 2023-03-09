package opgave5;

public class Main {
    public static void main(String[] args) {
        // Rekursionen vil fortsætte indtil den opfylder termineringsreglen, hvilket betyder at b bliver returneret,
        // da det er den største fælles divisor. Dette sker fordi for hver iteration bliver a reduceret
        // til resten af a divideret med b, indtil a er mindre end eller lig med b, og b er den største fælles divisor.

    }
    public static int sfd(int a, int b) {
        // Termineringsregel: Hvis b er mindre end eller lig med a og b går op i a, returner b
        if (b <= a && a % b == 0) {
            return b;
        }
        // Rekurrensregel 1: Hvis a er større end b, kør sfd med byttet om på a og b
        else if (a < b) {
            return sfd(b, a);
        }
        // Rekurrensregel 2: Ellers, kør sfd med b og a modulo b
        else {
            return sfd(b, a % b);
        }
    }
}
