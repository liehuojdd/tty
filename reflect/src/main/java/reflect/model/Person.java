package reflect.model;

import reflect.annotation.MyAnnotation;

import java.util.Arrays;

@MyAnnotation.MyClassAnnotation(desc = "The Class", uri = "com.sgl.annotation")
public class Person {
    private long id;
    private String name;
    private int age;
    public String defAsPublic;

    public Person(){

    }

    @MyAnnotation.MyConstructorAnnotation(desc = "The Class Constructor", uri = "com.sgl.annotation#constructor")
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    private Person(String name){
        this.name=name;
    }

    public static Person of(String name, int age){
        return new Person(name,age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        return "Person[name="+name+",age="+age+"]";
    }

    //function with array param
    public void eat(String[] arg){
        System.out.println("function with array param"+Arrays.toString(arg));
    }

    //function without param
    public void eatOnly(){
        System.out.println("function without param");
    }
}
