import java.util.*;
import java.io.*;

class Student {
    int rollno;
    String name;
    int age;

    Student(int rollno, String name, int age) {
        this.rollno = rollno;
        this.name = name;
        this.age = age;
    }
}

class NameComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        return s1.name.compareTo(s2.name);
    }
}

class AgeComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
        if (s1.age == s2.age)
            return 0;
        else if (s1.age > s2.age)
            return 1;
        else
            return -1;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> al = new ArrayList<Student>();
        int r, a;
        String sname;
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            r = sc.nextInt();
            sname = sc.next();
            a = sc.nextInt();
            al.add(new Student(r, sname, a));
        }
        System.out.println("Sorting by Name");
        Collections.sort(al, new NameComparator());
        for (Student st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }
        System.out.println("Sorting by age");
        Collections.sort(al, new AgeComparator());
        for (Student st : al) {
            System.out.println(st.rollno + " " + st.name + " " + st.age);
        }
    }
}
