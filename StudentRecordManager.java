import java.io.*;
import java.util.*;
public class StudentRecordManager {
    private final String filePath = "students.txt";

    public void addStudents() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("*************************");
        System.out.println("\t\t\t\t");
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
            System.out.println("--------------------------");
            System.out.println("Student record added.");
            System.out.println("--------------------------");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void viewStudents(){
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            System.out.println("*************************");
            System.out.println("\t\t\t\t");
            System.out.println("List of students:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void updateStudents(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("*************************");
        System.out.println("\t\t\t\t");
        System.out.println("Enter the name of the student you want to update: ");
        String searchName = scanner.nextLine();

        System.out.println("Enter the new age: ");
        int newAge = scanner.nextInt();

        System.out.println("Enter the new grade: ");
        scanner.nextLine();
        String newGrade = scanner.nextLine();

        String newDetails = searchName+ ", "+ newAge + ", "+ newGrade;

        List<String> lines = new ArrayList<>();
        boolean updated = false;

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            while ((line = reader.readLine()) != null){
                if (line.contains(searchName)){
                    lines.add(newDetails);
                    updated = true;
                }
                else{
                    lines.add(line);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        if (updated){
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath)) ){
                for (String updateLine: lines){
                    writer.write(updateLine);
                    writer.newLine();
                }
                System.out.println("------------------------------");
                System.out.println("Student record updated successfully.");
                System.out.println("------------------------------");

            }catch (IOException e){
                e.printStackTrace();
            }
        } else {
            System.out.println("------------------------------");
            System.out.println("Student not found.");
            System.out.println("------------------------------");

        }
    }
    public void deleteStudents() {

        Scanner sc = new Scanner(System.in);

        System.out.println("*************************");
        System.out.println("\t\t\t\t");
        System.out.println("Enter the name of the student you want to delete.");
        String searchName = sc.nextLine();

        List<String> lines = new ArrayList<>();
        boolean found = false;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains(searchName)) {
                    lines.add(line);
                } else {
                    found = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (found) {
            try (BufferedWriter wr = new BufferedWriter(new FileWriter(filePath))) {
                for (String updatedLine : lines) {
                    wr.write(updatedLine);
                    wr.newLine();
                }
                System.out.println("------------------------------");
                System.out.println("Student record deleted successfully.");
                System.out.println("------------------------------");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("------------------------------");
            System.out.println("Student not found");
            System.out.println("------------------------------");

        }
    }
}