package com.example.demo.proxy.cglib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.cglib.reflect.MulticastDelegate;

public class SimpleMulticastBean implements DelegatationProvider {

  private String value;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

}

