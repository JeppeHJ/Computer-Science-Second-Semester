package opgave2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        try {
            File file = new File("Gjøngehøvdingen.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNext()) {
                String word = scanner.next().replaceAll("[^a-zA-ZæøåÆØÅ]", "");
                if (!word.isEmpty()) {
                    if (!hashMap.containsKey(word)) {
                        hashMap.put(word, 1);
                    } else {
                        int count = hashMap.get(word);
                        hashMap.replace(word, count, count + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Create TreeMap and pass in the HashMap
        TreeMap<String, Integer> sortedMap = new TreeMap<>(hashMap);

        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}