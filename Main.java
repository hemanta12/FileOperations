import java.util.Scanner;
public class Main{
    public static void main(String []args){
        StudentRecordManager manager = new StudentRecordManager();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("*************************");
            System.out.println("Menu:");
            System.out.println("\t\t\t\t\t");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.println("*************************");


            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1:
                    manager.addStudents();
                    break;
                case 2:
                    manager.viewStudents();
                    break;
                case 3:
                    manager.updateStudents();
                    break;
                case 4:
                    manager.deleteStudents();
                    break;
                case 5:
                    System.out.println("Exiting the program...");
                   System.exit(0);
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}