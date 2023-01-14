package BasePackages;



import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class Basetest2 {



 public Baseutils2 baseutils2;
 public BaseAssert baseAssert;
    public WebDriver driver;



   @BeforeTest
   public void browser(){
        baseutils2=new Baseutils2(driver);
     driver=baseutils2.launchbrowser();


   }

   @AfterTest
   public void closebrowser(){
       baseutils2.close();
   }
}
