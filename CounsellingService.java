import java.io.*;
import java.util.*;

public class CounsellingService {

    ArrayList<Student> list = new ArrayList<>();

    public void addStudent(Student s) {
        list.add(s);
    }

    public void viewStudents() {
        for (Student s : list) {
            System.out.println(s);
        }
    }

    public Student search(int id) {
        for (Student s : list) {
            if (s.getId() == id)
                return s;
        }
        return null;
    }

    public String suggestCareer(Student s) {
        int marks = s.getMarks();
        String interest = s.getInterest().toLowerCase();

        if (marks >= 80) {
            if (interest.contains("coding"))
                return "Software Developer / Full Stack Engineer";
            if (interest.contains("medical"))
                return "MBBS / BDS / Nursing";
            if (interest.contains("commerce"))
                return "CA / B.Com / Banking";
        } else if (marks >= 60) {
            if (interest.contains("coding"))
                return "BCA / BSc Computer Science / Testing";
            if (interest.contains("design"))
                return "UI/UX Designer / Graphic Designer";
        } else {
            return "Diploma / Polytechnic / Vocational Course";
        }

        return "General Degree Courses (BA/BSc/BCom)";
    }

    public void saveToFile() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.txt"));
        for (Student s : list) {
            bw.write(s.toString());
            bw.newLine();
        }
        bw.close();
    }

    public void loadFromFile() throws Exception {
        File f = new File("students.txt");
        if (!f.exists())
            return;

        BufferedReader br = new BufferedReader(new FileReader(f));
        String line;
        while ((line = br.readLine()) != null) {
            String[] arr = line.split(",");
            Student s = new Student(
                Integer.parseInt(arr[0]),
                arr[1],
                Integer.parseInt(arr[2]),
                arr[3]
            );
            list.add(s);
        }
        br.close();
    }
}