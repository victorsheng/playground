package com.example.demo.proxy.cglib;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.cglib.beans.BulkBean;

public class BulkBeanTest {

  @Test
  public void testBulkBean() throws Exception {
    BulkBean bulkBean = BulkBean.create(SampleBean.class,
        new String[]{"getValue"},
        new String[]{"setValue"},
        new Class[]{String.class});
    SampleBean bean = new SampleBean();
    bean.setValue("Hello world!");
    //get
    assertEquals(1, bulkBean.getPropertyValues(bean).length);
    assertEquals("Hello world!", bulkBean.getPropertyValues(bean)[0]);
    //set
    bulkBean.setPropertyValues(bean, new Object[]{"Hello cglib!"});
    assertEquals("Hello cglib!", bean.getValue());
  }
}
