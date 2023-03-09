package opgave2;

import java.util.ArrayList;

public class RecursionZero {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(0);
        numbers.add(0);
        numbers.add(4);
        numbers.add(5);
        numbers.add(0);
        numbers.add(0);
        numbers.add(8);

        System.out.println(zero(numbers));

    }

    public static int zero(ArrayList<Integer> list) {
        // Kald den rekursive metode og angiv lave- og højgrænser
        return countZero(list, 0, list.size() - 1);
    }

    private static int countZero(ArrayList<Integer> list, int l, int h) {
        // Termineringsregel: Hvis l og h er ens, returner 1 hvis elementet på indexet er 0, ellers returner 0
        if (l == h) {
            return list.get(l) == 0 ? 1 : 0;
        } else {
            // Find midterpunktet af listen
            int m = (l + h) / 2;
            // Kald rekursivt på den første halvdel af listen
            int sum1 = countZero(list, l, m);
            // Kald rekursivt på den anden halvdel af listen
            int sum2 = countZero(list, m + 1, h);
            // Returner summen af resultaterne fra begge halvdele
            return sum1 + sum2;
        }
    }
}
