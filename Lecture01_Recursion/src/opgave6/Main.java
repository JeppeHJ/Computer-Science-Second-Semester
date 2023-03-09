package opgave6;

public class Main {
    public static void main(String[] args) {
        //Antallet af måder, hvorpå en n-strimmel kan dækkes af dominobrikker, kan udtrykkes som en rekursiv formel:

        //Termineringsregel: n = 0 eller n = 1, returner n.
        //Rekurrensregel: n = n-1 + n-2, n > 1
    }
    public static int dominos(int n) {
        // Termineringsregel: Hvis n er 0 eller 1, returner n
        if (n == 0 || n == 1) {
            return n;
        }
        // Rekurrensregel: Returner resultatet af rekursionen af n-1 og n-2
        else {
            return dominos(n - 1) + dominos(n - 2);
        }
    }

    //Rekursionen vil fortsætte indtil den opfylder termineringsreglen, hvilket betyder at enten 0 eller 1
    // bliver returneret afhængigt af input. Dette sker fordi formlen udtrykker antallet af måder, hvorpå
    // en n-strimmel kan dækkes af dominobrikker, og n reduceres til enten 0 eller 1 i hver iteration,
    // hvor vi tæller antallet af måder for n-1 og n-2.
}
