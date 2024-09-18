package com.experiments05.resource;
import com.experiments05.entity.College;
import com.experiments05.entity.Student;
import com.experiments05.entity.Teacher;
import java.util.*;
public class DatabaseUtils {
    private static final List<Student> STUDENTS=create();
    private static List<Student> create(){

        College c1 = new College("外国语学院");
        College c2 = new College("交通学院");
        Teacher t1 = new Teacher("Lily",200101);
        t1.setCollege(c1);
        Teacher t2= new Teacher("David",200102);
        t2.setCollege(c2);

        List<Student> students = new ArrayList<>();
        students.add(new Student("Peter",202206,2022,t1));
        students.add(new Student("Peter",202207,2022,t2));
        students.add(new Student("Peter",202208,2022,t1));
        students.add(new Student("Peter",202209,2022,t2));
        students.add(new Student("Peter",202103,2021,t1));
        students.add(new Student("Peter",202104,2021,t2));
        students.add(new Student("Peter",202105,2021,t1));
        return students;
    }
    public static List<Student> studentList(){
        return STUDENTS;
    }
}
