package com.example.demo.javassist;

import java.io.IOException;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;
import org.junit.Test;

public class Reading {

  @Test
  public void read() throws NotFoundException, CannotCompileException, IOException {
    ClassPool pool = ClassPool.getDefault();
    CtClass cc = pool.get("com.example.demo.javassist.Looper");
    cc.setSuperclass(pool.get("com.example.demo.javassist.Reading"));
    cc.writeFile();
  }
}
