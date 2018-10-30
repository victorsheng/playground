package cn.victor123.deom.spi;

public class Main {

  public static void main(String[] args) {
    Spi spib = SpiFactory.getSpi("SPIB");
    String result = spib.sayHello();
    System.out.println(result);
  }

}
