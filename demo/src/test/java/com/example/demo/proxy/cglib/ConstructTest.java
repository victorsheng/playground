package com.example.demo.proxy.cglib;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.cglib.reflect.ConstructorDelegate;

public class ConstructTest {

  @Test
  public void testConstructorDelegate() throws Exception {
    SampleBeanConstructorDelegate constructorDelegate = (SampleBeanConstructorDelegate) ConstructorDelegate
        .create(
            SampleBean.class, SampleBeanConstructorDelegate.class);
    SampleBean bean = (SampleBean) constructorDelegate.newInstance();
    assertTrue(SampleBean.class.isAssignableFrom(bean.getClass()));
  }


}
