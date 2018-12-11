package cn.victo123.util.print;

import java.io.FileNotFoundException;

public class Main {

  public static void main(String[] args) throws FileNotFoundException {
    ReadFile.readAllFile("/Users/victor/code/tdProjects/datashare");
//    ReadFile.readAllFile("/Users/victor/code/vicProjects/demo/demo/src/main/java");
    PrintPackageList.printUsageClass();
  }


}
