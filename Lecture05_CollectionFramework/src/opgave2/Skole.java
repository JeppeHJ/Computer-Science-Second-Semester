package opgave2;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Skole {
    private String name;
    private List<Studerende> students;

    public Skole(String name) {
        this.name = name;
        this.students = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Studerende student) {
        this.students.add(student);

    }

    public void removeStudent(Studerende student) {
        this.students.remove(student);

    }

    public double average() {
        int sum = 0;
        for (Studerende student: this.students) {
            for (int grade: student.getGrades()) {
                sum += grade;
            }
        }

        return 1.0 * sum / this.students.size();

    }

    public Studerende findStudent(int studyNumber) {
        for (Studerende student: this.students) {
            if (student.getStudyNumber() == studyNumber) {
                return student;

            }

        }
        return null;
    }

    public String toString() {
        return this.name;

    }

}
