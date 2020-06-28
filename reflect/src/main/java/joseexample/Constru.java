package joseexample;

import reflect.model.Person;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class Constru {
    public static void main(String args[]){
        try{
            //Class<?> clss= Person.class;
            Class clss=Class.forName("reflect.model.Person");

            Constructor constructor=clss.getConstructor(String.class,int.class);
            System.out.println(constructor);

            //Constructor[] constructors=clss.getDeclaredConstructors();
            Constructor[] constructors=clss.getConstructors();//get public constructor
            for(Constructor declareConstructor:constructors){
                System.out.println(declareConstructor);
            }
            System.out.println(Arrays.toString(constructors));
        }catch(ClassNotFoundException e){

        }catch (NoSuchMethodException e){

        }

    }
}
