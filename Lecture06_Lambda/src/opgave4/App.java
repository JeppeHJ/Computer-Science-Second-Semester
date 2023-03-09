package opgave4;

import java.util.List;

public class App {
    public static void main(String[] args) {

    }

    public static int countDelStreng(List<String> list, String sub) {
        int count = 0;  // variabel til at tælle antallet af forekomster af delstrengen
        for (String str : list) {  // loop igennem hver streng i listen
            int index = 0;  // variabel til at holde styr på startindeks for søgning efter delstrengen i strengen str
            while (index != -1) {  // så længe delstrengen sub kan findes i strengen str
                index = str.indexOf(sub, index);  // søg efter delstrengen i strengen str fra indeks index
                if (index != -1) {  // hvis delstrengen sub findes i strengen str
                    count++;  // tæl en forekomst af delstrengen sub
                    index += sub.length();  // spring frem til slutningen af delstrengen sub
                }
            }
        }
        return count;  // returner antallet af forekomster af delstrengen sub i listen
    }

    public static int countDelStreng2(List<String> list, String sub) {
        // Hvis listen er tom, returneres 0
        if (list.isEmpty()) {
            return 0;
        }
        // Tjek om det første element i listen indeholder delstrengen
        int count = countOccurrences(list.get(0), sub);
        // Kald rekursivt metoden med resten af listen og læg resultatet til tælleren
        count += countDelStreng(list.subList(1, list.size()), sub);
        return count;
    }

    // Hjælpemetode til at tælle antallet af forekomster af en delstreng i en streng
    private static int countOccurrences(String str, String sub) {
        int count = 0;
        int index = 0;
        while (index != -1) {
            index = str.indexOf(sub, index);
            if (index != -1) {
                count++;
                index += sub.length();
            }
        }
        return count;
    }

    public static int countDelStreng3(List<String> list, String sub) {
        // Base case: hvis listen er tom, er antallet af forekomster 0
        if (list.isEmpty()) {
            return 0;
        }

        // Del problemet ved at finde antallet af forekomster i første element i listen
        String first = list.get(0);
        int count = countDelStreng3(List.of(first), sub);

        // Kombiner resultatet for første element med resultatet for resten af listen
        List<String> rest = list.subList(1, list.size());
        return count + countDelStreng3(rest, sub);
    }

}
