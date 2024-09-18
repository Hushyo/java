package com.experiment04.resource;
import com.experiment04.entity.Student;
import java.util.*;

public class DatabaseUtils {
    private static List<Student> create(){
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(201801,"Mary",Student.Sex.FEMALE));
        studentList.add(new Student(201802,"Peter",Student.Sex.MALE));
        studentList.add(new Student(202002,"Lily",Student.Sex.FEMALE));
        studentList.add(new Student(201804,"David",Student.Sex.MALE));
        studentList.add(new Student(202005,"Lucy",Student.Sex.FEMALE));
        studentList.add(new Student(202006,"Steve",Student.Sex.MALE));
        studentList.add(new Student(202407,"Jett",Student.Sex.FEMALE));
        return studentList;
    }
    private static final List<Student>  STUDENTS=create();
    public static List<Student> studentList(){
        return STUDENTS;
    }
}
