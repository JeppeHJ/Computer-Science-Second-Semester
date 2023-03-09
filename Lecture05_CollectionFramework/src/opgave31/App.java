package opgave31;

import java.util.TreeSet;

public class App {
    public static void main(String[] args) {
        Skole skole = new Skole("My School");
        TreeSet<Studerende> studentsByName = new TreeSet<>(new StuderendeComparator());
        studentsByName.add(new Studerende(123, "Alice"));
        studentsByName.add(new Studerende(456, "Bob"));
        studentsByName.add(new Studerende(789, "Charlie"));
        System.out.println(studentsByName);
    }
}
