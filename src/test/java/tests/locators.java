package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import utilities.Driver;

public class locators {

    @Test
    public void test01() {
        Driver.getDriver().get("https://www.testotomasyonu.com/");
        String aranacakKelime = "shoes";

        Driver.getDriver().findElement(By.id("global-search")).sendKeys(aranacakKelime, Keys.ENTER);

        String text = Driver.getDriver().findElement(By.xpath("//*[@class=\"modeltext mt-1  mb-1\"]")).getText();
        System.out.println(text);

        if (aranacakKelime.equalsIgnoreCase(text)) {
            System.out.println("test passed");
        } else {
            System.out.println("test failed");
        }
        Driver.quitDriver();

    }
}
