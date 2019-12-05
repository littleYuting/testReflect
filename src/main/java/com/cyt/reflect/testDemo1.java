package com.cyt.reflect;

import com.cyt.domain.Person;

public class testDemo1 {
    public static void main(String[] args)  throws Exception{
        // 获取 Class 对象的方式
        // 方式 1
        Class c1 = Class.forName("com.cyt.domain.Person");
        System.out.println(c1);
        // 方式 2
        Class c2 = Person.class;
        System.out.println(c2);
        // 方式 3
        Class c3 = new Person().getClass();
        System.out.println(c3);

        System.out.println(c1==c2);//true
        System.out.println(c1==c3);//true
        // 总结：同一个字节码文件（*.class）在一次程序运行过程中，只会被加载一次，不论通过哪种方式获取的 class 对象都是同一个
    }
}
