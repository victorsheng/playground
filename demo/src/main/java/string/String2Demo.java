package string;

public class String2Demo {

    public static void main(String[] args) {

        String str1= "abc";//指向常量池
        String str2= new String("abc");
        String str3= str2.intern();//指向常量池
        System.out.println(str1==str2);//false
        System.out.println(str2==str3);//false
        System.out.println(str1==str3);//true
    }
}
