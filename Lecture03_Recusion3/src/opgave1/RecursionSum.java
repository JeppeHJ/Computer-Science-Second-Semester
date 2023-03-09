package opgave1;

import java.util.ArrayList;

public class RecursionSum {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);
        numbers.add(8);

        System.out.println(sum(numbers));

    }

    public static int sum(ArrayList<Integer> list) {

        return summation(list, 0, list.size() - 1);
    }

    private static int summation(ArrayList<Integer> list, int l, int h) {
        int sum = 0;
        // Termineringsregel: Hvis l og h er ens, er vi nået til sidste element
        if (l == h) {
            return list.get(l);
        // Rekurrensregel
        } else {
            int m = (l + h) / 2;
            int sum1 = summation(list, l, m);
            int sum2 = summation(list, m + 1, h);
            return sum1 + sum2;
            }
        }
    }

