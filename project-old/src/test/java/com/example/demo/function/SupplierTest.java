package com.example.demo.function;

import java.util.function.Supplier;
import org.junit.Test;

public class SupplierTest {

  public void close(Supplier supplier) {
    supplier.get();
  }

  public Integer Hello() {
    System.out.println("hi");
    return 0;
  }

  @Test
  public void name() {
    close(this::Hello);
  }
}
