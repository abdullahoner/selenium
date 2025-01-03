package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;
import java.util.Set;

public class iFrame {

    @Test
    public void test() {
        String url = "https://the-internet.herokuapp.com/iframe";
        Driver.getDriver().get(url);

        ReusableMethods.bekle(2);
        WebElement frame = Driver.getDriver().findElement(By.tagName("iframe"));

        Driver.getDriver().switchTo().frame(frame);

        WebElement textbox = Driver.getDriver().findElement(By.id("tinymce"));
        ReusableMethods.bekle(2);
        textbox.clear();

        textbox.sendKeys("test123");

        Driver.getDriver().switchTo().parentFrame();

        Driver.quitDriver();

    }

    @Test
    public void windowHandleTest() {
        String url = "https://the-internet.herokuapp.com/windows";

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");

        String windowHandleValue1 = Driver.getDriver().getWindowHandle();

        WebElement clickHereButton = Driver.getDriver().findElement(By.xpath("//a[.='Click Here']"));

        clickHereButton.click();

        Set<String> handleValuesSet = Driver.getDriver().getWindowHandles();

        String windowHandleValue2 = "";

        for (String each : handleValuesSet) {
            if (!each.equals(windowHandleValue1)) {
                windowHandleValue2 = each;
            }
        }
        Driver.getDriver().switchTo().window(windowHandleValue2);

        Assert.assertTrue(Driver.getDriver().getTitle().equals("New Window"));

        Driver.getDriver().switchTo().window(windowHandleValue1);

        Assert.assertTrue(Driver.getDriver().getTitle().equals("The Internet"));

        Driver.quitDriver();

    }

    @Test
    public void test02() {
        String url = "https://html.com/tags/iframe/";

        Driver.getDriver().get(url);

        Actions actions = new Actions(Driver.getDriver());

        actions.sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).
                perform();

        WebElement iframe = Driver.getDriver().findElement(By.xpath("//*[@sandbox=\"allow-same-origin allow-scripts allow-popups allow-forms\"]"));
        Driver.getDriver().switchTo().frame(iframe);

        WebElement playButton = Driver.getDriver().findElement(By.xpath("//button[@class=\"ytp-large-play-button ytp-button ytp-large-play-button-red-bg\"]"));

        playButton.click();
        WebElement durdurButton = Driver.getDriver().findElement(By.xpath("//button[@aria-label='Duraklat klavye kısayolu k']"));


        if (durdurButton.isDisplayed()) {
            durdurButton.click();
        }

        Driver.quitDriver();


    }
}
