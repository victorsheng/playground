package com.example.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过反射回去方法返回值的反省类型
 */
public class ReflectReturnType {

    public List<A> hello() {
        return null;
    }


    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Class<ReflectReturnType> reflectClass = ReflectReturnType.class;
        Method hello = reflectClass.getMethod("hello", null);
        Type genericReturnType = hello.getGenericReturnType();
        System.out.println(genericReturnType);
        ArrayList<A> list = new ArrayList<>();
        list.add(new A("AA1"));
        list.add(new A("AA2"));
        list.add(new A("AA3"));
        list.add(new A("AA4"));
        String json = JSON.toJSONString(list);
        //传统方式
//        List<A> as = JSON.parseObject(json, new TypeReference<List<A>>() {}.getType());
        List<A> as = JSON.parseObject(json, new TypeReference4Reflect(genericReturnType).getType());

        System.out.println(as);
    }


    public static class A implements Serializable {
        String name;

        public A(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            final StringBuffer sb = new StringBuffer("A{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    static public class TypeReference4Reflect<T> extends TypeReference<T> {
        public TypeReference4Reflect(T t) throws IllegalArgumentException, IllegalAccessException, SecurityException, NoSuchFieldException {
            Class<?> cla = TypeReference.class;
            Field field = cla.getDeclaredField("type");
            field.setAccessible(true);
            field.set(this, t);
        }
    }
}
