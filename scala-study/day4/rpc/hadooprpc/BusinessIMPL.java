package day4.rpc.hadooprpc;

/**
 * 实现 协议
 */
public class BusinessIMPL implements BusinessProtocol {

    @Override
    public void mkdir(String path) {
        System.out.println("成功创建了文件夹 ：" + path);
    }

    @Override
    public void hello(String name) {
        System.out.println("hello ：" + name);
    }

    @Override
    public String getName(String name) {
        return "HDFS + " + name;
    }
}
