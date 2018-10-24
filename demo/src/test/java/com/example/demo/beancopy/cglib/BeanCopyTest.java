package com.example.demo.beancopy.cglib;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;
import org.springframework.cglib.core.DebuggingClassWriter;

public class BeanCopyTest {

  /**
   * 相同class内copy
   */
  @Test
  public void testSimple() {
    // 动态生成用于复制的类,false为不使用Converter类
    BeanCopier copier = BeanCopier.create(MA.class, MA.class, false);

    MA source = new MA();
    source.setIp(123);
    MA target = new MA();

    // 执行source到target的属性复制
    copier.copy(source, target, null);

    assertTrue(target.getIp() == 123);
  }

  @Test
  public void testConvert() {
    // 动态生成用于复制的类,并使用Converter类
    BeanCopier copier = BeanCopier.create(MA.class, MA.class, true);

    MA source = new MA();
    source.setIp(42);
    MA target = new MA();

    // 执行source到target的属性复制
    copier.copy(source, target, new Converter() {
      /**
       * @param sourceValue source对象属性值
       * @param targetClass target对象对应类
       * @param methodName targetClass里属性对应set方法名,eg.setId
       * @return
       */
      public Object convert(Object sourceValue, Class targetClass, Object methodName) {
        if (targetClass.equals(Integer.TYPE)) {
          return new Integer(((Number) sourceValue).intValue() + 1);
        }
        return sourceValue;
      }
    });

    assertTrue(target.getIp() == 43);
  }


  /**
   * 不同class内copy
   */
  @Test
  public void testBeanCopy() {

    System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,
        "/Users/victor/code/vicProjects/demo/project-old/doc/testBeanCopy");


    // 动态生成用于复制的类,false为不使用Converter类
    BeanCopier copier = BeanCopier.create(MA.class, MB.class, false);

    MA source = new MA();
    source.setIp(123);
    MB target = new MB();

    // 执行source到target的属性复制
    copier.copy(source, target, null);

    assertTrue(target.getIp() == 123);
  }


}
