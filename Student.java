public class Student {
    private int id;
    private String name;
    private int marks;
    private String interest;

    public Student(int id, String name, int marks, String interest) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.interest = interest;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getMarks() { return marks; }
    public String getInterest() { return interest; }

    public void setMarks(int marks) { this.marks = marks; }
    public void setInterest(String interest) { this.interest = interest; }

    @Override
    public String toString() {
        return id + "," + name + "," + marks + "," + interest;
    }
}