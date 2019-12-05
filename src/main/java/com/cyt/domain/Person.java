package com.cyt.domain;

public class Person {
    private String name;
    private Integer age;

    public String a;
    String b;
    protected String c;
    private String d;

    public Person(){}

    public Person(String name, Integer age){
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public void eat(){
        System.out.println("just eat");
    }

    public void eat(String food) {
        System.out.println("you can eat " + food);
    }
}
