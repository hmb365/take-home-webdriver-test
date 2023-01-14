package Test_Script;

import BasePackages.Basetest2;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.logging.SocketHandler;

public class Script extends Basetest2 {

    WebDriver driver;

    public Script(){

    }

    @Test
    public void LogInSuccess() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/login");
        baseutils2.typeon("xpath://input[@id='username']", "tomsmith");
        Thread.sleep(2000);
        baseutils2.typeon("xpath://input[@id='password']", "SuperSecretPassword!");
        Thread.sleep(2000);
        baseutils2.clickon("xpath://button[@type='submit']");
        Thread.sleep(5000);

    }

    @Test
    public void LogInFail() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/login");
        baseutils2.typeon("xpath://input[@id='username']", "tomsmith");
        Thread.sleep(2000);
        baseutils2.typeon("xpath://input[@id='password']", "SuperSecret");
        Thread.sleep(2000);
        baseutils2.clickon("xpath://button[@type='submit']");
        Thread.sleep(5000);
    }

    @Test
    public void checkbox() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/checkboxes");
        baseutils2.clickon("xpath://input[@type='checkbox'][1]");
        Thread.sleep(1000);
        baseutils2.clickon("xpath://input[@type='checkbox'][2]");
        Thread.sleep(2000);
    }

    @Test
    public void RightClick() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/context_menu");
        baseutils2.rightclick("xpath://div[@id='hot-spot']");
        Thread.sleep(3000);
    }

    @Test
    public void Dropdown() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/dropdown");
        Thread.sleep(2000);
        baseutils2.dropdownselect("By Index", "id:dropdown", "1");
        Thread.sleep(5000);
        baseutils2.dropdownselect("By Index", "id:dropdown", "2");
        Thread.sleep(2000);

    }

    @Test
    public void MouseHower() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/hovers");
        Thread.sleep(2000);
        baseutils2.hower("xpath://*[@id=\"content\"]/div/div[1]/img");
        Thread.sleep(2000);
        baseutils2.hower("xpath://*[@id=\"content\"]/div/div[2]/img");
        Thread.sleep(2000);
        baseutils2.hower("xpath://*[@id=\"content\"]/div/div[3]/img");
        Thread.sleep(2000);


    }

    @Test

    public void iframe() throws InterruptedException {

        baseutils2.launchURL("http://localhost:7080/iframe");
        Thread.sleep(2000);
        baseutils2.switchToWindows();
        baseutils2.clickon("xpath:/html/body/div[4]/div/div/button/div/svg");
        Thread.sleep(2000);

    }

    @Test
    public void FloatingMenu() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/floating_menu");
        Thread.sleep(2000);

        //News Tab is Visiable at Top
        WebElement fs =baseutils2.elementfind("xpath","//*[@id=\"menu\"]/ul/li[2]/a");
        fs.isDisplayed();

        JavascriptExecutor scroll=(JavascriptExecutor) super.driver;
        scroll.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        Thread.sleep(5000);

        //Home Tab is Visiable at Bottom

        WebElement fs1 =baseutils2.elementfind("xpath","//*[@id=\"menu\"]/ul/li[1]/a");
        fs1.isDisplayed();

    }
@Test

    public void DragDrop() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/drag_and_drop");
        Thread.sleep(2000);

        Actions action=new Actions(super.driver);
        WebElement source= super.driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement Destination= super.driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
        action.dragAndDrop(source,Destination).pause(3).perform();
        Thread.sleep(3000);

    }


    @Test

    public void DynamicNewPayload() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/dynamic_content?with_content=static");
        Thread.sleep(2000);

        baseutils2.clickon("xpath://*[@id=\"content\"]/div/p[2]/a");

        WebElement e1 = super.driver.findElement((By.xpath("//*[@id=\"content\"]/div[1]/div[1]/img")));
        if (e1.isDisplayed()) {
            System.out.println("Static Contain");
        } else {
            System.out.println("Dynamic Contain");
        }

        Thread.sleep(2000);
        WebElement e2 = super.driver.findElement((By.xpath("//*[@id=\"content\"]/div[2]/div[1]/img")));
        if (e2.isDisplayed()) {
            System.out.println("Static Contain");
        } else {
            System.out.println("Dynamic Contain");
        }
        Thread.sleep(2000);
        WebElement e3 = super.driver.findElement((By.xpath("//*[@id=\"content\"]/div[3]/div[2]")));
        String e31 = e3.getText();
        String e32 = "Qui qui officiis unde repellendus recusandae nisi sapiente molestiae accusantium cumque omnis sed deleniti asperiores eum beatae iusto odio rerum sit totam voluptatem est nihil facilis laborum velit quasi nihil et tempora saepe culpa";

        if (e31 == e32) {
            System.out.println("Static Contain");
        } else {
            System.out.println("Dynamic Contain");
        }

        Thread.sleep(5000);
    }

    @Test
    public void FileDownload() throws InterruptedException {

        baseutils2.launchURL("http://localhost:7080/download");
        Thread.sleep(2000);
        baseutils2.clickon("xpath://*[@id=\"content\"]/div/a");
        Thread.sleep(2000);
    }

    @Test

    public void DynamicControls() throws InterruptedException {

        WebDriverWait wait= new WebDriverWait(super.driver,30);

        baseutils2.launchURL("http://localhost:7080/dynamic_controls");
        Thread.sleep(4000);
        baseutils2.clickon("xpath://*[@id=\"checkbox\"]/input");
        Thread.sleep(2000);
        baseutils2.clickon("xpath://*[@id=\"checkbox-example\"]/button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]")));
        Thread.sleep(2000);
        baseutils2.clickon("xpath://*[@id=\"input-example\"]/button");
        wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"message\"]"))));
        Thread.sleep(2000);
    }

    @Test

    public void DynamicLoading() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(super.driver,30);

        baseutils2.launchURL("http://localhost:7080/dynamic_loading/2");
        Thread.sleep(2000);
        baseutils2.clickon("xpath://*[@id=\"start\"]/button");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"finish\"]/h4")));
        WebElement e1= super.driver.findElement(By.xpath("//*[@id=\"finish\"]/h4"));
        String e11= e1.getText();
        System.out.println("Page Elements: "  +e11);

    }

    @Test

    public  void JavaScriptAlerts() throws InterruptedException {

        baseutils2.launchURL("http://localhost:7080/javascript_alerts");
        Thread.sleep(2000);
        baseutils2.clickon("xpath://*[@id=\"content\"]/div/ul/li[1]/button");

        Alert alert= super.driver.switchTo().alert();
        alert.accept();

        Thread.sleep(2000);

        baseutils2.clickon("xpath://*[@id=\"content\"]/div/ul/li[2]/button");

        Alert alert1=super.driver.switchTo().alert();
        alert1.dismiss();


        Thread.sleep(2000);

        baseutils2.clickon("xpath://*[@id=\"content\"]/div/ul/li[3]/button");

        Alert alert2=super.driver.switchTo().alert();
        alert2.sendKeys("Testing ");
        alert2.accept();

        Thread.sleep(2000);

    }



    @Test
    public void JavaScriptError() throws InterruptedException {

        baseutils2.launchURL("http://localhost:7080/javascript_error");
        Thread.sleep(2000);

        WebElement e1= super.driver.findElement(By.xpath("/html/body/p"));
        String s1=e1.getText();
        System.out.println(s1);

    }


    @Test
    public void NewWindow() throws InterruptedException {

        baseutils2.launchURL("http://localhost:7080/windows");
        Thread.sleep(3000);

        baseutils2.clickon("xpath://*[@id=\"content\"]/div/a");
        baseutils2.switchToWindows();
        Thread.sleep(5000);
        WebElement e1= super.driver.findElement(By.xpath("/html/body/div/h3"));
        String s1= e1.getText();
        System.out.println(s1);
        baseutils2.close();

    }

    @Test


    public void NotificationMessage() throws InterruptedException {
        baseutils2.launchURL("http://localhost:7080/notification_message_rendered");
        Thread.sleep(2000);

        baseutils2.clickon("xpath://*[@id=\"content\"]/div/p/a");

        WebElement e1= super.driver.findElement(By.xpath("//*[@id=\"flash\"]"));
        String s1=e1.getText();
        System.out.println("Notification Message: "  +s1);
         Thread.sleep(5000);


    }

}











