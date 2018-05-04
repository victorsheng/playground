package com.example.demo.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class JavassisTiming {
  public static void main(String[] args) throws Exception{
    //需要修改的已有的类名和方法名
    String className="com.example.demo.javassist.Looper";
    String methodName="loop";

    //修改为原有类的方法名为loop$impl
    CtClass clazz = ClassPool.getDefault().get(className);
    CtMethod method = clazz.getDeclaredMethod(methodName);
    String newname = methodName + "$impl";
    method.setName(newname);

    //使用原始方法名loop，定义一个新方法，在这个方法内部调用loop$impl
    CtMethod newMethod = CtNewMethod.make("public void "+methodName+"(){" +
            "long start=System.currentTimeMillis();" +
            ""+newname+"();" +//调用loop$impl
            "System.out.println(\"耗时:\"+(System.currentTimeMillis()-start)+\"ms\");" +
            "}"
        , clazz);
    clazz.addMethod(newMethod);

    //调用修改的Looper类的loop方法
    Looper looper = (Looper) clazz.toClass().newInstance();
    looper.loop();
  }
}
