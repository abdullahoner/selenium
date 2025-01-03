package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.Driver;

public class jsExecuter {
    @Test
    public void test() {
        String url = "https://www.amazon.com";

        Driver.getDriver().get(url);


        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        WebElement sellElement = Driver.getDriver().findElement(By.xpath("//*[.='Sell products on Amazon']"));

        jse.executeScript("arguments[0].click();", sellElement);

        WebElement controlElement = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Get over $50K in potential incentives when you start selling with Amazon.  ')]"));
        if (controlElement.isEnabled()) {
            System.out.println("Test Passed !!!");
        }
        Driver.quitDriver();
    }


}
