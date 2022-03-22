package day4.rpc.hadooprpc;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * 构建 RPC 客户端
 */
public class ClientTest {
    public static void main(String[] args) {

        /**
         * Class<T> protocol,
         * long clientVersion,
         * InetSocketAddress addr,
         * Configuration conf
         */
        try {

            /**
             * 获取了服务端中暴露了的服务协议的一个代理。
             * 客户端通过这个代理可以调用服务端的方法进行逻辑处理
             */
            BusinessProtocol proxy = RPC.getProxy(BusinessProtocol.class, BusinessProtocol.versionID,
                    new InetSocketAddress(args[0], Integer.parseInt(args[1])), new Configuration());

            /**
             * 在客户端调用了服务端的代码执行
             * 真正的代码执行是在服务端的
             */
            proxy.hello("hadoop");
            proxy.mkdir("/home/hadoop/apps");
            String proxyName = proxy.getName("MyHDFS");
            System.out.println(proxyName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
