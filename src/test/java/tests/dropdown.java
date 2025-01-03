package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class dropdown {

    @Test
    public void test01() {
        Driver.getDriver().get("https://www.amazon.com.tr");

        WebElement dropdownElement = Driver.getDriver().findElement(By.id("searchDropdownBox"));

        Select select = new Select(dropdownElement);

        select.selectByIndex(3); // 1. yontem
        //select.selectByValue("baby-products-intl-ship"); // 2. yontem
        //select.selectByVisibleText("Baby"); // 3. yontem

        //Tum optionlari getirmek icin
        List<WebElement> optionList = select.getOptions();

        for (WebElement w: optionList){
            System.out.println(" "+w.getText());
        }
        Driver.quitDriver();
    }
}
