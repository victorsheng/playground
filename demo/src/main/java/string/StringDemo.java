package string;

public class StringDemo {

    public static void main(String[] args) {
        String t = String.valueOf("bilibili");
        String t1 = t.intern();
        String t2 = "bilibili";
        String t3 = new String("bilibili");
        System.out.println(t == t1); //true

        System.out.println(t == t2); //true
        System.out.println(t1 == t2); //true

        System.out.println(t1 == t3); //false
        System.out.println(t1 == t3); //false
        System.out.println(t2 == t3); //false
    }
}
