package opgave31;

import java.util.Comparator;

public class StuderendeComparator implements Comparator<Studerende> {
    @Override
    public int compare(Studerende student1, Studerende student2) {
        return student1.getName().compareTo(student2.getName());
    }
}
