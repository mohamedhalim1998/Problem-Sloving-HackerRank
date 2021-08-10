import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HR_JavaPriorityQueue {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();
        System.out.println(Double.compare(3.6, 3.7));
        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st : students) {
                System.out.println(st.getName());
            }
        }
    }

    static class Student implements Comparable<Student> {
        int id;
        String name;
        double cgpa;

        public Student(int id, String name, double cgpa) {
            this.id = id;
            this.name = name;
            this.cgpa = cgpa;
        }

        public int getID() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getCGPA() {
            return cgpa;
        }

        @Override
        public int compareTo(Student student) {
            if (Double.compare(cgpa, student.cgpa) != 0) {
//                System.out.printf("%s:%f, %s:%f -> %d\n", name, cgpa, student.name, student.cgpa, Double.compare(cgpa, student.cgpa));
                return Double.compare(student.cgpa, cgpa);
            } else if (!name.equals(student.name)) {
                return name.compareTo(student.name);
            } else {
                return Integer.compare(id, student.id);
            }
        }
    }

    static class Priorities {
        List<Student> getStudents(List<String> events) {
            PriorityQueue<Student> queue = new PriorityQueue<>();
            for (String s : events) {
                String[] words = s.split(" ");
                if (words[0].equals("ENTER")) {
                    queue.add(new Student(Integer.parseInt(words[3]), words[1], Double.parseDouble(words[2])));
                } else {
                    if(!queue.isEmpty())
                        queue.remove();
                }
            }
            List<Student> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                list.add(queue.remove());
            }

            return list;
        }
    }
}