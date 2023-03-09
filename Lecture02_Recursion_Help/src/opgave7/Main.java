package opgave7;

public class Main {
    public static void main(String[] args) {
        //TODO OPGAVE 7.0
        //tal3 = 2 * tal0 - tal1 = 2 * 2 - 1 = 3
        //tal4 = tal3 + tal2 + 3 * tal1 = 3 + 5 + 3 * 1 = 11
        //tal5 = 2 * tal2 - tal3 = 2 * 5 - 3 = 7
        //tal6 = tal5 + tal4 + 3 * tal3 = 7 + 11 + 3 * 3 = 29
    }

    //TODO OPGAVE 7.1
    public int talN(int n) {
        // Termineringsregel 1: Hvis n er 0, returner 2
        if (n == 0) {
            return 2;
        }
        // Termineringsregel 2: Hvis n er 1, returner 1
        else if (n == 1) {
            return 1;
        }
        // Termineringsregel 3: Hvis n er 2, returner 5
        else if (n == 2) {
            return 5;
        }
        // Rekurrensregel 1: Hvis n er lige, brug første formel til at beregne taln
        else if (n % 2 == 0) {
            return 2 * talN(n - 3) - talN(n - 1);
        }
        // Rekurrensregel 2: Hvis n er ulige, brug anden formel til at beregne taln
        else {
            return talN(n - 1) + talN(n - 2) + 3 * talN(n - 3);
        }
    }

    //TODO OPGAVE 7.2
    public static int talN2(int n) {
        // Termineringsregel: Hvis n er mindre end 0, returneres 0.
        if (n < 0) {
            return 0;
        }

        // Termineringsregel: Hvis n er 0, returneres tal0 (2).
        if (n == 0) {
            return 2;
        }

        // Termineringsregel: Hvis n er 1, returneres tal1 (1).
        if (n == 1) {
            return 1;
        }

        // Termineringsregel: Hvis n er 2, returneres tal2 (5).
        if (n == 2) {
            return 5;
        }

        // Rekurrensregel: Hvis n er lige, returneres 2 * tal(n-3) - tal(n-1).
        if (n % 2 == 0) {
            return 2 * talN2(n - 3) - talN2(n - 1);
        }
        // Rekurrensregel: Hvis n er ulige, returneres tal(n-1) + tal(n-2) + 3 * tal(n-3).
        else {
            return talN2(n - 1) + talN2(n - 2) + 3 * talN2(n - 3);
        }
    }

    //TODO OPGAVE 7.3
    public int talN3 (int n) {
        // Definition af de første tre tal i talfølgen
        int tal0 = 2;
        int tal1 = 1;
        int tal2 = 5;
        int talN = 0;
        // Tjekker om n er 0, 1 eller 2. Hvis det er, returneres det første, andet eller tredje tal i talfølgen.
        if (n == 0) {
            return tal0;
        } else if (n == 1) {
            return tal1;
        } else if (n == 2) {
            return tal2;
        } else {
            // Looper igennem talfølgen fra tal 3 og op til det ønskede tal n.
            for (int i = 3; i <= n; i++) {
                // Tjekker om i er et lige tal.
                if (i % 2 == 0) {
                    // Hvis i er et lige tal, udregnes det næste tal i talfølgen ved hjælp af den formel: taln = 2 * tal(n - 3) - tal(n - 1)
                    talN = 2 * tal2 - tal1;
                } else {
                    // Hvis i er et ulige tal, udregnes det næste tal i talfølgen ved hjælp af den formel: taln = tal(n - 1) + tal(n - 2) + 3 * tal(n - 3)
                    talN = tal1 + tal2 + 3 * tal0;
                }
                // De gamle tal bliver gemt i variablerne tal0, tal1 og tal2 for at kunne bruges i udregningen af det næste tal i talfølgen.
                tal0 = tal1;
                tal1 = tal2;
                tal2 = talN;
            }
            // Det ønskede tal returneres.
            return talN;
        }
    }

    //Fordele ved at bruge den iterative metode:

    //Den iterative metode er ofte hurtigere end den rekursive metode, fordi den ikke skal gemme information
    //om hver iteration i en call-stack.
    //Den iterative metode er mindre tilbøjelig til at føre til stack overflow-fejl
    //end den rekursive metode, fordi den ikke skal huske information om hver iteration i en call-stack.

    //Ulemper ved at bruge den iterative metode:

    //Den iterative metode kan være mere kompleks og sværere at forstå og debugge end den rekursive metode,
    // fordi den skal håndtere information om hver iteration selv, i stedet for at bruge en call-stack.

    //Fordele ved den rekursive metode:
    //Den rekursive metode kan være nemmere at forstå og debugge end den iterative metode, fordi den bruger en
    //mindre kompleks logik. Dette skyldes, at den rekursive metode bruger den naturlige tankegang, hvor vi bruger
    // en mindre opgave til at løse en større opgave.

    //Ulemper ved den rekursive metode:

    //Den rekursive metode er dog ikke så effektiv, da den ofte kræver mere hukommelse end
    //den iterative metode. Dette skyldes, at den rekursive metode gemmer information om hver
    // kald til rekursionen, hvilket resulterer i en højere hukommelsesbrug. Derudover kan den
    // rekursive metode føre til en "stack overflow" fejl, hvis rekursionen går for dybt.
}
