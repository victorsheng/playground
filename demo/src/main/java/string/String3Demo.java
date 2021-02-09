package string;

public class String3Demo {

    public static void main(String[] args) {
        String s1 = (new String("1") + new String("1")).intern();
        String s2 = "11";
        System.out.println(s1 == s2);


        String z1 = new String("11").intern();
        String z2 = "11";
        System.out.println(z1 == z2);

    }
}
