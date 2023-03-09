package opgave31;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Studerende implements Comparable<Studerende> {
    private int studyNumber;
    private String name;
    private List<Integer> grades;

    public Studerende(int studyNumber, String name) {
        this.studyNumber = studyNumber;
        this.name = name;
        this.grades = new LinkedList<>();
    }

    public int getStudyNumber() {
        return studyNumber;
    }

    public List<Integer> getGrades() {
        return grades;
    }

    public void addGrade(int grade) {
        this.grades.add(grade);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(Studerende other) {
        return Integer.compare(this.studyNumber, other.studyNumber);
    }
}

