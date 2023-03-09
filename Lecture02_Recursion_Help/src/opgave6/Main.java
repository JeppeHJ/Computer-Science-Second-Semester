package opgave6;

public class Main {
    public static void main(String[] args) {
        int n = 3;
        solveTowersOfHanoi(n, 'A', 'C', 'B');
        System.out.println("Antal flytninger: " + moveCount);

        //TODO Antallet af flytninger til at løse Towers of Hanoi for et givet antal ringe n kan beregnes ved at
        // bruge følgende formel:
        // T(n) = 2^n - 1
        // Følgende er antal flytninger for hvert af de angivne antal ringe:
        // 2 ringe: T(2) = 2^2 - 1 = 3 flytninger
        // 3 ringe: T(3) = 2^3 - 1 = 7 flytninger
        // 4 ringe: T(4) = 2^4 - 1 = 15 flytninger
        // 5 ringe: T(5) = 2^5 - 1 = 31 flytninger
        // 6 ringe: T(6) = 2^6 - 1 = 63 flytninger
        // 7 ringe: T(7) = 2^7 - 1 = 127 flytninger
        // 8 ringe: T(8) = 2^8 - 1 = 255 flytninger
        // 9 ringe: T(9) = 2^9 - 1 = 511 flytninger
        // 10 ringe: T(10) = 2^10 - 1 = 1023 flytninger
        // 15 ringe: T(15) = 2^15 - 1 = 32767 flytninger
        // 20 ringe: T(20) = 2^20 - 1 = 1048576 flytninger
        // 25 ringe: T(25) = 2^25 - 1 = 33,554,431 flytninger
    }

    private static int moveCount = 0;

    // Rekurrensregel: Flytte topringen fra den ene stang til en anden, indtil alle ringene er på destinationstangen.
    public static void solveTowersOfHanoi(int n, char from, char to, char aux) {
        // Termineringsregel: Når der ikke er flere ringe på startstangen, har vi nået vores mål.
        if (n == 1) {
            System.out.println("Flyt ring 1 fra " + from + " til " + to);
            moveCount++;
            return;
        }

        // Rekursivt flytte n-1 ringe til den midlertidige stang, så topringen kan blive flyttet til destinationstangen.
        solveTowersOfHanoi(n - 1, from, aux, to);
        System.out.println("Flyt ring " + n + " fra " + from + " til " + to);
        moveCount++;
        // Rekursivt flytte n-1 ringe tilbage til destinationstangen.
        solveTowersOfHanoi(n - 1, aux, to, from);
    }

    //TODO

}







