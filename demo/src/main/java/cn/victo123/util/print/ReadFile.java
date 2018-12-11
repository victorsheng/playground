package cn.victo123.util.print;

import java.io.File;
import java.util.ArrayList;

public class ReadFile {

  private static ArrayList<File> list = new ArrayList<File>();

  public static void main(String[] args) throws Exception {
    readAllFile("/Users/victor/code/vicProjects/demo/demo/src/main/java");
    System.out.println(list.size());
  }

  public static ArrayList<File> getList() {
    return list;
  }


  //读取一个文件夹下所有文件及子文件夹下的所有文件
  public static void readAllFile(String filePath) {
    File f = null;
    f = new File(filePath);
    File[] files = f.listFiles(); // 得到f文件夹下面的所有文件。
    for (File file : files) {
      if (file.isDirectory()) {
        //如何当前路劲是文件夹，则循环读取这个文件夹下的所有文件
        readAllFile(file.getAbsolutePath());
      } else {
        list.add(file);
      }
    }
//    for (File file : files) {
//      System.out.println(file.getAbsolutePath());
//    }
  }




}
