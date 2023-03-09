package opgave2;

public class Main {
    public static void main(String[] args) {
        //Skriv en rekursiv metode public static int power(int n, int p) der beregner np p>=0.

        //Termineringsregel: np = 1, p=0
        //Rekurrensregel: np = np-1*n, p>0
    }

    public static int power(int n, int p) {
        // Termineringsregel: np = 1, p=0
        if (p == 0) return 1;
        // Rekurrensregel: np = np-1*n, p>0
        return power(n, p - 1) * n;
    }

    public static int power2(int n, int p) {
        // Termineringsregel: np = 1, p=0
        if (p == 0) return 1;

        // Rekurrensregel: np = np-1*n, p>0 og p er ulige
        if (p % 2 != 0) return power2(n, p - 1) * n;

        // Rekurrensregel: np = (n^2)p/2, p>0 og p er lige
        int subResult = power2(n, p / 2);
        return subResult * subResult;
    }
}
