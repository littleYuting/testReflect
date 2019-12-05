package com.cyt.reflect;

import com.cyt.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class testDemo2 {
    public static void main(String[] args)  throws Exception{
        // 1. 获取 Class 对象的方式
        Class c = Person.class;
        // 2.1  获取所有 public 的成员变量
        Field[] fields = c.getFields(); // output: public java.lang.String com.cyt.domin.Person.a
        for (Field f:fields) {
            System.out.println(f);
        }
        // 2.2 获取 public + 指定名称 的成员变量，否则会报错：.NoSuchFieldException
        Field field = c.getField("a"); // output: public java.lang.String com.cyt.domin.Person.a
        System.out.println(field);
        // 2.3  不分修饰符的获取所有成员变量
        /** output:
             * private java.lang.String com.cyt.domin.Person.name
             * private java.lang.Integer com.cyt.domin.Person.age
             * public java.lang.String com.cyt.domin.Person.a
             * java.lang.String com.cyt.domin.Person.b
             * protected java.lang.String com.cyt.domin.Person.c
             * private java.lang.String com.cyt.domin.Person.d
         */
        Field[] fields1 = c.getDeclaredFields();
        for (Field f:fields1) {
            System.out.println(f);
        }
        // 2.4  不分修饰符的获取指定名称的成员变量
        Field field1 = c.getDeclaredField("name");
        System.out.println(field1);//output: private java.lang.String com.cyt.domin.Person.name

        Person p = new Person();
        // 3.1  获取成员变量的值
        System.out.println(field.get(p)); // output: null
        // 3.2  设置成员变量的值
        field.set(p, "设置成员变量的值");
        System.out.println(field.get(p)); // output: 设置成员变量的值
        // 3.2 获取 private 成员变量
        field1.setAccessible(true);//忽略访问权限修饰符的安全检查，强制反射
        field1.set(p, "cyt");
        System.out.println(field1.get(p));

        // 4.1 获取构造方法（指定参数）
        Constructor constructor = c.getConstructor(String.class, Integer.class);
        System.out.println(constructor); // public com.cyt.domin.Person(java.lang.String,java.lang.Integer)
        Object person = constructor.newInstance("cyt",25);
        System.out.println(person);// Person{name='cyt', age=25, a='null', b='null', c='null', d='null'}
        // 4.2 获取构造方法（无参）
        Object person1 = c.newInstance();
        System.out.println(person1);// Person{name='null', age=null, a='null', b='null', c='null', d='null'}

        // 5.1 获取成员方法（指定名称 + 无参）
        Method method1 = c.getMethod("eat");
        method1.invoke(p); // just eat
        // 5.2 获取成员方法（指定名称 + 有参）
        Method method2 = c.getMethod("eat", String.class);
        method2.invoke(p,"apple"); // you can eat apple
        // 5.3 获取所有 public 的成员方法，还包括 object 类中的
        Method[] methods = c.getMethods();
        for(Method m:methods){
            System.out.println(m);
        }
    }
}
