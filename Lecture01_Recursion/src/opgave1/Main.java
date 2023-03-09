package opgave1;

public class Main {
    public static void main(String[] args) {
        //TODO OPGAVE1
        //Skriv en rekursiv metode, der beregner n!, n>=0.
        //Termineringsregel: n! = 1, n = 0
        //Rekurrensregel: n! = n*(n-1)!, n>0
    }
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }


    }

