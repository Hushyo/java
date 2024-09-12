package com.example09;

import com.sun.source.tree.CatchTree;

import java.io.*;

public class IO {
    public static void getBytetoChar() throws IOException {
        try (FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
             FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt")) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.println("字节十进制:" + c);
                System.out.println("十进制转为字符:" + (char) c);
                out.write(c);
            }
        }
    }

    public static void getBytetoChar2() throws IOException {
        FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
        FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt");
        try (in; out) {
            int c;
            while ((c = in.read()) != -1) {
                System.out.print("字节十进制:" + c+"  ");
                System.out.println("十进制转为字符:" + (char) c);
                out.write(c);
            }
        }
    }

    public static void getBytetoChar3() throws IOException {
        try (FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
             FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt")) {
            byte[] buffer=new byte[4];
            int len=0;
            while ((len = in.read(buffer)) != -1) {
                out.write(buffer,0,len);
            }
        }
    }

    public static void getBytetoChar4() throws IOException {
        try (FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
             FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt")) {
            System.out.print("本次写入"+in.transferTo(out)+"个字符");
        }
    }

    public static void getBytetoChar5() throws IOException {
        try (FileInputStream in = new FileInputStream("E:\\Gitfile\\test.txt");
             FileOutputStream out = new FileOutputStream("E:\\Gitfile\\out.txt")) {
          byte[] bytes=in.readAllBytes();
            System.out.println(new String(bytes));
        }
    }

    public static void copyFile(String sourceFilePath, String targetFilePath) {
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);

        try (InputStream in = new FileInputStream(sourceFile);
             OutputStream out = new FileOutputStream(targetFile)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = in.read(buffer)) != -1) {
                out.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        copyFile("E:/Gitfile/test.txt","E:/Gitfile/out.txt");
    }
}
