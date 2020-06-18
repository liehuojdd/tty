package reflect.model;

import java.util.Arrays;

public class Person {
    private String name;
    private int age;
    public String defAsPublic;

    public Person(){

    }

    public Person(String name,int age){
        this.name=name;
        this.age=age;
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
