package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;

public class test {


    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get("https://amazon.com/");

        String title = Driver.getDriver().getTitle();

        System.out.println(Driver.getDriver().getCurrentUrl());

        System.out.println(title);

        if (title.contains("Amazon")) {
            System.out.println("title amazon içeriyor");
        } else {
            System.out.println("title amazon içermiyor");
        }


        Driver.quitDriver();
    }

    @Test
    public void tes02() {
        Driver.getDriver().navigate().to("https://amazon.com/");
        Driver.getDriver().navigate().to("https://youtube.com/");
        Driver.getDriver().navigate().back();
        Driver.getDriver().navigate().forward();
        Driver.getDriver().navigate().refresh();

        System.out.println(Driver.getDriver().manage().window().getPosition()); //sayfanın konumunu getirir.
        System.out.println(Driver.getDriver().manage().window().getSize()); //sayfanın boyutunu getirir.
        Driver.getDriver().manage().window().fullscreen(); //sayfanın boyutunu tam sayfa yapar
        Driver.quitDriver();


    }
}
