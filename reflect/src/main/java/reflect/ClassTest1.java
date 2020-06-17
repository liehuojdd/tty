package reflect;

public class ClassTest1 {
    public static void main(String args[]) throws ClassNotFoundException {
        String hello="Hello";
        Class helloClass1=hello.getClass();

        //First, from an object
        Class<?> clss="Hello".getClass();
        //Class<String> helloClass3="Hello".getClass(); //Complie ERROR!
        //Class<Object> helloClass4="Hello".getClass(); //Complie ERROR!

        //Second, from a know class
        Class<?> clss2=String.class;

        //Third, from the name of a class
        Class<?> clss3=Class.forName("java.lang.String");

    }
}

