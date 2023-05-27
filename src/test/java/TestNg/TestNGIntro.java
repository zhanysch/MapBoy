package TestNg;

import org.testng.annotations.Test;

public class TestNGIntro {

    @Test(priority = 1,invocationCount = 10) //invocation count бул тесты 10 жолу аткарат
    public void test1(){
        System.out.println("i am test 1");
    }

    @Test(priority = 2)
    public  void test2(){
        System.out.println("i am test2");
    }

    @Test (priority = 3)
    public  void test3(){
        System.out.println("i am test3");
    }
}
