package opgave5;

public class Main {
    public static void main(String[] args) {
        System.out.println(binomial(0, 0)); // Output: 1
        System.out.println(binomial(1, 0)); // Output: 1
        System.out.println(binomial(1, 1)); // Output: 1
        System.out.println(binomial(2, 2)); // Output: 1
        System.out.println(binomial(2, 1)); // Output: 2
        System.out.println(binomial(3, 2)); // Output: 3
        System.out.println(binomial(7, 4)); // Output: 35
    }

    //Binomialkoefficienten er en slags tal, vi bruger til at regne ud, hvor mange måder vi kan vælge en bestemt antal
    // ting ud af en større samling ting. Lad os sige, at vi har en samling af bamser. Vi vil gerne vide, hvor mange måder
    // vi kan vælge 3 bamser ud af samlingen. Binomialkoefficienten hjælper os med at besvare dette spørgsmål.

    //TODO Termineringsregel #1: "Kn,m = 1, m = 0"
    // siger, at hvis m er lig med 0, skal resultatet af binomialkoefficienten
    // være 1. Dette skyldes, at hvis vi har en samling på størrelse n, og vi vil finde antallet af mulige kombinationer
    // af størrelse 0, vil der kun være én mulig kombination: en tom samling. Således er binomialkoefficienten C(n, 0)
    // altid lig med 1.

    //TODO Termineringsregel #2: "Kn,m = 1, m = n"
    // siger, at hvis m er lig med n, skal resultatet af binomialkoefficienten
    // være 1. Dette skyldes, at hvis vi har en samling på størrelse n, og vi vil finde antallet af mulige kombinationer
    // af størrelse n, vil der kun være én mulig kombination: hele samlingen

    public static int binomial(int n, int m) {
        // Termineringsregel: Kn,m = 1, m = 0
        if (m == 0) {
            return 1;
        }
        // Termineringsregel: Kn,m = 1, m = n
        if (m == n) {
            return 1;
        }
        // Rekurrensregel: Kn,m = Kn-1,m + Kn-1,m-1, 0<m<n
        return binomial(n - 1, m) + binomial(n - 1, m - 1);
    }
}