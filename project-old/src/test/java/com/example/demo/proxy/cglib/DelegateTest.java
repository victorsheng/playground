package com.example.demo.proxy.cglib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.cglib.reflect.MethodDelegate;

public class DelegateTest {

  @Test
  public void testMethodDelegate() throws Exception {
    SampleBean bean = new SampleBean();
    bean.setValue("Hello cglib!");
    BeanDelegate delegate = (BeanDelegate) MethodDelegate.create(
        bean, "getValue", BeanDelegate.class);
    assertEquals("Hello cglib!", delegate.getValueFromDelegate());
  }
}
