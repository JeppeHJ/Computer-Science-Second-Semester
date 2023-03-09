package opgave31;

import java.util.HashMap;
import java.util.Map;

public class Skole {
    private String name;
    private Map<Integer, Studerende> students;

    public Skole(String name) {
        this.name = name;
        this.students = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addStudent(Studerende student) {
        this.students.put(student.getStudyNumber(), student);

    }

    public void removeStudent(Studerende student) {
        this.students.remove(student.getStudyNumber());

    }

    public double average() {
        int sum = 0;
        for (int studyNumber: this.students.keySet()) {
            for (int grade: this.students.get(studyNumber).getGrades()) {
                sum += grade;
            }
        }

        return 1.0 * sum / this.students.size();

    }

    public Studerende findStudent(int studyNumber) {
        for (int studyNumber2: this.students.keySet()) {
            if (this.students.get(studyNumber2).getStudyNumber() == studyNumber) {
                return this.students.get(studyNumber);

            }

        }
        return null;
    }

    public String toString() {
        return this.name;

    }

}
