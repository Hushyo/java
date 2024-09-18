package com.experiment04.service;
import com.experiment04.entity.Student;

import java.util.*;
public interface StudentService {
    List<Student> addStudent(Student student);
    List<Student> listStudentsByYear(int year);
    List<String> listStudentsNames(int year, Student.Sex sex);
    List<Student> listStudentsByYearSortedById(int year);
    Map<Student.Sex, List<Student>> listStudentsMapBySex();
    Map<Integer, Student> listStudentsByYearMapById(int year);
    boolean removeStudent(int id);

}
