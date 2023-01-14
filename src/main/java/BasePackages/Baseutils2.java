package BasePackages;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Baseutils2 {

    public WebDriver driver;

    public Baseutils2(WebDriver driver) {
        this.driver=driver;
    }

    public WebDriver launchbrowser(){
      System.setProperty("webdriver.gecko.driver", "C:\\Users\\hmbha\\The_Internet_Project\\src\\main\\java\\Drivers\\geckodriver.exe");
       // System.setProperty("webdriver.gecko.driver", ConfrigationLoader.conficOptions.getGeckoPath());

        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
        return (WebDriver) driver;


    }



    public void launchURL(String url){
        driver.get(url);
    }

    public void WWW(String url){
        driver.get(url);
    }

    public void close(){
        driver.close();
    }
    public WebElement elementfind(String LocatBy, String value){

        WebElement element=null;

        switch (LocatBy){
            case "id":
               element= driver.findElement(By.id(value));
                break;
            case "name":
                element= driver.findElement(By.name(value));
                break;
            case "xpath":
                element= driver.findElement(By.xpath(value));
                break;
            case "plt":
                element=  driver.findElement(By.partialLinkText(value));
                break;
            case "class":
                element=  driver.findElement(By.className(value));
                break;
            case "text":
                element= driver.findElement(By.linkText(value));
                break;
        }
        return element;

    }

    public void clickon(String ElementHow){
     waituntilclickableandClick(ElementHow,10);

//        String how=ElementHow.split(":",2)[0];
//        String howvalue=ElementHow.split(":",2)[1];
//       WebElement clickhere= elementfind(how,howvalue);
//       clickhere.click();
    }

    public void SimpleClick(String ElementHow){

        String how=ElementHow.split(":",2)[0];
        String howvalue=ElementHow.split(":",2)[1];
       WebElement clickhere= elementfind(how,howvalue);
       clickhere.click();
    }

    public void clickthis(String Ele1){
        String how=Ele1.split(":",2 )[0];
        String how1=Ele1.split(":",2)[1];
        WebElement webe=elementfind(how,how1);
        webe.click();
    }

    public void typeon(String ElementHow, String Uservalue){

       waitUntilType(ElementHow,10,Uservalue);
//        String how=ElementHow.split(":")[0];
//        String howvalue= ElementHow.split(":")[1];
//       WebElement typein= elementfind(how,howvalue);
//        typein.click();
//        typein.clear();typein.sendKeys(Uservalue);
    }

    public void hower(String Element4) {
        String how = Element4.split(":")[0];
        String howElement = Element4.split(":")[1];
        WebElement type41 = elementfind(how, howElement);
        Actions actions = new Actions(driver);
        actions.moveToElement(type41).build().perform();
    }

    public void switchToWindows1() {
        String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        List<String> listOfWindows = new ArrayList<String>(allWindows);
        int switchToSecond = 1;
        driver.switchTo().window(listOfWindows.get(switchToSecond));
    }

    public void rightclick(String Element4){
        String how = Element4.split(":")[0];
        String howElement = Element4.split(":")[1];
        WebElement type41 = elementfind(how, howElement);
        Actions actions = new Actions(driver);
        actions.contextClick(type41).build().perform();
    }

    public void dropdownselect(String ByWhat, String Xpath, String listvalue) {
        String how = Xpath.split(":", 2)[0];
        String howValue = Xpath.split(":", 2)[1];
        WebElement elemenToselect = elementfind(how, howValue);
        Select select = new Select(elemenToselect);
        if (ByWhat.equalsIgnoreCase("ByValue"))
            select.selectByValue(listvalue);
        else if (ByWhat.equalsIgnoreCase("By VisiableText")) {
            select.selectByVisibleText(listvalue);
        } else if (ByWhat.equalsIgnoreCase("By Index")) {
            select.selectByIndex(Integer.parseInt(listvalue));
        }
    }
        public void switchToWindows() {
            String currentWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();
            List<String> listOfWindows = new ArrayList<String>(allWindows);
            int switchToSecond = 1;
            driver.switchTo().window(listOfWindows.get(switchToSecond));
        }



    //---------------------------------------------------------------------------------------------------------

    //BaseUtilts4 methods
    public By findby(String Locateby, String path){

        By by=null;
        switch (Locateby){
            case "xpath":
                by=By.xpath(path);
                break;
            case "class":
                by=By.className(path);
                break;
            case "plt":
                by=By.linkText(path);
                break;
            case "id":
                by=By.id(path);
                break;
            case "cssName":
                by=By.className(path);
                break;

            case "name":
                by=By.name(path);
                break;
            case "cssSelector":
                by=By.cssSelector(path);
                break;

        }
        return by;
    }


    public WebElement waituntilvisiable(WebElement element){
        WebDriverWait wait=new WebDriverWait(driver,10);
        WebElement element1=wait.until(ExpectedConditions.visibilityOf(element));
        return element;

    }

    public WebElement waitUntilvisiableandReturn(String HowElement, int noofSeconds){
        String how=HowElement.split(":",2)[0];
        String how1=HowElement.split(":",2)[1];
        By by=findby(how,how1);
        WebDriverWait wait=new WebDriverWait(driver,noofSeconds);
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;
    }

    public WebElement waituntilclickableandClick(String Howelement, int noofseconnds){
        String how=Howelement.split(":",2)[0];
        String how1= Howelement.split(":",2)[1];
        By by=this.findby(how,how1);
        WebDriverWait wait=new WebDriverWait(this.driver,noofseconnds);
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        return element;
    }

    public WebElement waitUntilType(String Howelement, int noofseconds, String uservalue){
        String how=Howelement.split(":",2)[0];
        String how1=Howelement.split(":",2)[1];
        By by=this.findby(how,how1);
        WebDriverWait wait=new WebDriverWait(this.driver,noofseconds);
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        element.clear();
        element.sendKeys(uservalue);
        return element;

    }

    public String waituntliAndgetText(String HowElement,int nooofseconds){
        String how=HowElement.split(":",2)[0];
        String how1=HowElement.split(":",2)[1];
        By by=findby(how,how1);
        WebDriverWait wait=new WebDriverWait(driver,nooofseconds);
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element.getText();
    }

public void takescreeshots(String testname) throws IOException {
     TakesScreenshot task=(TakesScreenshot)driver;
     File screenshoots=task.getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(screenshoots,new File(System.getProperty("C:\\Users\\hmbha\\IdeaProjects\\Selenium_First\\src\\main\\resources\\Screenshoots"+testname+".jpg")));

}
 public void windowexample(){
     String currentwindiw=  driver.getWindowHandle();
     Set<String> allwindows=driver.getWindowHandles();
     List<String> listwindow=new ArrayList<String>(allwindows);
     driver.switchTo().window(listwindow.get(1));
 }




    }
