package com.experiment04;
import com.experiment04.*;
import com.experiment04.entity.Student;
import com.experiment04.service.StudentService;
import com.experiment04.service.impl.StudentServiceImpl;

import java.awt.print.Printable;

public class Test {
    public static void main(String[] args){
        StudentServiceImpl studentService = new StudentServiceImpl();
        Student student=new Student(201809,"Fenix",Student.Sex.MALE);
        System.out.println(1);
        studentService.addStudent(student).forEach(s-> System.out.println(s.toString()));
        System.out.println("----------------------------");
        System.out.println(2);
        studentService.listStudentsByYear(2018).forEach(s-> System.out.println(s.toString()));
        System.out.println("----------------------------");
        System.out.println(3);
        studentService.listStudentsNames(2018, Student.Sex.MALE).forEach(s-> System.out.println(s.toString()));
        System.out.println("----------------------------");
        System.out.println(4);
        studentService.listStudentsByYearSortedById(2018).forEach(s-> System.out.println(s.toString()));
        System.out.println("----------------------------");
        System.out.println(5);
        studentService.listStudentsMapBySex().forEach((k,v)-> System.out.println(k+" "+v));
        System.out.println("----------------------------");
        System.out.println(6);
        studentService.listStudentsByYearMapById(2018).forEach((k,v)-> System.out.println(k+" "+v));
        System.out.println("----------------------------");
        System.out.println(7);
        studentService.removeStudent(201801);
    }
}
