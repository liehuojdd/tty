package joseexample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Fields {
    public static void main(String args[]){
        try{
            //Class<?> clss= Person.class;
            Class clss=Class.forName("reflect.model.Person");
            Object o = clss.newInstance();

            Field field=clss.getField("name");
            field.setAccessible(true);
            field.set(o,"ss");
            System.out.println(o);


        }catch(ClassNotFoundException e){

        }catch (NoSuchFieldException e){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
