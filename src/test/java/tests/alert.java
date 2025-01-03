package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class alert {


    @Test
    public void test() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        String expResult = "You successfully clicked an alert";

        WebElement alertButton1 = Driver.getDriver().findElement(By.xpath("//*[@onclick='jsAlert()']"));

        alertButton1.click();

        Driver.getDriver().switchTo().alert().accept();

        String actResult = Driver.getDriver().findElement(By.id("result")).getText();

        Assert.assertEquals(actResult, expResult);

        Driver.quitDriver();
    }

    @Test
    public void test02() {

        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        String expResult = "You clicked: Cancel";

        WebElement alertButton2 = Driver.getDriver().findElement(By.xpath("//*[@onclick='jsConfirm()']"));

        alertButton2.click();

        Driver.getDriver().switchTo().alert().dismiss();

        String actResult = Driver.getDriver().findElement(By.id("result")).getText();

        Assert.assertEquals(actResult, expResult);

        Driver.quitDriver();
    }

    @Test
    public void test03() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton3 = Driver.getDriver().findElement(By.xpath("//*[@onclick='jsPrompt()']"));

        String text = "test123";

        alertButton3.click();

        Driver.getDriver().switchTo().alert().sendKeys(text);

        Driver.getDriver().switchTo().alert().accept();

        String expResult = "You entered: " + text;

        String actResult = Driver.getDriver().findElement(By.id("result")).getText();

        Assert.assertEquals(actResult, expResult);

        Driver.quitDriver();

    }
}
