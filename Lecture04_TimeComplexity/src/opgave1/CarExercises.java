package opgave1;

public class CarExercises {
        //TODO OPGAVE 1:
        boolean IsStringHello(String[] strings, String string) {
            if (string.equals("Hello")) {
                return true;
            }
            return false;
        }

        //O(1) fordi den enten vurderer, at string equals "Hello" eller ej.

        //TODO OPGAVE 2:
        boolean checkString(String[] strings, String st) {
            for (int i = 0; i < strings.length; i++) {
                if (strings[i] == st) {
                    return true;
                }
            }
            return false;
        }

        //O(n) hvor n er længden af strings Arrayet. Det er en linear funktion.

        //TODO OPGAVE 3:
        /*for (int pass = 1; pass <= n; pass++) {
             for (int index = 0; index < n; index++) {
                for (int count = 1; count < 10; count++)

        Den er O(n^3).
        Vi har 3 nested loops. Første loop kører n mængde gange.
        Næste loop kører n mængde gange.
        Og sidste loop kører 9 gange.
        Ergo kan vi sige n * n * 9, hvilket er det samme som O(n^3)

        //TODO OPGAVE 4:
        Med n i stedet for 10, så bliver det blot n * n * (n-1)
        Og dermed er det stadig O(n^3)

        //TODO OPGAVE 5:
        Out loop kører n-1 gange
        Kalder en metode med et loop, der kører n gange.
        Dermed er den O(n^2).
        Der er ikke nogle best/worst case scenarios.
        */
        public static void method(int[] array, int n) {
            for (int index = 0; index < n - 1; index++) {
                int mark = privateMethod(array, index, n - 1);
                int temp = array[index];
                array[index] = array[mark];
                array[mark] = temp;
            }
        }
        public static int privateMethod(int[] array, int first, int last) {
            int min = array[first];
            int indexOfMin = first;
            for (int index = first + 1; index <= last; index++) {
                if (array[index] < min) {
                    min = array[index];
                    indexOfMin = index;
                }
            }
            return indexOfMin;
        }
}
