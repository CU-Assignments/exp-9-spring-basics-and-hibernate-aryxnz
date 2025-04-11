// Student.java
public class Student {
    private String name;
    private Course course;

    public Student(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Course Details: " + course);
    }
}
