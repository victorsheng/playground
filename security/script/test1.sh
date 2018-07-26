rm ./directBase64-gc.log
java -ea -verbose:gc -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintHeapAtGC -Xloggc:./directBase64-gc.log -Xmx512m -Xms512m -XX:MetaspaceSize=256m -cp /Users/victor/code/vicProjects/demo/security/target/security-0.0.1-SNAPSHOT.jar com.example.demo.security.Test1
rm ./md5-gc.log
java -ea -verbose:gc -XX:+PrintGC -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:+PrintHeapAtGC -Xloggc:./md5-gc.log -Xmx512m -Xms512m -XX:MetaspaceSize=256m -cp /Users/victor/code/vicProjects/demo/security/target/security-0.0.1-SNAPSHOT.jar com.example.demo.security.Test2