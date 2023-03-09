package opgave22;

public class App {
    public static void main(String[] args) {
        Skole skole = new Skole("My School");

        // Create some students
        Studerende student1 = new Studerende(12345, "Alice");
        student1.addGrade(7);
        student1.addGrade(10);

        Studerende student2 = new Studerende(54321, "Bob");
        student2.addGrade(4);
        student2.addGrade(7);

        Studerende student3 = new Studerende(67890, "Charlie");
        student3.addGrade(12);
        student3.addGrade(10);

        // Add the students to the school
        skole.addStudent(student1);
        skole.addStudent(student2);
        skole.addStudent(student3);

        // Test the average method
        System.out.println("Average grade: " + skole.average());

        // Test the findStudent method
        Studerende foundStudent = skole.findStudent(12345);
        if (foundStudent != null) {
            System.out.println("Found student: " + foundStudent);
        } else {
            System.out.println("Student not found.");
        }

        // Test the removeStudent method
        skole.removeStudent(student2);
        }
    }
