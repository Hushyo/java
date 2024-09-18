package com.example10Files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.text.Format;

public class Test {
    private static  final Path BASE= Path.of("E:/Gitfile");
    public static void main(String[] args){
        /*
        Path path=Path.of("E:/Gitfile/test.txt");
        System.out.println(path);//E:\Gitfile\test.txt
        System.out.println(path.getFileName());//test.txt
        System.out.println(path.getParent());//E:\Gitfile
        System.out.println(path.getRoot());//E:\
        */
/*
        Path dir=Path.of("E:/test");
        Path file=Path.of("input.txt");
        Path p1=dir.resolve(file);
        System.out.println(p1);
        Path p2=Path.of("E:","test///","input.txt");
        System.out.println(p2);
        System.out.println(p1.equals(p2));

        */
/*
        Path p1 = BASE.resolve("123");
        System.out.println(p1);
        System.out.println(Files.exists(p1));
        System.out.println("目录"+Files.isDirectory(p1));

        Path p2=BASE.resolve("test.txt");
        System.out.println(p2);
        System.out.println(Files.exists(p2));
        System.out.println("目录"+Files.isDirectory(p2));

        System.out.println(BASE);
        System.out.println(Files.exists(BASE));
        System.out.println("目录"+Files.isDirectory(BASE));*/


        Path dir=Path.of("E:/Doc/a");
        try {
            Files.walk(dir).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------");
        try {
            Files.walk(dir,1).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-------------------------");
        try {
            Files.walk(dir,2).forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
