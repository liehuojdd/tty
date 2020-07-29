package reflect;

import reflect.annotation.MyAnnotation;
import reflect.model.Person;

import java.lang.reflect.*;
import java.util.Arrays;

public class PlayWithRefllection {
    public static void main(String[] args){
        try{
            String personClassName="reflect.model.Person";
            Class<?> personClass=Class.forName(personClassName);

            System.out.println("Person class="+personClass);

            Field[] fileds=personClass.getFields();
            System.out.println("Fileds:");
            System.out.println(Arrays.toString(fileds));//Get blank because only can get public fileds.

            Field[] declaredFields=personClass.getDeclaredFields();
            System.out.println("DeclaredFields:");
            System.out.println(Arrays.toString(declaredFields));
            Field filed=personClass.getDeclaredField("name");
            filed.setAccessible(true);
            Person p= (Person) personClass.newInstance();
            filed.set(p,"Lee");
            System.out.println("Set filed "+p);

            System.out.println("Methods:");
            Method[] methods=personClass.getMethods();
            for(Method method:methods){
                System.out.println(method);
            }

            System.out.println("Declared Methods:");
            Method[] declaredMethods=personClass.getDeclaredMethods();
            for(Method method:declaredMethods){
                System.out.println(method);
            }

            System.out.println("Static Declared Methods");
            Arrays.stream(declaredMethods)
                    .filter(m-> Modifier.isStatic(m.getModifiers()))
                    .forEach(System.out::println);

            System.out.println("=======================");

            String[] s = new String[]{"aa","bb"};
            Constructor con2 =  personClass.getConstructor( new Class[]{String.class, int.class});
            MyAnnotation.MyConstructorAnnotation conAnn= (MyAnnotation.MyConstructorAnnotation) con2.getAnnotation(MyAnnotation.MyConstructorAnnotation.class);
            Constructor con =  personClass.getConstructor();
            Person p2 = (Person) con.newInstance();
            Method method1=personClass.getMethod("eat",String[].class);
            method1.invoke(p2,new Object[]{s});
            method1.invoke(p2,(Object)s);//two functions are the same

            Method method2=personClass.getMethod("eatOnly",null);
            //method2=personClass.getMethod("eatOnly",(Class<?>[]) null);//(Class<?>[]) from my project.
            method2.invoke(p,null);

            System.out.println("get annotation");
            MyAnnotation.MyClassAnnotation myAnn=personClass.getAnnotation(MyAnnotation.MyClassAnnotation.class);
            System.out.println(myAnn.desc()+" "+myAnn.uri());

        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (NoSuchMethodException e){
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
