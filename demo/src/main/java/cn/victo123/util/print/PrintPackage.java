package cn.victo123.util.print;

import com.thoughtworks.qdox.JavaDocBuilder;
import com.thoughtworks.qdox.model.JavaSource;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PrintPackage {

  public static void main(String[] args) throws FileNotFoundException {
    String fileFullPath = "/Users/victor/code/vicProjects/demo/demo/src/main/java/Anony.java";
    List<String> list = new ArrayList<>();
    list.add(fileFullPath);
    Set<String> packageList = getPackageList(list);
    System.out.println(packageList);

  }

  public static Set<String> getPackageList(List<String> fileList)
      throws FileNotFoundException {
    Set<String> resultSet = new TreeSet<>();
    JavaDocBuilder builder = new JavaDocBuilder();
    for (String s : fileList) {
      try {
        builder.addSource(new FileReader(s));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    JavaSource[] sources = builder.getSources();
    for (JavaSource source : sources) {
      String[] imports = source.getImports();
      for (String anImport : imports) {
        resultSet.add(anImport);
      }
    }
    return resultSet;
  }

}
