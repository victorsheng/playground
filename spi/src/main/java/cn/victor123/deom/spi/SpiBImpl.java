package cn.victor123.deom.spi;

public class SpiBImpl implements Spi {

  public boolean isSupport(String name) {

    return "SPIB".equalsIgnoreCase(name.trim());

  }

  public String sayHello() {
    return "hello wing";
  }

}