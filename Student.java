import java.util.List;

public class Student
{
    private String name;
    private List<String> courses;

    public Student(String name, List<String> courses)
    {
        this.name = name;
        this.courses = courses;
    }

    public String getName()
    {
        return this.name;
    }

    public List<String> getCourses()
    {
        return this.courses;
    }

    @Override
    public String toString()
    {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}