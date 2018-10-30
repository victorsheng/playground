package cn.victor123.deom.spi;

public class SpiAImpl implements Spi {

  public boolean isSupport(String name) {

    return "SPIA".equalsIgnoreCase(name.trim());

  }

  public String sayHello() {
    return "hello victor";
  }

}