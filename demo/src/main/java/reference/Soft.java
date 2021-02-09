package reference;

import java.lang.ref.SoftReference;
import java.util.ArrayList;

/**
 * 类似一个缓存，神奇
 */
public class Soft {

    private String path;
    private SoftReference<byte[]> dataRef;

    public Soft(String path) {
        this.path = path;
        dataRef = new SoftReference<byte[]>(new byte[0]);
    }

    private byte[] readImage(int i) {
        System.out.println("init from：" + i);
        return new byte[1024 * 1024]; //省略了读取文件的操作
    }

    public byte[] getData(int i) {
        byte[] dataArray = dataRef.get();
        if (dataArray == null || dataArray.length == 0) {

            dataArray = readImage(i);
            dataRef = new SoftReference<byte[]>(dataArray);
        }
        return dataArray;
    }

    public static void main(String[] args) {
        final Soft soft = new Soft("、");
        int len = 2 >> 10;
        final ArrayList<Object> objects = new ArrayList<>();
        int i = 0;
        while (true) {
            i++;
            final byte[] bytes = new byte[len];
            objects.add(bytes);
            final byte[] data = soft.getData(i);
        }
    }
}
