package opgave1;

import java.util.HashSet;
import java.util.Set;

public class opgave1 {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        s.add(34);
        s.add(12);
        s.add(23);
        s.add(45);
        s.add(67);
        s.add(34);
        s.add(98);
        System.out.println(s);
        s.add(23);
        System.out.println(s);
        s.remove(67);
        System.out.println(s);
        System.out.println(s.contains(67));
        System.out.println(s.size());


    }
}
