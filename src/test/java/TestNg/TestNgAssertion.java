package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgAssertion {


    public int multiplication(int number1 , int number2){
        return number1*number2;
    }
    @Test
    public void validateMultiplucation(){
        int actualResult= multiplication(3,4);
        int expectedResult = 12;
        /*if (actualResult==expectedResult){
            System.out.println("Passed");
        }else {
            System.out.println("Failed");
        }*/
        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test
    public void validateZero(){
       int actual = multiplication(0,9999);
       int expected = 0;
       Assert.assertTrue(actual==expected);
    }

    @Test
    public  void validateNegativeWithPositive(){
       int acutal = multiplication(-1,9);
       int expected = -9;
       Assert.assertFalse(acutal!=expected);

    }

    @Test
    public void validateNegativeWithNegative(){
        /*int actual = multiplication(-1,-5);
        int expected = 5;*/

        Assert.assertEquals(multiplication(-1,-5),5);
    }
}
