import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("********************");
        System.out.println("Задача 1");
        System.out.println("********************");
        List<Integer> list = Arrays.asList(1, -4, 2, -6, 4, -1, 3, 0, 4, 9, 7);
        System.out.println(list);
        int sum = list.stream()
                  .filter((x) -> x % 2 != 0)
                  .map((x) -> x * x)
                  .reduce((x, y) -> x + y).get();
        System.out.println(sum);

        System.out.println("********************");
        System.out.println("Задача 2");
        System.out.println("********************");
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student("Иван", Arrays.asList("Программирование на Java", "Линейная алгебра", "Физика")));
        students.add(new Student("Екатерина", Arrays.asList("Программирование на C#", "Math")));
        students.add(new Student("Николай", Arrays.asList("Программирование на Java", "Math")));
        students.add(new Student("Антон", Arrays.asList("Программирование на Java", "Программирование на C#", "Физика")));
        students.add(new Student("Максим", Arrays.asList("Линейная алгебра", "Физика", "Math")));
        students.add(new Student("Иван", Arrays.asList("Программирование на Java", "Линейная алгебра", "Физика")));
        System.out.println(students);
        System.out.println("Студенты, записанные на курс \"Math\":");
        students.stream()
                .filter((student) -> student.getCourses().contains("Math"))
                .forEach((student) -> System.out.println(student.getName()));
        System.out.println("Студент, записанный на наибольшее количество курсов:");
        System.out.println(
            students.stream()
                    .max((a, b) -> a.getCourses().size() - b.getCourses().size())
                    .map(Student::getName)
                    .get()
        );
        System.out.println("Список всех курсов, на которые записаны студенты:");
        List<String> courses = students.stream()
                                       .map(Student::getCourses)
                                       .flatMap(Collection::stream)
                                       .distinct()
                                       .collect(Collectors.toList());
        System.out.println(courses);
        System.out.println("Студент, записанный на наименьшее количество курсов:");
        System.out.println(
                students.stream()
                        .min((a, b) -> a.getCourses().size() - b.getCourses().size())
                        .map(Student::getName)
                        .get()
        );
    }
}