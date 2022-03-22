package day1.core;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 作者： 马中华  https://blog.csdn.net/zhongqi2513
 * 时间： 2019/4/19 15:51
 * 描述： Java版本的wordcount
 */
public class Demo022_JavaWordCount {
    public static void main(String[] args) throws Exception {

        FileInputStream fileInputStream = new FileInputStream(new File("D:\\bigdata\\wc_java\\input\\wc.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

        Map<String, Integer> wordContext = new HashMap<String, Integer>();

        String line = null;
        while ((line = br.readLine()) != null) {

            String[] words = line.split(" ");
            for (String word : words) {
                if (wordContext.containsKey(word)) {
                    wordContext.put(word, wordContext.get(word) + 1);
                } else {
                    wordContext.put(word, 1);
                }
            }
        }

        File file = new File("D:\\bigdata\\wc_java\\output\\wc.result.txt");
        if (!file.exists()) {
            file.delete();
        }
        file.createNewFile();
        PrintWriter printWriter = new PrintWriter(file);

        // 展示结果
        Set<String> keys = wordContext.keySet();
        for (String key : keys) {
            System.out.println(key + "\t" + wordContext.get(key));
            printWriter.println(key + "\t" + wordContext.get(key));
        }

        br.close();
        printWriter.close();
    }
}
