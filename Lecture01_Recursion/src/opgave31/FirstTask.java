package opgave31;

public class FirstTask {
    public static void main(String[] args) {
        //TODO OPGAVE 3
        //Skriv en rekursiv metode public static int product(int a, int b) der beregner a*b hvor a og b er to hele tal
        //større end eller lig med nul.  Metoden skal anvendedefinitionen

        //Termineringsregel: a * b = 0, a = 0
        //Rekurrensregel: a * b = (a-1)*b + b, a>1
    }

    // Metoden tjekker først, om a er lig med nul. Hvis ja, returneres 0 som resultat.
    // Hvis a ikke er lig med nul, tjekker metoden, om a er lig med 1. Hvis ja, returneres b som resultat.
    // Hvis ingen af de ovennævnte tilfælde er sande, anvendes rekurrensreglen og metoden kalder sig selv
    // med argumenterne a-1 og b. Dette vil fortsætte indtil enten termineringsregel 1 eller termineringsregel 2 er opfyldt.
    // Når dette sker, vil metoden returnere resultatet tilbage til den foregående kald til metoden, og så videre,
    // indtil resultatet er blevet beregnet for det oprindelige kald til metoden.
    public static int product(int a, int b) {
        // Termineringsregel: a * b = 0, a = 0
        if (a == 0) {
            return 0;
        }

        // Termineringsregel: a * b = b, a = 1
        else if (a == 1) {
            return b;
        }

        // Rekurrensregel: a * b = (a-1)*b + b, a > 1
        else {
            return product(a-1, b) + b;
        }
    }
}
