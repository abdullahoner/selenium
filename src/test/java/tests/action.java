package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class action {

    @Test
    public void test() {
        Driver.getDriver().get("https://www.amazon.com.tr");

        Actions action = new Actions(Driver.getDriver());

        WebElement accountAndList = Driver.getDriver().findElement(By.id("nav-link-accountList"));

        action.moveToElement(accountAndList).perform();

        WebElement creteAlist = Driver.getDriver().findElement(By.xpath("(//span[@class='nav-text'])[1]"));

        action.click(creteAlist).perform();

        String expUrl = "https://www.amazon.com.tr/hz/wishlist/intro";
        String actUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actUrl, expUrl);
        Driver.quitDriver();
    }

    @Test
    public void test02() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        Actions actions = new Actions(Driver.getDriver());
        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));

        actions.contextClick(box).perform();

        String actResult = Driver.getDriver().switchTo().alert().getText();
        String expResult = "You selected a context menu";

        Driver.getDriver().switchTo().alert().accept();

        Assert.assertEquals(actResult, expResult);

        Driver.quitDriver();
    }

    @Test
    public void test03() {

        String url = "https://selenium08.blogspot.com/2020/01/click-and-hold.html";

        Driver.getDriver().get(url);

        WebElement C = Driver.getDriver().findElement(By.xpath("//li[@name ='C']"));
        WebElement D = Driver.getDriver().findElement(By.xpath("//li[@name ='D']"));

        Actions actions = new Actions(Driver.getDriver());

        actions.clickAndHold(C).moveToElement(D).perform();

        Driver.quitDriver();
    }

    @Test
    public void test04() {
        String url = "https://demoqa.com/droppable";

        Actions actions = new Actions(Driver.getDriver());

        Driver.getDriver().get(url);

        WebElement dragMeElement = Driver.getDriver().findElement(By.id("draggable"));
        WebElement dropHereElement = Driver.getDriver().findElement(By.id("droppable"));

        actions.dragAndDrop(dragMeElement, dropHereElement).perform();

        String expresult = "Dropped!";
        String actResult = dropHereElement.getText();

        Assert.assertEquals(expresult, actResult);

        Driver.quitDriver();
    }
    @Test
    public void test05(){
        String url = "https://www.amazon.com.tr";

        Driver.getDriver().get(url);

        WebElement searchTextBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        Actions actions = new Actions(Driver.getDriver());

        actions.click(searchTextBox).
                keyDown(Keys.SHIFT).sendKeys("s").
                keyUp(Keys.SHIFT).
                sendKeys("amsung").
                sendKeys(Keys.SPACE).
                sendKeys("note 10").
                sendKeys(Keys.ENTER).perform();

        WebElement aramasonucu = Driver.getDriver().findElement(By.xpath("//*[@class=\"a-color-state a-text-bold\"]"));
        String expResult = "Samsung note 10";
        String actResult = aramasonucu.getText();


        Assert.assertTrue(actResult.contains(expResult));

        Driver.quitDriver();
    }
}
