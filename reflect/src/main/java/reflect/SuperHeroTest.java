package reflect;

import reflect.model.SuperHero;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SuperHeroTest {
    public static void main(String[] args) {
        try{
            System.out.println("获取对象");
            SuperHero ironMan = new SuperHero("1","钢铁侠",35, "战甲");
            Class clazz = ironMan.getClass();
            System.out.println(clazz.getName());

            //Class clazz = SuperHero.getClass();
            Class clazz2 = SuperHero.class.getClass();//不太对
            System.out.println(clazz2.getName());

            Class clazz3 = Class.forName("reflect.model.SuperHero");
            System.out.println(clazz3.getName());

            System.out.println("创建方式");
            Class clazz4 = Class.forName("reflect.model.SuperHero");
            System.out.println(clazz4.getName());  //获取类名称（含路径）
            System.out.println(clazz4.getSimpleName());  //获取类名称（不含路径）
            System.out.println(clazz4.getPackage());  //获取所在包

            SuperHero hero = (SuperHero)clazz4.newInstance();  //通过Class创建对象
            System.out.println(hero);

            System.out.println("构造函数");
            Constructor[] constructors=clazz4.getDeclaredConstructors();
            System.out.println(clazz4.getDeclaredConstructor(null));
            System.out.println(clazz4.getDeclaredConstructor( new Class[]{String.class, String.class, Integer.class, String.class}));

            System.out.println("成员变量");
            Field[] fields = clazz4.getDeclaredFields();
            System.out.println(clazz4.getDeclaredField("ADDRESS"));
            System.out.println(clazz4.getDeclaredField("name"));

            System.out.println("成员方法");
            Method[] methods = clazz4.getDeclaredMethods();
            Method method = clazz4.getDeclaredMethod("getName", null);
            method = clazz4.getDeclaredMethod("setName", new Class[]{String.class});

            System.out.println("方法执行");
            Object o = clazz4.newInstance();
            Method method2=o.getClass().getDeclaredMethod("setName",new Class[]{String.class});
            method2.invoke(o,"钢铁侠");
            Method method3=o.getClass().getDeclaredMethod("getName");
            System.out.println(method3.invoke(o));



        }catch (ClassNotFoundException e){

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
