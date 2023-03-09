package opgave31;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;

        System.out.println(search(array, 4));

    }

    //Denne implementering tager et array af heltal array, et tal x der skal søges efter, en left index for at holde styr
    // på venstre grænse af det aktuelle interval, og en right index for at holde styr på højre grænse af det aktuelle
    // interval. I hver iteration af rekursionen beregnes midterste index ved at tage summen af left og right og dividere
    // med to, og derefter tjekker vi, om midterste værdi er lig med x. Hvis det er sandt, returneres true. Hvis midterste
    // værdi er større end x, kaldes rekursivt metoden med right sættes til at være mid - 1, og hvis midterste værdi er
    // mindre end x, kaldes rekursivt metoden med left sættes til at være mid + 1. Hvis left bliver større end right,
    // betyder det at tallet ikke er fundet, og metoden returnerer false.

    public static boolean search(int[] array, int number) {
        return binarySearch(array, number, 0, array.length - 1);
    }
    public static boolean binarySearch(int[] array, int number, int left, int right) {
        if (left > right) {
            return false;
        }
        int middle = (left + right) / 2;
        int k = array[middle];
        if (k == number) {
            return true;
        } else if (k > number) {
            return binarySearch(array, number, left, middle - 1);
        } else {
            return binarySearch(array, number, middle + 1, right);
        }



    }

}
