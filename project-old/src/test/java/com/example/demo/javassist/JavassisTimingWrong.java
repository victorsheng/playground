package com.example.demo.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

/**
 * 这是因为，javassist插入的代码片段中，每次插入操作的代码，称之为一个插入代码块，后面的插入块不能使用前面的插入块定义的局部变量，而言且也不能使用方法中的原有局部变量。而上述代码中，我们分表调用了insertBefore和insertAfter插入了两个代码块，而后面的插入块不能使用前面的插入块定义的局部变量start，因此爆出了上面的错。
 *
 */
public class JavassisTimingWrong {


  public static void main(String[] args) throws Exception {

    //需要修改的已有的类名和方法名

    String className="com.example.demo.javassist.Looper";

    String methodName="loop";

    ClassPool classPool = ClassPool.getDefault();

    CtClass clazz = classPool.get(className);

    CtMethod method = clazz.getDeclaredMethod(methodName);

    method.insertBefore("long start=System.currentTimeMillis();");

    method.insertAfter("System.out.println(\"耗时:\"+(System.currentTimeMillis()-start)+\"ms\");");

    //调用修改的Looper类的loop方法

    Looper looper = (Looper) clazz.toClass().newInstance();

    looper.loop();

  }
}
