package cn.victor123.randomfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ShellMain {

  public static void main(String[] args) throws IOException {
    ScheduledExecutorService scheduledExecutorService = Executors
        .newSingleThreadScheduledExecutor();
    scheduledExecutorService.schedule(() -> {
      try {
        String key = "TaskManagerRunner";
        String command = "ps -aux|grep " + key
            + "|grep -v grep|cut -c 9-15 |xargs /home/hadoop/flink-1.9-tpcds-master/asyn/profiler.sh -f /home/hadoop/flink-1.9-tpcds-master/log/result.svg stop";
        String[] commands = {"/bin/bash", "-c", "jps -v|grep java"};
        Process exec = Runtime.getRuntime()
            .exec(
                commands);
        System.out.println(command);
        BufferedReader tBufferedReader = new BufferedReader(
            new InputStreamReader(exec.getInputStream()));

        StringBuffer tStringBuffer = new StringBuffer();
        String sTempOneLine;
        while ((sTempOneLine = tBufferedReader.readLine()) != null) {
          tStringBuffer.append(sTempOneLine);
        }
        System.out.println(tStringBuffer);

        BufferedReader tBufferedReader2 = new BufferedReader(
            new InputStreamReader(exec.getErrorStream()));

        StringBuffer tStringBuffer2 = new StringBuffer();
        String sTempOneLine2;
        while ((sTempOneLine2 = tBufferedReader2.readLine()) != null) {
          tStringBuffer2.append(sTempOneLine2);
        }
        System.out.println(tStringBuffer2);

      } catch (IOException e) {
        e.printStackTrace();
      }

    }, 1, TimeUnit.SECONDS);
  }

}
