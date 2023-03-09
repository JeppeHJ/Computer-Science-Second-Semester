package opgave1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listBoy = new ArrayList<>();
        listBoy.add(12);
        listBoy.add(2);
        listBoy.add(3);
        listBoy.add(4);
        listBoy.add(5);
        listBoy.add(6);
        listBoy.add(7);
        listBoy.add(14);
        listBoy.add(15);

        System.out.println(ligeTal(listBoy));
        System.out.println(ligeTal2(listBoy));

    }

    public static int ligeTal(ArrayList<Integer> list) {
        int result = 0;
        if (list.size() == 0) {
            result = 0;
        } else {
            if (list.get(0) % 2 == 0) {
                result++;
            }
            list.remove(0);
            result = result + ligeTal(list);
        }
        return result;
    }

    public static int ligeTal2(ArrayList<Integer> list) {
        return ligeTal2(list, 0);
    }

    private static int ligeTal2(ArrayList<Integer> list, int index) {
        // Hvis index er lig med listen størrelse, returneres 0
        if (index == list.size()) {
            return 0;
        }

        // Gemmer det aktuelle tal i listen
        int tal = list.get(index);
        // Tjekker om tallet er et lige tal
        int antal = tal % 2 == 0 ? 1 : 0;

        // Returnerer antallet af lige tal og rekursivt kalder metoden for det næste element i listen
        return antal + ligeTal2(list, index + 1);
    }
}



