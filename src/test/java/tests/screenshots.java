package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import utilities.Driver;

import java.io.File;
import java.io.IOException;

public class screenshots {

    @Test
    public void test() throws IOException {
        String url = "https://www.amazon.com.tr/";

        Driver.getDriver().get(url);

        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Samsung" + Keys.ENTER);

        TakesScreenshot tss = (TakesScreenshot) Driver.getDriver();

        File tamSayfaSS = new File("target/screenshot/tumSayfaSS.png");

        File  ss = tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(ss,tamSayfaSS);

        Driver.quitDriver();
    }
}
