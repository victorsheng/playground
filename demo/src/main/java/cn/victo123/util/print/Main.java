package cn.victo123.util.print;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    ReadFile.readAllFile("/Users/victor/code/vicProjects/demo/demo/src/main/java");
    ArrayList<File> list = ReadFile.getList();
    List<String> paths = list.stream()
        .filter(f -> !f.isDirectory() && f.getName().endsWith(".java")).map(File::getAbsolutePath)
        .collect(Collectors
            .toList());
    Set<String> packageList = PrintPackage.getPackageList(paths);
    for (String pack : packageList) {
      System.out.println(pack);
    }
  }

}
