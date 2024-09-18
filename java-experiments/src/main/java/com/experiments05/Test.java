package com.experiments05;

import com.experiments05.entity.College;
import com.experiments05.entity.Teacher;
import com.experiments05.entity.Student;
import com.experiments05.resource.DatabaseUtils;

import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        System.out.println(getCollegeName(DatabaseUtils.studentList().get(0)));
        System.out.println(isTeacher(DatabaseUtils.studentList().get(0), "曾志优"));
        System.out.println(getCollegeName(DatabaseUtils.studentList(),8888));
        printCollegeName(DatabaseUtils.studentList(), 201001, 1002);
    }

    /**
     * 基于给定学生，获取学生的导师的所在学院名称。
     * 任何一项不存在或失败，返回 未知学院
     * @param student
     * @return
     */
    private static String getCollegeName(Student student) {
        Optional<Student> s = Optional.ofNullable(student);
        if(s.isPresent()){
            if(s.get().getTeacher()!=null&&s.get().getTeacher().getCollege()!=null){
                return s.get().getTeacher().getCollege().getName();
            }
        }
        return "未知学院";
    }

    /**
     * 基于给定学生及教师姓名，判断是否为给定学生的指导教师。
     * 不匹配或不存在，均返回false
     * @param student
     * @param teacherName
     * @return
     */
    private static boolean isTeacher(Student student, String teacherName) {
        Optional<Student> s=Optional.ofNullable(student);
        if(s.isPresent()){
            if(s.get().getTeacher().getName()==teacherName)return true;
        }
        return false;
    }

    /**
     * 基于给定学生集合，学生编号，实现获取学生的导师的所在学院名称。
     * 任何一项不存在或失败，返回 未知学院
     * 结合collection stream findFirst()方法实现
     * 可直接通过一条方法链实现
     *
     * @param students
     * @param sNumber
     * @return
     */
    private static String getCollegeName(List<Student> students, int sNumber) {
        return students.stream()
                .filter(s->s.getId()==sNumber)
                .findFirst()
                .map(s->s.getTeacher().getCollege().getName())
                .orElse("未知学院");
    }

    /**
     * 实现在给定学生集合中查询指定编号学生，如果学生导师编号为指定编号，打印显式导师所在学院名称。
     * 任何一项不存在或失败，打印显式 未知学院
     * 结合collection stream findFirst()方法实现
     * 可直接通过一条方法链实现
     *
     * @param students
     * @param sNumber，学生编号
     * @param tNumber，教师编号
     */
    private static void printCollegeName(List<Student> students, int sNumber, int tNumber) {
        students.stream()
                .filter(s->s.getId()==sNumber&&s.getTeacher().getId()==tNumber)
                .findFirst()
                .ifPresentOrElse(s-> System.out.println(s.getTeacher().getCollege().getName()),
                        ()-> System.out.println("未知学院"));
    }

}