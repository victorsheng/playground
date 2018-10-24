package com.example.demo.proxy.cglib;

import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.Test;
import org.springframework.cglib.beans.BeanGenerator;
import org.springframework.cglib.core.DebuggingClassWriter;

public class BeanG {

  @Test
  public void test()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
//        "/Users/victor/code/vicProjects/demo/project-old/doc/cglib-BeanGenerator");

    BeanGenerator beanGenerator = new BeanGenerator();

    beanGenerator.addProperty("name", String.class);
    Object myBean = beanGenerator.create();
    Method setter = myBean.getClass().getMethod("setName", String.class);
    setter.invoke(myBean, "some string value set by a cglib");

    Method getter = myBean.getClass().getMethod("getName");
    assertEquals("some string value set by a cglib", getter.invoke(myBean));
  }

}
