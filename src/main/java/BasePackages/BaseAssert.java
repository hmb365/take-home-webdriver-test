package BasePackages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BaseAssert {

    public static void ShoulbEqual(String Actual, String Expected, String... messageof) {
        if (messageof.length > 0) {
            Assert.assertEquals(Actual, Expected, messageof[2]);
        }
        else{
            Assert.assertEquals(Actual, Expected);

        }
    }

    public static void ShoulbNotEqual(String Actual, String Expected, String... messageof) {
        if (messageof.length > 0) {
            Assert.assertNotEquals(Actual, Expected, messageof[2]);
        }
        else{
            Assert.assertEquals(Actual, Expected);

        }
    }
    public static void isDisplay(WebElement Elment, String... messageof){
        if (messageof.length > 0) {
            Assert.assertTrue(Elment.isDisplayed(), messageof[0]);
        }
            else{
                Assert.assertTrue(Elment.isDisplayed());

        }


    }

    public static void isDisplay1(WebElement Elment){

            Assert.assertTrue(Elment.isDisplayed());

        }


    }







