package opgave31;

public class SecondTask {
    public static void main(String[] args) {
        // Dette er en rekursiv metode til at beregne produktet af to hele tal a og b uden at bruge Java's indbyggede
        // gangeoperation, men ved at fordoble og halvere tal og lægge dem sammen.
        // Metoden tjekker først, om a er lig med nul. Hvis ja, returneres 0 som resultat.
        // Hvis a ikke er lig med nul, tjekker metoden, om a er ulige. Hvis ja, anvendes rekurrensregel 1 og
        // metoden kalder sig selv med argumenterne a-1 og b.

        // Hvis a er lige, anvendes rekurrensregel 2. Her divideres a med 2, og b fordobles. Derefter kalder metoden
        // sig selv med argumenterne a/2 og 2*b.

        // Når termineringsreglen opfyldes, vil metoden returnere resultatet tilbage til den foregående kald
        // til metoden, og så videre, indtil resultatet er blevet beregnet for det oprindelige kald til metoden.

        //TODO SAMMENLIGNING:
        // Sammenligning af antal beregninger i product og productRus afhænger af værdierne af a og b. Generelt vil productRus
        // udføre færre beregninger, da rekurrensregel 2 gør det muligt at dividere a med 2 og fordoble b
        // ved hvert kald til metoden, hvilket resulterer i en hurtigere konvergens til en termineringsregel.

    }
    public static int productRus(int a, int b) {
        // Termineringsregel: a * b = 0, a = 0
        if (a == 0) {
            return 0;
        }

        // Rekurrensregel: a * b = (a-1)*b + b, a >= 1 og a er ulige
        else if (a % 2 == 1) {
            return productRus(a-1, b) + b;
        }

        // Rekurrensregel: a * b = (a div 2)*(2*b), a > 1 og a er lige
        else {
            int c = productRus(a/2, 2*b);
            return c;
        }
    }

}
