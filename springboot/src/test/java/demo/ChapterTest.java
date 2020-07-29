package demo;

import demo.domain.DemoProperties;
import demo.web.HelloController;
import org.junit.Test;

public class ChapterTest {
    @Test
    public void Test1(){
        HelloController helloController=new HelloController();
        helloController.index();
        DemoProperties dp=new DemoProperties();
        dp.setAuthor("mark");
        dp.getAuthor();
        DemoClassB demoClass=new DemoClassB();
        demoClass.newInt();
        System.out.println("ChapterTest");
    }
}
