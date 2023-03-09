package opgave31;

import java.util.ArrayList;
import java.util.Arrays;

public class FletSortHole {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(8, 56, 45, 34, 15, 12, 34, 44));
        System.out.println(list);
        fletteSort(list);
        System.out.println(list);
    }


    // den metode der saetter fletningen i gang
    public static void fletteSort(ArrayList<Integer> list) {
        mergesort(list, 0, list.size() - 1);
    }

    // den rekursive metode der implementere del-loes og kombiner skabelonen
    private static void mergesort(ArrayList<Integer> list, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergesort(list, l, m);
            mergesort(list, m + 1, h);
            merge(list, l, m, h);
        }
    }

    // kombiner er realiseret ved fletteskabelonen
    private static void merge(ArrayList<Integer> list, int low, int middle, int high) {
        // Opretter en midlertidig liste til at gemme sorteringsresultaterne
        ArrayList<Integer> temp = new ArrayList<Integer>();

        // Indeksene til de to dele af listen, der skal sorteres og samles
        int i = low;
        int j = middle + 1;

        // Indeks til den midlertidige liste
        int k = 0;

        // Sammenligner elementerne i de to dele af listen og gemmer de mindste i den midlertidige liste
        while (i <= middle && j <= high) {
            if (list.get(i) <= list.get(j)) {
                temp.add(k, list.get(i));
                i++;
            } else {
                temp.add(k, list.get(j));
                j++;
            }
            k++;
        }

        // Tilsætter eventuelle resterende elementer fra den ene del af listen til den midlertidige liste
        while (i <= middle) {
            temp.add(k, list.get(i));
            i++;
            k++;
        }

        while (j <= high) {
            temp.add(k, list.get(j));
            j++;
            k++;
        }

        // Kopierer de sorterede elementer fra den midlertidige liste tilbage til den oprindelige liste
        for (i = low, k = 0; i <= high; i++, k++) {
            list.set(i, temp.get(k));
        }

        //For-løkken begynder med i = low og k = 0. Det betyder, at den begynder med at kopiere elementer fra den
        // midlertidige liste tilbage til den første position i den oprindelige liste, og den begynder med at hente
        // elementer fra den første position i den midlertidige liste.

        //For-løkken kører så længe i <= high, hvilket betyder, at den kører så længe vi stadig har elementer at
        // kopiere tilbage til den oprindelige liste.
    }
}
