package com.example.demo.file;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileHandleLeakExample {

  public static String readContentFromFile(String filename) {

    StringBuilder sb = new StringBuilder();
    BufferedReader br = null;
    try {
      br = new BufferedReader(new FileReader(filename));
      String line = null;
      while ((line = br.readLine()) != null) {
        sb.append(line).append("\n");
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
      exit(1);
    } finally {
//          模拟疏忽关掉句柄的操作
//            try {
//                br.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    for (int j = 0; j < 20; j++) {
      System.out.println(j++);
      FileHandleLeakExample.readContentFromFile("/Users/victor/tmp/qingshu.txt");
    }
    System.out.println("byte");
  }

}

/*
    输入结果如下:
    1.txt (Too many open files)
*/