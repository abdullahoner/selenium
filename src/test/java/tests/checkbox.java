package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class checkbox {

    @Test
    public void test01() {
        String url = "https://the-internet.herokuapp.com/checkboxes";

        Driver.getDriver().get(url);

        WebElement checkbox1 = Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkbox2 = Driver.getDriver().findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
        Driver.quitDriver();
    }
}
