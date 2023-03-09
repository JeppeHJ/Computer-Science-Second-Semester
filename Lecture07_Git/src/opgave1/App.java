package opgave1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<>();

        try {
            File file = new File("Gjøngehøvdingen.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                treeSet.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (String word: treeSet) {
            System.out.println(word);
        }

        System.out.println(treeSet.size());


    }
}
