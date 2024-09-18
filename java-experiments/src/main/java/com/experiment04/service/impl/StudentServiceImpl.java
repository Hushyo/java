package com.experiment04.service.impl;
import com.experiment04.resource.DatabaseUtils;
import com.experiment04.entity.Student;
import com.experiment04.service.StudentService;

import java.util.*;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {
    private List<Student> students=DatabaseUtils.studentList();
    @Override//1
    public List<Student> addStudent(Student student) {
        students.add(student);
        return students;
    }

    @Override//2
    public List<Student> listStudentsByYear(int year) {
        return students.stream()
                .filter(stu->(stu.getId()/100)==year)
                .toList();
    }

    @Override//3
    public List<String> listStudentsNames(int year, Student.Sex sex) {
        return students.stream()
                .filter(stu->(stu.getId()/100)==year && stu.getSex()==sex)
                .map(Student::getName)
                .toList();
    }

    @Override//4
    public List<Student> listStudentsByYearSortedById(int year) {
        return students.stream()
                .filter(stu->(stu.getId()/100)==year)
                .sorted(Comparator.comparing(Student::getId).reversed())
                .toList();
    }

    @Override//5
    public Map<Student.Sex, List<Student>> listStudentsMapBySex() {
       return students.stream()
               .collect(Collectors.groupingBy(s->s.getSex()));
    }

    @Override//6
    public Map<Integer, Student> listStudentsByYearMapById(int year) {
        return students.stream()
                .filter(stu->(stu.getId()/100)==year)
                .collect(Collectors.toMap(Student::getId,s->s));
    }

    @Override//7
    public boolean removeStudent(int id) {
        return students.removeIf(s->s.getId()==id);
    }

}
