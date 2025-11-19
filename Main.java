import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        CounsellingService service = new CounsellingService();

        service.loadFromFile();

        while (true) {
            System.out.println("\n=== Student Career Counselling System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Career Suggestion");
            System.out.println("5. Save & Exit");
            System.out.print("Enter choice: ");

            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();
                    System.out.print("Enter Interest: ");
                    String interest = sc.next();
                    service.addStudent(new Student(id, name, marks, interest));
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();
                    Student s = service.search(sid);
                    System.out.println(s != null ? s : "Not Found");
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    int cid = sc.nextInt();
                    Student st = service.search(cid);
                    if (st != null) {
                        String suggestion = service.suggestCareer(st);
                        System.out.println("Career Suggestion: " + suggestion);
                    } else {
                        System.out.println("Student Not Found!");
                    }
                    break;

                case 5:
                    service.saveToFile();
                    System.out.println("Saved! Exiting...");
                    System.exit(0);
            }
        }
    }
}