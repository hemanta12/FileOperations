import java.io.*;
import java.util.*;
public class StudentRecordManager {
    private final String filePath = "students.txt";

    public void addStudents() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter student name: ");
        String name = scanner.nextLine();

        System.out.println("Enter student age: ");
        int age = scanner.nextInt();

        System.out.println("Enter student grade: ");
        scanner.nextLine();
        String grade = scanner.nextLine();

        String studentData = name + ", " + age + ", " + grade;

        try (FileWriter writer = new FileWriter(filePath, true)){
            writer.write(studentData + "\n");
            System.out.println("Student record added.");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void viewStudents(){

    }
    public void updateStudents(){

    }
    public void deleteStudents(){

    }

}